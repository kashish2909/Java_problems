class LinkedListNode<T>
{
    int data;
    LinkedListNode<T> next;
    public LinkedListNode(int d)
    {
        data=d;
        next=null;
    }
}

public class Solution {

    public static void main(String[] args) {
        LinkedListNode<Integer> head=new LinkedListNode(1);
        head.next=new LinkedListNode(4);
        head.next.next=new LinkedListNode(5);
        head.next.next.next=new LinkedListNode(2);
        System.out.println("yo");
        System.out.println(head.data+" "+head.next.data+" "+head.next.next.data+" "+head.next.next.next.data);
        mergeSort(head);
        System.out.println(head.data+" "+head.next.data+" "+head.next.next.data+" "+head.next.next.next.data);
    }

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		// write your code here
        LinkedListNode<Integer> temp=head;
        int cnt=0;
        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }
        System.out.println(cnt);
        util(head,0,cnt-1);
        return head;
	}
    static void util(LinkedListNode<Integer> head,int si,int ei)
    {
        if(si<ei)
        {
            int m=(si+ei)/2;
            util(head,si,m);
            util(head,m+1,ei);
            merge(head,si,m,ei);
        }
    }
    static void merge(LinkedListNode<Integer> head,int si,int m,int ei)
    {
        LinkedListNode<Integer> newNode=null;
        int i=0;
        LinkedListNode<Integer> temp=head;
        while(i<si)
        {
            i++;
            temp=temp.next;
        }
        LinkedListNode<Integer> temp2=temp;
        int j=si;
        while(j<m)
        {
            j++;
            temp2=temp2.next;
        }
        LinkedListNode<Integer> temp3=newNode;
        while(temp!=null && temp2!=null)
        {
            if(temp.data<temp2.data)
            {
                if(temp3==null)
                {
                    newNode=temp;
                    temp=temp.next;
                    temp3=temp;
                }
                else
                {
                    temp3.next=temp;
                    temp3=temp3.next;
                    temp=temp.next;
                }
            }
            else if(temp.data>=temp2.data)
            {
                if(temp3==null)
                {
                    temp3=temp2;
                    newNode=temp3;
                    temp2=temp2.next;
                }
                else
                {
                    temp3.next=temp2;
                    temp3=temp3.next;
                    temp2=temp2.next;
                }
            }
        }
        head=newNode;
    }
}
