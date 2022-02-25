/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Cliente;
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
    private ClienteService clienteService;
    
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
        
        var clientesDB = clienteService.getClientes();
        model.addAttribute("clientesDB", clientesDB);    
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/modificarCliente/{idcliente}")
    public String modificarCliente(Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idcliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
