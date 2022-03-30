package com.concurency;

public class HelloRunnable implements Runnable{
    public void run(){
        System.out.println("Hello from a thread!");
    }
    public static void main (String[]args){
        Runnable r = new HelloRunnable(); //bikin runnable
        Thread t = new Thread(r);//bikin thread dengan parameter runnable
        t.start();
    }
}
