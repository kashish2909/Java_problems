import java.util.*;
class Node
{
	int data;
	Node next;
	Node(int i)
	{
		data=i;
		next=null;
	}
}
public class LL 
{
	static int nodes=0;
	Node head=null;
	public static void main(String abc[])
	{
		System.out.println("Enter Linked list");
		System.out.println("How many nodes to enter");
		Scanner sc=new Scanner(System.in);
		int count=sc.nextInt();
		LL obj=new LL();
		for(int i=0;i<count;i++)
		{
			System.out.println("Enter element"+(i+1));
			int temp=sc.nextInt();
			obj.insertend(temp);
		}
		obj.printlist();
		while(true)
		{
			System.out.println("Where you want to insert  1:at end  2:at beginning  3:in middle  4:exit");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
				{
					System.out.println("Enter element");
					int temp=sc.nextInt();
					obj.insertend(temp);
					obj.printlist();
					break;
				}
			case 2:
			{
				System.out.println("Enter element");
				int temp=sc.nextInt();
				obj.insertbeg(temp);
				obj.printlist();
				break;
			}
			case 3:
			{
				System.out.println("Enter element");
				int temp=sc.nextInt();
				System.out.println("Enter position");
				int pos=sc.nextInt();
				System.out.println("1:Before "+pos+" position  2:After "+pos+" position  3:At "+pos+" position");
				int opt=sc.nextInt();
				switch(opt)
				{
				case 1:
				{
					obj.insertmidbefore(temp, pos-1);
					obj.printlist();
					break;
				}
				case 2:
				{
					obj.insertmidafter(temp, pos-1);
					obj.printlist();
					break;
				}
				case 3:
				{
					obj.insertmidat(temp, pos-1);
					obj.printlist();
					break;
				}
				default:
				{
					System.out.println("Wrong input");
				}
				}
				break;
			}
			case 4:
			{
				System.exit(0);
			}
			default:
			{
				System.out.println("Wrong input");
			}
			}
		}
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
			nodes++;
		}
		else
		{
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newNode;
			nodes++;
		}
	}
	void insertbeg(int i)
	{
		Node newNode=new Node(i);
		if(head==null)
		{
			head=newNode;
			nodes++;
		}
		else
		{
			newNode.next=head;
			head=newNode;
			nodes++;
		}
	}
	void insertmidafter(int element,int pos)
	{
		LL obj=new LL();
		if(pos==0)
		{
			obj.insertbeg(element);
		}
		else if(pos==nodes)
		{
			obj.insertend(element);
		}
		else if(pos>nodes)
		{
			System.out.println("Error!!!");
		}
		else
		{
			int i=0;
			Node newNode=new Node(element);
			Node temp=head;
			while(i<pos)
			{
				temp=temp.next;
				i++;
			}
			newNode.next=temp.next;
			temp.next=newNode;
			
		}
	}
	void insertmidbefore(int element,int pos)
	{
		LL obj=new LL();
		if(pos==0)
		{
			obj.insertbeg(element);
		}
		else if(pos==nodes)
		{
			obj.insertend(element);
		}
		else if(pos>nodes)
		{
			System.out.println("Error!!!");
		}
		else
		{
			int i=0;
			Node newNode=new Node(element);
			Node temp=head;
			while(i<pos-1)
			{
				temp=temp.next;
				i++;
			}
			newNode.next=temp.next;
			temp.next=newNode;
			
		}
	}
	void insertmidat(int element,int pos)
	{
		LL obj=new LL();
		if(pos==0)
		{
			obj.insertbeg(element);
		}
		else if(pos==nodes)
		{
			obj.insertend(element);
		}
		else if(pos>nodes)
		{
			System.out.println("Error!!!");
		}
		else
		{
			int i=0;
			Node newNode=new Node(element);
			Node temp=head;
			while(i<pos-1)
			{
				temp=temp.next;
				i++;
			}
			newNode.next=temp.next.next;
			temp.next=newNode;
			
		}
	}
}
