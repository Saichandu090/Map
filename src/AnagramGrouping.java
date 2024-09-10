import java.util.*;

public class AnagramGrouping
{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        Map<String[], String> mp=new HashMap<>();

        String choice="Yes";
        while(choice.equalsIgnoreCase("Yes"))
        {
            String[] ss = new String[2];
            System.out.println("Enter two Strings : ");
            String st = sc.next();
            String st1 = sc.next();
            ss[0] = st;
            ss[1] = st1;

            String ls = get(ss[0], ss[1]);
            mp.put(ss, ls);

            System.out.println("Do you want to add more ? 'Yes' or 'No' ");
            choice=sc.next();
        }
        Set<String[]> keys=mp.keySet();
        for(String[] s:keys)
        {
            System.out.println(s[0]+","+s[1]+" -> "+mp.get(s));
        }
    }

    public static String get(String s1,String s2)
    {
        boolean rs=isAnagram(s1,s2);
        if(rs)
            return "Anagrams";
        else
            return "Not Anagrams";
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
