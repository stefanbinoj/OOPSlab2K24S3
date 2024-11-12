import java.util.Scanner ;
class Node {
    int data;
    Node prev;
    Node next;
}

class Dlink{
    Node first =null;
    Node last = null;
    Scanner sc = new Scanner (System.in);
    int total = 0;
    void add(){
        Node temp = new Node();
        System.out.println("Ente r  :");
        int a = sc.nextInt();
        temp.data=a;
        temp.prev=null;
        temp.next=null;
        if(first==null){
            first=last=temp;
        }
        else{
            last.next=temp;
            temp.prev=last;

            last=temp;
        }
        total++;
    }

    void disp(){
        System.out.println("Enter 1 for forward 2 for backward ");
        int a = sc.nextInt();
        if(a==1){
            Node temp = new Node();
            temp=first;
            while(temp!=null){
                System.out.println(temp.data+" --> ");
                temp=temp.next;
            }
        }
        else{
            Node temp = new Node();
            temp=last;
            while(temp!=null){
                System.out.println("< -- "+temp.data);
                temp=temp.prev;
            }
        }
    }

    void search(){
        System.out.println("Enter to search  :");
        int a =sc.nextInt();
        boolean found=false;
        
        Node temp = new Node();
        temp = first;
        while(temp!=null){
            if(temp.data==a){
                found = true;
                break;
            }
            temp=temp.next;
        }
        if(found==false){
            System.out.println("NOt foudn");
        }
        else{
            System.out.println("found at "+temp+" val : "+temp.data);
        }
    }
    void del(){
        System.out.println("Enter the pos  :");
        int a = sc.nextInt();
        if(a>total){
            System.out.println("not possible");
            return ;
        }
        else{
            if(a==1){
                first= first.next;
                first.prev=null;
            }
            else if(a==total){
                last = last.prev;
                last.next=null;
            }
            else{
                Node temp = first;
                for(int i =0;i<a;i++ ){
                    temp=temp.next;
                }
                Node tmepprev = temp.prev;
                Node tempnext = temp.next;
                tmepprev.next=tempnext;
                tempnext.prev=tmepprev;
            }
        }
        total --;

    }
}

class doubly
 {
   
   
 public static void main(String args[])
  {
   Scanner s=new Scanner(System.in);
   int op;
   Dlink dl=new Dlink();
   while(true)
   {

    System.out.println("1.add\n2.disp\n3.search\n4.del\n5.exit\n Enter Option");
    op=s.nextInt();

    switch(op)
    {
     case 1: dl.add();
             break;

    case 2: dl.disp();
            break;
    case 3: dl.search();
            break; 
    
    case 4: dl.del();
            break; 
    case 5:System.exit(0);  

     }

   }

   }

}