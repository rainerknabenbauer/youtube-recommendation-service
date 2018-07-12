package de.basedefender.youtube.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/"})
    public String redirect() {
        return "redirect:/swagger-ui.html";
    }

}
