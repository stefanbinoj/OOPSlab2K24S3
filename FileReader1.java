import java.io.FileReader ;
import java.io.BufferedReader ; 
import java.io.IOException;

class FileReader1{
    public static void main (String args[]){
            try{
                FileReader fr = new FileReader("example.txt");
                BufferedReader br = new BufferedReader(fr);

                String ch;
                while((ch=br.readLine())!=null){
                    System.out.println(ch);
                }
            }
            catch(IOException e ){
                e.printStackTrace();
            }
    }
}