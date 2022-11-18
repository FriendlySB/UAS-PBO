
package UAS.Model;

public class User {
    private int idUser;
    private String username;
    private String alamat;

    public User() {
        
    }

    public User(int idUser, String username, String alamat) {
        this.idUser = idUser;
        this.username = username;
        this.alamat = alamat;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
}
