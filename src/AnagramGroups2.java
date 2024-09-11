import java.util.*;

public class AnagramGroups2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Map<String[], List<String>> map=new HashMap<>();

        String enterChoice="Yes";
        while(enterChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the size of the Array");
            int size=sc.nextInt();

            String[] s=new String[size];

            List<String> list=new ArrayList<>();
            System.out.println("Enter "+size+" Strings : ");
            for(int i=0;i<s.length;i++)
            {
                s[i]=sc.next();
            }
            for(int i=0;i<s.length;i++)
            {
                for(int j=i+1;j<s.length;j++)
                {
                    if(isAnagram(s[i],s[j]))
                       list.add(s[i]+"->"+s[j]);
                }
            }

            map.put(s,list);
            System.out.println("Do you want to add one more array ? 'Yes' Or 'No' ");
            enterChoice=sc.next();
        }

        System.out.println("=================");
        Set<String[]> keys=map.keySet();
        for(String[] s : keys)
        {
            System.out.println("Size : "+s.length+" -> "+map.get(s));
        }
    }

    public static boolean isAnagram(String s1,String s2)
    {
        int[] r1=countFreq(s1);
        int[] r2=countFreq(s2);
        for(int i=0;i<128;i++)
        {
            if(r1[i]!=r2[i])
                return false;
        }
        return true;
    }

    public static int[] countFreq(String st)
    {
        int[] rs=new int[128];
        for(int i=0;i<st.length();i++)
        {
            char ch=st.charAt(i);
            rs[ch]++;
        }
        return rs;
    }
}
