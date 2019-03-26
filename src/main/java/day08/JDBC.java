package day08;

// import sun.security.util.Password;

import java.sql.*;

public class JDBC {
    private static final String URL="jdbc:mysql://127.0.0.1:3306";
    private  static final String User="root";
    private static  final String Password="123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Driver加载驱动
        // new Driver();
        Class.forName("com.mysql.jdbc.Driver");
        //2.Connection //获取连接
        Connection connection=DriverManager.getConnection(URL, User, Password);
        //3.PrepareStatement 创建接口实例
        String sql="insert into db_test.user value(null,?,md5(?))";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"Tom");
        preparedStatement.setString(2,"123");
        //4.1.p.execteUpdate(); // DML
        preparedStatement.executeUpdate(); // 更新
        //4.2.p.executeQuery();// DQL
        //5. *.close();
        preparedStatement.close(); //
        connection.close(); // 关闭数据库连接
        System.out.println("done");

    }
}
