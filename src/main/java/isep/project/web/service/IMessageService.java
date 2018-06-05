package isep.project.web.service;

import isep.project.web.entity.MessageEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMessageService {
    @Transactional
    MessageEntity getById(int id);

    @Transactional
    List<MessageEntity> getAll();

    @Transactional
    void save(MessageEntity messageEntity);

    @Transactional
    void delete(int messageId);
}
