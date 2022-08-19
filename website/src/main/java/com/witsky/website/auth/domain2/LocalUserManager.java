package com.witsky.website.auth.domain2;

import com.witsky.website.base.Starter;
import org.slf4j.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/22 16:07
 */
@Repository
public class LocalUserManager implements Starter {

    public static final Logger L = LoggerFactory.getLogger(LocalUserManager.class);

    @Resource
    private RegisterService registerService;

    @Resource
    private PasswordEncoder passwordEncoder;

    List<LocalUser> localUsers;



    @Override
    public void onStart() throws Exception {
        List<RegisterUser> registerUsers = registerService.getRegisterUsers();
        List<LocalUser> localUserList = new ArrayList<>();
        for (RegisterUser registerUser : registerUsers) {
            LocalUser localUser = new LocalUser();
            localUser.setUsername(registerUser.getName());
            // localUser.setPassword(registerUser.getPassword());
            localUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
            localUser.setEnable(true);
            localUser.setEnable(true);
            localUserList.add(localUser);
            L.info("配置文件中（注册用户）加载成为本地用户,用户名:{}->{}" ,localUser.getUsername(),localUser.getPassword());
        }
        this.localUsers = Collections.unmodifiableList(localUserList);
    }

    public LocalUser loadUserByUsername(String username) {
        Optional<LocalUser> first = localUsers.stream().filter(u-> u.getUsername().equals(username)).findFirst();
        return first.get();
    }
}
