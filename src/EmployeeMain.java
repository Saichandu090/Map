import java.util.*;

public class EmployeeMain
{
    public static void main(String[] args) {

        Map<Integer, List<Employee>> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);

        String enterChoice="Yes";
        while(enterChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the details of the Employee : ");
            System.out.println("Name : ");
            String empName=sc.next();
            System.out.println("Id : ");
            Integer empId=sc.nextInt();
            System.out.println("Department : ");
            String empDept=sc.next();

            List<Employee> list=new ArrayList<>();
            list.add(new Employee(empName,empId,empDept));
            map.put(empId,list);

            System.out.println("Do you want to add more ? 'Yes' Or 'No' ");
            enterChoice=sc.next();
        }

        System.out.println("Do you want to search any Employee? 'Yes' Or 'No' ");
        String searchChoice=sc.next();
        while(searchChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the Id of the Employee : ");
            int getId=sc.nextInt();
            if(map.containsKey(getId))
            {
                Set<Integer> keys=map.keySet();
                for(Integer i : keys)
                {
                    if(i.equals(getId))
                        System.out.println(map.get(i));
                }
            }
            else
                System.out.println("Incorrect Employee Id!!");

            System.out.println("\"Do you want to search any Employee? 'Yes' Or 'No' ");
            searchChoice=sc.next();
        }

        System.out.println("Do you want to display the all Employees details ? 'Yes' Or 'No' ");
        String dispChoice=sc.next();
        if(dispChoice.equalsIgnoreCase("Yes"))
        {
            Set<Integer> keys=map.keySet();
            for(int i : keys)
            {
                System.out.println(i+" -> "+map.get(i));
            }
        }
    }
}
