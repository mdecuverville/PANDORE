package isep.project.web.service;

import isep.project.web.dao.LikeDAO;
import isep.project.web.entity.LikeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
