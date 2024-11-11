import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException;

class StringTokenizers{
    public static void main(String args[]){
        BufferedReader br = null;
        try{
        br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer tkn = new StringTokenizer(line);
        int sum=0;
        while(tkn.hasMoreTokens()){
            String token = tkn.nextToken();
            int num = Integer.parseInt(token);
            System.out.println("THw num is  : "+num);
            sum+=num;
        }
        System.out.println("Yhe sum is : "+sum);
        }
        catch(IOException e ){
            e.printStackTrace();
        }
        finally{
            try{
                br.close();
            }
            catch(IOException e ){
                e.printStackTrace();
            }
        }
        
    }
}