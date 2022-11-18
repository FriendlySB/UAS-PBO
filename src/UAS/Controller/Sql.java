package UAS.Controller;

import UAS.Model.CategoryUser;
import UAS.Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sql {
    DatabaseHandler conn = new DatabaseHandler();
    
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
            }
            return listCategory;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
