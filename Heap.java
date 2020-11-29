import java.util.Arrays;

//MinHeap
public class Heap {
    
    static int capacity = 10;
    static int A[] = new int[capacity];
    static int size = 0;
    
    public static void main(String[] args) {
        Heap h = new Heap();
        h.initalise();
        h.insert(3);
        h.insert(2);
        //System.out.println(Arrays.toString(A));
        h.delete_key(1);
        //System.out.println(Arrays.toString(A));
        h.insert(15);
        h.insert(5);
        h.insert(4);
        h.insert(45);
        System.out.println(h.extractMin());
        System.out.println(A[0]);
        h.changeKey(2,1);
        System.out.println(A[0]);
    }
    void initalise(){
        for(int i = 0;i<capacity;i++)
            A[i] = Integer.MAX_VALUE;
    }
    void insert(int key)
    {
        if(size == capacity){
            System.out.println("Overflow");
            return;
        }
        A[size] = key;
        
        int i = size;
        while(i>=0 && A[(i-1)/2]>A[i]){
            int temp = A[i];
            A[i] = A[(i-1)/2];
            A[(i-1)/2] = temp;
            
            i = (i-1)/2;
        }
        size++; 
    }
    
    void changeKey(int pos,int value){
        if(pos>=capacity){
            System.out.println("Overflow");
            return;
        }
        A[pos] = value;
        
        int i = pos;
        while(i>=0 && A[(i-1)/2]>A[i]){
            int temp = A[i];
            A[i] = A[(i-1)/2];
            A[(i-1)/2] = temp;
            
            i = (i-1)/2;
        }
    }
    void delete_key(int pos){
        if(pos>=capacity){
            System.out.println("Overflow");
            return;
        }
        if(pos<0){
            System.out.println("Underflow");
            return;
        }
        if(size == 1 && pos ==0){
            size--;
        }
       // System.out.println("Before"+Arrays.toString(A));
        changeKey(pos,Integer.MIN_VALUE);
       // System.out.println(Arrays.toString(A));
        extractMin();
        
    }
    int extractMin(){
//       if(size == 1){
//           size--;
//           return A[size+1];
//       } 
//       if(size == 0){
//           System.out.println("Underflow");
//           return -9999;
//       }
       int min = A[0];
        System.out.println("size and A[size] "+size + A[size]);
       A[0] = A[size-1];
       size--;
       heapify(0);
       
       return min;
    }
    
    void heapify(int key){
        int min = key;
        int left = 2*min+1,right = 2*min + 2;
        if(left<capacity && A[left]<A[min])
            min = left;
        if(right<capacity && A[right]<A[min])
            min = right;
        
        if(min!=key){
            int temp = A[key];
            A[key] = A[min];
            A[min] = temp;
            heapify(min);
        }
    }
}