public class Circular {
    public static void main(String[] args) {
        Circular list=new Circular();
        list.insertAtEnd(0);
        list.show();
        list.insertAtEnd(1);
        list.show();
        list.insertAtEnd(2);
        list.show();
        list.insertAtBeginning(69);
        list.show();
        list.insertAfter(69, 70);
        list.show();
        list.delete(2);
        list.show();
    }
    
    void delete(int key){
        Node temp=head;
        if(head.next==head && head.data==key){
            head=null;
        }
        else if(head.data==key){
            while(temp.next!=head)
                temp=temp.next;
            head=head.next;
            temp.next=head;
        }
        else{
            while(temp.next!=head && temp.next.data!=key){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        
    }
    
    void insertAfter(int after,int key){
        Node temp=head;
        Node new_node=new Node(key);
        
        if(head.data==after && head.next==head){
            
            head.next=new_node;
            new_node.next=head;
        }
        else{
           while(temp.next!=head && temp.data!=after){
               temp=temp.next;
           }
           
           if(temp.next==head && temp.data!=after)
                System.out.println("No element found");
           
           else{
               new_node.next=temp.next;
               temp.next=new_node;
           }
          
        }
    }
    
    void insertAtBeginning(int key){
        if(head==null){
            head=new Node(key);
            head.next=head;
        }
        else{
            Node temp=head;
            Node new_node=new Node(key);
            
            while(temp.next!=head)
                temp=temp.next;
            
            temp.next=new_node;
            new_node.next=head;
            head=new_node;
        }
    }
    
    void insertAtEnd(int key){
        if(head==null){
            head=new Node(key);
            head.next=head;
        }
        else{
            Node temp=head;
           
            while( temp.next!=head){
                temp=temp.next;
            }
            
            Node new_node=new Node(key);
            temp.next=new_node;
            new_node.next=head;
        }
    }
    
    void show(){
        Node temp=head;
        if(temp!=null && temp.next==head){
            System.out.println(temp.data+" ");
        }
        else{
            if(temp!=null)
            {
                while(temp.next!=head){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
             System.out.print(temp.data+" ");
             System.out.println();
            }
             
        }
       
    }
    
    Node head;
    class Node{
        
        Node next;
        int data;
        
        Node(int value){
            data=value;
        }
    }
}