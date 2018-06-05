package isep.project.web.service;


import isep.project.web.dao.CategoryDAO;
import isep.project.web.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryDAO dao;

    @Override
    @Transactional
    public CategoryEntity getById(int id){
        return dao.getCategoryById(id);
    }

    @Override
    @Transactional
    public List<CategoryEntity> getAll(){
        return  dao.getAllCategories();
    }

    @Override
    @Transactional
    public void save(CategoryEntity cat){
        dao.saveCategory(cat);
    }

    @Override
    @Transactional
    public void delete(int theId){
        dao.deleteCategory(theId);
    }

}
