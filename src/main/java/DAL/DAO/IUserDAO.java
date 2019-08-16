package DAL.DAO;

import DAL.DTO.IUserDTO;
import DAL.DTO.UserDTO;

import java.sql.Connection;

public interface IUserDAO {

    void createUser(Connection connection, IUserDTO userDTO);
    UserDTO getUser(Connection connection, int ID);
    void updateUser(Connection connection, IUserDTO userDTO);
    void deleteUser(Connection connection, int ID);
}
