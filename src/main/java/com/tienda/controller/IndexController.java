/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Michael
 */
@Controller

public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @RequestMapping("/")
    public String inicio(Model model) {
        
        var mensaje = "Mensaje desde el controllador";
        model.addAttribute("TextoSaludo", mensaje);

        Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenesbl@gmail.com", "8820-2655");
        model.addAttribute(cliente);

        Cliente cliente2 = new Cliente("Juan", "Rojas Perez", "jrojas@gmail.com", "8877-4466");
        var clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes", clientes);
        
        //clienteDao.save(cliente2);
        
        var clientesDB = clienteDao.findAll();
        model.addAttribute("clientesDB", clientesDB);    
        
        return "index";
    }
    
}
