package isep.project.web.controller;

import isep.project.web.dao.ConversationDAO;
import isep.project.web.entity.ConversationEntity;
import isep.project.web.entity.MessageEntity;
import isep.project.web.service.ConversationService;
import isep.project.web.service.IConversationService;
import isep.project.web.service.IMessageService;
import isep.project.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Created by owner on 18-05-15.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IConversationService conversationService;

    @GetMapping("/list")
    public String listAll(Model theModel) {

        List<MessageEntity> messagesList = messageService.getAll();
        theModel.addAttribute("messages", messagesList);

        return "list-messages";
    }

    @GetMapping("/add")
    public String add(Model theModel) {

        MessageEntity theMessage = new MessageEntity();
        theModel.addAttribute("message", theMessage);

        return "message-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("message") MessageEntity theMessage) {

        try {

            ConversationEntity newConversation = new ConversationEntity();
            newConversation.setConversationName(theMessage.getTitle());

            newConversation.addMessage(theMessage);
            theMessage.setConversationIn(newConversation);

            messageService.save(theMessage);
            conversationService.save(newConversation);

            return "redirect:/index.jsp";
        }

        catch (NullPointerException e) {
            return "redirect:/";
        }

    }

    @PostMapping("/save/{conversationId}")
    public String save(@PathVariable("conversationId") int conversationId,@ModelAttribute("message") MessageEntity theMessage) {

        try {

            ConversationEntity conversation = conversationService.getById(conversationId);

            messageService.save(theMessage);

            conversation.addMessage(theMessage);
            theMessage.setConversationIn(conversation);

            return "redirect:/message/list";
        }

        catch (NullPointerException e) {
            return "redirect:/";
        }

    }

    @GetMapping("/update")
    public String update(@RequestParam("messageId") int theId, Model theModel) {

        // Get the message from the database
        MessageEntity theMessage = messageService.getById(theId);

        // Set the message s a model attribute to pre-populate the form
        theModel.addAttribute("message", theMessage);

        // Send it to the form
        return "message-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("messageId") int theId) {

        // Get the message from the database
        messageService.delete(theId);

        return "redirect:/message/list";
    }

}
