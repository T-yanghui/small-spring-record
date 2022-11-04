package org.example.beans.factory.support;

import org.example.beans.factory.support.event.CustomEvent;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class ApiTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        classPathXmlApplicationContext.registerShutdownHook();
    }

    @Test
    public void test_event(){
        classPathXmlApplicationContext.publishEvent(new CustomEvent(classPathXmlApplicationContext,10001L,"bad day..."));
    }
    @Test
    public void test_merge(){
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    public int[][] merge (int[][] arr) {
        // write code here
        Arrays.sort(arr,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        ArrayList<ArrayList<Integer>> memo=new ArrayList<>();
        int min=arr[0][0],max=arr[0][1];
        for(int[] pair:arr){
            int low=pair[0],heigh=pair[1];
            if(max<low){
                memo.add(new ArrayList<>(Arrays.asList(min,max)));
                min=low;
                max=heigh;
            }else{
                max=Math.max(max,heigh);
            }
        }
        memo.add(new ArrayList<>(Arrays.asList(min,max)));
        int[][] resultArr=new int[memo.size()][2];
        int index=0;
        for(ArrayList<Integer> list:memo){
            resultArr[index][0]=list.get(0);
            resultArr[index][1]=list.get(1);
            index++;
        }
        return resultArr;
    }
    public int[] merge (int[] nums1, int m, int[] nums2, int n) {
        // write code here
        int index_1=m-1;
        int index_2=n-1;
        int index=m+n-1;
        while(index>=0){
            int a=index_1>=0?nums1[index_1]:Integer.MIN_VALUE;
            int b=index_2>=0?nums2[index_2]:Integer.MIN_VALUE;
            if(a>b){
                nums1[index--]=a;
                index_1--;
            }else{
                nums1[index--]=b;
                index_2--;
            }
        }
        return nums1;
    }
}
