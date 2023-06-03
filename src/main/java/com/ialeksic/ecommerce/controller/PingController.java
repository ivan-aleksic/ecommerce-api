package com.ialeksic.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/ping")
public class PingController {
    @RequestMapping("")
    public String ping() {
        return "pong";
    }
}
