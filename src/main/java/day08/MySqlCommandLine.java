package day08;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/*
    create database ...;
    create table ...;
    insert into ...;
    update ...;
    delete ...;
    select ...;
    drop table ...;
    drop database ...;
 */
// executeUpdate();   DDL: create alter drop truncate    DML: insert update delete
// executeQuery();  DQL:select
public class MySqlCommandLine {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306?user=root&password=123456&useSSL=false";

    private static Connection connection; // connection 获取连接
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private static Scanner scanner; // 输入
    private static SimpleDateFormat simpleDateFormat; // 日期

    public MySqlCommandLine() {
        scanner = new Scanner(System.in); // 输入入口
        getConnection(); // 获取连接
        simpleDateFormat = new SimpleDateFormat("[YYYY-MM-dd HH:mm:ss]"); // 日期
    }

    public Connection getConnection() { // singleton 单例模式：实例只有一个。  创建方法获取连接
        if (connection == null) {
            try {
                new Driver(); // 加载驱动器
                connection = DriverManager.getConnection(URL); // 获取连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public void update(String sql) { // 更新语句
        try {
            long start = System.currentTimeMillis(); // 开始时间 ms
            preparedStatement = connection.prepareStatement(sql);
            int rowAffected = preparedStatement.executeUpdate(); // rowAffected执行几次语句。更新语句executeUpdate。本句意思为更新了几次
            long end = System.currentTimeMillis(); // 结束时间 ms

            System.out.print(simpleDateFormat.format(new Date(end))); // 输出当前时间
            System.out.println(rowAffected + " row affected in " + (end - start) + " ms"); // 用时
        } catch (SQLException e) {
            System.out.println("SQL ERROR：" + e.getMessage()); // 简化错误信息
        }
    }

 //BIN
    public void create(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void query(String sql) { // 查询语句
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); // 元数据
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.println(resultSetMetaData.getCatalogName(i + 1) + " ");
            }
            System.out.println("\n----------------");
/*            System.out.println(resultSetMetaData.getColumnCount());            // 3 几列
            System.out.println(resultSetMetaData.getColumnClassName(1));       // java.lang.Integer  第一行的数据类型
            System.out.println(resultSetMetaData.getColumnDisplaySize(1));     // 11  宽度
            System.out.println(resultSetMetaData.getColumnLabel(1));           // id 字段名字
            System.out.println(resultSetMetaData.getColumnName(1));            // id 字段名字
            System.out.println(resultSetMetaData.getColumnType(1));            // 4 几种类型
            System.out.println(resultSetMetaData.getColumnTypeName(1));        // INT
  */
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.println(resultSet.getString(i + 1) + " ");
                }
                System.out.println();
            }
        }
        catch (SQLException e) {
            System.out.println("SQL ERROR:"+e.getMessage()); // 简化错误信息
            e.printStackTrace();
        }
    }

// BIN
    public void dispatch(String sql) { // dispatch 派遣
        if (sql==("quit;")) {
            System.exit(0);
        } else if (sql.toLowerCase().trim().startsWith("select")) { // toLowerCase变小写 trim消除空格
            query(sql);
        } else if (sql.toLowerCase().trim().startsWith("create")) {
            create(sql);
        } else {
            update(sql);
        }
    }

    public String getSQL() { // 接受用户输入的SQL语句
        System.out.print("mysql> ");
        String line = scanner.nextLine();
        StringBuilder sql=new StringBuilder(line);
        while(!line.endsWith(";")){
            System.out.print("->");
            line=scanner.nextLine();
            sql.append(line);
        }
        return sql.toString();
    }

    public static void main(String[] args) throws SQLException{
        MySqlCommandLine mySqlCommandLine = new MySqlCommandLine();
        String sql = mySqlCommandLine.getSQL();
        System.out.println(sql);
        while (!sql.equalsIgnoreCase("quit;")) {
            mySqlCommandLine.dispatch(sql);
            sql = mySqlCommandLine.getSQL();
        }

         /*
        mySqlCommandLine.getConnection();

        // 用户在登录表单填写的值
        String username = "' or 'a'='a";   // SQL Injection 注入
        String password = "' or 'a'='a";

        String sql1 = "select * from db_test.user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        System.out.println(resultSet1.next()); // true 用户可以登录

        String sql2 = "select * from db_test.user where username = '" + username + "' and password = '" + password + "'";
        System.out.println(sql2);
        Statement statement = connection.createStatement();
        ResultSet resultSet2 = statement.executeQuery(sql2);
        System.out.println(resultSet2.next());

        */

    }
}