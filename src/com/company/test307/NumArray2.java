package com.company.test307;


public class NumArray2 {
    private SegmentTree segmentTree;
    public NumArray2(int[] nums) {
        if (nums.length>0){
            segmentTree=new SegmentTree(nums);
        }
    }

    public void update(int index, int val) {
        if(segmentTree==null)
            throw new IllegalArgumentException("Segment Tree is null");
        segmentTree.set(index,val);
    }
    public int sumRange(int i, int j) {
        if (segmentTree==null)
            throw new IllegalArgumentException("Segment Tree is null");
        return segmentTree.query(i,j);
    }
}
