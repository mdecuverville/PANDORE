package isep.project.web.service;

import isep.project.web.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {


    CategoryEntity getById(int id);

    List<CategoryEntity> getAll();

    void save(CategoryEntity cat);

    void delete(int catId);
}

