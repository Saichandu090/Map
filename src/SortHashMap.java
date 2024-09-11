import com.sun.source.tree.Tree;

import java.util.*;

public class SortHashMap
{
    public static void main(String[] args) {

        Map<String,Integer> hm=new HashMap<>();
        hm.put("a",237);
        hm.put("g",234);
        hm.put("f",258);
        hm.put("d",563);
        hm.put("e",523);
        hm.put("b",147);
        hm.put("z",236);
        hm.put("A",222);
        hm.put("C",963);

        Set<String> set=hm.keySet();
        TreeSet<String > ts=new TreeSet<>(set); //Sorting the Strings of keys by adding into Tree set.
        for(String i : ts)
        {
            System.out.println(i+" -> "+hm.get(i));
        }

        System.out.println(hm);

    }
}
