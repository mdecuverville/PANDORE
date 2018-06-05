package isep.project.web.service;

import isep.project.web.dao.UserDAO;
import isep.project.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by owner on 18-04-04.
 */
@Service
public class UserService implements IUserService {

    // need to inject customer isep.project.web.dao
    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional
    public List<UserEntity> getAll() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public UserEntity getById(int theId) {
        return userDAO.getUser(theId);
    }

    @Override
    @Transactional
    public void save(UserEntity theUser) {
        userDAO.saveUser(theUser);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        userDAO.deleteUser(theId);
    }
}
