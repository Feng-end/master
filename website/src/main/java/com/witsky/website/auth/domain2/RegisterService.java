package com.witsky.website.auth.domain2;

import com.witsky.website.base.Starter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YSJ
 * @date 2022/07/22 15:21
 */
@Service
public class RegisterService implements Starter {

    @Value("#{${witsky.local-user}}")
    private Map<String,String> localUser;

    private List<RegisterUser> registerUsers;


    public List<RegisterUser> getRegisterUsers(){
        Set<String> usernames = localUser.keySet();
        List<RegisterUser> registerUserList = usernames.stream().map(u -> {
            return new RegisterUser(u, localUser.get(u));
        }).collect(Collectors.toList());

        this.registerUsers = Collections.unmodifiableList(registerUserList);
        return registerUsers;
    }

    @Override
    public void onStart() throws Exception {
        // Set<String> usernames = localUser.keySet();
        // List<RegisterUser> registerUserList = usernames.stream().map(u -> {
        //     return new RegisterUser(u, localUser.get(u));
        // }).collect(Collectors.toList());
        //
        // this.registerUsers = Collections.unmodifiableList(registerUserList);
    }
}
