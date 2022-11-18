package UAS.Controller;

import UAS.Model.*;
import java.util.ArrayList;

public class Controller {
    Sql sql = new Sql();

    public Controller() {
        
    }
    
    public CategoryUser buatCategoryUser(int id){
        CategoryUser temp = new CategoryUser();
        ArrayList<CategoryUser> listCategory = new ArrayList<>(sql.getCategoryUser());
        for(int i = 0; i < listCategory.size(); i++){
            if(id == listCategory.get(i).getCategoryId()){
                temp.setCategoryId(listCategory.get(i).getCategoryId());
                temp.setCategoryName(listCategory.get(i).getCategoryName());
            }
        }
        return temp;
    }
    
    public Object[] buatTabel(User user){
        int id = user.getUserId();
        String username = user.getUserName();
        String password = user.getPassword();
        String gender = user.getUserGender();
        String email = user.getUserEmail();
        String kategori = user.getUserCategory().getCategoryName();
        int follower = user.getUserFollowers();
        Object data[] = {id,username,password,gender,email,kategori,follower};
        return data;
    }
}
