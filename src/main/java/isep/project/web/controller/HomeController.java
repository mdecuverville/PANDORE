package isep.project.web.controller;

import isep.project.web.entity.MessageEntity;
import isep.project.web.service.IMessageService;
import isep.project.web.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    IMessageService messageService;

    @GetMapping("/homepage")
    public String index(Model model) {
        List<MessageEntity> messages = messageService.getAll();
        model.addAttribute("allMessages", messages);
        return "index";
    }

}
