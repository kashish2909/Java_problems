import java.util.Arrays;

class QuickSort
{
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quick_sort(int[] arr,int l,int h)
    {
        if(l<h)
        {
            int p = partition(arr,l,h);
            quick_sort(arr, l, p-1);
            quick_sort(arr, p+1, h);
        }
    }
    static int partition(int[] arr,int l,int h)
    {
        int key=arr[h];
        int i=l-1;
        int j=l;
        for(;j<h;j++)
        {
            if(arr[j]<key)
            {
                i++;
                int tmp=arr[j];
                arr[j]=arr[i];
                arr[i]=tmp;
            }
        }
        int tmp=arr[h];
        arr[h]=arr[i+1];
        arr[i+1]=tmp;
        return i+1;
    }
}