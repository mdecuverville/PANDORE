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
    @ResponseBody
    public int postResponseController(@RequestParam int messageId) {
        try{
            //get user and message
            //TODO get UserEntity from session
            UserEntity user = userService.getById(72);

            if (user == null){
                return 1;
            }


            MessageEntity message = messageService.getById(messageId);

            //check if user is allowed to like
            if(canLike(user, message)) {
                // create like if allowed
                LikeEntity like = new LikeEntity(false, message, user);
                likeService.save(like);
                return 0;
            }
            return 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 2;
    }

    private boolean canLike(UserEntity user, MessageEntity message) {
        List<LikeEntity> allLikes = likeService.getAll();
        for (LikeEntity like : allLikes) {
            if (like.getLikedBy()==user && like.getLikedMessage()==message) return false;
        }
        return true;
    }
}
