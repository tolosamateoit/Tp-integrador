package com.ecommerce.carritocompras.usecase;

import com.ecommerce.carritocompras.dto.ProductoDTO;
import com.ecommerce.carritocompras.mapper.ProductoMapper;
import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.repositorio.ProductoRepositorio;
import com.ecommerce.carritocompras.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CrearProductoUseCase {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoMapper productoMapper;

    @Transactional
    public ProductoDTO ejecutar(ProductoDTO productoDTO) {
        validarPrecio(productoDTO.getPrecio());
        Producto producto = productoMapper.toEntity(productoDTO);
        producto.setActivo(true);
        Producto productoGuardado = productoRepositorio.save(producto);
        return productoMapper.toDTO(productoGuardado);
    }

    private void validarPrecio(Double precio) {
        if (precio == null || precio < 0) {
            throw new RuntimeException(Constantes.MSG_PRECIO_INVALIDO);
        }
    }
}

