package isep.project.web.dao;

import isep.project.web.entity.MessageEntity;

import java.util.List;

public interface MessageDAO {
    List<MessageEntity> getAllMessages();

    MessageEntity getMessageById(int id);

    void saveMessage(MessageEntity message);

    void deleteMessage(int theId);
}
