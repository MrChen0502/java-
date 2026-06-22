package org.example;

import java.util.HashMap;
import java.util.Map;

public class HashMap的put语法 {
    public static void main(String[] args) {

        System.out.println("══════════════════════════════════");
        System.out.println("  HashMap put() 全过程演示");
        System.out.println("══════════════════════════════════\n");

        HashMap<String, Integer> map = new HashMap<>(8); // 初始容量8
        // 负载因子默认 0.75，存到 8×0.75=6 个就扩容

        // ============ 第1个 ============
        System.out.println("【第1步】put(\"张三\", 20)");
        System.out.println("  key=\"张三\"，算出桶编号 → 假设桶2");
        System.out.println("  桶2是空的 → 直接放进去");
        map.put("张三", 20);
        printMap(map);
        System.out.println("  当前容量: 8 | 数据量: 1 | 阈值: 6\n");

        // ============ 第2个 ============
        System.out.println("【第2步】put(\"李四\", 22)");
        System.out.println("  key=\"李四\"，算出桶编号 → 假设桶5");
        System.out.println("  桶5是空的 → 直接放进去");
        map.put("李四", 22);
        printMap(map);
        System.out.println("  当前容量: 8 | 数据量: 2 | 阈值: 6\n");

        // ============ 第3个 ============
        System.out.println("【第3步】put(\"王五\", 25)");
        System.out.println("  key=\"王五\"，算出桶编号 → 假设桶2");
        System.out.println("  桶2已有\"张三\"，key不同 → 挂在后面（链表）");
        map.put("王五", 25);
        printMap(map);
        System.out.println("  桶2现在: (\"张三\"=20) → (\"王五\"=25) ← 链表\n");

        // ============ 第4个 ============
        System.out.println("【第4步】put(\"张三\", 99)");
        System.out.println("  key=\"张三\"，key已存在 → 覆盖旧值！");
        System.out.println("  旧值: " + map.get("张三") + " → 新值: 99");
        map.put("张三", 99);
        printMap(map);
        System.out.println("  桶2现在: (\"张三\"=99) → (\"王五\"=25)\n");

        // ============ 继续塞数据，触发扩容 ============
        System.out.println("【第5步】继续塞数据，触发扩容...");
        System.out.println("  容量8，负载因子0.75，阈值=6");
        System.out.println("  塞到第7个时会自动扩容！\n");

        map.put("赵六", 30);
        System.out.println("  put(\"赵六\", 30) → 数据量: " + map.size());
        map.put("孙七", 35);
        System.out.println("  put(\"孙七\", 35) → 数据量: " + map.size());
        map.put("周八", 40);
        System.out.println("  put(\"周八\", 40) → 数据量: " + map.size());

        System.out.println("\n  ⚠️ 超过阈值6！自动扩容！");
        System.out.println("  容量: 8 → 16（翻倍）");
        System.out.println("  所有数据重新分配到新桶\n");

        map.put("吴九", 45);
        System.out.println("  put(\"吴九\", 45) → 数据量: " + map.size());
        printMap(map);
        System.out.println("  当前容量: 16 | 数据量: " + map.size() + " | 新阈值: 12\n");

        // ============ 总结 ============
        System.out.println("══════════════════════════════════");
        System.out.println("  总结 put() 三种情况：");
        System.out.println("══════════════════════════════════");
        System.out.println("  1️⃣ 桶空 → 直接放");
        System.out.println("  2️⃣ key相同 → 覆盖旧值");
        System.out.println("  3️⃣ key不同 → 链表挂在后面");
        System.out.println("  4️⃣ 数据太多 → 扩容，重新分配");
    }

    // 打印 HashMap 内容
    public static void printMap(HashMap<String, Integer> map) {
        System.out.print("  📦 HashMap内容: { ");
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue());
            count++;
            if (count < map.size()) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
}