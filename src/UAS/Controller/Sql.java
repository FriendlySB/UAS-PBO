package UAS.Controller;

import UAS.Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sql {
    DatabaseHandler conn = new DatabaseHandler();
    
    public boolean insertDataUser(User user){
        conn.connect();
        String query = "INSERT INTO user (username,alamat) VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getAlamat());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ArrayList<User> selectDataUser(){
        ArrayList<User> listUser = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setAlamat(rs.getString("alamat"));
                listUser.add(user);
            }
            return listUser;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
