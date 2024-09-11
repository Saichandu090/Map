import java.util.*;

public class SortHashMap
{
    public static void main(String[] args)
    {
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

        Map<String,Integer> map=sortByValues(hm);

        Set<String > ss=map.keySet();
        for(String i : ss)
        {
            System.out.println(i+" -> "+map.get(i));
        }
    }

    public static Map<String,Integer> sortByValues(Map<String ,Integer> hm)
    {
        List<Map.Entry<String ,Integer>> list=new ArrayList<>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();
        for(Map.Entry<String ,Integer> entry : list)
        {
            lhm.put(entry.getKey(),entry.getValue());
        }
        return lhm;
    }
}
