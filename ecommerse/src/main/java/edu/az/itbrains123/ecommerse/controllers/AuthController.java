package edu.az.itbrains123.ecommerse.controllers;

import edu.az.itbrains123.ecommerse.dtos.user.UserRegisterDto;
import edu.az.itbrains123.ecommerse.sevices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String register( UserRegisterDto userRegisterDto) {
        boolean result = userService.register(userRegisterDto);
        if (result) {
            return "redirect:login";
        }
        return "redirect:register";
    }
}
