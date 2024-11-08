class myThread extends Thread{
    public myThread(String name){
        super(name);

    }
    public synchronized void run(){
        for (int i =0 ; i<10 ; i++){
            System.out.println("The Thread is : "+Thread.currentThread().getId()+" Name : "+getName() +" Priority : "+getPriority()+" value : "+i);
            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException e ){
                e.printStackTrace();
            }
        }
    }
}

class OurThread{
    public static void main(String args[]){
        myThread t1 = new myThread("T1");
        myThread t2 = new myThread("t22");
        myThread t3 = new myThread("fjjk");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(InterruptedException e ){
            e.printStackTrace();
                    }

    }
}