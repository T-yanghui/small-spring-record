package org.example.beans.factory.support.beans;

import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2022/11/08
 */
public class UserService implements IUserService {
    @Override
    public String queryUserInfo() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "001" + " xiaoming";
    }

    @Override
    public String register(String userName) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "registry " + userName + " success";
    }
}
