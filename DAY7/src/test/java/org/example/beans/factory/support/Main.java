package org.example.beans.factory.support;

import org.hamcrest.core.IsNot;

import java.time.OffsetTime;
import java.util.*;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2022/10/24
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,3));
        int[] nums=list.stream().mapToInt(e->e).toArray();
    }
}
