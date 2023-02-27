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
@RequestMapping("/logIn")
public class LogInController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping()
    public String login(Model model) {
        model.addAttribute("existUser", new User());
        return "login/LogIn";
    }

    @PostMapping()
    public String logIn(@ModelAttribute("existUser") User user) {
        return userDAO.login(user);
    }

    @GetMapping("/fail")
    public String fail(Model model) {
        return "login/fail";
    }


}
