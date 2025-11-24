package com.b612.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class HelloController {
    
    @GetMapping("/status")
    public String checkStatus() {
        return "B612 operando. O essencial é invisível aos olhos, mas os dados estão aqui!";
    }
    
}
