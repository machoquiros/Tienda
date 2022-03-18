/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ArticuloService;
import com.tienda.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author Michael
 */
@Controller

public class IndexController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        
        return "index";
    }
}
