package isep.project.web.service;

import isep.project.web.dao.LikeDAO;
import isep.project.web.entity.LikeEntity;
import isep.project.web.entity.MessageEntity;
import isep.project.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikeService implements ILikeService{

    @Autowired
    LikeDAO dao;

    @Override
    @Transactional
    public LikeEntity getById(int id){
        return dao.getLikeById(id);
    }

    @Override
    public List<LikeEntity> getByUserId(int userId) {
        List<LikeEntity> likes = getAll();
        List<LikeEntity> userlikes = new ArrayList<>();
        for(LikeEntity like : likes){
            if (like.getLikedBy().getId() == userId){
                userlikes.add(like);
            }
        }

        return null;
    }

    @Override
    @Transactional
    public List<LikeEntity> getAll(){
        return  dao.getAllLikese();
    }

    @Override
    @Transactional
    public void save(LikeEntity like){
        dao.saveLike(like);
    }

    @Override
    @Transactional
    public void delete(int theId){
        dao.deleteLike(theId);
    }

    @Override
    @Transactional
    public LikeEntity getLikeIfExists(UserEntity user, MessageEntity message) {
        return dao.getByUserAndMessage(user.getId(), message.getId());
    }
}
