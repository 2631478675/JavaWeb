package javaweb.gather.traversal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * four ways to traverse map
 */
public class TraversalMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","liu");
        map.put("2","yuan");
        map.put("3","lin");
        map.put("4","liu");
        //the first method : iterate through key and value using map.keySet
        System.out.println("the first method : iterate through key and value using map.keySet");
        for (String key : map.keySet()){
            System.out.println("Key: "+key+" Value: "+map.get(key));
        }
        //the second method :iterator is used to iterate through key and value using map.entry
        System.out.println("the second method :iterator is used to iterate through key and value using map.entry");
        Iterator mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry<String,String>)mapIterator.next();
            System.out.println("Key: " + entry.getKey() +" Value: "+entry.getValue());

        }
        //the third method : iterate through key and value using map.entry
        System.out.println("the third method : iterate through key and value using map.entry");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() +" Value: "+entry.getValue());
        }
        //the fourth method : iterate through key using Map.values ,but can`t iterate over key
        System.out.println("the fourth method : iterate through key using Map.values ,but can`t iterate over key");
        for(String value : map.values()){
            System.out.println("the value is "+value);
        }
    }


}
