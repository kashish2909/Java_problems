import java.util.*;
public class merge_sort {
    public static void main(String args[])
    {
        int arr[]={2,6,8,5,4,3};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

	// public static void mergeSort(int[] input){
	// 	// Write your code here
	// 	util(input,0,input.length-1);
	// }
    // static void util(int arr[],int si,int ei)
    // {
    //     if(si>=ei)
    //         return;
    //     int mid=(si+ei)/2;
    //     util(arr,si,mid);
    //     util(arr,mid+1,ei);
    //     merge(arr,si,mid,ei);
    // }
    // static void merge(int arr[],int si,int mid,int ei)
    // {
    //     int temp[]=new int[ei-si+1];
    //     int itr=0;
    //     int i=si;
    //     int j=mid+1;
    //     while(i<=mid && j<=ei)
    //     {
    //         if(arr[i]<=arr[j])
    //         {
    //             temp[itr++]=arr[i++];
    //         }
    //         else if(arr[i]>arr[j])
    //         {
    //             temp[itr++]=arr[j++];
    //         }
    //     }
    //     while(i<=mid)
    //     {
    //         temp[itr++]=arr[i++];
    //     }
    //     while(j<=ei)
    //     {
    //         temp[itr++]=arr[j++];
    //     }
    //     //System.out.println(Arrays.toString(temp));
    //     //int itr2=0;
    //     for(int p=si;p<=ei;p++)
    //     {
    //         arr[p]=temp[p-si];
    //     }
    // }
    public static void quickSort(int[] input) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
		util(input,0,input.length-1);
	}
	static void util(int arr[],int si,int ei)
    {
        if(si>=ei)
            return;
        int p=partition(arr,si,ei);
        util(arr,si,p-1);
        util(arr,p+1,ei);
    }
    static int partition(int[] arr,int si,int ei)
    {
        int i=si-1;
        int j=si;
        int pivot=arr[ei];
        while(j<ei)
        {
            if(arr[j]<pivot)
            {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            j++;
        }
        int x=arr[i+1];
        arr[i+1]=pivot;
        arr[ei]=x;
        return i+1;
    }
}