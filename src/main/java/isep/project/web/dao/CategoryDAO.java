package isep.project.web.dao;

import isep.project.web.entity.CategoryEntity;

import java.util.List;

public interface CategoryDAO {

    List<CategoryEntity> getAllCategories();

    CategoryEntity getCategoryById(int id);

    void saveCategory(CategoryEntity cat);

    void deleteCategory(int theId);
}
