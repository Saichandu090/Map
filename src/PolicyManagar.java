import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PolicyManagar
{
    Map<Integer, List<Policy>> map1=new HashMap<>();

    Map<Policy,List<Policy>> map2=new LinkedHashMap<>();

    Map<LocalDate,List<Policy>> map3=new TreeMap<>(LocalDate::compareTo);

    public void addPolicy(int pNum,String pName,String date)
    {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate dates=null;

        while(true)
        {
            String input=date;
                try
                {
                    dates = LocalDate.parse(input, formatter);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println("Invalid date!!!");
                }
            }

            List<Policy> list=new ArrayList<>();
            list.add(new Policy(pNum,pName,dates));
            map1.put(pNum,list);
            map2.put(new Policy(pNum,pName,dates),list);
            map3.put(dates,list);
    }

    public Policy getPolicy(int num)
    {
        Set<Policy> keys=map2.keySet();
        for(Policy p : keys)
        {
            if(p.getPolicyNumber()==num)
                return p;
        }
        return null;
    }

    public List<Policy> getPolicyExpiringSoon()
    {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);

        List<Policy> kio=new ArrayList<>();
        System.out.println("Policies Expiring within thirty days are : ");
        Set<Policy> keys=map2.keySet();
        for(Policy key : keys)
        {
            if(!key.getExpiryDate().isBefore(today) && !key.getExpiryDate().isAfter(thirtyDaysFromNow))
                kio.add(key);
        }

        return kio;
    }

    public List<Policy> getPoliciesByPolicyHolder(String name)
    {
        List<Policy> kio=new ArrayList<>();
        Set<Policy> keys=map2.keySet();
        for(Policy p : keys)
        {
            List<Policy> dd=map2.get(p);
            for(Policy l: dd)
            {
                if(l.getPolicyHolderName().equals(name))
                    kio.add(l);
            }
        }
        return kio;
    }

    public void removeExpiredPolicies()
    {
        LocalDate today=LocalDate.now();
        Set<Policy> keys=map2.keySet();
        for(Policy p : keys)
        {
            List<Policy> dd=map2.get(p);
            for(Policy l:dd)
            {
                if(l.getExpiryDate().isBefore(today))
                {
                    map2.remove(l);
                    map3.remove(l.getExpiryDate());
                    map1.remove(l.getPolicyNumber());
                }
            }
        }
    }

    public void displayPolicies()
    {
        if(!(map2.isEmpty()))
        {
            Set<Policy> keys=map2.keySet();
            for(Policy p : keys)
            {
                System.out.println(map2.get(p));
            }
        }
    }
}
