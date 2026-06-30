package com.pawamamama.collection_.homework;

import java.util.ArrayList;

/**
 * Class: homework01
 *
 * <pre>
 * 作业说明：
 * 1. 使用 ArrayList 存储新闻对象 News
 * 2. 倒序遍历集合
 * 3. 对新闻标题进行处理：
 *    - 如果标题长度 > 15，则截取前15个字符并拼接 "..."
 *    - 如果 ≤ 15，则原样输出
 *
 * 目的：
 * 练习 ArrayList 遍历 + 字符串处理 + 封装方法
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/30
 */
@SuppressWarnings({"all"})
public class homework01 {

    public static void main(String[] args) {

        // =========================
        // 1️⃣ 创建 News 对象
        // =========================
        News news = new News("新冠确诊病例超千万,数百万印度教徒奔赴恒河盛域，引民众担忧。");
        News news1 = new News("男子突然想起两个月前钓的鱼还在网兜中捞起一看，赶紧放生");
        News news2 = new News("哦，泡宝觉得可乐粉好磕");

        // =========================
        // 2️⃣ 将对象存入 ArrayList
        // =========================
        ArrayList list = new ArrayList();
        list.add(news);
        list.add(news1);
        list.add(news2);

        // =========================
        // 3️⃣ 倒序遍历集合
        // =========================
        for (int i = list.size() - 1; i >= 0; i--) {

            // 取出 News 对象（需要强转）
            News n = (News) list.get(i);

            // =========================
            // 4️⃣ 处理标题长度
            // =========================
            n.setTitle(processTitle(n.getTitle()));

            // 输出对象（调用 toString）
            System.out.println(n);
        }
    }

    /**
     * 处理新闻标题的方法
     *
     * @param title 原始标题
     * @return 处理后的标题
     *
     * 规则：
     * 1. null 或空字符串 → 返回 ""
     * 2. 长度 ≤ 15 → 原样返回
     * 3. 长度 > 15 → 截取前15个字符 + "..."
     */
    public static String processTitle(String title) {

        // 空值判断（防止 NullPointerException）
        if (title == null || title.equals("")) {
            return "";
        }

        // 长度不超过限制，直接返回
        if (title.length() <= 15) {
            return title;
        }

        // 超过长度，截取 + 省略号
        return title.substring(0, 15) + "...";
    }
}

/**
 * News 类（新闻实体类）
 */
class News {

    private String title;   // 新闻标题
    private String content; // 新闻内容（未使用）

    /**
     * 构造器：只初始化标题
     */
    public News(String title) {
        this.title = title;
    }

    // getter / setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 输出对象信息
     */
    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}