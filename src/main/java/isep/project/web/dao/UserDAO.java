package isep.project.web.dao;

import isep.project.web.entity.UserEntity;

import java.util.List;

/**
 * Created by owner on 18-04-01.
 */
public interface UserDAO {

    List<UserEntity> getAllUsers();
    UserEntity getUser(int theId);
    UserEntity getUser(String email);

    void saveUser(UserEntity theUser);
    void deleteUser(int theId);

}
