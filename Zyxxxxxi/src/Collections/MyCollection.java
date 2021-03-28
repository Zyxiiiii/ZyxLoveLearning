package List;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

/**
 * @author zyx
 */
public class MyCollection {
    /**创建集合对象*/
    public static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public static LinkedList<Double> linkedList = new LinkedList<Double>();
    public static HashSet<String> hashSet = new HashSet<String>();

    public static void main(String[] args) {
        learnArrayList();
        learnLinkedList();
        learnHashSet();

    }
    /**ArrayList*/
    public static void learnArrayList(){

        System.out.println("=========================");
        System.out.println("ArrayList");
        System.out.println("增加并获取元素");
        if (arrayList.add(1)) {
            System.out.println(arrayList.get(0));
        }
        if (arrayList.add(2)) {
            System.out.println(arrayList.get(1));
        }
        if (arrayList.add(3)) {
            System.out.println(arrayList.get(2));
        }
        System.out.println("-------------------------");
        System.out.println("在集合中插入元素");
        arrayList.add(1, 3);
        System.out.println("遍历");
        int x = 1;
        for (Integer i : arrayList) {
            System.out.println("第" + x +"个元素是" + i);
            x++;
        }
        //遍历结果表示插入元素是在索引指定的元素前插入
        System.out.println("-------------------------");
        System.out.println("修改数据");
        System.out.println(arrayList.set(1, 234));
        System.out.println("-------------------------");
        System.out.println("删除数据");
        System.out.println(arrayList.remove(1));
        System.out.println("-------------------------");
        System.out.println("集合长度");
        System.out.println(arrayList.size());
    }

    /**LinkedList*/
    public static void learnLinkedList(){

        System.out.println("=========================");
        System.out.println("LinkedList");
        System.out.println("增加集合中的元素");
        for (int i = 0; i < 3; i++) {
            linkedList.addFirst(1.23);
        }
        System.out.println("遍历");
        for (Double i : linkedList) {
            System.out.println(i);
        }
        System.out.println("在集合开头增加元素");
        System.out.println("遍历");
        linkedList.addFirst(1.22);
        for (Double i : linkedList) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        System.out.println("在末尾增加元素");
        //在末尾增加元素
        linkedList.addLast(1.24);
        System.out.println("遍历");
        for (Double i : linkedList) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        System.out.println("获取集合的首尾元素");
        System.out.println("集合第一个元素是：" + linkedList.getFirst());
        System.out.println("集合最后一个元素是：" + linkedList.getLast());
        System.out.println("-------------------------");
        System.out.println("删除集合第一个元素");
        linkedList.removeFirst();
        System.out.println("遍历");
        for (Double i : linkedList) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        System.out.println("删除集合最后一个元素");
        linkedList.removeLast();
        System.out.println("遍历");
        for (Double i : linkedList) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        System.out.println("集合长度");
        System.out.println(linkedList.size());
    }

    /**HashSet*/
    public static void learnHashSet(){
        System.out.println("=========================");
        System.out.println("HashSet");
        System.out.println("添加元素");
        hashSet.add("first");
        hashSet.add("second");
        hashSet.add("third");
        hashSet.add("forth");
        //具有哈希表的特性：迭代次序不保证
        System.out.println("遍历");
        for (String i : hashSet) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        System.out.println("删除first元素");
        if (hashSet.remove("first")){
            System.out.println("遍历");
            for (String i : hashSet) {
                System.out.println(i);
            }
        }
        System.out.println("-------------------------");
        System.out.println("获取集合长度");
        System.out.println(hashSet.size());
        System.out.println("-------------------------");
        if (hashSet.isEmpty()){
            System.out.println("此时集合为空");
        }else{
            System.out.println("此时集合不为空");
        }
        System.out.println("遍历");
        for (String i : hashSet) {
            System.out.println(i);
        }
        System.out.println("清空集合");
        hashSet.clear();
        System.out.println("遍历");
        for (String i : hashSet) {
            System.out.println(i);
        }
        if (hashSet.isEmpty()){
            System.out.println("此时集合为空");
        }else{
            System.out.println("此时集合不为空");
        }
    }
}
