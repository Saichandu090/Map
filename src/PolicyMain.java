import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class PolicyMain
{
    public static void main(String[] args)
    {
        Map<Integer,List<Policy>> map1=new HashMap<>();

        Map<Policy,List<Policy>> map2=new LinkedHashMap<>();

        Map<LocalDate,List<Policy>> map3=new TreeMap<>(LocalDate::compareTo);

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Scanner sc=new Scanner(System.in);

        String enterChoice="Yes";
        while(enterChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the details of the new Policy : ");
            System.out.println("Enter the Policy Number : ");
            int pNum=sc.nextInt();
            System.out.println("Enter the Policy Holder Name : ");
            String pName=sc.next();
            System.out.println("Enter the expiry date : ");
            System.out.println("Enter the date in the format (dd-MM-yyyy): ");
            LocalDate date=null;

            while(true)
            {
                String input=sc.next();
                try
                {
                    date = LocalDate.parse(input, formatter);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Invalid date!!!");
                }
            }

            List<Policy> list=new ArrayList<>();
            list.add(new Policy(pNum,pName,date));
            map1.put(pNum,list);
            map2.put(new Policy(pNum,pName,date),list);
            map3.put(date,list);

            System.out.println("Do you want to add more policies? 'Yes' Or 'No' ");
            enterChoice=sc.next();
        }

        System.out.println("Do you want to search a Policy ? 'Yes' Or 'No' ");
        String searchChoice=sc.next();
        while(searchChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the Policy Number :");
            int pNum=sc.nextInt();
            if(map1.containsKey(pNum))
            {
                Set<Integer> st=map1.keySet();
                for(int i : st)
                {
                    if(i==pNum)
                        System.out.println(map1.get(i));
                }
            }
            System.out.println("Do you want to search a Policy ? 'Yes' Or 'No' ");
            searchChoice=sc.next();
        }


        System.out.println("Do you want to see the expiring policies within thirty days ? 'Yes' Or 'No' ");
        String seeChoice=sc.next();
        if(seeChoice.equalsIgnoreCase("yes"))
        {
            LocalDate today = LocalDate.now();
            LocalDate thirtyDaysFromNow = today.plusDays(30);

            System.out.println("Policies Expiring within thirty days are : ");
            Set<Policy> keys=map2.keySet();
            for(Policy key : keys)
            {
                if(!key.getExpiryDate().isBefore(today) && !key.getExpiryDate().isAfter(thirtyDaysFromNow))
                    System.out.println(key);
            }
        }

        System.out.println("Do you want to see the Expired Policies ? 'Yes' Or 'No' ");
        String expireChoice=sc.next();
        if(expireChoice.equalsIgnoreCase("Yes"))
        {
            LocalDate today=LocalDate.now();
            Set<Policy> keys=map2.keySet();
            for(Policy key : keys)
            {
                List<Policy> dd=map2.get(key);
                for(Policy p : dd)
                {
                    if(p.getExpiryDate().isBefore(today))
                        System.out.println(dd);
                }
            }
        }

        System.out.println("Do you want to sort the Policies according to expiry date ? 'Yes' Or 'No' ");
        String polChoice=sc.next();
        if(polChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Sorted the list of Policies According to ExpiryDate");
            Set<LocalDate> keys = map3.keySet();
            for (LocalDate key : keys) {
                System.out.println(map3.get(key));
            }
        }
    }
}

