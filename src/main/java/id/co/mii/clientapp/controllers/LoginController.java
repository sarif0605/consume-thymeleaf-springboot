package id.co.mii.clientapp.controllers;

import id.co.mii.clientapp.models.dto.request.LoginRequest;
import id.co.mii.clientapp.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping("/login")
    public String loginPage(LoginRequest loginRequest){
//        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest){
        if (!loginService.login(loginRequest)){
            return "redirect:/login?error=true";
        }
        return "redirect:/region";
    }

}
