import java.util.*;

class SelectionSort {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        for(int i=0;i<n-1;i++)
        {
            int min_idx=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[min_idx])
                {
                    min_idx = j;
                }
            }
            int temp=arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }   
}