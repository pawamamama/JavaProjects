# JavaProjects

个人 Java 学习仓库，用于记录从零基础入门到面向对象、集合、IO、多线程、网络编程等阶段的学习代码与练习。

仓库为 **IntelliJ IDEA 原生多模块工程**（纯 `.iml` + `.idea/`，**没有使用 Maven/Gradle**），JDK 版本为 **25**。代码以「章节 + 独立小项目」的形式组织，每个目录通常是一个独立的 IDEA 模块，便于单独编译运行。

> 说明：本文档中的目录名与描述均来自仓库实际内容，`chaper10`、`chaper13` 为仓库中真实存在的目录拼写（`chaper` 而非 `chapter`），未作改名。

---

## 仓库结构

下表列出仓库根目录下的主要条目及其对应的学习主题。

| 目录 | 学习主题 |
|---|---|
| `chapter1~7` | Java 基础入门：变量与数据类型、运算符、流程控制（if / switch / 循环）、数组与二维数组、排序与杨辉三角等 |
| `chapter07` | 方法与面向对象入门：构造器、方法重载、递归（汉诺塔、迷宫）、变量作用域、`this`、可变参数 |
| `chapter08` | 面向对象核心：封装 / 继承 / 多态、包与访问修饰符、`Object` 与重写、调试，以及房屋出租、零钱通等小项目 |
| `chaper10` | 面向对象进阶：抽象类、代码块、`final`、内部类（成员 / 静态 / 局部 / 匿名）、接口、`main` 语法、单例、`static` 关键字 |
| `chapter11` | 注解（`@Override` / `@Deprecated` / `@SuppressWarnings`）、枚举，以及 chapter10 的作业代码 |
| `chapter12` | 异常处理：异常体系、`try-catch`、`throws`、常见运行时异常与自定义异常 |
| `chaper13` | 常用类：String 与包装类、StringBuffer / StringBuilder、Arrays / BigDecimal / BigInteger、日期时间、`Math` / `System` 及作业 |
| `chapter14` | 集合框架：Collection / List / Set / Map 各实现类、`Collections` 工具类，含源码分析与作业 |
| `chapter15` | 泛型：泛型类 / 接口 / 方法、自定义泛型、泛型继承与通配符 |
| `chapter16` | 绘图与事件处理入门，并开始坦克大战（自己版本 + 老师版本） |
| `chapter17` | 多线程：`Thread` / `Runnable`、线程方法、线程状态、`synchronized` 与死锁，含售票窗口练习 |
| `chapter18` | 坦克大战续：加入子弹与爆炸效果（两个平行版本） |
| `chapter19` | IO 流：`File`、字节 / 字符流、缓冲流、转换流、打印流、`Properties`、对象序列化，含图片 / 文本拷贝练习 |
| `chapter20` | 坦克大战收尾：加入存档 / 记录（Recorder / Node）与音效（AePlayWave + `111.wav`） |
| `chapter21` | 网络编程：TCP / UDP Socket、文件上传下载，作业含聊天与音乐文件传输 |
| `QQClient` | QQ 即时通讯项目的客户端模块（界面 + 连接服务端线程 + 业务服务） |
| `QQServer` | QQ 即时通讯项目的服务端模块（监听、线程管理、消息转发） |
| `untitled` | IDEA 自动生成的脚手架残留模块，仅含 `src/test.java`，无实际学习内容 |

> 备注：`chapter08` 下还嵌套了 `chapter08`、`hello`、`test01` 等子模块；`tatus` 是一个疑似命令行重定向误产生的残留文件；`java_code.iml`、`.idea/` 为 IDEA 工程配置，不属于学习内容。

---

## 如何运行

本仓库**没有 Maven / Gradle 构建文件**（已确认不存在 `pom.xml`、`build.gradle`、`settings.gradle`），所有代码都是 IntelliJ IDEA 工程，推荐用以下方式运行：

### 方式一：用 IntelliJ IDEA 打开（推荐）

1. 用 IDEA 打开仓库根目录 `java_code`（或直接打开某个章节目录）。
2. 等待 IDEA 完成索引；各章节是独立模块，模块信息由目录中的 `.iml` 描述。
3. 打开要运行的类，点击 `main` 方法左侧的绿色三角，或右键选择 `Run '类名.main()'`。
4. 编译输出默认放在各模块的 `out/` 目录下（该目录已在 `.gitignore` 中忽略）。

### 方式二：命令行 `javac` / `java`

对于单个独立的 `.java` 文件（尤其是 `chapter1~7`、`chapter07` 这类顶层扁平类），可以直接编译运行：

```bash
javac Hello.java
java Hello
```

若源码带包名（如 `com.pawamamama...`），需在源码根目录下按包结构编译，并带上包名运行：

```bash
javac -d out src/com/pawamamama/xxx/Demo.java
java -cp out com.pawamamama.xxx.Demo
```

> 本仓库需要 JDK 25 才能完整编译（`.idea/misc.xml` 中 `languageLevel="JDK_25"`、`project-jdk-name="25"`）。

---

## 已涉及的 Java 知识点概览

- **语言基础**：基本数据类型与包装类、运算符、流程控制、数组与二维数组
- **面向对象**：类与对象、构造器、重载、封装、继承、多态、抽象类、接口、内部类、`final` / `static`
- **常用 API**：String / StringBuilder / StringBuffer、Arrays、BigDecimal / BigInteger、日期时间、Math / System
- **异常处理**：异常体系、try-catch、throws、自定义异常
- **集合与泛型**：List / Set / Map 各实现、Collections 工具类、泛型类 / 接口 / 方法
- **IO 流**：File、字节流、字符流、缓冲流、转换流、打印流、Properties、对象序列化
- **多线程**：Thread / Runnable、线程状态、同步与死锁
- **网络编程**：TCP / UDP Socket、多线程服务端、文件上传下载
- **GUI 与项目实践**：Swing 绘图与事件、坦克大战（多版本迭代）、QQ 聊天室（客户端 + 服务端）

---

## 学习用途说明

- 本仓库为**个人学习记录**，代码主要用于练习与验证知识点，**并非生产级项目**。
- 各章节代码风格、命名与实现方式会随学习进度变化，部分目录存在重复或历史遗留文件，仅供学习参考。
- 仓库中的音频、图片等资源仅用于学习示例（如坦克大战音效），不用于任何商业用途。
- 若代码或注释中引用了他人教程内容，版权归原作者所有；如涉及侵权请联系删除。
