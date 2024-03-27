package com.tiago.greeter.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeter")
public class GreetingResource {

    @GetMapping
    public String greeting(@RequestParam(required = false) String name) {
        return "Hello, World!".concat(name != null ? " " + name : "");
    }


}