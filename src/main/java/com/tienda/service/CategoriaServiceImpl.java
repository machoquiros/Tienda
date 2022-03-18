
package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Michael
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional (readOnly = true) //Para manejar transacciones de lectura
    public List<Categoria> getCategorias(boolean activos) {
        var lista =(List<Categoria>)categoriaDao.findAll();
        
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional //Para manejar transacciones de escritura y lecura
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional //Para manejar transacciones de escritura y lecura
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional (readOnly = true) //Para manejar transacciones de lectura
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
}
