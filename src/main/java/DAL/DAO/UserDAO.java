package DAL.DAO;

import DAL.DTO.IUserDTO;
import DAL.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {


    public void createUser(Connection connection, IUserDTO userDTO) {
        try {
            PreparedStatement prep1 = connection.prepareStatement("INSERT INTO Users VALUES (?,?,?);");
            PreparedStatement prep2 = connection.prepareStatement("INSERT INTO Roles VALUES (?,?);");

            prep1.setInt(1,userDTO.getUserID());
            prep1.setString(2,userDTO.getUsername());
            prep1.setBoolean(3,userDTO.getAdmin());
            prep1.execute();

            prep2.setInt(1,userDTO.getUserID());

            for(int i = 0; i < userDTO.getRoleList().size(); i++){
                prep2.setString(2, userDTO.getRoles(i));
                prep2.execute();
            }


        } catch (SQLException e){e.printStackTrace();}
    }

    public UserDTO getUser(Connection connection, int ID) {
        try {
            PreparedStatement prep1 = connection.prepareStatement("SELECT*FROM Users WHERE user_id = ?;");
            PreparedStatement prep2 = connection.prepareStatement("SELECT*FROM Roles WHERE user_id= ?;");

            prep1.setInt(1,ID);

            prep2.setInt(1,ID);

            ResultSet resultSetRoller = prep1.executeQuery();

            ArrayList rolesList = new ArrayList();
            int index = 0;
            while (resultSetRoller.next()){
                rolesList.add(index,resultSetRoller.getString(index+1));
                index++;
            }

            ResultSet res = prep1.executeQuery();

            UserDTO userDTO = null;

            while(res.next()){
                userDTO = new UserDTO(res.getInt(1),res.getString(2),res.getBoolean(3),rolesList);
            }

            return userDTO;

        } catch (SQLException e){e.printStackTrace();}

        return null;
    }

    public void updateUser(Connection connection, IUserDTO userDTO) {
        try {
            PreparedStatement prep1 = connection.prepareStatement("UPDATE Users SET username = ?, administrator = ? WHERE user_id = ?;");
            PreparedStatement prep2 = connection.prepareStatement("UPDATE Roles SET role = ? WHERE user_id = ?;");

            prep1.setString(1,userDTO.getUsername());
            prep1.setBoolean(2,userDTO.getAdmin());
            prep1.setInt(3,userDTO.getUserID());
            prep1.executeUpdate();

            for(int i = 0; i < userDTO.getRoleList().size(); i++){
                prep2.setString(1,userDTO.getRoles(i));
                prep2.setInt(2, userDTO.getUserID());
                prep2.executeUpdate();
            }


        } catch (SQLException e){e.printStackTrace();}
    }

    public void deleteUser(Connection connection, int ID) {
        try {
            PreparedStatement prep1 = connection.prepareStatement("DELETE FROM Users WHERE user_id = ?;");
            PreparedStatement prep2 = connection.prepareStatement("DELETE FROM Roles WHERE user_id = ?;");

            prep2.setInt(1,ID);
            prep2.execute();

            prep1.setInt(1,ID);
            prep1.execute();


        } catch (SQLException e){e.printStackTrace();}
    }
}
