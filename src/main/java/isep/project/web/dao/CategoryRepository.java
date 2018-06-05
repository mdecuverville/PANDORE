package isep.project.web.dao;

import isep.project.web.entity.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository implements CategoryDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CategoryEntity> getAllCategories(){
        Session s =sessionFactory.getCurrentSession();

        Query<CategoryEntity> query = s.createQuery("from CategoryEntity order by categoryName", CategoryEntity.class);

        return query.getResultList();
    }

    @Override
    public CategoryEntity getCategoryById(int id){
        Session s = sessionFactory.getCurrentSession();
        return s.get(CategoryEntity.class, id);
    }

    @Override
    public void saveCategory(CategoryEntity cat){
        Session s = sessionFactory.getCurrentSession();
        s.saveOrUpdate(cat);
    }

    @Override
    public void deleteCategory(int theId){
        Session s = sessionFactory.getCurrentSession();
        s.delete(getCategoryById(theId));
    }


}
