import java.util.Scanner;
class ss{
    int top;
    int a[]=new int[10];
    Scanner sc = new Scanner(System.in);
    ss(){
        top =-1;
    }
    void push(){
        System.out.println("wnter : ");
        int n= sc.nextInt();
        a[++top]=n;
    }
    void pop(){
        System.out.println("digit is : "+a[top]);
        top--;
    }
    void disp(){
        if(top==-1){
            System.out.println("empty");
            return ;
        }
        for(int i =0;i<=top;i++){
            System.out.println(a[i]);
        }
    }
}

class stack{
     public static void main(String args[]){
        int op;
        ss st=new ss();
        do{
 System.out.println("1.push \n2.pop\n3.dis\n4.exit");
 Scanner s=new Scanner(System.in);
 op=s.nextInt();
 switch(op)
 {
  case 1:st.push();break;
  case 2:st.pop();break;
  case 3:st.disp();break;
  case 4: System.exit(0);
  }
 }
while(op!=4);
}
}