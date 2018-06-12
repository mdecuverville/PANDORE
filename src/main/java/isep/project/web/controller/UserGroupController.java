package isep.project.web.controller;

import isep.project.web.entity.CategoryEntity;
import isep.project.web.entity.UserEntity;
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
@RequestMapping("/group")
public class UserGroupController {

    @Autowired
    private IUserGroupService groupService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IUserService userService;


    @GetMapping("/list")
    public String listAll(Model theModel) {

        List<UserGroupEntity> groupList = groupService.getAll();
        List<CategoryEntity> categories = categoryService.getAll();
        List<UserEntity> users = userService.getAll();
        // set it as an attribute inside the Model
        theModel.addAttribute("groups", groupList);
        theModel.addAttribute("categories", categories);
        theModel.addAttribute("users", users);
        return "list-groups";
    }

    @GetMapping("/add")
    public String add(Model theModel) {

        // We create a new group to bind form data
        UserGroupEntity theUserGroup = new UserGroupEntity();
        theModel.addAttribute("group", theUserGroup);

        return "group-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("group") UserGroupEntity theUserGroup) {

        // save the group using our isep.project.web.service
        groupService.save(theUserGroup);

        return "redirect:/group/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("groupId") int theId, Model theModel) {

        // Get the group from the database
        UserGroupEntity theUserGroup = groupService.getById(theId);

        // Set the group s a model attribute to pre-populate the form
        theModel.addAttribute("group", theUserGroup);

        // Send it to the form
        return "group-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("groupId") int theId) {

        // Get the group from the database
        groupService.delete(theId);

        return "redirect:/group/list";
    }

}
