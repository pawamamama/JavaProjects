package com.pawamamama.generic.homework;

import org.junit.jupiter.api.Test;

import java.util.*;
/**
 * Class: HomeWork01
 *
 * <pre>
 * 本练习用于演示 Java 泛型 DAO（Data Access Object）封装模式的实现与使用。
 *
 * 一、核心目标：
 * 1. 使用泛型类 DAO<T> 实现对任意类型数据的统一管理
 * 2. 基于 Map<String, T> 实现对象的存储、查询、更新、删除
 * 3. 提供集合形式的数据输出（List<T>）
 *
 * 二、DAO 泛型类功能说明：
 *
 * 1. save(String id, T value)
 *    - 将对象存入 Map
 *    - id 作为 key，value 作为 value
 *
 * 2. get(String id)
 *    - 根据 id 获取对应对象
 *    - 返回类型为 T（泛型保证类型安全）
 *
 * 3. update(String id, T value)
 *    - 更新指定 id 对应的对象（本质是覆盖 put）
 *
 * 4. delete(String id)
 *    - 删除指定 id 对应的数据
 *
 * 5. list()
 *    - 返回 Map 中所有 value，封装为 List<T>
 *    - 使用 map.values() 构造 ArrayList
 *
 * 6. listNew()
 *    - 通过 keySet 遍历 Map
 *    - 手动取出每个 value 添加到 List
 *
 * 三、User 类说明：
 * - 作为 DAO 泛型的测试实体类
 * - 包含 id、age、name 三个属性
 * - 用于模拟数据库中的记录对象
 *
 * 四、测试类 A 功能：
 * 1. 创建 DAO<User> 对象
 * 2. 测试 save / get / update / delete 操作
 * 3. 测试 list 方法遍历所有对象
 * 4. 验证 Map 内部数据变化
 *
 * 五、设计思想（重点）：
 * 1. 使用泛型提升代码复用性（DAO<T>）
 * 2. 使用 Map 实现“类似数据库”的增删改查
 * 3. 泛型保证编译期类型安全，避免强制类型转换
 * 4. DAO 是典型的数据访问层封装模型
 *
 * 六、扩展方向：
 * - 可替换底层 Map 为数据库操作（JDBC / MyBatis）
 * - 可扩展分页查询（page / limit）
 * - 可增加条件查询（filter）
 *
 * </pre>
 *
 * @author
 * @date 2026/7/5
 */
@SuppressWarnings({"all"})
public class HomeWork01 {
    public static void main(String[] args) {

    }
   //使用
    @Test
    public  void  test() {

    }

}


class DAO<T> {
    Map<String, T> map = new HashMap<>();
    //1.保存T类型对象到 Map成员量中

    public void save(String id, T value) {
        map.put(id, value);
    }

    //2.从map中获取id 对应的对象
    public T get(String id) {
        return map.get(id);//因为返回值是 map限定过的类型所以返回类型一致
    }

    //3.替换map 中的key为id的内容，改为 value对象
    public void update(String id, T value) {
        map.put(id, value);
    }

    //4.返回 map中 存放的所有 T 对象
    public List<T> list() {
        return new ArrayList<T>(map.values());
    }

    //4.2 老师做的使用keySet 遍历
    public List<T> listNew() {
        //创建 ArrayList
        List<T> list = new ArrayList<>();
        //拿到key
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(map.get(key));//获取value 并添加
        }
        return list;//返回类型指定为 List<T> 所以能直接返回
    }

    //5.删除指定对象
    public void delete(String id) {
        map.remove(id);
    }

}

class User {
    private int id, age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}

class A {
    @Test
    public void m1() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 19, "pawamamama"));
        userDAO.save("2", new User(2, 15, "liuwowo"));
        System.out.println("id = 1 的员工是" + userDAO.get("1"));
        //修改 id = 1 的对象
        userDAO.update("1", new User(1, 19, "王微信"));
        System.out.println("修改过的ID = 1 的员工是" + userDAO.get("1"));
        List<User> list = userDAO.list();
        System.out.println("--------输出所有对象----------");
        for (User user : list) {
            System.out.println(user);
        }
        //删除id =2的对象
        userDAO.delete("2");
        System.out.println(userDAO.map);
    }
}