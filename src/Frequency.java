import java.util.*;

public class Frequency
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Map<String, List<List<String>>> mp = new HashMap<>();
        String choice="Yes";
        while(choice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the String : ");
            String s = sc.next();
            List<List<String>> rs = countFreq(s);
            mp.put(s, rs);

            System.out.println("Do you want to add more ? 'Yes' Or 'No' ");
            choice=sc.next();
        }

        Set<String> keys=mp.keySet();
        for(String sd : keys)
        {
            System.out.println(sd+" -> "+mp.get(sd));
        }
    }

    public static List<List<String>> countFreq(String st)
    {
        List<List<String>> rs=new ArrayList<>();
        int[] as=new int[128];
        for(int i=0;i<st.length();i++)
        {
            char ch=st.charAt(i);
            as[ch]++;
        }
        for(int j=0;j<128;j++)
        {
            if(as[j]!=0)
            {
                rs.add(Collections.singletonList((char) j + " -> " + as[j]));
            }
        }
        return rs;
    }
}
