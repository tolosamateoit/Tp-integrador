package com.ecommerce.carritocompras.usecase;

import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.repositorio.ProductoRepositorio;
import com.ecommerce.carritocompras.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class EliminarProductoUseCase {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Transactional
    public void ejecutar(Long id) {
        Optional<Producto> producto = productoRepositorio.findById(id);
        if (producto.isEmpty()) {
            throw new RuntimeException(Constantes.MSG_PRODUCTO_NO_ENCONTRADO);
        }

        Producto p = producto.get();
        p.setActivo(false);
        productoRepositorio.save(p);
    }
}

