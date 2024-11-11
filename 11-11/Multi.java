import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
class SharedData{
    private boolean processed = false;
    private int number ;
    synchronized void SetNumber(int n){
        this.number= n;
        this.processed=false;
    }
    synchronized void setProcessed(boolean val){
        this.processed=val;
    }
    synchronized int getNumber(){
        return this.number;
    }
    synchronized boolean isProcessed(){
        return this.processed;
    }

}

class NumberGenerator extends Thread{
    private SharedData sd;
    NumberGenerator(SharedData sd){
        this.sd = sd;
    }
    public void run(){           
        Random r = new Random();
        while(true){
            int a = r.nextInt(100);
            synchronized(sd){
                sd.SetNumber(a);
                sd.setProcessed(false);
                sd.notifyAll();
            }
            System.out.println("Number Gen and notified "+ a);
            try{
                Thread.sleep(1000);
                sd.setProcessed(true);
                

            }catch(InterruptedException e ){
                e.printStackTrace();
            }
        }
    }
}

class EvenNumver extends Thread{
    private SharedData sd ;
    EvenNumver(SharedData sd){
        this.sd=sd;
    }

    public void run(){
        BufferedWriter br = null;
        while(true){
            synchronized(sd){
                System.out.println("Even "+sd.getNumber()+""+sd.isProcessed());
                while(sd.isProcessed() || sd.getNumber() % 2 != 0 ){
                    try{
                        sd.wait();
                    }
                    catch(InterruptedException e ){
                        e.printStackTrace();
                    }
                }
                    int num = sd.getNumber();
                    int sq= num*num;
                    sd.setProcessed(true);
                    sd.notifyAll();
                    try{
                        br=new BufferedWriter(new FileWriter("even.txt",true));
                        br.write(sq+"");
                        br.write('\n');
                    }
                    catch(IOException e ){
                        e.printStackTrace();
                    }
                    finally{
                        System.out.println("the sqaure of "+num+" is : "+sq);
                        try{
                            br.close();

                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                    }

                
            }
        }
    }

}

class OddNumber extends Thread{
    private SharedData sd ;
    OddNumber(SharedData sd ){
        this.sd=sd;
    }
    public void run(){
        BufferedWriter br = null;
        while(true){
            synchronized(sd){
                System.out.println("Even "+sd.getNumber()+""+sd.isProcessed());
                while(sd.isProcessed() || sd.getNumber()%2 == 0 ){
                    try{
                        sd.wait();
                    }catch(InterruptedException e ){
                        e.printStackTrace();
                    }
                }
                    int num = sd.getNumber();
                    int cube = num*num*num;
                    sd.setProcessed(true);
                    sd.notifyAll();
                    try{
                        br=new BufferedWriter(new FileWriter("odd.txt",true));
                        br.write(cube+" ");
                        br.write('\n');
                    }
                    catch(IOException e ){
                        e.printStackTrace();
                    }
                    finally{
                        System.out.println("the cube of "+num+" is : "+cube);
                        try{
                            br.close();

                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        
                    }
                
            }
        }
    }
}

class Multi{
    public static void main(String args[]){
        SharedData sd = new SharedData();

        NumberGenerator numgen = new NumberGenerator(sd);
        OddNumber odd = new OddNumber(sd);
        EvenNumver even = new EvenNumver(sd);
        numgen.start();
        even.start();
        odd.start();
        

    }
}