/***************
 * BinaryTreeNode class already given - 
 * 
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}
***************/

/**************
 * Main function that we are using internally 
 * 
public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
*******************/
import java.util.*;
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}
public class BinarySearchTree {
    // Complete this class
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

        }
    }
    BinaryTreeNode<Integer> root=null;
    
    boolean search(int data)
    {
        return searchUtil(root,data);
    }
	
    boolean searchUtil(BinaryTreeNode<Integer> node,int data)
    {
        // if(node==null)
        // {
        //     return false;
        // }
        // if(node.data==data)
        //     return true;
        // if(node.data>data)
        //     return searchUtil(node.left,data);
        // else if(node.data<data)
        //     return searchUtil(node.right,data);
        return false;
    }
    
    void insertData(int data)
    {
        root=insUtil(root,data);
        printTree();
    }
	
    BinaryTreeNode<Integer> insUtil(BinaryTreeNode<Integer> node,int data)
    {
        if(node==null)
        {
            node=new BinaryTreeNode<Integer>(data);
            return node;
        }
        else
        {
        if(node.data>data)
            node.left=insUtil(node.left,data);
        else if(node.data<data)
            node.right=insUtil(node.right,data);
        }
        return node;
    }
    
    void deleteData(int data)
    {
        root=delUtil(root,data);
    }
	
    BinaryTreeNode<Integer> findmin(BinaryTreeNode<Integer> node)
    {
        if(node==null)
            return null;
        while(node.left!=null)
        {
            node=node.left;
        }
        return node;
    }
    
    BinaryTreeNode<Integer> delUtil(BinaryTreeNode<Integer> node,int data)
    {
        if(root==null)
            return null;
        if(node.left!=null && data<node.data)
            node.left=delUtil(node.left,data);
        else if(node.right!=null && node.data<data)
            node.right=delUtil(node.right,data);
        else
        {
            if(node.left==null)
            {
                return node.right;
            }
            else if(node.right==null)
            {
                return node.left;
            }
            else
            {
                BinaryTreeNode<Integer> temp=findmin(node.right);
                node.data=temp.data;
                delUtil(node.right,temp.data);
            }
        }
        return root;
    }
    
    void printTree()
    {
        printUtil(root);
    }
    
    void printUtil(BinaryTreeNode<Integer> node)
    {
        if(node==null)
        {
            return;
        }
        printUtil(node.left);
        System.out.print(node.data+":");
        if(node.left!=null)
            System.out.print("L:"+node.left.data+",");
        if(node.right!=null)
            System.out.println("R:"+node.right.data);
        printUtil(node.right);
    }
}
