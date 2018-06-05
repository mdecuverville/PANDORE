package isep.project.web.controller;

import isep.project.web.entity.LikeEntity;
import isep.project.web.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by owner on 18-05-15.
 */
@Controller
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private ILikeService likeService;

    @GetMapping("/list")
    public String listAll(Model theModel) {

        List<LikeEntity> likesList = likeService.getAll();

        // set it as an attribute inside the Model
        theModel.addAttribute("likes", likesList);

        return "list-likes";
    }

    @GetMapping("/add-like") // AJAX
    public int addLike() {

//        LikeEntity like = new LikeEntity();
//
////         get the user who liked
////         get the message liked
//
//        like.setDislike(false);
//        like.setLikedBy(User);
//        like.setLikedMessage(Message);
//
////        the Liked Message
////        --> this is just an exemple it is not like this (we have to fetch the message from the db with it's Id)
//        MessageEntity likeMessage = new MessageEntity();
//        int nbLikes = likeMessage.getLikes().size();
//
//        return nbLikes;

        return 0;
    }

    @GetMapping("/remove-like") // AJAX
    public int removeLike() {
        // fetch all the likes of this message
        // In a for loop remove the like coresponding to this user
        // Return the size of the likes list

        return 0;
    }



}
