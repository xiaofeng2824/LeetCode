package myArray;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-indices-of-stable-mountains/
 * 找到稳定山的下标
 */
public class StableMountains {

    public static void main(String[] args) {
        int[] height = {10,1,10,1,10}; int threshold = 3;
        System.out.println(stableMountains(height,threshold));
    }


    public static List<Integer> stableMountains(int[] height, int threshold) {

        List<Integer> res = new ArrayList<>();
        if (height == null || height.length < 2) return res;

        for (int i=1;i<height.length;i++){
            if (height[i-1] > threshold){
                res.add(i);
            }
        }
        return  res;
    }
}
