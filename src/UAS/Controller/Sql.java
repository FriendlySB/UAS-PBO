package UAS.Controller;

import UAS.Model.CategoryUser;
import UAS.Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sql {
    DatabaseHandler conn = new DatabaseHandler();
    
    public int getIdUser() {
        conn.connect();
        String query = "SELECT count(userId) AS 'id' FROM user";
        try {
            int id = 0;
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }
            return id + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public boolean insertNewUser(User user) {
        conn.connect();
        String query = "INSERT INTO user (userName, userEmail, userGender, userCategory, userFollowers, password) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserEmail());
            stmt.setString(3, user.getUserGender());
            stmt.setInt(4, user.getUserCategory().getCategoryId());
            stmt.setInt(5, user.getUserFollowers());
            stmt.setString(6, user.getPassword());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public ArrayList<CategoryUser> getCategoryUser(){
        ArrayList<CategoryUser> listCategory = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM category_user";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                CategoryUser temp = new CategoryUser();
                temp.setCategoryId(rs.getInt("categoryId"));
                temp.setCategoryName(rs.getString("categoryName"));
                listCategory.add(temp);
            }
            return listCategory;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<User> getAllUser(){
        ArrayList<User> listUser = new ArrayList<>();
        Controller controller = new Controller();
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User temp = new User();
                temp.setUserName(rs.getString("userName"));
                temp.setPassword(rs.getString("password"));
                temp.setUserEmail(rs.getString("userEmail"));
                temp.setUserFollowers(rs.getInt("userFollowers"));
                temp.setUserGender(rs.getString("userGender"));
                temp.setUserCategory(controller.buatCategoryUser(rs.getInt("userCategory")));
                listUser.add(temp);
            }
            return listUser;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
