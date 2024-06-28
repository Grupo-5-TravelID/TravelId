package com.eoi.grupo5.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InicioCtrl {

    @GetMapping
    public String inicio() {
        return "index";
    }
}
