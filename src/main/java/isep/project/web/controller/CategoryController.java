package isep.project.web.controller;

import isep.project.web.entity.CategoryEntity;
import isep.project.web.entity.UserGroupEntity;
import isep.project.web.service.ICategoryService;
import isep.project.web.service.IUserGroupService;
import isep.project.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by owner on 18-05-15.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IUserGroupService userGroupService;

    @GetMapping("/list")
    public String listAll(Model theModel) {

        List<CategoryEntity> catList = categoryService.getAll();
        List<UserGroupEntity> allGroups = userGroupService.getAll();
        // set it as an attribute inside the Model
        theModel.addAttribute("categories", catList);
        theModel.addAttribute("allGroups", allGroups);

        return "list-cat";
    }

    @GetMapping("/add")
    public String add(Model theModel) {

        // We create a new category to bind form data
        CategoryEntity theCategory = new CategoryEntity();
        theModel.addAttribute("category", theCategory);

        return "category-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") CategoryEntity theCategory) {

        // save the category using our isep.project.web.service
        categoryService.save(theCategory);

        return "redirect:/category/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("categoryId") int theId, Model theModel) {

        // Get the category from the database
        CategoryEntity theCategory = categoryService.getById(theId);

        // Set the category s a model attribute to pre-populate the form
        theModel.addAttribute("category", theCategory);

        // Send it to the form
        return "category-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("categoryId") int theId) {

        // Get the category from the database
        categoryService.delete(theId);

        return "redirect:/category/list";
    }

}
