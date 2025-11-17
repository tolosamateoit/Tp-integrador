package com.ecommerce.carritocompras.usecase;

import com.ecommerce.carritocompras.dto.ProductoDTO;
import com.ecommerce.carritocompras.mapper.ProductoMapper;
import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.repositorio.ProductoRepositorio;
import com.ecommerce.carritocompras.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class ActualizarProductoUseCase {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoMapper productoMapper;

    @Transactional
    public ProductoDTO ejecutar(Long id, ProductoDTO productoDTO) {
        Optional<Producto> productoExistente = productoRepositorio.findById(id);
        if (productoExistente.isEmpty()) {
            throw new RuntimeException(Constantes.MSG_PRODUCTO_NO_ENCONTRADO);
        }

        validarPrecio(productoDTO.getPrecio());

        Producto producto = productoExistente.get();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());

        Producto productoActualizado = productoRepositorio.save(producto);
        return productoMapper.toDTO(productoActualizado);
    }

    private void validarPrecio(Double precio) {
        if (precio == null || precio < 0) {
            throw new RuntimeException(Constantes.MSG_PRECIO_INVALIDO);
        }
    }
}

