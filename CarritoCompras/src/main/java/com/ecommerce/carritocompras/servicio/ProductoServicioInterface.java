package com.ecommerce.carritocompras.servicio;

import com.ecommerce.carritocompras.dto.ProductoDTO;
import java.util.List;

public interface ProductoServicioInterface {

    List<ProductoDTO> obtenerTodosLosProductos();

    ProductoDTO obtenerProductoPorId(Long id);

    ProductoDTO crearProducto(ProductoDTO productoDTO);

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);

    void eliminarProducto(Long id);

    List<ProductoDTO> buscarProductos(String nombre);

    List<ProductoDTO> ordenarProductos(List<ProductoDTO> productosDTO, String campo);
}
