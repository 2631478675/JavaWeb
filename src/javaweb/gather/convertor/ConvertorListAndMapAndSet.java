package javaweb.gather.convertor;

import java.util.*;

public class ConvertorListAndMapAndSet {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","liu.map");
        map.put("2","yuan.map");
        map.put("3","lin.map");
        map.put("4","liu.map");

        Set<String> set = new HashSet<String>();
        set.add("liu.set");
        set.add("yuan.set");
        set.add("lin.set");

        String[] strings ={"liu.string","yuan.string","lin.string","liu.string"};

        List<String> list = new ArrayList<String>();
        list.add("liu.list");
        list.add("yuan.list");
        list.add("lin.list");
        list.add("liu.list");







        // map key translate into list
        System.out.println("map key translate into list");
        List<String> keyToList = new ArrayList<String>(map.keySet());
        System.out.println("keyToList "+keyToList);
        //map values translate into list
        System.out.println("\n"+"map values translate into list");
        List<String> valuesToList = new ArrayList<String>(map.values());
        System.out.println("valuesToList "+valuesToList);

        //map key translate into set
        System.out.println("\n"+"map key translate into set");
        Set<String> keyToSet = map.keySet();
        System.out.println("keyToSet " +keyToSet);
        //map values translate into set
        System.out.println("\n"+"map values translate into set");
        Set<String> valuesToValues = new HashSet<String>(map.values());
        System.out.println("valuesToValues "+valuesToValues);





        //set translate into array
        System.out.println("\n"+"set translate into array");
        String[] setToArray = new String[set.size()];
        set.toArray(setToArray);
        System.out.println(setToArray);
        System.out.println(Arrays.toString(setToArray));

        //set translate into list
        System.out.println("\n"+"set translate into list");
        List<String> setToList = new ArrayList<String>(set);
        System.out.println(setToList);






        //array translate into list
        System.out.println("\n"+"array translate into list");
        List<String> arrayToList = Arrays.asList(strings);
        System.out.println("arrayToList "+arrayToList);

        //array translate into set
        System.out.println("\n"+"array translate into set");
        Set<String> arrayToSet = new HashSet<String>(Arrays.asList(strings));
        System.out.println("arrayToSet "+arrayToSet);





        //list translate into array
        System.out.println("\n"+"list translate into array");
        String[] listToArray = new String[list.size()];
        list.toArray(listToArray);
        System.out.println("listToArray "+Arrays.toString(listToArray));

        //list translate into set
        System.out.println("\n"+"list translate into set");
        Set<String> listToSet = new HashSet<String>(list);
        System.out.println("listToSet "+listToSet);
    }
}
