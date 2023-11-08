package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import javax.persistence.PersistenceContext;
import java.util.Map;

@Controller
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Todo: Добавить слой сервис - прослойка между репозиторием и контроллером
    @GetMapping("/index")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "Ann") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "index";
    }

    @GetMapping()
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "users";
    }

    @GetMapping("Users")
    public String UserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
}
