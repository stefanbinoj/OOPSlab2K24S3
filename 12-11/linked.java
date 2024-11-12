import java.util.Scanner;
class Node {
    int data ;
    Node next;
}
class List{
    Node first , last ;
    List(){
        first=last=null;
    }
    Scanner sc = new Scanner (System.in);


    void push(){
        System.out.println("Enter : ");
        int a =sc.nextInt();
        Node newnode = new Node();
        newnode.data=a;
        newnode.next=null;
        if(first==null){
            first =newnode;
            last=newnode;
            
        }
        else{
            last.next=newnode;
            last=newnode;
        }
    }

    void delete(){
        
        Node newnode = new Node();
        newnode=first;

        if(newnode==null){
            System.out.println("EMpty");
            return ;
            
        }
        else{
            while(newnode.next!=null){
                newnode=newnode.next;
            }
            last = newnode;
            System.out.println("deleted : "+newnode.data);
        }
    }

    void display(){
        Node newnode = new Node();
        newnode=first;
        if(first==null){
            System.out.println("EMpty");
            return ;
        }
        do{
            System.out.print(newnode.data + "-->> ");
            newnode=newnode.next;
        }while(newnode!=null);
    }
}


class linked
{

 public static void main(String args[])
 {
   List l=new List();
   Scanner s=new Scanner(System.in);
   int op;
   while(true)
   {
   System.out.println("\n1.push\n2.pop\n3.dis\n4.exit");
   System.out.println("Enter option....");
   op=s.nextInt();
   switch(op)
   {

    case 1:l.push();
           break;
    case 2:l.delete();
           break;
    case 3:l.display();
           break;  
    case 4:System.exit(0);
   }

   }
}

}