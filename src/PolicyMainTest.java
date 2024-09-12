import java.time.LocalDate;
import java.util.*;

public class PolicyMainTest
{
    public static void main(String[] args)
    {
        PolicyManagar p=new PolicyManagar();
        p.addPolicy(1,"Sai", "09-09-2024");
        p.addPolicy(2,"Chandu","10-09-2024");
        p.addPolicy(3,"Vamsi","25-09-2024");

        p.displayPolicies();

        System.out.println("================");
        List<Policy> l=p.getPoliciesByPolicyHolder("Sai");
        l.forEach(System.out::println);

        System.out.println("================");
        List<Policy> ll=p.getPolicyExpiringSoon();
        ll.forEach(System.out::println);

        System.out.println("================");
        p.removeExpiredPolicies();
        p.displayPolicies();

    }
}
