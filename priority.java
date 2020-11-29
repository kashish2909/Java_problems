import java.util.Scanner;
class Node
{
    int data;
    int pri;
    Node next;
    Node(int i,int j)
    {
        data=i;
        pri=j;
    }
}
//Lower number higher priority
class priority
{
    Node head=null;
    public static void main(String abv[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        priority obj=new priority();
        for(int i=0;i<n;i++)
        {
            int dt=s.nextInt();
            int pr=s.nextInt();
            obj.insertend(dt,pr);
        }
        obj.print();
    }
    void insertbeg(int dt,int pr)
    {
        Node newnode=new Node(dt,pr);
        newnode.next=head;
        head=newnode;
    }
    void insertend(int dt,int pr)
    {
        Node temp=head;
        Node prev=null;
        Node newnode=new Node(dt,pr);
        if(head==null)
        {
            head=newnode;
        }
        else
        if(pr<head.pri)
        {
            this.insertbeg(dt,pr);
        }
        else
        {
            while(temp!=null)
            {
                if(temp.pri>=pr)
                {
                    break;
                }
                prev=temp;
                temp=temp.next;
            }
            newnode.next=prev.next;
            prev.next=newnode;
        }
       
    }
    void print()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"|"+temp.pri+"    ");
            temp=temp.next;
        }
    }
}