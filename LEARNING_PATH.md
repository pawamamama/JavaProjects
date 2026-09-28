# JavaProjects 学习路线（由 269 次真实提交归纳）

## 整理口径

- 数据来源：本仓库 `git log --oneline` 的全部输出，**共 269 次提交**，按时间从最早到最新排列后按学习主题分段。
- 分段依据：**只用提交信息里真实出现的章节号与关键词**（`chap13` / `chapter13`、`chapter14`、`chapter15章`、`chapter16`、`chapter17`、`chapter18`、`chapter19`、`chapter20`、`网络编程`、`QQ网络项目`）作为阶段边界，没有臆造阶段名。
- 提交数统计：按每段在 `git log --oneline`（正序）中占据的行号区间计数，区间连续、无重叠、合计 269。
- 短 hash 与提交信息均为原文摘录（超长信息只截取开头关键部分，用 `…` 表示省略）。
- 本文件由文档整理任务自动生成，**只新增此文件**，未修改 `README.md` 与 `.gitignore`，未做任何 `git add/commit/push`。

---

## 阶段总览

| 阶段 | 主题 | 提交数 | 起始提交 | 结束提交 |
|---|---|---|---|---|
| 1 | 建仓与异常处理期（chapter12 收尾） | 6 | `7cba6b8` | `7f75bbc` |
| 2 | 常用类期（chapter13 / chap13） | 40 | `cebb1a9` | `3f4d14a` |
| 3 | 集合框架期（chapter14） | 50 | `0f58986` | `cbf1831` |
| 4 | 泛型期（chapter15） | 14 | `b8a7cea` | `e3a943f` |
| 5 | 绘图与坦克大战一期（chapter16） | 13 | `5127865` | `98aafa1` |
| 6 | 多线程期（chapter17） | 17 | `89ed310` | `92bc153` |
| 7 | 坦克大战二期（chapter18） | 29 | `8acc7f4` | `912dd30` |
| 8 | IO 流期（chapter19） | 38 | `dd92884` | `0950cc9` |
| 9 | 坦克大战收尾（chapter20） | 8 | `09fd624` | `7fa7e2f` |
| 10 | 网络编程期（TCP/UDP） | 6 | `a15f95f` | `e32bb84` |
| 11 | QQ 网络项目期 | 48 | `5314c15` | `05215ce` |
| — | **合计** | **269** | | |

---

## 阶段 1 · 建仓与异常处理期（chapter12 收尾）

**提交数 6** ｜ 起始 `7cba6b8` ｜ 结束 `7f75bbc`

标志性提交：
- `7cba6b8` Initial commit
- `3dd0026` 第一次上传我的Java代码
- `bbc5eed` Merge branch 'main' of github.com:pawamamama/JavaProjects
- `7898778` test
- `466d69b` throws 的使用细节
- `7f75bbc` throws和throw自定义异常

阶段小结：先把早期章节代码整批传上 GitHub（第一次上传的 `chaper10` 等），随后在 `chapter12` 里补完 `throws` 使用细节与 `throw` 自定义异常，异常处理这一章收尾。

---

## 阶段 2 · 常用类期（chapter13 / chap13）

**提交数 40** ｜ 起始 `cebb1a9` ｜ 结束 `3f4d14a`

