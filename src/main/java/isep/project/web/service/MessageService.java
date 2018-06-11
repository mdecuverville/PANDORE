package isep.project.web.service;

import isep.project.web.dao.MessageDAO;
import isep.project.web.entity.LikeEntity;
import isep.project.web.entity.MessageEntity;
import isep.project.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<MessageEntity> getLikedByUser(UserEntity user){
        List<LikeEntity> likes = user.getLikes();
        List<MessageEntity> messages = new ArrayList<>();

        for(LikeEntity like : likes){
            MessageEntity mes = like.getLikedMessage();
            if(!messages.contains(mes)) messages.add(mes);
        }
        return messages;
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
