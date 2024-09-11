import java.util.*;

public class DuplicatesInArray
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Map<int[],List<String>> map=new HashMap<>();

        String enterChoice="Yes";
        while (enterChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the size of the Array");
            int size=sc.nextInt();

            int[] ar=new int[size];
            System.out.println("Enter "+size+" values inside the array ");
            for(int i=0;i<ar.length;i++)
            {
                ar[i]=sc.nextInt();
            }
            int[] dup=removeDup(ar);
            List<String > rs=countFreq(dup);
            map.put(ar,rs);

            System.out.println("Do you want to enter a new array ? 'Yes' Or 'No' ");
            enterChoice=sc.next();
        }

        Set<int[]> keys=map.keySet();
        for(int[] a : keys)
        {
            System.out.println("Size : "+a.length+" -> "+map.get(a));
        }
    }

    public static List<String> countFreq(int[] ar)
    {
        List<String > ls=new ArrayList<>();
        boolean[] rr=new boolean[ar.length];
        for(int i=0;i<ar.length;i++)
        {
            if(rr[i]==false)
            {
                int count = 0;
                for (int j = 0; j < ar.length; j++)
                {
                    if (i==j)
                    {
                        count++;
                        rr[j]=true;
                    }
                }
                if(rr[i])
                   ls.add(ar[i] + "->" + count);
            }
        }
        return ls;
    }

    public static int[] removeDup(int[] ar)
    {
        boolean[] rs=new boolean[ar.length];
        int k=0;
        for(int i=0;i<ar.length;i++)
        {
            if(!rs[i])
            {
                for(int j=i+1;j<ar.length;j++)
                {
                    if(ar[i]==ar[j])
                    {
                        k++;
                        rs[j] = true;
                    }
                }
            }
        }
        int[] rr=new int[k];
        for(int i=0,j=0;i<ar.length;i++)
        {
            if(rs[i])
                rr[j++]=ar[i];
        }
        return rr;
    }
}
