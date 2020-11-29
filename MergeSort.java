import java.util.Arrays;
import java.util.Scanner;


public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr,int low,int high)
    {
        if(low<high)
        {
            int mid=(high+low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    static void merge(int arr[],int low,int mid,int high)
    {
        int arr1[]=new int[mid-low+1];
        int arr2[]=new int[high-mid];
        for(int i=0;i<arr1.length;i++)
            arr1[i]=arr[low+i];
        for(int i=0;i<arr2.length;i++)
            arr2[i]=arr[mid+1+i];
        int i=0;
        int j=0;
        int k=low;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<=arr2[j])
            {
                arr[k]=arr1[i];
                i++;
                k++;
            }
            else
            {
                arr[k]=arr2[j];
                j++;
                k++;
            }
        }
        while(i<arr1.length)
        {
            arr[k]=arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length)
        {
            arr[k]=arr2[j];
            j++;
            k++;
        }
    }
}