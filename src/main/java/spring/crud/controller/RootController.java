package spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.crud.service.UserService;
import spring.crud.model.User;

import java.util.List;

@Controller
public class RootController {

    private final UserService userService;

    @Autowired
    public RootController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String indexPage(ModelMap model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping(value = "/user")
    public String showUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "id", defaultValue = "0") int id,
                           ModelMap model
                           ) {

        if (id != 0) {
            User findUser = userService.getById(id);
            model.addAttribute("user", findUser);
        }

        return "form";
    }

    @GetMapping(value = "/delete/")
    public String deleteUser(@RequestParam(value = "id") int id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping
    public String saveUser(
            @ModelAttribute("user") User user,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        userService.save(user);

        return "redirect:/";
    }
}
