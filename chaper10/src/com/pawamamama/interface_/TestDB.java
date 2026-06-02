package com.pawamamama.interface_;

// 定义接口
interface DBConnection {
    void startConnection();   // 开始连接
    void closeConnection();   // 断开连接
}

// MySQL 数据库实现
class MySQLConnection implements DBConnection {
    @Override
    public void startConnection() {
        System.out.println("MySQL 数据库连接已启动...");
    }

    @Override
    public void closeConnection() {
        System.out.println("MySQL 数据库连接已断开...");
    }
}

// Oracle 数据库实现
class OracleConnection implements DBConnection {
    @Override
    public void startConnection() {
        System.out.println("Oracle 数据库连接已启动...");
    }

    @Override
    public void closeConnection() {
        System.out.println("Oracle 数据库连接已断开...");
    }
}

// PostgreSQL 数据库实现
class PostgreSQLConnection implements DBConnection {
    @Override
    public void startConnection() {
        System.out.println("PostgreSQL 数据库连接已启动...");
    }

    @Override
    public void closeConnection() {
        System.out.println("PostgreSQL 数据库连接已断开...");
    }
}

// 测试类
public class TestDB {
    public static void main(String[] args) {
        //使用起来规范也可以进行统一管理
        DBConnection mysql = new MySQLConnection();
        DBConnection oracle = new OracleConnection();
        DBConnection postgres = new PostgreSQLConnection();
        t(mysql);
        t(oracle);
        t(postgres);

    }
    private  static void t(DBConnection db){
        db.startConnection();
        db.closeConnection();
    }
}