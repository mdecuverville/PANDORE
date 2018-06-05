package isep.project.web.dao;

import isep.project.web.entity.UserGroupEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserGroupRepository implements UserGroupDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserGroupEntity getUserGroupById(int id){
        Session s = sessionFactory.getCurrentSession();
        return s.get(UserGroupEntity.class, id);
    }

    @Override
    public List<UserGroupEntity> getAllUserGroups(){
        Session s = sessionFactory.getCurrentSession();
        Query<UserGroupEntity> query = s.createQuery("from UserGroupEntity order by userGroupName", UserGroupEntity.class);
        return query.getResultList();
    }

    @Override
    public void saveUserGroup(UserGroupEntity userGroup){
        Session s = sessionFactory.getCurrentSession();
        s.saveOrUpdate(userGroup);
    }

    @Override
    public void deleteUserGroup(int theId){
        Session s = sessionFactory.getCurrentSession();
        s.delete(getUserGroupById(theId));

        System.out.println("work done");
    }


}
