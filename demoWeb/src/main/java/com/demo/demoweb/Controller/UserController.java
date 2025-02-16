package com.demo.demoweb.Controller;

import com.demo.demoweb.dto.UserDTO;
import com.demo.demoweb.repository.UserRepository;
import com.demo.demoweb.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/user/")
    public String findAll(Model model) {
        List<UserDTO> userDTOList = userService.findAll();
        model.addAttribute("userList", userDTOList);
        return "list";
    }

    @GetMapping("/user/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/user/save")
    public String save(@ModelAttribute UserDTO userDTO){
        System.out.println("UserController.save");
        System.out.println("userDTO = "+userDTO);
        userService.save(userDTO);

        return "testrealmain";
    }

    @GetMapping("/user/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/user/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session){
        UserDTO loginResult = userService.login(userDTO);
        if(loginResult != null){
            session.setAttribute("loginResult", loginResult.getUserEmail());
            return "main";
        }else {
            return "login";
        }
    }

    @GetMapping("/user/{userId}")
    public String findById(@PathVariable Long userId, Model model){
        UserDTO userDTO = userService.findByUserId(userId);
        model.addAttribute("user", userDTO);
        return "detail";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteById(@PathVariable Long userId){
        userService.deleteByUserId(userId);
        return "redirect:/user/login";
    }
}
