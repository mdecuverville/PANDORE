package isep.project.web.controller;

import isep.project.web.entity.UserEntity;
import isep.project.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by owner on 18-05-15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public String listAll(Model theModel) {

        List<UserEntity> usersList = userService.getAll();

        // set it as an attribute inside the Model
        theModel.addAttribute("users", usersList);

        return "list-users";
    }

    @GetMapping("/info")
    public String home(Model model, Authentication authentication) {

        // Get the usermail from the sesssion Auth
        authentication.getPrincipal();

        // Get the user from the database
        UserEntity theUser = userService.getByEmail(authentication.getName());

        model.addAttribute("user", theUser);
        return "user-info";
    }

    @GetMapping("/add")
    public String add(Model theModel) {

        // We create a new user to bind form data
        UserEntity theUser = new UserEntity();
        theModel.addAttribute("user", theUser);

        return "user-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") UserEntity theUser) {

        // save the user using our isep.project.web.service
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        theUser.setPasswordHash(encoder.encode(theUser.getPasswordHash()));
        userService.save(theUser);

        return "redirect:/user/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("userId") int theId, Model theModel) {

        // Get the user from the database
        UserEntity theUser = userService.getById(theId);

        // Set the user s a model attribute to pre-populate the form
        theModel.addAttribute("user", theUser);

        // Send it to the form
        return "user-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId) {

        // Get the user from the database
        userService.delete(theId);

        return "redirect:/user/list";
    }

}
