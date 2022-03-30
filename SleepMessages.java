package com.concurency;

public class SleepMessages {
    public static void main(String[]args) throws InterruptedException{
        String infopenting[]={
            "Kambing makan rumput",
            "Harimau makan kambing",
            "Manusia makan harimau",
            "Anak-anak juga makan harimau"
        };
        for (int i=0;i<infopenting.length;i++){
            //pause 4 detik
            Thread.sleep(4000);
            System.out.println(infopenting[i]);
            
        }
    }   
}
