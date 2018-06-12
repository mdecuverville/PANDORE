package isep.project.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import isep.project.web.entity.*;
import isep.project.web.jsonview.AjaxRequestBody;
import isep.project.web.jsonview.Views;
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
        //get the user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //if (!(authentication instanceof AnonymousAuthenticationToken)) {
            //UserEntity user = userService.getByEmail(UserEntity.getLoggedUser());
        UserEntity user = userService.getById(72);//until merge, it will do
        List<LikeEntity> userlikes = user.getLikes();

        //get the messages he liked
        List<Integer> likedMessagesIds = new ArrayList<>();
        for(LikeEntity like : userlikes){
            int mesId = like.getLikedMessage().getId();
            if(!likedMessagesIds.contains(mesId)) likedMessagesIds.add(mesId);
        }

        //}

        //get all messages
        List<ConversationEntity> conversations = conversationService.getAll();
        List<MessageEntity> messages = new ArrayList<>();
        for (ConversationEntity conv : conversations){
            if(conv.getMessages().size()>0) messages.add(conv.getMessages().get(0));
        }

        Map<MessageEntity,Boolean> messagesAndlikes = new HashMap<>();//Key:message  Value:IsLikedByUser
        for (MessageEntity m : messages){
            messagesAndlikes.put(m,likedMessagesIds.contains(m.getId()));
        }
        model.addAttribute("messagesAndlikes", messagesAndlikes);
        return "index";
    }


//    private class AjaxRequestBody{
//        int id;
//    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/test/test")
    public AjaxResponseBody getSearchResultViaAjax(@RequestBody AjaxRequestBody requestBody) {

        AjaxResponseBody result = new AjaxResponseBody();

        System.out.println(requestBody.getId());

        if (requestBody.getId() != null) {

                result.setCode("200");
                result.setMsg("");
                result.setResult("ca marche : " + requestBody.getId());


        } else {
            result.setCode("400");
            result.setMsg("Search criteria is empty!");
        }

        //AjaxResponseBody will be converted into json format and send back to client.
        return result;

    }

    @RequestMapping(value = "/likeMessage", method = RequestMethod.POST, consumes = "application/json" , produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Integer likeHandle(HttpServletRequest request, @RequestBody AjaxRequestBody arb, Authentication authentication){
        int result;
        System.out.println("hello");

        try{

            // Get the usermail from the sesssion Auth
            authentication.getPrincipal();

            // Get the user from the database
            UserEntity user = userService.getByEmail(authentication.getName());

            MessageEntity message = messageService.getById(Integer.valueOf(arb.getId()));
            LikeEntity like = likeService.getLikeIfExists(user,message);

            //check if user is allowed to like
            if(like == null) {
                // create like if none exist
                like = new LikeEntity(false, message, user);
                likeService.save(like);
                result=2;// "success";
            }
            else{
                //delete like if there is one already
                likeService.delete(like.getId());
                result = 3; //"like removed successfully";
            }
        }
        catch (Exception e){
            result = 4; //"error :" + e.getMessage();
        }
        return result;
    }



}
