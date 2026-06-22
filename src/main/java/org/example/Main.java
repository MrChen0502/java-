package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // 分隔线方法
        printSection("ArrayList 演示（有序、可重复、有索引）");

        ArrayList<String> arrayList = new ArrayList<>();

        // 增
        arrayList.add("苹果");
        arrayList.add("香蕉");
        arrayList.add("苹果");  // 可以重复
        arrayList.add(1, "橘子"); // 在索引1插入

        System.out.println("【添加后】" + arrayList);
        System.out.println("  索引0: " + arrayList.get(0));
        System.out.println("  索引1: " + arrayList.get(1));
        System.out.println("  总共有: " + arrayList.size() + " 个元素");
        System.out.println("  包含'苹果'? " + arrayList.contains("苹果"));
        System.out.println("  '苹果'第一次出现索引: " + arrayList.indexOf("苹果"));
        System.out.println();

        // 改
        arrayList.set(2, "草莓");
        System.out.println("【修改索引2后】" + arrayList);
        System.out.println();

        // 遍历
        System.out.println("【遍历所有元素】");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("  索引" + i + " -> " + arrayList.get(i));
        }
        System.out.println();

        // 删
        arrayList.remove("香蕉");
        System.out.println("【删除'香蕉'后】" + arrayList);
        System.out.println("  剩余: " + arrayList.size() + " 个元素");

        System.out.println("\n" + "=".repeat(50) + "\n");


        // ============ Set ============
        printSection("Set 演示（无序、不可重复、无索引）");

        Set<String> set = new HashSet<>();

        set.add("张三");
        set.add("李四");
        set.add("张三");  // 重复，存不进去

        System.out.println("【添加后】" + set);
        System.out.println("  总共有: " + set.size() + " 个元素");
        System.out.println("  '张三'存了两次，但只保留了1个");
        System.out.println("  包含'张三'? " + set.contains("张三"));
        System.out.println("  包含'王五'? " + set.contains("王五"));
        System.out.println();

        // 遍历方式1
        System.out.println("【遍历方式1 - 增强for】");
        for (String name : set) {
            System.out.println("  👤 " + name);
        }
        System.out.println();

        // 遍历方式2
        System.out.println("【遍历方式2 - 迭代器】");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("  👤 " + it.next());
        }
        System.out.println();

        // 删
        set.remove("张三");
        System.out.println("【删除'张三'后】" + set);
        System.out.println("  剩余: " + set.size() + " 个元素");
        System.out.println("  是否为空? " + set.isEmpty());

        System.out.println("\n" + "=".repeat(50) + "\n");


        // ============ HashSet ============
        printSection("HashSet 演示（Set的实现类，用法一样）");

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("🐱");
        hashSet.add("🐶");
        hashSet.add("🐱");  // 重复，存不进去

        System.out.println("【添加后】" + hashSet);
        System.out.println("  总共有: " + hashSet.size() + " 个元素");
        System.out.println("  包含🐱? " + hashSet.contains("🐱"));
        System.out.println("  是否为空? " + hashSet.isEmpty());
        System.out.println("  有下一个元素? " + hashSet.iterator().hasNext());
        System.out.println("  转成数组: " + java.util.Arrays.toString(hashSet.toArray()));
        System.out.println();

        // 删
        hashSet.remove("🐱");
        System.out.println("【删除🐱后】" + hashSet);
        System.out.println("  剩余: " + hashSet.size() + " 个元素");
        System.out.println("  包含🐱? " + hashSet.contains("🐱"));

        System.out.println("hashcode:"+hashSet.hashCode());

        System.out.println("\n" + "=".repeat(50) + "\n");


        // ============ 总结对比 ============
        printSection("总结对比");

        System.out.println("┌──────────┬──────────┬──────────┐");
        System.out.println("│   特性   │ ArrayList│ Set/HashSet │");
        System.out.println("├──────────┼──────────┼──────────┤");
        System.out.println("│ 有序？   │    ✅    │    ❌    │");
        System.out.println("│ 可重复？ │    ✅    │    ❌    │");
        System.out.println("│ 有索引？ │    ✅    │    ❌    │");
        System.out.println("│ 取单个   │ get(索引)│   遍历    │");
        System.out.println("└──────────┴──────────┴──────────┘");
    }

    // 打印分段标题的辅助方法
    public static void printSection(String title) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  📌 " + title);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}