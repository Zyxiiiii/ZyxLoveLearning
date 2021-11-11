package io;

import java.util.*;

/**
 * @author zyx
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 获取a社团成员
        System.out.print("请输入加入A社团的人(以\",\"隔开):");
        String aTeam = scanner.nextLine();
        List<String> a = new ArrayList<>(Arrays.asList(aTeam.split(",")));

        // 获取b社团成员
        System.out.print("请输入加入B社团的人(以\",\"隔开):");
        String bTeam = scanner.nextLine();
        List<String> b = new ArrayList<>(Arrays.asList(bTeam.split(",")));

        // 获取交集
        List<String> both = new ArrayList<>();
        // 遍历b，将a中已存在的元素存放到both中
        for (String bPerson : b){
            if (a.contains(bPerson)){
                both.add(bPerson);
            }
        }

        // 遍历输出
        System.out.println("A社团中的人员有:");
        a.forEach(System.out::println);
        System.out.println("B社团中的人员有:");
        b.forEach(System.out::println);
        System.out.println("两个社团都加入的人有:");
        both.forEach(System.out::println);

    }
}
