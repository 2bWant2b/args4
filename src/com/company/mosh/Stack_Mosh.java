package com.company.mosh;

import java.util.Arrays;

public class Stack_Mosh {
    private final int[] items = new  int[5];
    private int count;

    public void push(int item){
        if (count==items.length)
            throw new StackOverflowError();
        items[count++] = item;
    }

    public int pop(){
        if (count == 0)
            throw new IllegalStateException();
        return items[--count];
    }

    public int peek(){
        if (count == 1)
            throw new IllegalStateException();
        return items[count-1];
    }

    public boolean isEmpty(){
        return count==0;
    }
    //重写toString类，println会自动调用此方法
    @Override
    public String toString(){
        int[] content = Arrays.copyOfRange(items,0,count);
        return Arrays.toString(content);
    }

}
