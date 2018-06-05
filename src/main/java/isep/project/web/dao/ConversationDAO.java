package isep.project.web.dao;

import isep.project.web.entity.ConversationEntity;

import java.util.List;

public interface ConversationDAO {
    List<ConversationEntity> getAllConversations();

    ConversationEntity getConversationById(int id);

    void saveConversation(ConversationEntity conv);

    void deleteConversation(int theId);
}
