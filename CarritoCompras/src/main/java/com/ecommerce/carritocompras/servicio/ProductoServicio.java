package com.ecommerce.carritocompras.servicio;

import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositorio.findAllActivos();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        Optional<Producto> producto = productoRepositorio.findById(id);
        if (producto.isPresent() && producto.get().getActivo()) {
            return producto;
        }
        return Optional.empty();
    }

    public Producto crearProducto(Producto producto) {
        if (producto.getPrecio() == null || producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo o nulo");
        }
        producto.setActivo(true);
        producto.setCreatedAt(LocalDateTime.now());
        producto.setUpdatedAt(LocalDateTime.now());
        return productoRepositorio.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Optional<Producto> productoExistente = productoRepositorio.findById(id);
        if (productoExistente.isPresent()) {
            if (productoActualizado.getPrecio() == null || productoActualizado.getPrecio() < 0) {
                throw new IllegalArgumentException("El precio no puede ser negativo o nulo");
            }
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setUpdatedAt(LocalDateTime.now());
            return productoRepositorio.save(producto);
        }
        return null;
    }

    public boolean eliminarProducto(Long id) {
        Optional<Producto> producto = productoRepositorio.findById(id);
        if (producto.isPresent()) {
            Producto p = producto.get();
            p.setActivo(false);
            p.setUpdatedAt(LocalDateTime.now());
            productoRepositorio.save(p);
            return true;
        }
        return false;
    }

    public List<Producto> buscarProductos(String nombre) {
        return productoRepositorio.findByNombreContainingAndActivo(nombre, true);
    }
}
