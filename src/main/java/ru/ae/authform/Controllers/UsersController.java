package ru.ae.authform.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ae.authform.dao.UserDAO;
import ru.ae.authform.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/signUp")
public class UsersController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping()
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "signup/signUp";
    }

    @GetMapping("/admin")
    public String success(Model model) {
        model.addAttribute("user", userDAO.success());
        return "signup/admin";
    }

    @PostMapping()
    public String result(@ModelAttribute("user") User user) {
        return userDAO.contains(user);
    }


}
