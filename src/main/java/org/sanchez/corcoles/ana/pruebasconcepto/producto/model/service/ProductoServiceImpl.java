package org.sanchez.corcoles.ana.pruebasconcepto.producto.model.service;

import org.sanchez.corcoles.ana.pruebasconcepto.producto.model.dao.IProductoDao;
import org.sanchez.corcoles.ana.pruebasconcepto.producto.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return (Producto) productoDao.findById(id).get();
    }
}
