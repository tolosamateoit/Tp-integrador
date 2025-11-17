package com.ecommerce.carritocompras.mapper;

import com.ecommerce.carritocompras.dto.ProductoDTO;
import com.ecommerce.carritocompras.modelo.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoMapper {

    public ProductoDTO toDTO(Producto producto) {
        if (producto == null) {
            return null;
        }
        
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setActivo(producto.getActivo());
        dto.setCreatedAt(producto.getCreatedAt());
        dto.setUpdatedAt(producto.getUpdatedAt());
        return dto;
    }

    public Producto toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        if (dto.getActivo() != null) {
            producto.setActivo(dto.getActivo());
        }
        return producto;
    }

    public List<ProductoDTO> toDTOList(List<Producto> productos) {
        if (productos == null) {
            return null;
        }
        return productos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

