package de.basedefender.youtube.api.controller;

import de.basedefender.youtube.domain.HttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    @GetMapping("/{searchterm}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public String search(@PathVariable String searchterm) {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }

}
