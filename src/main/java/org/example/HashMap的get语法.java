package org.example;

import java.util.HashMap;

public class HashMap的get语法 {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("张三", 20);
        map.put("李四", 22);
        map.put("王五", 25);

        System.out.println("map 内容: " + map);
        System.out.println();

        // 存在的 key
        System.out.println("get(\"张三\") → " + map.get("张三"));
        System.out.println("  key存在 → 返回value: 20\n");

        // 不存在的 key
        System.out.println("get(\"赵六\") → " + map.get("赵六"));
        System.out.println("  key不存在 → 返回null\n");

        // getOrDefault
        System.out.println("getOrDefault(\"赵六\", 0) → " + map.getOrDefault("赵六", 0));
        System.out.println("  key不存在 → 返回默认值0");
    }
}