标志性提交：
- `cebb1a9` chap13包装类和常用类
- `781509a` chap13 - 八大包装类介绍->装箱和拆箱->自动装箱和自动拆箱。
- `2f5646e` chap13-IntegerCache 缓存池
- `dd7a1fc` chap13 -String对象的理解和创建对象-String的实现接口-String类的final char[] value介绍-final的理解
- `2827af1` chap13 -String的常量池和new对象时的创建流程-intern的使用…
- `35b4361` chap13-StringBuffer介绍-继承关系…String VS StringBuffer
- `927a87b` chapter13-StringBuilder学习-一个可变的字符序列 单线程中优先采用…
- `89dee55` chapter13-学习Math类常用方法：abs、pow、ceil、floor、round、sqrt、random
- `e6bf623` chapter13-学习 Arrays 常用方法及源码分析
- `7b94705` feat: 学习 chapter13 Comparator接口与定制排序
- `c76bca2` chapter13-feat:大数处理方案
- `f9db60f` chapter13-feat:第一代java.util日期
- `24989b1` chapter13-feat:第二代日期 Calendar
- `76eb5ae` chapter13-feat:JDK8第三代日期时间API学习与示例代码
- `995e9d5` chapter13-homework01-数组翻转
- `55c93c4` chapter13-homework03- 字符串练习-将姓名按照指定格式输出。

阶段小结：从八大包装类与装箱拆箱起步，深挖 String 常量池、`intern()`、StringBuffer/StringBuilder 三者对比，再学 Math/Arrays/Comparator、BigDecimal 大数、三代日期 API，最后用 4 个 homework 巩固。

---

## 阶段 3 · 集合框架期（chapter14）

**提交数 50** ｜ 起始 `0f58986` ｜ 结束 `cbf1831`

标志性提交：
- `0f58986` chapter14-集合
- `1b9f13b` chapter14-集合体系图
- `f32cb5d` chapter14-集合体collection-ArrayList方法使用
- `3b03088` chapter14-集合collection-迭代器遍历
- `4cd5f59` chapter14-集合collection-list的三种遍历方式
- `085f2be` chapter14-集合collection-ArrayList 的扩容和构造器源码分析
- `97fe0f2` chapter14-集合collection-Vector(线程安全的动态数组)的扩容和构造器源码分析
- `c1b99c1` chapter14-集合collection-LinkedList01 双向链表模拟
- `588ebe4` chapter14-集合collection-HashSet 介绍
- `0a22954` chapter14-集合collection-HashSet 模拟 数组+链表
- `4115dbe` chapter14-集合collection-HashSet的扩容机制和树化刨析
- `9adeb4c` chapter14-集合collection-LinkedHashSet双向链表源码解读…
- `f3cd701` chapter14-Map接口的介绍和-实现类HashMap的特点（双列元素）K,V
- `9c07fc6` chapter14 - HashMap 底层结构与原理和扩容机制
- `2338cef` chapter14 - HashTable 介绍+扩容机制（1.0版已弃用）
- `a554c55` chapter14 - Properties的介绍与使用它
- `06482e3` chapter14 - TreeSet类特点-使用-和他的比较器-源码分析-使用比较器
- `b1316f2` chapter14 - Collections工具类常用方法
- `31cae52` chapter14 - 集合家庭作业6- 重写hashcode + equals 添加修改数值之后定位变化作业

阶段小结：这是全仓库提交量最大的章节。从 Collection 体系图与三种遍历出发，逐个啃 ArrayList/Vector/LinkedList 的扩容与链表结构，再深入 HashSet 的数组+链表+树化、HashMap 底层与扩容、TreeSet/TreeMap 比较器，最后以 7 个集合家庭作业收尾。

---

## 阶段 4 · 泛型期（chapter15）

**提交数 14** ｜ 起始 `b8a7cea` ｜ 结束 `e3a943f`

标志性提交：
- `b8a7cea` chapter15章-泛型
- `65b9008` chapter15章-泛型引入
- `fb637bb` chapter15章-Java 泛型（Generic）的基本概念、作用以及优势
- `bcbf6b8` chapter15章-练习-Java 集合框架中泛型的综合使用-使用泛型解决转型和限定类型问题
- `7bce3df` chapter15章-练习-泛型细节1
- `0c254eb` chapter15章-练习-泛型练习-集合排序（ArrayList + Comparator）…
- `646211b` chapter15章-练习-自定义泛型类-细节与语法
- `48daf32` chapter15章-练习-自定义泛型接口-与实现接口类 and 和接口继承泛型接口
- `39f662f` chapter15章-练习- 泛型方法 and 使用泛型的方法-基本语法
- `2fc31d9` chapter15章-练习- 泛型的继承和通配符
- `e3a943f` chapter15章-练习-本练习用于演示 Java 泛型 DAO（Data Access Object）封装模式的实现与使用。

