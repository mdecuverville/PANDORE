package isep.project.web.controller;

import isep.project.web.entity.ConversationEntity;
import isep.project.web.entity.LikeEntity;
import isep.project.web.entity.MessageEntity;
import isep.project.web.entity.UserEntity;
import isep.project.web.service.IConversationService;
import isep.project.web.service.ILikeService;
import isep.project.web.service.IMessageService;
import isep.project.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    IMessageService messageService;
    @Autowired
    IUserService userService;
    @Autowired
    ILikeService likeService;
    @Autowired
    IConversationService conversationService;

    @GetMapping("/homepage")
    public String index(Model model) {
//        //get the user
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        //if (!(authentication instanceof AnonymousAuthenticationToken)) {
//        //UserEntity user = userService.getByEmail(UserEntity.getLoggedUser());
//        UserEntity user = userService.getById(72);//until merge, it will do
//        List<LikeEntity> userlikes = user.getLikes();
//
//        //get the messages he liked
//        List<Integer> likedMessagesIds = new ArrayList<>();
//        for(LikeEntity like : userlikes){
//            int mesId = like.getLikedMessage().getId();
//            if(!likedMessagesIds.contains(mesId)) likedMessagesIds.add(mesId);
//        }
//
//        //}

        //get all messages
        List<ConversationEntity> conversations = conversationService.getAll();
        List<MessageEntity> messages = new ArrayList<>();
        Map<Integer, MessageEntity> convIdAndMessages = new HashMap<>();
        for (ConversationEntity conv : conversations){
            if(conv.getMessages().size()>0) convIdAndMessages.put(conv.getId(), conv.getMessages().get(0));
        }

//        Map<MessageEntity,Boolean> messagesAndlikes = new HashMap<>();//Key:message  Value:IsLikedByUser
//        for (MessageEntity m : messages){
//            messagesAndlikes.put(m,likedMessagesIds.contains(m.getId()));
//        }
        model.addAttribute("convIdAndMessages", convIdAndMessages);
        return "index";
    }


    private class AjaxRequestBody{
        int id;
    }

//    @RequestMapping(value = "/likeMessage2", method = RequestMethod.POST, consumes = "application/json" , produces = MediaType. APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    Integer newProductCategory(HttpServletRequest request, @RequestBody AjaxRequestBody arb){
//        int result = 0;
//        try{
//
//            //get user and message
//            //String usermail = UserEntity.getLoggedUser();
//            //UserEntity user = userService.getByEmail(uesrmail);
//
//            //for now lets use this one
//            UserEntity user = userService.getById(72);
//            if (user == null){
//                result =1;//"You must be logged in";
//            }
//            MessageEntity message = messageService.getById(arb.id);
//            LikeEntity like = likeService.getLikeIfExists(user,message);
//
//            //check if user is allowed to like
//            if(like == null) {
//                // create like if none exist
//                like = new LikeEntity(false, message, user);
//                likeService.save(like);
//                result=2;// "success";
//            }
//            else{
//                //delete like if there is one already
//                likeService.delete(like.getId());
//                result = 3; //"like removed successfully";
//            }
//        }
//        catch (Exception e){
//            result = 4;//"error :" + e.getMessage();
//        }
//        return result;
//    }



}