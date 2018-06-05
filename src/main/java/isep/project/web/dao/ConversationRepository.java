package isep.project.web.dao;

import isep.project.web.entity.ConversationEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConversationRepository implements ConversationDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<ConversationEntity> getAllConversations(){
        Session s = sessionFactory.getCurrentSession();
        Query<ConversationEntity> query = s.createQuery("from ConversationEntity  order by conversationName", ConversationEntity.class);
        return query.getResultList();
    }

    @Override
    public ConversationEntity getConversationById(int id){
        Session s = sessionFactory.getCurrentSession();
        return s.get(ConversationEntity.class, id);
    }

    @Override
    public void saveConversation(ConversationEntity conv){
        Session s = sessionFactory.getCurrentSession();
        s.saveOrUpdate(conv);
    }

    @Override
    public void deleteConversation(int theId){
        Session s = sessionFactory.getCurrentSession();
        s.delete(getConversationById(theId));
    }
}
