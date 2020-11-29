import java.util.*;
public class StringSubsequences {
    public static void main(String[] args) {
        String s="abcd";
        ArrayList<String> ans =new ArrayList<String>();
        int n=util(s,ans);
        System.out.println(ans);
    }

    public static int util(String s, ArrayList<String> ans)
    {
        if(s=="")
        {
            ans.add("");
            return 1;
        }
        int n;
        if(s.length()>1)
            n=util(s.substring(1),ans);
        else
            n=util("",ans);
        for(int i=0;i<n;i++)
        {
            ans.add(Character.toString(s.charAt(0))+ans.get(i));
        }
        return 2*n;
    }
}