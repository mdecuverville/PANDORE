package isep.project.web.service;

import isep.project.web.entity.LikeEntity;
import isep.project.web.entity.MessageEntity;
import isep.project.web.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ILikeService {


    @Transactional
    LikeEntity getById(int id);

    @Transactional
    List<LikeEntity> getByUserId(int userId);

    @Transactional
    List<LikeEntity> getAll();


    @Transactional
    void save(LikeEntity like);

    @Transactional
    void delete(int likeId);

    LikeEntity getLikeIfExists(UserEntity user, MessageEntity message);
}
