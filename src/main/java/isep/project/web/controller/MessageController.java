package isep.project.web.controller;

import isep.project.web.entity.MessageEntity;
import isep.project.web.service.IMessageService;
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
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;
    @Autowired
    private IUserService userService;

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

//        See if the message if the first of a conversation
//        if (theMessage.getType() == "FIRST") {
//            ConversationEntity newConversation = new ConversationEntity();
//            newConversation.setConversationName(theMessage.getTitle());
//        }

//        save the message using our isep.project.web.service
//        System.out.println(theMessage.getCreatedBy().getFirstName());

        System.out.println(theMessage);

        messageService.save(theMessage);

        return "redirect:/message/list";
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