阶段小结：由泛型引入与基本概念起步，练习泛型类/接口/方法、继承与通配符，最后用一个泛型 DAO 封装模式把这一章的知识点串起来。

---

## 阶段 5 · 绘图与坦克大战一期（chapter16）

**提交数 13** ｜ 起始 `5127865` ｜ 结束 `98aafa1`

标志性提交：
- `5127865` chapter16（坦克大战前置学习）-java绘图原理说明
- `ad95e10` chapter16（坦克大战前置学习）-java绘图原理说明 + 绘图基本方法
- `e220acb` chapter16-坦克大战-Tank父类初始-Hero玩家坦克初始-MyPanel游戏绘图区域初始化-pawaTankGame游戏主窗口+入口
- `9445e93` chapter16-坦克大战-自己复刻版本详情请看上一次提交
- `f5fbb6c` chapter16-坦克大战1-绘制坦克身体-个人优化版重新绘制了同色系 + 抗锯齿（封装成方法使用）
- `99c65c2` chapter16-坦克大战1-前置学习-小球动起来-KeyListener监听键盘事件
- `69a4db3` chapter16-坦克大战1-(teacher)添加绘制坦克的四个方向和坦克移动
- `88b7887` chapter16-坦克大战1-(Study自己复刻版)加绘制坦克的四个方向和坦克移动
- `05089e2` chapter16-坦克大战1（teacher）-添加敌人并绘制坦克（Vector管理）
- `98aafa1` chapter16-坦克大战1（study）-添加敌人并绘制坦克（Vector管理）

阶段小结：先补 Java 绘图原理与基本方法，然后用 Tank/Hero/MyPanel 搭出坦克大战骨架；这一章明显是「teacher 版 + Study 自己复刻版」双线推进，并用 KeyListener 实现方向键移动、Vector 管理敌人坦克。

---

## 阶段 6 · 多线程期（chapter17）

**提交数 17** ｜ 起始 `89ed310` ｜ 结束 `92bc153`

标志性提交：
- `89ed310` chapter17-多线程初级-查看cpu数量
- `ca721a6` chapter17-多线程初级-继承Thread创建线程-多线程机制-主线程与子线程
- `d74902e` chapter17-多线程初级-继承Thread创建线程-start简单分析-为什么不直接cat.run()运行线程
- `f3d280c` chapter17-多线程初级-Runnable继承接口实现线程-Thread类模拟-设计模式：[静态代理模式]
- `a76de54` chapter17-多线程初级-多线程售票同步问题
- `bca75a6` chapter17-多线程初级-  线程常用方法演示-中断线程案例
- `d081b15` chapter17-多线程初级-  线程常用方法演示3- 守护线程（Daemon Thread）
- `49dd844` chapter17-多线程初级-  Java线程七大状态
- `4df2e0b` chapter17-多线程初级- 线程同步机制-synchronized基本使用-解决票数超卖问题
- `26cc367` chapter17-多线程初级- 线程死锁演示
- `042505a` chapter17-多线程初级-作业- 一个线程控制另一个线程退出
- `92bc153` chapter17-多线程初级-作业2-线程锁取钱作业

阶段小结：从 Thread/Runnable 两种创建方式与 `start()` 原理讲起，覆盖线程常用方法、守护线程、七大状态，再到 `synchronized` 解决售票超卖与死锁演示，最后用两个作业巩固。

---

## 阶段 7 · 坦克大战二期（chapter18）

**提交数 29** ｜ 起始 `8acc7f4` ｜ 结束 `912dd30`

