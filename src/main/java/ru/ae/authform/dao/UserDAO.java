package ru.ae.authform.dao;

import org.springframework.stereotype.Component;
import ru.ae.authform.model.User;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDAO {

    private List<User> userList = new ArrayList<>();

    public void save(User user) {
        userList.add(user);
    }

    public List<User> success() {
        return userList;
    }
    public String contains(User user) {
        for (User u : userList) {
            if (u.getLogin().equals(user.getLogin())) {
                return "redirect:/logIn";
            }
        }

        userList.add(user);
        return "redirect:/profile/" + user.getLogin();

    }

    public User getUser(String login) {

        User person = null;

        for(User u : userList) {
            if (u.getLogin().equals(login)) {
                person = u;
            }
        }
        return person;
    }

    public String login(User newUser) {

        for (User u : userList) {
            if (u.getLogin().equals(newUser.getLogin()) && u.getPassword().equals(newUser.getPassword())) {
                return "redirect:/profile/" + newUser.getLogin();
            }
        }

        return "redirect:/logIn/fail";

    }

    public void update(String login, User userToBeUpdated) {
        User user = getUser(login);
        user.setPassword(userToBeUpdated.getPassword());
    }




}
