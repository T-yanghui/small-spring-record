package org.example.beans.factory.support;

import org.junit.experimental.max.MaxCore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2022/10/14
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int count=0;
        int magic=1;
        int left=0;
        while(left<n){
            int a1=nums[left];
            int a2=(left+1>=n?a1:nums[left+1]);
            int a3=(left+2>=n?a1:nums[left+2]);
            if(a1>a2&&magic==1){
                magic--;
                left=left+2;
                continue;
            }
            if(left+1==n||left+2==n){
                if(magic==1){
                    magic--;
                    left=left+2;
                    continue;
                }
            }
            while (a1>0){
                a1--;
                a2--;
                a3--;
                count++;
            }
            if(a2>0){
                if(left+1<n){
                    nums[left+1]=a2;
                }
                if(left+2<n){
                    nums[left+2]=a3;
                }
                left+=1;
                continue;
            }
            if(a3>0){
                if(left+2<n){
                    nums[left+2]=a3;
                }
                left+=2;
                continue;
            }
            left+=3;
        }
        System.out.println(count);
    }
}
