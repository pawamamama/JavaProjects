package com.pawamamama.properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class: Properties03
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/13
 */
@SuppressWarnings({"all"})
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来创建 配置文件，修改配置文件内容
        Properties prop = new Properties();
        //创建属性
        //该文件没有key，就是创建，有key就是修改
        //properties 底层是hashtable，
        /*public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>)tab[index];
        for(; entry != null ; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;//key存在，就替换
                return old;
            }
        }

        addEntry(hash, key, value, index);//新key就添加
        return null;
    }
*/
        prop.setProperty("charset","utf-8");
        prop.setProperty("user", "pawamamama-帕瓦");//汉字是中文unicode码
        prop.setProperty("pwd","123456");
        prop.setProperty("pwd","111111");
        //将k-v 存储到文件中
        prop.store(new FileOutputStream("D:\\java_learning\\java_code\\chapter1" +
                "9\\src\\com\\pawamamama\\properties_\\mysql2.properties"),null);//注释



    }

}