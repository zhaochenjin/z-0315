package day08;
// 访问数据库流程：
//驱动管理器（加载JDBC驱动程序）——>连接数据库（建立数据库的连接）——>SQL语句（发送SQL查询）——>结果集（得到查询结果）
import com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBC {
    private static final String URL="jdbc:mysql://127.0.0.1:3306?useSSL=false";
    private  static final String User="root";
    private static  final String Password="123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Driver加载驱动类，装载MySQL驱动
        // new Driver();
        Class.forName("com.mysql.jdbc.Driver");
        //2.Connection //获取连接
        Connection connection=DriverManager.getConnection(URL, User, Password);
        //3.PrepareStatement 创建接口实例
        String sql="insert into db_test.user value(null,?,md5(?))";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"Tom");//参数索引是从1开始计算，而不是0
        preparedStatement.setString(2,"123");
        preparedStatement.setString(1,"Togrhfi");//参数索引是从1开始计算，而不是0
        preparedStatement.setString(2,"123");
       // preparedStatement.setObject(1,"zhao"); // setObject 所有类型
        //preparedStatement.setObject(2,"123");
        //preparedStatement.setDate(3,new java.sql.Date(System.currentTimeMillis())); // 注入当前时间
        //4.1.p.execteUpdate(); // DML
        preparedStatement.executeUpdate(); // 更新.执行
        //4.2.p.executeQuery();// DQL
        //5. *.close();
        preparedStatement.close(); //
        connection.close(); // 关闭数据库连接
        System.out.println("done");

    }
}
