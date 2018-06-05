package isep.project.web.service;

import isep.project.web.dao.UserGroupDAO;
import isep.project.web.entity.UserGroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserGroupService implements  IUserGroupService{
    @Autowired
    UserGroupDAO dao;


    @Override
    @Transactional
    public UserGroupEntity getById(int id){
        return dao.getUserGroupById(id);
    }

    @Override
    @Transactional
    public List<UserGroupEntity> getAll(){
        return dao.getAllUserGroups();
    }

    @Override
    @Transactional
    public void save(UserGroupEntity userGroup){
        dao.saveUserGroup(userGroup);
    }


    @Override
    @Transactional
    public void delete(int theId){
        dao.deleteUserGroup(theId);
    }
}
