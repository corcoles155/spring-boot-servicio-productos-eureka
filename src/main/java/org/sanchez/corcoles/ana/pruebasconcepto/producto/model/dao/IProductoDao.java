package org.sanchez.corcoles.ana.pruebasconcepto.producto.model.dao;

import org.sanchez.corcoles.ana.pruebasconcepto.commons.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {
}
