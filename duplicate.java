import java.util.Scanner;

public class duplicate
{
    public static void main(String abc[])
    {
        int arr[]={1,1,1,2,2,3,3,3,4,4,5,6};
        int j=0;
        int count=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]!=arr[i+1])
            {
                arr[++j]=arr[i+1];
                count++;
            }
        }
        for(int i=0;i<=count;i++)
        System.out.println(arr[i]);
    }
}