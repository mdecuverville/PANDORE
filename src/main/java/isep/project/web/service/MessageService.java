package isep.project.web.service;

import isep.project.web.dao.MessageDAO;
import isep.project.web.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MessageService implements IMessageService {
    @Autowired
    MessageDAO dao;

    @Override
    @Transactional
    public MessageEntity getById(int id){
        return dao.getMessageById(id);
    }

    @Override
    @Transactional
    public List<MessageEntity> getAll(){
        return  dao.getAllMessages();
    }

    @Override
    @Transactional
    public void save(MessageEntity cat){
        dao.saveMessage(cat);
    }

    @Override
    @Transactional
    public void delete(int theId){
        dao.deleteMessage(theId);
    }

}
