package isep.project.web.dao;

import isep.project.web.entity.LikeEntity;

import java.util.List;

public interface LikeDAO {
    List<LikeEntity> getAllLikese();

    LikeEntity getLikeById(int id);

    void saveLike(LikeEntity like);

    void deleteLike(int theId);
}
