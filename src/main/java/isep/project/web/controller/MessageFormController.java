package isep.project.web.controller;

import isep.project.web.entity.*;
import isep.project.web.service.ICategoryService;
import isep.project.web.service.IConversationService;
import isep.project.web.service.IMessageService;
import isep.project.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/send")
public class MessageFormController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;
    @Autowired
    private IConversationService conversationService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/add")
    public String add(Model theModel) {

        MessageEntity theMessage = new MessageEntity();
        theModel.addAttribute("message", theMessage);

        List<CategoryEntity> categories = categoryService.getAll();

        theModel.addAttribute("categories",  categories);

        return "message-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("message") MessageFormEntity messageForm) {

        try {
            MessageEntity theMessage = new MessageEntity();
            theMessage.setContent(messageForm.getContent());
            theMessage.setTitle(messageForm.getTitle());
            theMessage.setAnonymous("on".equals(messageForm.getAnonymism()));

            ConversationEntity newConversation = new ConversationEntity();
            newConversation.setConversationName(theMessage.getTitle());
            newConversation.setPrivate("on".equals(messageForm.getPrivacy()));

            UserEntity loggedUser = userService.getByEmail(UserEntity.getLoggedUser());

            newConversation.setAuthor(loggedUser);
            theMessage.setCreatedBy(loggedUser);

            int categoryId = messageForm.getCategoryId();

            CategoryEntity category = categoryService.getById(categoryId);

            newConversation.addUser(loggedUser);

//            for(UserGroupEntity userGroup : category.getUsersGroups()) {
//                for(UserEntity user : userGroup.getUsers()) {
//                    if(!newConversation.getUsersIn().contains(user)) {
//                        newConversation.addUser(user);
//                    }
//                }
//            }

            conversationService.save(newConversation);

            theMessage.setConversationIn(newConversation);

            messageService.save(theMessage);


            conversationService.save(newConversation);

            return "redirect:/index.jsp";
        }

        catch (NullPointerException e) {
            return "redirect:/";
        }

    }

    @GetMapping("/add/{conversationId}")
    public String add(@PathVariable("conversationId") int conversationId, Model theModel) {
        ConversationEntity conversation = conversationService.getById(conversationId);

        theModel.addAttribute("conversation", conversation);

        return "conversation-form";
    }

    @PostMapping("/save/{conversationId}")
    public String save(@PathVariable("conversationId") int conversationId, @ModelAttribute("message") MessageEntity theMessage) {

        try {

            ConversationEntity conversation = conversationService.getById(conversationId);

            UserEntity loggedUser = userService.getByEmail(UserEntity.getLoggedUser());

            theMessage.setCreatedBy(loggedUser);

            theMessage.setCreatedAt(new Date(Calendar.getInstance().getTime().getTime()));

            conversationService.save(conversation);

            theMessage.setConversationIn(conversation);

            messageService.save(theMessage);

            return "redirect:/send/add/"+conversationId;
        }

        catch (NullPointerException e) {
            return "redirect:/";
        }

    }
}
