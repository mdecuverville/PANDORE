package isep.project.web.dao;

import isep.project.web.entity.LikeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class LikeRepository implements LikeDAO {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<LikeEntity> getAllLikese(){
        Session s = sessionFactory.getCurrentSession();
        Query<LikeEntity> query = s.createQuery("from LikeEntity order by id", LikeEntity.class);
        return query.getResultList();
    }

    @Override
    public LikeEntity getLikeById(int id){
        Session s = sessionFactory.getCurrentSession();
        return s.get(LikeEntity.class, id);
    }

    @Override
    public void saveLike(LikeEntity like){
        Session s = sessionFactory.getCurrentSession();
        s.saveOrUpdate(like);
    }

    @Override
    public void deleteLike(int theId){
        Session s = sessionFactory.getCurrentSession();
        s.delete(getLikeById(theId));
    }

    @Override
    public LikeEntity getByUserAndMessage(int userId, int messageId){
        Session s = sessionFactory.getCurrentSession();
        List<?> likeList = hibernateTemplate.find("FROM LikeEntity WHERE likedBy=? AND likedMessage=?",userId,messageId);

        if(likeList.size()>0) return (LikeEntity) likeList.get(0);
        return null;
    }

}
