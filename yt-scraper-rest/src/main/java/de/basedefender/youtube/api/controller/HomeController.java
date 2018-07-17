package de.basedefender.youtube.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HomeController {

    @GetMapping({"", "/"})
    public String redirect() {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping("/channels/")
    public String redirectChannels() {
        return "redirect://channels";
    }

}
