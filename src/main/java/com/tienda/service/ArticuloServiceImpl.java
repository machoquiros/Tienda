
package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
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
public class ArticuloServiceImpl implements ArticuloService {
    
    @Autowired
    private ArticuloDao articuloDao;
    
    @Override
    @Transactional (readOnly = true) //Para manejar transacciones de lectura
    public List<Articulo> getArticulos(boolean activos) {
        var lista =(List<Articulo>)articuloDao.findAll();
        
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional //Para manejar transacciones de escritura y lecura
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional //Para manejar transacciones de escritura y lecura
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    @Transactional (readOnly = true) //Para manejar transacciones de lectura
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    
}
