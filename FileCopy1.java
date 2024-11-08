import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

class FileCopy{
    public static void main(String args[]){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            FileReader fr = new FileReader("example.txt");
            FileWriter fw = new FileWriter("output.txt",false);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String line;
            int l =0 ;
            while((line = br.readLine())!=null){
                l++;
                bw.write(line);
                bw.newLine();
                System.out.println ("The line is "+l+" value is : "+line);
            }
        }
        catch(IOException e ){
            e.printStackTrace();
        }
        finally{
            try{
                br.close();
                bw.close();
            }catch(IOException e ){
            e.printStackTrace();
        }
        }
    }
}