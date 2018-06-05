package isep.project.web.service;

import isep.project.web.entity.LikeEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ILikeService {


    @Transactional
    LikeEntity getById(int id);

    @Transactional
    List<LikeEntity> getAll();

    @Transactional
    void save(LikeEntity like);

    @Transactional
    void delete(int likeId);
}
