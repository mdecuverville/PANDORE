package isep.project.web.service;

import isep.project.web.entity.UserGroupEntity;

import java.util.List;

public interface IUserGroupService {

    UserGroupEntity getById(int id);

    List<UserGroupEntity> getAll();

    void save(UserGroupEntity userGroup);

    void delete(int userGroupId);
}
