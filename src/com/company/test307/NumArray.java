package com.company.test307;

public class NumArray {
    private int[] sum;//sum[i]存储前i个元素的和，sum[0]=0
    private int[] data;
    public NumArray(int[] nums) {
        data=new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            data[i]=nums[i];

        sum=new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i < sum.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
    }

    public void update(int index, int val) {
        data[index]=val;
        for (int i = index+1; i < sum.length; i++) {
            sum[i]=sum[i-1]+data[i-1];
        }
    }
    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}
