import java.util.Random;
class RandomGen extends Thread{
    public void run{
        Random r = new Random();
        int a = r.nextInt(100);
    }
}