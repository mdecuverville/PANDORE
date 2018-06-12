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
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/index")
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
        //get the user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Integer> likedMessagesIds = new ArrayList<>();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserEntity user = userService.getByEmail(UserEntity.getLoggedUser());
            //UserEntity user = userService.getById(72);//until merge, it will do
            List<LikeEntity> userlikes = user.getLikes();

            //get the messages he liked
            for (LikeEntity like : userlikes) {
                int mesId = like.getLikedMessage().getId();
                if (!likedMessagesIds.contains(mesId)) likedMessagesIds.add(mesId);
            }
        }

        //get all messages
        List<ConversationEntity> conversations = conversationService.getAll();
        List<MessageEntity> messages = new ArrayList<>();
        for (ConversationEntity conv : conversations) {
            if (conv.getMessages().size() > 0) messages.add(conv.getMessages().get(0));
        }

        Map<MessageEntity, Boolean> messagesAndlikes = new HashMap<>();//Key:message  Value:IsLikedByUser
        for (MessageEntity m : messages) {
            messagesAndlikes.put(m, likedMessagesIds.contains(m.getId()));
        }
        model.addAttribute("messagesAndlikes", messagesAndlikes);

        int likeVal =0;
        model.addAttribute("likeId", likeVal);
        return "index";
    }




    @GetMapping("/likeMessage")
    public String likeHandler(@RequestParam("mId") int  theId, Authentication authentication){
        try{

            authentication.getPrincipal();
            // Get the usermail from the sesssion Auth
            UserEntity user = null;

//            if (!(authentication instanceof AnonymousAuthenticationToken)) {
//               user = userService.getByEmail(UserEntity.getLoggedUser());
//            }

            //user = userService.getByEmail(UserEntity.getLoggedUser());
            user = userService.getByEmail(authentication.getName());


            MessageEntity message = messageService.getById(theId);

            LikeEntity like = null;
            if (user!=null){
                like = likeService.getLikeIfExists(user,message);
            }


            //check if user is allowed to like
            if(like == null && user!=null && message!=null) {
                // create like if none exist
                like = new LikeEntity(false, message, user);
                likeService.save(like);
            }
            else if (like != null){
                //delete like if there is one already
                likeService.delete(like.getId());
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/index.jsp";
    }



}
