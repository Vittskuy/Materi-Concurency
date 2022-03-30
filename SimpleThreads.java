package com.concurency;

public class SimpleThreads {
//ATTRIBUT
    //formating tampil massage jadi Thread-0: message
    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }
    //bikin thread bernama MessageLoop();
    private static class MessageLoop implements Runnable{
        public void run(){
            String infopenting[]={
                "Kambing makan rumput",
                "Harimau makan kambing",
                "Manusia makan harimau",
                "Anak-anak juga makan harimau"
            };
            try{
                for (int i=0;i<infopenting.length;i++){
                    //pause 4 detik
                    Thread.sleep(4000);
                    threadMessage(infopenting[i]); //print list
                }   
            } catch (InterruptedException e){
                threadMessage("Belom selesai nih!");
            }//total waktu program 16 detik!
        }
    }
//^ATRIBUT

    public static void main(String[]args) throws InterruptedException{
    //disini kita mau bikin program yg manggil thread MessageLoop dan cuma ngasih waktu 12 detik buat nunggu
    //KAMUS 
        //waktu kesabaran dalam milisekon sebelum kita akhirnya interupt MessageLoop kalo overtime
        long kesabaran = 12000; //12 detik
        
        //gatau buat apa, keknya cuma masttiin program jalan dengan benar
        if (args.length >0){
            try{
                kesabaran =Long.parseLong(args[0])*1000;
            } catch (NumberFormatException e) {
                System.err.println("Argumen harus integer!");
                System.exit(1);
            }
        }

    //ALGORITMA UTAMA
        threadMessage("Memulai thread MessageLoop");
        //memulai thread t yang menjalankan MessageLoop
        long startTime = System.currentTimeMillis(); //catat waktu mulai
        MessageLoop m = new MessageLoop();
        Thread t = new Thread(m);
        t.start();

        //nampilin pesan bahwa lg nunggu 
        threadMessage("Menunggu thread MessageLoop selesai");

        //Disini kita kasih spare perpanjangan waktu kesabaran nunggu thread t selesai selama 1 detik
        while (t.isAlive()){ 
            threadMessage("Still waiting...");
            t.join(1000);//tunggu 1 detik
            //kalo ternyata waktu nunggunya ngelebihin (kesabaran + (1 detik )) tapi thread t belum selesai juga (t.isAlive), 
            //bakal diinterupsi
            if (((System.currentTimeMillis()-startTime)>kesabaran) && t.isAlive()) {
                threadMessage("Kelamaan nunggu!");
                t.interrupt(); //interupsi thread t
                t.join();
            }
            //disini karna kesabaran nya cuma 12 detik + join 1 detik, padahal program nya 16 detik, 
            //maka bakal lgsg di interupt (dieend saat itu juga)
        }
        threadMessage("Akhirnya!");


    }


}
