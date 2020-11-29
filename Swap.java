
import java.util.Scanner;



public class Swap 
{
	Node head=null;
	public static void main(String abc[])
	{
		System.out.println("Enter Linked list 1");
		System.out.println("How many nodes to enter");
		Scanner sc=new Scanner(System.in);
		int count1=sc.nextInt();
		Swap obj1=new Swap();
		for(int i=0;i<count1;i++)
		{
			System.out.println("Enter element");
			int temp=sc.nextInt();
			obj1.insertend(temp);
		}
		obj1.printlist();
		
		System.out.println("Enter Linked list 2");
		System.out.println("How many nodes to enter");
		int count2=sc.nextInt();
		Swap obj2=new Swap();
		for(int i=0;i<count2;i++)
		{
			System.out.println("Enter element");
			int temp=sc.nextInt();
			obj2.insertend(temp);
		}
		obj2.printlist();
		Swap listf=mergelist(obj1,obj2);
		listf.printlist();
	}
	void printlist()
	{
		Node temp=head;
		System.out.println("Your Linked List is:");
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("NULL");
		System.out.println();
	}
	void insertend(int i)
	{
		Node newNode=new Node(i);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newNode;
		}
	}
	static Swap mergelist(Swap obj1,Swap obj2)
	{
		Node temp1=obj1.head;
		Node temp2=obj2.head;
        Swap listf=new Swap();
        while(temp1!=null || temp2!=null)
        {
            if(temp1.data<temp2.data)
            {
                listf.insertend(temp1.data);
                if(temp1.next!=null)
                temp1=temp1.next;
                else
                break;
            }
            else
            {
                listf.insertend(temp2.data);
                if(temp2.next!=null)
                temp2=temp2.next;
                else
                break;
            }
        }
        if(temp1.next==null && temp2.next!=null)
        {
            while(temp2!=null)
            {
                listf.insertend(temp2.data);
                temp2=temp2.next;
            }
        }
        else if(temp2.next==null && temp1.next!=null)
        {
            while(temp1!=null)
            {
                listf.insertend(temp1.data);
                temp1=temp1.next;
            }
        }
        return listf;
	}
}
class Node
{
	int data;
	Node next;
	Node(int i)
	{
		data=i;
	}
}
