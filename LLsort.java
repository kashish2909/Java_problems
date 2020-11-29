import java.util.Scanner;

class Node
{
    int data;
    Node next;
    Node(int i)
    {
        data=i;
    }
}
class LLsort
{
    Node head=null;
    public static void main(String abc[])
    {
        int arr[]={1,3,5,7,9};
        LLsort obj=new LLsort();
        for(int i=0;i<arr.length;i++)
        {
            obj.insertend(arr[i]);
        }
        obj.print();
        obj.insertsort();
        obj.print();
        obj.reverse();
        obj.print();
        obj.swap(1,4);
        obj.print();
    }
    void insertend(int i)
    {
        Node newnode=new Node(i);
        if(head==null)
        {
            head=newnode;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }
    void insertsort()
    {
        int n=6;
        Node temp=head;
        Node prev=null;
        Node newNode=new Node(n);
        while(temp!=null)
        {
            if(n<temp.data)
            {
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        newNode.next=prev.next;
        prev.next=newNode;
    }
    void print()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println();
    }
    void reverse()
    {
        Node current=head;
        Node prev=null;
        Node nextnode=null;
        while(current!=null)
        {
            nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        } 
        head=prev;
    }
    void swap(int n1,int n2)
    {
        Node temp1=head;
        Node temp2=head;
        int i=0,j=0;
        while(i<n1)
        {
            if(temp1.next!=null)
            temp1=temp1.next;
        }
        while(j<n2)
        {
            if(temp2.next!=null)
            temp2=temp2.next;
        }

        Node t1n=temp1.next;

        Node t2n=temp2.next;
        if(t1n.next!=null && t2n.next!=null)
        t1n.next=t2n.next;
        if(temp1.next!=null)
        temp1.next=t2n;
        if(temp2.next!=null)
        temp2.next=t1n;
        if(t1n.next!=null && t2n.next!=null)        
        t2n.next=t1n.next;
    }
}