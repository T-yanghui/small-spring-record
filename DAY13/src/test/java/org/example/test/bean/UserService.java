package org.example.test.bean;

import org.example.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2023/03/25
 */
@Component("userService")
public class UserService implements IUserService {
    private String token;

    @Override
    public String queryUserInfo() {
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return "1,1001,beijing";
    }

    @Override
    public String register(String userName) {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return userName+" signin success";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#token" + getToken();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
