
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;
    
    @Override
    @Transactional (readOnly = true) //Para manejar transacciones de lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional //Para manejar transacciones de escritura y lecura
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional //Para manejar transacciones de escritura y lecura
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly = true) //Para manejar transacciones de lectura
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    public List<Cliente> findByCorreo(String correo) {
        return clienteDao.findByCorreo(correo);
    }

    @Override
    public Cliente findByNombreAndApellidos(String nombre, String apellidos) {
        return clienteDao.findByNombreAndApellidos(nombre, apellidos);
    }
    
    
}
