package isep.project.web.dao;

import isep.project.web.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by owner on 18-04-01.
 */

@Repository
public class UserRepository implements UserDAO {
    //  Need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    //  @Transactional  -> we will remove it here since we added a isep.project.web.service which will delegate the DAO and manage the transaction (see in CustomerService)
    public List<UserEntity> getAllUsers() {
        // get the hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<UserEntity> theQuery = currentSession.createQuery("from UserEntity order by lastName", UserEntity.class);

        // execute query ans get the result list then return the result
        return theQuery.getResultList();
    }

    @Override
    public void saveUser(UserEntity theUser) {
        Session currentSession = sessionFactory.getCurrentSession();

        // This line of code save or update an entry according of it's disponibility
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public UserEntity getUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(UserEntity.class, theId);
    }

    public UserEntity getUser(String email) {

        UserEntity user = new UserEntity();

        List<?> userList = hibernateTemplate.find("FROM UserEntity WHERE email=?",
                email);
        if(!userList.isEmpty())
            user = (UserEntity) userList.get(0);

        return user;
    }

    @Override
    public void deleteUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // Get the customer from the DB and delete him
        currentSession.delete(getUser(theId));

//        Here is another method to do the same thing
//        Query theQuery = currentSession.createQuery("delete from Customer as c where c.id=:theId");
//        theQuery.setParameter("theId", theId);
//
//        theQuery.executeUpdate();
    }

}
