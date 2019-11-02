package org.sanchez.corcoles.ana.pruebasconcepto.producto.controller;

import org.sanchez.corcoles.ana.pruebasconcepto.commons.model.entity.Producto;
import org.sanchez.corcoles.ana.pruebasconcepto.producto.model.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        //Para simular timeout
        /*try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return producto;
    }

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productoService.deleteById(id);
    }

    @PutMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@PathVariable Long id, @RequestBody Producto producto) {
        final Producto productoAEditar = productoService.findById(id);
        if (producto.getNombre() != null) {
            productoAEditar.setNombre(producto.getNombre());
        }
        if (producto.getPrecio() != null) {
            productoAEditar.setPrecio(producto.getPrecio());
        }
        if (producto.getCreateAt() != null) {
            productoAEditar.setCreateAt(producto.getCreateAt());
        }
        return productoService.save(productoAEditar);
    }
}