标志性提交：
- `8acc7f4` chapter18-坦克大战2
- `b709ae6` chapter18-坦克大战2-重构了一下坦克的身体
- `29a9cb2` chapter18-坦克大战2（study + teacher）: 创建Shot类，初步实现子弹方向控制、移动和生命周期管理
- `814d975` chapter18-坦克大战2（study + teacher）: 为hero 添加射击线程-子弹线程创建和坐标初始化
- `fab3b58` chapter18-坦克大战2（study + teacher）: 添加j键按下射击
- `98d1707` chapter18-坦克大战2(0.4版)（study + teacher）:敌方子弹-Vector集合管理子弹
- `2390ca6` chapter18-坦克大战2(0.4版)（study + teacher）:判断是否击中敌方坦克静态方法 + 判断子弹是否打到敌人打到了停止绘制
- `0e75a77` chapter18-坦克大战2(0.4版)（study + teacher）:添加bomb类用于绘制爆炸效果
- `6a529be` chapter18-坦克大战2(0.4版)（study + teacher）:击中敌人时绘制爆炸效果-用图片模拟爆炸效果播放（bomb生命周期实现的）
- `59514d3` chapter18-坦克大战2(0.4版)（study + teacher）:把敌人坦克做成线程让敌人动起来
- `9c11e26` chapter18-坦克大战2(0.4版)（study + teacher）:-使用集合管理多颗子弹-最多发射5颗
- `912dd30` chapter18-坦克大战bug未修复

阶段小结：把多线程用到游戏里——Shot 子弹线程、敌人坦克线程、MyPanel 线程画板；加入爆炸效果（Bomb + 图片）、Vector 管理子弹、击杀判定与边界处理，版本号推进到 0.4 版，末尾留了一个未修复的 bug 提交。

---

## 阶段 8 · IO 流期（chapter19）

**提交数 38** ｜ 起始 `dd92884` ｜ 结束 `0950cc9`

标志性提交：
- `dd92884` chapter19 io流学习
- `def0e3b` chapter19 io流学习-创建文件的三种方法（构造器）
- `b277c80` chapter19 io流学习-获取文件信息（方法）
- `2eaeb23` chapter19 io流学习-字节输入流完整使用
- `0d5dc45` chapter19 io流学习-字节输出流
- `57e4dff` chapter19 io流学习-文件拷贝
- `80870da` chapter19 io流学习-字符输入流
- `9b77481` chapter19 io流学习-文件包装流/处理流模拟
- `728e6d9` chapter19 io流学习-字符包装流-BufferedReader使用
- `ea0553e` chapter19 io流学习-字符包装流-不能操作二进制文件
- `8336aab` chapter19 io流学习-字节包装流拷贝文件
- `e2163a8` chapter19 io流学习-对象处理流-对象序列化
- `143636d` chapter19 io流学习-标准输入流System.in和标准输出流System.out的使用
- `20ee1c8` chapter19 io流学习-转换流-InputStreamReader 的使用
- `24f01c1` chapter19 io流学习-转换流-编码问题
- `f01f8b5` chapter19 io流学习-转换流-outputStreamWriter使用
- `8a12f76` chapter19 io流学习-打印流 PrintStream 和 PrintWriter
- `2e0d41e` chapter19 io流学习-配置文件-propertise引出
- `7b6d8b9` chapter19 io流学习-作业2-使用字符处理流 BufferedReader 按行读取文件内容 + 转换流解决乱码问题
- `e232183` chapter19 io流学习-作业3-使用properties进行对象的序列化和反序列化（泛型）

阶段小结：按 File 基础 → 字节流 → 字符流 → 包装流/处理流 → 对象序列化 → 标准流 → 转换流 → 打印流 → Properties 配置文件的顺序推进，作业里用转换流解决乱码、用 Properties 做序列化。

---

## 阶段 9 · 坦克大战收尾（chapter20）

**提交数 8** ｜ 起始 `09fd624` ｜ 结束 `7fa7e2f`

