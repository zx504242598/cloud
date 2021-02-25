package com.zx.cloud.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaoxuan
 * @date 2021-02-01 14:19
 **/
public  class Main <T>{
    public Node head;
    public int size=0;

    class Node{
        public T val;
        public Node next;
        public Node(T val){
            this.val=val;
        }
    }

    public void add(T val){
        Node last=getLast();
        last.next=new Node(val);
        size++;
    }

    public Node getLast(){
        Node last=head;
        while (last.next!=null){
            last=last.next;
        }
        return last;
    }



    public void print(){
        int count=size;
        Node node=head;
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<count;i++){
                list.add(i);
            }

        }
    }

    public static int aaa(List<Integer> list,int start){
       int size=list.size();
       if (size==1){
           return list.get(0);
       }
       int end=size-(size-start-1)%3-1;
       for (int i=end;i>=start;i-=3){
           list.remove(i);
       }
       return aaa(list,(size-start-1)%3-1);
    }
}
