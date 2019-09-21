package com.company.test155;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    private int[] data;
    private int size;
    private Stack<Integer> min =new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        data=new int[10];
        size=0;
    }

    public void push(int x) {
        if(size==data.length){
            resize(2*size);
        }
        data[size]=x;
        size++;
        if (min.isEmpty()||min.peek()>=x){
            min.push(x);
        }
    }

    public void pop() {
        if(data[size-1]==min.peek()){
            min.pop();
        }
        size--;
    }

    public int top() {
        return data[size-1];
    }

    public int getMin() {
        return min.peek();
    }
    private void resize(int capacity){
        data = Arrays.copyOf(data,capacity);
    }
}
