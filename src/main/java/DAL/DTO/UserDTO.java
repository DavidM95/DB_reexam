package DAL.DTO;

import java.util.ArrayList;
import java.util.List;

public class UserDTO implements IUserDTO {

    int userID;
    String username;
    boolean admin;
    ArrayList<String> roles;

    public UserDTO(int userID, String username, boolean admin, ArrayList<String> roles){

        this.userID = userID;
        this.username = username;
        this.admin = admin;
        this.roles = roles;

    }

    public int getUserID() {
        return this.userID;
    }

    public String getUsername() {
        return this.username;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public String getRoles(int i) {
        return this.roles.get(i);
    }

    public List getRoleList() {return  this.roles;}

    @Override
    public String toString() {
        return "UserDTO{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", admin=" + admin +
                ", roles=" + roles +
                '}';
    }
}
