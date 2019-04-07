package day12;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DB {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306?user=root&password=123456&useSSL=false";

    private static Connection connection; // connection 获取连接
    /*       private PreparedStatement preparedStatement;
           private ResultSet resultSet;
           private static Scanner scanner; // 输入
           private static SimpleDateFormat simpleDateFormat; // 日期
   */
    public DB() {
        Scanner scanner = new Scanner(System.in); // 输入入口
        getConnection(); // 获取连接
    }

    public static Connection getConnection() { // singleton 单例模式：实例只有一个。  创建方法获取连接
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
}
