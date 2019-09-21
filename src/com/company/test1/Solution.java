package com.company.test1;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ret =new int[2];
        HashMap<Integer,Integer> x=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (x.containsKey(nums[i])){
                ret[0]=x.get(nums[i]);
                ret[1]=i;
                return ret;
            }else {
                x.put((target-nums[i]),i);
            }
        }
        return ret;
    }
}
