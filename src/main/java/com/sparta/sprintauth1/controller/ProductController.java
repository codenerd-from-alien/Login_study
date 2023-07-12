package com.sparta.sprintauth1.controller;
import com.sparta.sprintauth1.dto.ProductRequestDto;
import com.sparta.sprintauth1.entity.User;
import com.sparta.sprintauth1.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        User user = userDetails.getUser();
        System.out.println("user.getUsername() = " + user.getUsername());
        return "redirect:/";
    }


}