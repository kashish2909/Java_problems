import java.util.Arrays;
import java.util.Scanner;


public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        for(int i=1;i<arr.length;i++)
        {
            int key=arr[i];
            int j=i-1;
            for(;j>=0 && arr[j]>key;j--)
            {
                arr[j+1]=arr[j];
            }
            arr[j+1]=key;
        }
        System.out.println(Arrays.toString(arr));
    }
}