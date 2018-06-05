package isep.project.web.dao;

import isep.project.web.entity.MessageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepository implements  MessageDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<MessageEntity> getAllMessages(){
        Session s = sessionFactory.getCurrentSession();
        Query<MessageEntity> query = s.createQuery("from MessageEntity order by id", MessageEntity.class);
        return query.getResultList();
    }

    @Override
    public MessageEntity getMessageById(int id){
        Session s = sessionFactory.getCurrentSession();
        return s.get(MessageEntity.class, id);
    }

    @Override
    public void saveMessage(MessageEntity message){
        Session s = sessionFactory.getCurrentSession();
        s.saveOrUpdate(message);
    }

    @Override
    public void deleteMessage(int theId){
        Session s = sessionFactory.getCurrentSession();
        s.delete(getMessageById(theId));
    }
}
