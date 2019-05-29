package com.example.urlshorter;

import com.example.urlshorter.service.ShorterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

    @Autowired
    private ShorterService shorterService;

    @RequestMapping(path = "/{key:.+}", method = RequestMethod.GET)
    public RedirectView redirect(@PathVariable String key) {
        String originalUrl = shorterService.elongate(key);
        return new RedirectView(originalUrl);
    }
}
