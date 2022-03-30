package com.concurency;

public class HelloThread extends Thread  {
    public void run(){
        System.out.println("Hello dari thread!");
    }
    public static void main (String[]args){
        Thread t = new HelloThread(); 
        //bikin Thread pake parameter HelloThread karna HelloThread extends Thread 
        t.start();
    }
}

//kelebihan: simpel
//kekurangan: java gabisa multiple inheritence sehingga cuma bisa ada 1 kelas yg extends Thread
