import java.util.*;

public class Heap_sort {

    public static void main(String[] args) {
        int arr[]={2,6,8,5,4,3};
        inplaceHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

	public static void inplaceHeapSort(int input[]) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Change in the given input itself.
		* Taking input and printing output is handled automatically.
		*/
		heapify(input,input.length);
		for(int i=input.length-1;i>=0;i--)
		{
		int temp=input[i];
		input[i]=input[0];
		input[0]=temp;
		heapify(input,i);
		}
        
        // int n = arr.length; 
  
        // for (int i = n / 2 - 1; i >= 0; i--) 
        //     heapify(arr, n, i); 
  
        // for (int i=n-1; i>=0; i--) 
        // { 
        //     int temp = arr[0]; 
        //     arr[0] = arr[i]; 
        //     arr[i] = temp; 
  
        //     heapify(arr, i, 0); 
        // }
	}
    static void heapify(int heap[],int n)
    {
        int i=0;
        int curr;
        int left;
        int right;
        while(2*i+1<n)
        {
            curr=heap[i];
            left=heap[2*i+1];
            if(2*i+2<n)
                right=heap[2*i+2];
            else
                right=Integer.MIN_VALUE;
            if(curr<left || curr<right)
            {
                if(left>right)
                {
                    int temp=left;
                    heap[2*i+1]=curr;
                    heap[i]=temp;
                    i=2*i+1;
                }
                else if(left<right)
                {
                    int temp=right;
                    heap[2*i+2]=curr;
                    heap[i]=temp;
                    i=2*i+2;
                }
            }
            else if(curr>left && curr>right)
                break;
        }
    }
}