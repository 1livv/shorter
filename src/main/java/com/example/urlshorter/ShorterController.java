package com.example.urlshorter;

import com.example.urlshorter.model.ShortningRequest;
import com.example.urlshorter.service.ShorterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ShorterController {

    @Autowired
    private ShorterService shorterService;

    @ResponseBody
    @RequestMapping(path = "/short", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String shorten(@RequestBody @Validated ShortningRequest shortningRequest) {
        System.out.println(shortningRequest.getUrl());
        return shorterService.shortenAndSave(shortningRequest.getUrl(), shortningRequest.getContext());
    }
}
