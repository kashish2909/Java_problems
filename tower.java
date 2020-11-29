class tower{
    public static void main(String abc[])
    {
        int n=2;
        towerof(n,'a','b','c');
    }
    static void towerof(int n,char from,char aux,char to)
    {
        if(n==1)
        {
            System.out.println(from+"->"+to);
            return;
        }
        towerof(n-1,'a','c','b');
        System.out.println(from+"->"+to);
        towerof(n-1,'b','a','c');
    }
}