import java.util.*;
public class Double 
{
	Node head=null;
	public static void main(String abc[])
	{
		System.out.println("Enter Linked list");
		System.out.println("How many nodes to enter");
		Scanner sc=new Scanner(System.in);
		int count=sc.nextInt();
		Double obj=new Double();
		for(int i=0;i<count;i++)
		{
			System.out.println("Enter element");
			int temp=sc.nextInt();
			obj.insertend(temp);
		}
		obj.printlist();
		System.out.println("Enter element");
		int temp=sc.nextInt();
		System.out.println("Enter position");
		int pos=sc.nextInt();
		obj.insertpos(temp, pos-1);
		obj.printlist();
	}
	void printlist()
	{
		Node temp=head;
		System.out.println("Your Linked List is:");
		while(temp!=null)
		{
			System.out.print("prev:");
			if(temp.prev==null)
				System.out.println("NULL");
			else
				System.out.println(temp.prev.data);
			System.out.print("value:");
			System.out.println(temp.data);
			System.out.print("next:");
			if(temp.next==null)
				System.out.println("NULL");
			else
				System.out.println(temp.next.data);
			temp=temp.next;
		}
		System.out.println("NULL");
		System.out.println();
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
			newnode.prev=temp;
			temp.next=newnode;
		}
	}
	void insertpos(int element,int pos)
	{
		int i=0;
		Node newNode=new Node(element);
		Node temp=head;
		while(i<pos-1)
		{
			temp=temp.next;
			i++;
		}
		newNode.prev=temp;
		newNode.next=temp.next;
		temp.next.prev=newNode;
		temp.next=newNode;
	}
}
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int i)
	{
		data=i;
	}
}
