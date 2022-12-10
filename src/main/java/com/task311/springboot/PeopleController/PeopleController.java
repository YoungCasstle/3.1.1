package com.task311.springboot.PeopleController;

import com.task311.springboot.Service.Service;
import com.task311.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class PeopleController {

    private final Service userService;

    @Autowired
    public PeopleController(Service userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", userService.getAllUser());
        return "user/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id,Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return "redirect:/user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user";
    }
}



