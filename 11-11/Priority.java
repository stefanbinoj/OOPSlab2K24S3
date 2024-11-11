class myThread extends Thread{
    myThread(String name ){
        super(name);
    }
    public void run(){
        for(int i =0 ; i<5 ; i++){
            System.out.println("the id"+getId()+" name "+getName() +" val "+i+" prioty "+getPriority());
            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Priority{
    public static void main(String args[]){
        myThread m1 = new myThread("tt1");
        myThread m2 = new myThread("tt4");
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m2.start();
        try{
            m1.join();
            m2.join();
            
        }catch(InterruptedException e ){
            e.printStackTrace();
        }
    }
}