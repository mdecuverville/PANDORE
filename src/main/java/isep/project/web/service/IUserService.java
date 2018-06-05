package isep.project.web.service;

import isep.project.web.entity.UserEntity;

import java.util.List;

/**
 * Created by owner on 18-04-04.
 */
public interface IUserService {
    List<UserEntity> getAll();
    UserEntity getById(int theId);
    UserEntity getByEmail(String email);


    void save(UserEntity theUser);
    void delete(int theId);
}
