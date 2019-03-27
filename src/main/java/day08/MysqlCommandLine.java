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
public class MysqlCommandLine {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306?user=root&password=123456&useSSL=false";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private static Scanner scanner;
    private static SimpleDateFormat simpleDateFormat;

    public MysqlCommandLine() {
        scanner = new Scanner(System.in);
        getConnection();
        simpleDateFormat = new SimpleDateFormat("[YYYY-MM-dd HH:mm:ss]");
    }

    public Connection getConnection() { // singleton 单例模式
        if (connection == null) {
            try {
                new Driver(); // 加载驱动器
                connection = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public void update(String sql) {
        try {
            long start = System.currentTimeMillis(); // 开始时间
            preparedStatement = connection.prepareStatement(sql);
            int rowAffected = preparedStatement.executeUpdate();
            long end = System.currentTimeMillis(); // 结束时间

            System.out.print(simpleDateFormat.format(new Date(end)));
            System.out.println(rowAffected + " row affected in " + (end - start) + " ms"); // 用时
        } catch (SQLException e) {
            System.out.println("SQL ERROR：" + e.getMessage());
        }
    }


    public void query(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); // 元数据
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.println(resultSetMetaData.getCatalogName(1 + 1) + " ");
            }
            System.out.println("\n----------------");
/*            System.out.println(resultSetMetaData.getColumnCount());            // 3
            System.out.println(resultSetMetaData.getColumnClassName(1));       // java.lang.Integer
            System.out.println(resultSetMetaData.getColumnDisplaySize(1));     // 11
            System.out.println(resultSetMetaData.getColumnLabel(1));           // id
            System.out.println(resultSetMetaData.getColumnName(1));            // id
            System.out.println(resultSetMetaData.getColumnType(1));            // 4
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
                System.out.println("SQL ERROR:"+e.getMessage());
                e.printStackTrace();
  }
        }


    public void dispatch(String sql) {
        if (sql.toLowerCase().trim().startsWith("select")) { // toLowerCase变小写 trim消除空格
            query(sql);
        } else {
            update(sql);
        }
    }

    public String getSQL() {
        System.out.println("mysql> ");
        String line = scanner.nextLine();
        StringBuilder sql=new StringBuilder(line);
        while(!line.endsWith(";")){
            System.out.println("   ->");
            line=scanner.nextLine();
            sql.append(line);
        }return sql.toString();
    }

    public static void main(String[] args) {
        MysqlCommandLine mysqlCommandLine = new MysqlCommandLine();
        String sql = mysqlCommandLine.getSQL();
        while (!sql.equalsIgnoreCase("quit")) {
            mysqlCommandLine.dispatch(sql);
            sql = mysqlCommandLine.getSQL();
        }
    }
}