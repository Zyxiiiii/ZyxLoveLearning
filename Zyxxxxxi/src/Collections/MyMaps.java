package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zyx
 */
public class MyMaps {
    public static Map<String,String> hashMap = new HashMap<String,String>();

    /**
     *      Map是一类接口，它含有Key和Value，通过Key的值来映射到Value的值，
     *  从而获取我们想要的值（Key和Value的数据类型都为泛型，需要在创建对象时候确定下来）。
     *      由于Map是一类接口，所以不能直接创建对象，而是通过Map的实现类实例化Map，
     *  一般我们使用HashMAp。
     * */

    public static void learnHashMap(){
        System.out.println("=========================");
        System.out.println("Map/HashMap");
        System.out.println("添加元素");
        hashMap.put("Zyx","19 years old");
        hashMap.put("Lqq","19 years old");
        hashMap.put("Zyx's birthday","April.25th");
        hashMap.put("Lqq's birthday","April.2th");
        System.out.println("遍历①");
        //     由于Map集合每个元素具有一个键对应一个值，所以遍历Map不能用常规的方法去遍历
        //  方法一：把每一个Key集合起来，通过遍历Key来遍历每一个元素。
        Set<String> keySet = hashMap.keySet();
        for (String i : keySet) {
            System.out.println("[" + i + "," + hashMap.get(i) + "]");
        }
        System.out.println("遍历②");
        //  方法二：利用HashMap的entrySet方法返回一个Map.Entry类型的对象，再用增强for遍历时获取键和值。
        Set<Map.Entry<String,String>> entrySet = hashMap.entrySet();
        for (Map.Entry<String,String> i : entrySet) {
            System.out.println("[" + i.getKey() + "," + i.getValue() + "]");
        }
        System.out.println("-------------------------");
        System.out.println("删除键对应的键值对元素");
        System.out.println("删除了" + hashMap.remove("Lqq's birthday"));
        System.out.println("-------------------------");
        System.out.println("判断集合中是否包含某个键");
        if (hashMap.containsKey("Lqq")){
            System.out.println("集合中含有Lqq这个键");
        }else{
            System.out.println("集合中不含Lqq这个键");
        }
        System.out.println("-------------------------");
        System.out.println("集合中是否包含某一个值");
        if (hashMap.containsValue("April.2th")){
            System.out.println("集合中包含April.2th这个值");
        }else{
            System.out.println("集合中不含April.2th这个值");
        }
        System.out.println("-------------------------");
        System.out.println("判断集合是否为空");
        if (hashMap.isEmpty()){
            System.out.println("集合为空");
        }else{
            System.out.println("集合不为空");
        }
        System.out.println("-------------------------");
        System.out.println("获取集合的长度");
        System.out.println("该集合的长度为：" + hashMap.size());
        System.out.println("-------------------------");
        System.out.println("清空集合再遍历");
        hashMap.clear();
        Set<String> newKeySet = hashMap.keySet();
        for (String i : newKeySet) {
            System.out.println("[" + i + "," + hashMap.get(i) + "]");
        }
        System.out.println("-------------------------");
        System.out.println("在判断一次集合是否为空");
        if (hashMap.isEmpty()){
            System.out.println("集合为空");
        }else{
            System.out.println("集合不为空");
        }
        System.out.println("-------------------------");
        System.out.println("获取集合的长度");
        System.out.println("该集合的长度为：" + hashMap.size());
    }
}
