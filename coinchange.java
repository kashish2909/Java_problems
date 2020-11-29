import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class coinchange {

    // Complete the getWays function below.
    static long getWays(long n, long[] c)
    {
        long sol[][]=new long[c.length+1][(int)n+1];
        for(int i=0;i<c.length+1;i++)
        {
          sol[i][0]=1;
        }
        for(int i=0;i<n+1;i++)
        {
          sol[0][i]=0;
        }
        for(int i=1;i<c.length+1;i++)
        {
          for(int j=1;j<n+1;j++)
          {
            if(c[i-1]<=j)
            {
              sol[i][j]=sol[i-1][j]+sol[i][(int)(j-c[i-1])];
            }
            else
            {
              sol[i][j]=sol[i-1][j];
            }
          }
        }
        for(int i=0;i<c.length+1;i++)
        {
          for(int j=0;j<n+1;j++)
          {
            System.out.print(sol[i][j]+"  ");
          }
          System.out.println();
        }
        return sol[c.length][(int)n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
