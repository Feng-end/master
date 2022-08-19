package com.witsky.website.web.wrapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * <p>
 *
 * @author Kun Yang
 * @date 2020-05-07 03:35
 */
public class CacheBodyHttpServletRequest extends HttpServletRequestWrapper {

    private byte[] rawData;

    private final HttpServletRequest request;

    public CacheBodyHttpServletRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (rawData == null) {
            ServletInputStream input = request.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = input.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            this.rawData = buffer.toByteArray();
        }
//        final ByteArrayInputStream inputStream = new ByteArrayInputStream(rawData);
//        return new DelegatingServletInputStream(inputStream);
        return new ServletInputStreamCopier(rawData);
    }

    public class ServletInputStreamCopier extends ServletInputStream {

        private ByteArrayInputStream stream;

        public ServletInputStreamCopier(byte[] in) {
            this.stream = new ByteArrayInputStream(in);
        }

        @Override
        public boolean isFinished() {
            return stream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            throw new RuntimeException("Not implemented");
        }

        @Override
        public int read() throws IOException {
            return this.stream.read();
        }

    }

}
