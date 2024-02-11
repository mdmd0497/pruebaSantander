package com.pruebasantander.dockerized.postgresql.producto;

import com.pruebasantander.dockerized.postgresql.producto.Producto;
import com.pruebasantander.dockerized.postgresql.producto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private static final Logger LOGGER = Logger.getLogger(ProductoController.class.getName());

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> {
                    LOGGER.log(Level.SEVERE, "Producto no encontrado con id: " + id);
                    return new RuntimeException("Producto no encontrado con id: " + id);
                });
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoToUpdate = productoRepository.findById(id)
                .orElseThrow(() -> {
                    LOGGER.log(Level.SEVERE, "Producto no encontrado con id: " + id);
                    return new RuntimeException("Producto no encontrado con id: " + id);
                });

        productoToUpdate.setNombre(producto.getNombre());
        productoToUpdate.setPrecio(producto.getPrecio());
        return productoRepository.save(productoToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}