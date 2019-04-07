package day12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDao {
    public static void addCard2(Card mc) throws SQLException {
        Connection connection= (Connection) DB.getConnection();
    String sql=" "+"insert into card"+"(id,name,class_name,password)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
       // preparedStatement.setString(1,mc.getId());
        preparedStatement.setString(2,mc.getName());
        preparedStatement.setString(3,mc.getClass_name());
        preparedStatement.setString(4,mc.getPassword());
        preparedStatement.execute();
    }
    public static Card findCard(String id) throws SQLException {
        Connection connection=DB.getConnection();
        String sql=""+"select * from card where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        Card card=new Card();
        if(resultSet.next()) {
      //      card.setId(resultSet.getString("id"));
            card.setName(resultSet.getString("name"));
            card.setClass_name(resultSet.getString("class_name"));
            card.setMoney(resultSet.getInt("money"));
            card.setPassword(resultSet.getString("password"));
        } else {
      //      card.setId("-1");
        }
        return card;
    }
}
