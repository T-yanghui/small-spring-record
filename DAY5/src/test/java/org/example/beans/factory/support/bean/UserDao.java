package org.example.beans.factory.support.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class UserDao {
    private static Map<String,String> hashmap=new HashMap<>();
    static {
        hashmap.put("1","小杨");
        hashmap.put("2","小田");
    }
    public String queryUserName(String uId){
        return hashmap.get(uId);
    }
}
