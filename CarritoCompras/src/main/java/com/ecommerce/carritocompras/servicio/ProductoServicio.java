package com.ecommerce.carritocompras.servicio;

import com.ecommerce.carritocompras.dto.ProductoDTO;
import com.ecommerce.carritocompras.mapper.ProductoMapper;
import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.repositorio.ProductoRepositorio;
import com.ecommerce.carritocompras.usecase.ActualizarProductoUseCase;
import com.ecommerce.carritocompras.usecase.CrearProductoUseCase;
import com.ecommerce.carritocompras.usecase.EliminarProductoUseCase;
import com.ecommerce.carritocompras.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio implements ProductoServicioInterface {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoMapper productoMapper;

    @Autowired
    private CrearProductoUseCase crearProductoUseCase;

    @Autowired
    private ActualizarProductoUseCase actualizarProductoUseCase;

    @Autowired
    private EliminarProductoUseCase eliminarProductoUseCase;

    public List<ProductoDTO> obtenerTodosLosProductos() {
        List<Producto> productos = productoRepositorio.findAllActivos();
        return productoMapper.toDTOList(productos);
    }

    public ProductoDTO obtenerProductoPorId(Long id) {
        Optional<Producto> producto = productoRepositorio.findById(id);
        if (producto.isEmpty() || !producto.get().getActivo()) {
            throw new RuntimeException(Constantes.MSG_PRODUCTO_NO_ENCONTRADO);
        }
        return productoMapper.toDTO(producto.get());
    }

    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        return crearProductoUseCase.ejecutar(productoDTO);
    }

    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        return actualizarProductoUseCase.ejecutar(id, productoDTO);
    }

    public void eliminarProducto(Long id) {
        eliminarProductoUseCase.ejecutar(id);
    }

    public List<ProductoDTO> buscarProductos(String nombre) {
        List<Producto> productos = productoRepositorio.findByNombreContainingAndActivo(nombre, true);
        return productoMapper.toDTOList(productos);
    }

    public List<ProductoDTO> ordenarProductos(List<ProductoDTO> productosDTO, String campo) {
        if (productosDTO == null || productosDTO.isEmpty()) {
            return productosDTO;
        }
        
        return switch (campo.toLowerCase()) {
            case Constantes.ORDENAR_NOMBRE -> productosDTO.stream()
                    .sorted((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()))
                    .toList();
            case Constantes.ORDENAR_PRECIO -> productosDTO.stream()
                    .sorted((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()))
                    .toList();
            case Constantes.ORDENAR_PRECIO_DESC -> productosDTO.stream()
                    .sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()))
                    .toList();
            default -> productosDTO;
        };
    }

}
