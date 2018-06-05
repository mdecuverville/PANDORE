package isep.project.web.service;

import isep.project.web.entity.ConversationEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IConversationService {
    @Transactional
    ConversationEntity getById(int id);

    @Transactional
    List<ConversationEntity> getAll();

    @Transactional
    void save(ConversationEntity conv);

    @Transactional
    void delete(int convId);
}
