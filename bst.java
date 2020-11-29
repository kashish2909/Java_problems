class Node
{
   int data;
   Node left;
   Node right;
   Node(int i)
   {
    data=i;
   }    
}

class bst
{
    static Node root=null;
    public static void main(String abc[])
    {
        bst obj=new bst();
        root=obj.insert(5,root);
        root=obj.insert(4,root);
        root=obj.insert(7,root);
        root=obj.insert(6,root);
        root=obj.insert(9,root);
        root=obj.insert(1,root);
        root=obj.insert(2,root);
        root=obj.insert(3,root);
        obj.inorder(root);
        System.out.println();
        obj.delete(7, root);
        obj.inorder(root);
        System.out.println();
        obj.levelorder(root);
    }
    Node insert(int i,Node root)
    {
        if(root==null)
        {
            root=new Node(i);
            return root;
        }
        else
        {
            if(i<root.data)
            {
                root.left=insert(i, root.left);
            }
            else if(i>root.data)
            {
                root.right=insert(i, root.right);
            }
        }
        return root;
    }

    Node delete(int i,Node root)
    {
        if(root==null)
        {
            return null;
        }
        if(i<root.data)
        {
            root.left=delete(i,root.left);
        }
        else if(i>root.data)
        {
            root.right=delete(i, root.right);
        }
        else
        {
            if(root.right==null)
            {
                return root.left;
            }
            if(root.left==null)
            {
                return root.right;
            }
            bst obj=new bst();
            root.data=obj.findmin(root.right);
            root.right=delete(root.data,root.right);
        }
        return root;
    }
    int findmin(Node root)
    {
        Node temp=root;
        while(temp.left!=null)
        {
            temp=temp.left;
        }
        return temp.data;
    }
    void inorder(Node root)
    {
        if(root.left!=null)
            inorder(root.left);
        System.out.print(root.data+" ");
        if(root.right!=null)
            inorder(root.right);
    }
    int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            int lheight=height(root.left);
            int rheight=height(root.right);
            if(lheight>rheight) return lheight+1;
            else return rheight+1;
        }
    }
            int printgivenlevel(Node root,int level)//also prints sum at each level
            {
                int sum=0;
                if(root==null)
                {
                    return 0;
                }
                if(level==1)
                {
                    System.out.print(root.data+"  ");
                    return root.data;
                }
                if(level>1)
                {
                    sum+=printgivenlevel(root.left,level-1);
                    sum+=printgivenlevel(root.right,level-1);
                }
                return sum;
            }
            void levelorder(Node root)
            {
                bst obj=new bst();
                int h=obj.height(root);
                for(int i=1;i<=h;i++)
                {
                 int sum=obj.printgivenlevel(root, i);
                 System.out.println(sum);
             }
         }
     }