package DAL.DTO;

import java.util.List;

public interface IUserDTO {
    int getUserID();
    String getUsername();
    Boolean getAdmin();
    String getRoles(int i);
    List getRoleList();
}
