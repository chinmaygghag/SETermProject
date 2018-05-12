package com.example.demo.controller;

import com.example.demo.models.Post;
import com.example.demo.models.Users;
import com.example.demo.services.AdminService;
import com.example.demo.services.PostService;
import com.example.demo.util.AdminUtilClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    PostService postService;


    @GetMapping(value = "/admin")
    public ModelAndView setModelView(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        AdminUtilClass adminUtilClass = new AdminUtilClass();
        List<Users> usersList = adminService.getAllUsers();
        List<String> usernames = new ArrayList<>();
        for (int i=0;i<usersList.size();i++){
            usernames.add(usersList.get(i).getUsername());
        }
        adminUtilClass.setUsername(usernames);

        List<Post> postList = adminService.getAllPosts();

        adminUtilClass.setPostList(postList);


        modelAndView.addObject("admin",adminUtilClass);

        modelAndView.setViewName("admin");
        return modelAndView;
    }



    @GetMapping("/deletePost")
    public ModelAndView deletePosts(HttpServletRequest request,
                                    @RequestParam(name = "postId") String postId){

        Post p = postService.getPostById(Integer.parseInt(postId));
        adminService.deletePost(p);


        return new ModelAndView("success");

    }


}

