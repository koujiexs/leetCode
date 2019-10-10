package com.company.test303;

public class NumArray {
    private SegmentTree segmentTree;
    public NumArray(int[] nums) {
        if (nums.length>0){
            segmentTree=new SegmentTree(nums);
        }
    }

    public int sumRange(int i, int j) {
        if (segmentTree==null)
            throw new IllegalArgumentException("Segment Tree is null");
        return segmentTree.query(i,j);
    }
}
