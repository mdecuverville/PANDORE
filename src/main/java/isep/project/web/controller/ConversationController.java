package isep.project.web.controller;

import isep.project.web.entity.ConversationEntity;
import isep.project.web.service.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by owner on 18-05-15.
 */
@Controller
@RequestMapping("/conversation")
public class ConversationController {

    @Autowired
    private IConversationService conversationService;

    @GetMapping("/list")
    public String listAll(Model theModel) {

        List<ConversationEntity> conversationList = conversationService.getAll();

        // set it as an attribute inside the Model
        theModel.addAttribute("conversations", conversationList);

        return "list-conversations";
    }

    @GetMapping("/add")
    public String add(Model theModel) {

        // We create a new conversation to bind form data
        ConversationEntity theConversation = new ConversationEntity();
        theModel.addAttribute("conversation", theConversation);

        return "conversation-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("conversation") ConversationEntity theConversation) {

        // save the conversation using our isep.project.web.service
        conversationService.save(theConversation);

        return "redirect:/conversation/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("conversationId") int theId, Model theModel) {

        // Get the conversation from the database
        ConversationEntity theConversation = conversationService.getById(theId);

        // Set the conversation s a model attribute to pre-populate the form
        theModel.addAttribute("conversation", theConversation);

        // Send it to the form
        return "conversation-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("conversationId") int theId) {

        // Get the conversation from the database
        conversationService.delete(theId);

        return "redirect:/conversation/list";
    }

}
