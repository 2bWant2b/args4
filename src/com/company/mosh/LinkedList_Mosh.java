package com.company.mosh;

import java.util.NoSuchElementException;

public class LinkedList_Mosh {
    private static class Node{
        private final int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
    }
    private Node first;
    private Node last;
    //设置私有字段可以避免每次调用size()时遍历链表
    private int size;

    private boolean isEmpty(){
        return first==null;
    }

    public void addLast(int item){
        Node node = new Node(item);
        if(isEmpty()){
            first=last=node;
        }else{
            last.next=node;
            last=node;
        }
        size++;
    }

    public void addFirst(int item){
        Node node = new Node(item);
        if(isEmpty()){
            first=last=node;
        }else {
            node.next=first;
            first=node;
        }
        size++;
    }

    public int indexOf(int item){
        int index=0;
        Node current=first;
        while (current!=null){
            if(current.value==item) return index;
            current=current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }
    
    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        //考虑只有一项的情况
        if(first==last){
            first=last=null;
            size--;
            return;
        }
        Node oldfirst=first;
        first=first.next;
        oldfirst.next=null;
        size--;
    }

    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        if(first==last){
            first=last=null;
            size--;
            return;
        }
        Node current = first;
        while (current.next!=last){
            current=current.next;
        }
        current.next=null;
        last=current;
        size--;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        int index = 0;
        Node current = first;
        while (current!=null){
            array[index++]=current.value;
            current=current.next;
        }
        return array;
    }

    public void reverse(){
        if (isEmpty()) return;
        Node previous = first;
        Node current = previous.next;
        while (current!=null){
            Node next = current.next;
            current.next=previous;
            previous = current;
            current = next;
        }
        last=first;
        first=previous;
        last.next=null;
    }

    public int getKthFromTheEnd(int k){
        if(k<=0||k>size) throw new IllegalArgumentException();
        Node slow = first;
        Node fast = first;
        for(int i=0;i<k-1;i++){
            fast=fast.next;
        }
        while (fast!=last){
            slow=slow.next;
            fast= fast.next;
        }
        return slow.value;
    }
}
