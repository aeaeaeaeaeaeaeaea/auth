package ru.ae.authform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ae.authform.dao.UserDAO;
import ru.ae.authform.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/{userLogin}")
    public String profile(@PathVariable("userLogin") String login, Model model) {
        model.addAttribute("person", userDAO.getUser(login));
        return "profile/profile";
    }

    @GetMapping("/{userLogin}/edit")
    public String edit(@PathVariable("userLogin") String login, Model model) {
        model.addAttribute("editUser", userDAO.getUser(login));
        return "profile/edit";
    }

    @PatchMapping("/{userLogin}")
    public String Data(@ModelAttribute("editUser") User user, @PathVariable("userLogin") String login) {

        userDAO.update(login, user);
        return "redirect:/logIn";
    }
}
