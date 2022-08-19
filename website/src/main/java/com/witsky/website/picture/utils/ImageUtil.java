package com.witsky.website.picture.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.*;
import com.witsky.website.base.ApiException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static com.witsky.website.common.WitSkyErrorCode.*;

/**
 * @author YSJ
 * @date 2022/07/20 17:39
 */
public class ImageUtil {
    /**
     * 保存文件，直接以multipartFile形式
     *
     * @param multipartFile
     * @param pictureNo
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile, long pictureNo, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = pictureNo + ".png";
        // BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+ fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

    public static String getPictureBase64(String picturePath, String pictureNo, HttpServletResponse response)  {

        File file = new File(picturePath);
        if (!file.exists()) {
            throw ApiException.of(PICTURE_GET_ERROR);
        }
        BufferedInputStream in = FileUtil.getInputStream(picturePath+pictureNo+".png");
        byte[] bytes = IoUtil.readBytes(in);
        return Base64.encode(bytes);

    }
}
