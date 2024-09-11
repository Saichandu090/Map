import java.util.*;

public class PhoneBookMain
{
    public static void main(String[] args) {

        Map<String,List<PhoneBook>> map=new TreeMap<>();
        Scanner scan=new Scanner(System.in);

        String choice="Yes";
        while(choice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the Details of the Contact :");
            System.out.println("Name : ");
            String name=scan.next();
            System.out.println("Age : ");
            int age=scan.nextInt();
            System.out.println("Phone Number : ");
            long number=scan.nextLong();
            System.out.println("Place : ");
            String place=scan.next();

            List<PhoneBook> list =new ArrayList<>();
            list.add(new PhoneBook(name,age,number,place));

            map.put(name,list);

            System.out.println("Do you want to add a new Contact ? 'Yes' Or 'No' ");
            choice= scan.next();
        }

        System.out.println("Do you want to remove any contact ? 'Yes' Or 'No' ");
        String removeChoice= scan.next();
        while(removeChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Enter the Contact name : ");
            String contName= scan.next();
            if(map.containsKey(contName))
            {
                map.remove(contName);
                System.out.println(contName+" removed Successfully!!");
            }
            else
                System.out.println(contName+" Not found!!");

            System.out.println("Do you want to delete any contact ? 'Yes' Or 'No' ");
            removeChoice= scan.next();
        }

        System.out.println("Do you want to search any contact ? 'Yes' Or 'No' ");
        String searchChoice= scan.next();
        while(searchChoice.equalsIgnoreCase("Yes"))
        {
            System.out.println("Specify the contact name : ");
            String sname=scan.next();
            if(map.containsKey(sname))
            {
                Set<String> keys=map.keySet();
                for(String i : keys)
                {
                    if(i.equals(sname))
                        System.out.println(map.get(i));
                }
            }
            else
                System.out.println(sname+" not found!!!");

            System.out.println("Do you want to search any contact ? 'Yes' Or 'No' ");
            searchChoice=scan.next();
        }

        System.out.println("Do you want to Display the PhoneBook? 'Yes' Or 'No' ");
        String dipChoice=scan.next();
        if(dipChoice.equalsIgnoreCase("Yes"))
        {
            Set<String > keys=map.keySet();
            for(String s : keys)
            {
                System.out.println(s+" -> "+map.get(s));
            }
        }

    }
}
