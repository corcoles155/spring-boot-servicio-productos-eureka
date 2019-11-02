package org.sanchez.corcoles.ana.pruebasconcepto.producto.model.service;

import org.sanchez.corcoles.ana.pruebasconcepto.producto.model.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();

    Producto findById(Long id);

    Producto save(Producto producto);

    void deleteById(Long id);
}
