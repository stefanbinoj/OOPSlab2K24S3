import java.util.Scanner;
import java.util.Arrays;

class binary{
    static int s[] = new int[10];
    public static void main(String args[]){
        System.out.println("Enter  : ");
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i<=9 ;i++){
            int a =sc.nextInt();
            s[i]=a;
        }
        Arrays.sort(s);
        dispaly();
        int n;
        do{
            System.out.println("Enter element to search  :");
             n = sc.nextInt();
            search(n,0,9);

        }while(n!=-1);

    }

    static void dispaly(){
        for(int i = 0 ; i<=9 ;i++){
            System.out.print(s[i]+" ");
        }
    }
    static void search(int n,int left , int right){
        int mid = left<=right ?  (left+right)/2 : -1 ;
        if(mid==-1){
            System.out.println("Not found");
            return ;
        }
        if(s[mid]==n){
            System.out.println("found at : "+mid);
            return;
        }
        else if(s[mid]>n)
             search(n ,left ,mid-1 );
        else if(s[mid]<n)
             search(n ,mid+1 , right );

    }
}