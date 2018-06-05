package isep.project.web.service;

import isep.project.web.dao.ConversationDAO;
import isep.project.web.entity.ConversationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConversationService implements  IConversationService {

    @Autowired
    ConversationDAO dao;

    @Override
    @Transactional
    public ConversationEntity getById(int id){
        return dao.getConversationById(id);
    }

    @Override
    @Transactional
    public List<ConversationEntity> getAll(){
        return  dao.getAllConversations();
    }

    @Override
    @Transactional
    public void save(ConversationEntity conv){
        dao.saveConversation(conv);
    }

    @Override
    @Transactional
    public void delete(int theId){
        dao.deleteConversation(theId);
    }
}