标志性提交：
- `09fd624` chapter20-坦克大战0.5
- `158b3a8` chapter20-坦克大战0.5-防止敌人坦克重叠-修复子弹替换问题bug
- `1397b45` chapter20-坦克大战0.5-记录击毁敌人坦克数量-升级newhittank
- `8812bda` chapter20-坦克大战0.5-记录敌人坦克信息坐标方向
- `98704cd` chapter20-坦克大战0.5-恢复上局游戏
- `204ab53` chapter20-坦克大战0.5-添加音乐
- `7fa7e2f` chapter20-坦克大战0.5-不完全的玩家碰撞检查

阶段小结：坦克大战进入 0.5 版，重点转向存档与恢复（记录击毁数、敌人坐标方向、恢复上局游戏）、防止敌人坦克重叠、以及用 `111.wav` 添加音效；玩家碰撞检查当时还未完成。

---

## 阶段 10 · 网络编程期（TCP/UDP）

**提交数 6** ｜ 起始 `a15f95f` ｜ 结束 `e32bb84`

标志性提交：
- `a15f95f` 网络编程-tcp完结-udp开头
- `440c4f3` upd 网络编程-发送消息
- `0a90092` tcp网络编程作业（自己写的版本）-服务器根据客户端消息定向发送信息-使用一个专门发信息的方法
- `a3053c2` udp网络编程作业（自己写的版本）- 发送端和接收端相互通讯
- `e32bb84` tcp网络编程-网络传输文件

阶段小结：从 TCP 收尾转入 UDP，做了发送端/接收端互发消息与服务器定向回复的作业，并练习 TCP 网络传输文件（提交信息里自嘲「音乐文件有点大」）。

---

## 阶段 11 · QQ 网络项目期

**提交数 48** ｜ 起始 `5314c15` ｜ 结束 `05215ce`

标志性提交：
- `5314c15` QQ网络项目-uesr和message对象创建
- `02963ee` QQ网络项目-客户端界面创建
- `6785936` QQ网络项目-新增客户端连接服务器线程，循环接收服务端消息 ClientConnectServerThread类
- `8b17712` QQ网络项目-UserClientService类完成用户登录验证和用户注册等功能
- `a565ad5` QQ项目-服务端-监听端口等待客户端的连接并保持通讯
- `9321396` QQ项目-服务端-添加线程保持和客户端通讯
- `d35ca7e` QQ项目-服务端-添加集合管理登录和登录验证方法
- `13b2911` QQ网络项目-拉取在线用户-客户端-写一个方法发送用户列表请求
- `42eba58` QQ网络项目-服务端-管理socket线程的类-添加返回在线用户方法
- `2cf6582` QQ网络项目-客户端-应用安全退出实现
- `4fa2a3a` QQ网络项目-客户端-私聊实现-构建新的客户端消息服务类-私聊发送方法实现
- `611afc9` QQ网络项目-服务端-私聊实现-服务端使用相应线程类转发发送端的私聊消息到接收端
- `74da0d4` QQ项目-服务端and客户端-添加群发消息类型
- `5d2f30e` QQ项目-服务端-群发消息转发给在线用户
- `05215ce` QQ网络项目-服务端-读取并显示群发消息-重构消息显示格式更直观

阶段小结：网络编程的集大成实践。先建 User/Message 对象与客户端界面，再实现登录注册、在线用户列表拉取、安全退出，最后完成私聊与群发消息的服务端转发；`QQClient` / `QQServer` 两个模块就是这一阶段的产物。

---

## 附：合并与版本管理提交

以下提交不改变学习阶段，仅作记录：

- Merge 类：`bbc5eed`、`e76d301`、`a71d7ef`、`d6c4eb2`、`54d9a9d`
- 版本管理类：`3269396`、`91472d3`、`e08d06b`、`23cb49a`、`64a7642`、`0cea631`

---

> 本文档由 `git log --oneline` 的 269 条真实提交归纳而成，分段与描述均可回溯到上表所列的具体提交。
