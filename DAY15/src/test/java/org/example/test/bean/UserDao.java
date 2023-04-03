package org.example.test.bean;

import org.example.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2023/04/01
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
