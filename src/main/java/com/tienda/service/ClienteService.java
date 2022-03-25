
package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface ClienteService {
    
    public List<Cliente> getClientes();
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
    
    public Cliente getCliente(Cliente cliente);
    
    public List<Cliente> findByCorreo(String correo);
    
    public Cliente findByNombreAndApellidos(String nombre, String apellidos);
}
