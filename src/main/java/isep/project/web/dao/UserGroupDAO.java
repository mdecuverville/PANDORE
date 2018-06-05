package isep.project.web.dao;

import isep.project.web.entity.UserGroupEntity;

import java.util.List;

public interface UserGroupDAO {
    UserGroupEntity getUserGroupById(int id);

    List<UserGroupEntity> getAllUserGroups();

    void saveUserGroup(UserGroupEntity userGroup);

    void deleteUserGroup(int theId);
}
