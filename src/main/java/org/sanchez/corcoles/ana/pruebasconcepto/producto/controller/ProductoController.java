package org.sanchez.corcoles.ana.pruebasconcepto.producto.controller;

import org.sanchez.corcoles.ana.pruebasconcepto.producto.model.entity.Producto;
import org.sanchez.corcoles.ana.pruebasconcepto.producto.model.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/productos")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(p -> {
            p.setPort(port);
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/productos/{id}")
    public Producto ver(@PathVariable Long id) {
        final Producto producto = productoService.findById(id);
        producto.setPort(port);
        /*try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return producto;
    }
}
