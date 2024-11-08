import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner ; 

class FileWriter1{
    public static void main (String args[]){
        BufferedWriter br = null;
        try{
            FileWriter fr = new FileWriter("example.txt",true);
            br = new BufferedWriter(fr);
            Scanner sc = new Scanner (System.in);
            String a = sc.nextLine();
            br.write(a);
            br.newLine();
            String b = sc.nextLine();
            br.write(b);
            
        }
        catch(IOException e ){
            e.printStackTrace();
        }
        finally{
            try{
                            br.close();

            }catch(IOException e ){
            e.printStackTrace();
        }
        }
    }
}