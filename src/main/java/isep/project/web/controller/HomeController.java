package isep.project.web.controller;

import isep.project.web.entity.LikeEntity;
import isep.project.web.entity.MessageEntity;
import isep.project.web.entity.UserEntity;
import isep.project.web.service.ILikeService;
import isep.project.web.service.IMessageService;
import isep.project.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    IMessageService messageService;
    @Autowired
    IUserService userService;
    @Autowired
    ILikeService likeService;

    @GetMapping("/homepage")
    public String index(Model model) {
        List<MessageEntity> messages = messageService.getAll();
        model.addAttribute("allMessages", messages);
        return "index";
    }

    @PostMapping("/likeMessage")
    public  @ResponseBody String likeMessageViaAjax(@RequestParam("id") String id) {
        try{
            int messageId = Integer.parseInt(id);
            //get user and message
            //TODO get UserEntity from session
            UserEntity user = userService.getById(72);
            if (user == null){
                return "You must be logged in";
            }
            MessageEntity message = messageService.getById(messageId);
            LikeEntity like = likeService.getLikeIfExists(user,message);
            //check if user is allowed to like
            if(like == null) {
                // create like if allowed
                like = new LikeEntity(false, message, user);
                likeService.save(like);
                return "success";
            }
            else{
                likeService.delete(like.getId());
                return "like removed successfully";
            }
        }
        catch (Exception e){
            return "error :" + e.getMessage();
        }

    }

}
