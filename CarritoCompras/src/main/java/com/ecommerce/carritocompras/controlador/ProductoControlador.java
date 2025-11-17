package com.ecommerce.carritocompras.controlador;

import com.ecommerce.carritocompras.dto.ProductoDTO;
import com.ecommerce.carritocompras.servicio.ProductoServicioInterface;
import com.ecommerce.carritocompras.util.Constantes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicioInterface productoServicio;

    @GetMapping(Constantes.RUTA_PRODUCTOS)
    public String listarProductos(
            Model model, 
            @RequestParam(value = "buscar", required = false) String buscar,
            @RequestParam(value = "ordenar", required = false, defaultValue = "id") String ordenar) {
        
        List<ProductoDTO> productos;
        
        if (buscar != null && !buscar.isEmpty()) {
            productos = productoServicio.buscarProductos(buscar);
            model.addAttribute(Constantes.ATTR_BUSCAR, buscar);
            model.addAttribute(Constantes.ATTR_BUSCANDO, true);
        } else {
            productos = productoServicio.obtenerTodosLosProductos();
            model.addAttribute(Constantes.ATTR_BUSCANDO, false);
        }
        
        productos = productoServicio.ordenarProductos(productos, ordenar);
        
        model.addAttribute(Constantes.ATTR_PRODUCTOS, productos);
        model.addAttribute(Constantes.ATTR_ORDENAR, ordenar);
        model.addAttribute(Constantes.ATTR_NUEVO_PRODUCTO, new ProductoDTO());
        return Constantes.VISTA_PRODUCTOS;
    }

    @PostMapping(Constantes.RUTA_PRODUCTOS_CREAR)
    public String crearProducto(
            @Valid ProductoDTO productoDTO, 
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute(Constantes.ATTR_PRODUCTOS, productoServicio.obtenerTodosLosProductos());
            model.addAttribute(Constantes.ATTR_NUEVO_PRODUCTO, productoDTO);
            model.addAttribute(Constantes.ATTR_ERROR, Constantes.MSG_ERROR_FORMULARIO);
            return Constantes.VISTA_PRODUCTOS;
        }
        
        productoServicio.crearProducto(productoDTO);
        redirectAttributes.addFlashAttribute(Constantes.ATTR_MENSAJE, Constantes.MSG_PRODUCTO_CREADO);
        return Constantes.REDIRECT_PRODUCTOS;
    }

    @GetMapping(Constantes.RUTA_PRODUCTOS_EDITAR)
    public String editarFormulario(@PathVariable Long id, Model model) {
        ProductoDTO producto = productoServicio.obtenerProductoPorId(id);
        model.addAttribute(Constantes.ATTR_PRODUCTO, producto);
        model.addAttribute(Constantes.ATTR_PRODUCTOS, productoServicio.obtenerTodosLosProductos());
        model.addAttribute(Constantes.ATTR_NUEVO_PRODUCTO, new ProductoDTO());
        model.addAttribute(Constantes.ATTR_EDITANDO, true);
        return Constantes.VISTA_PRODUCTOS;
    }

    @PostMapping(Constantes.RUTA_PRODUCTOS_ACTUALIZAR)
    public String actualizarProducto(
            @PathVariable Long id, 
            @Valid ProductoDTO productoDTO,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute(Constantes.ATTR_PRODUCTO, productoDTO);
            model.addAttribute(Constantes.ATTR_PRODUCTOS, productoServicio.obtenerTodosLosProductos());
            model.addAttribute(Constantes.ATTR_NUEVO_PRODUCTO, new ProductoDTO());
            model.addAttribute(Constantes.ATTR_EDITANDO, true);
            model.addAttribute(Constantes.ATTR_ERROR, Constantes.MSG_ERROR_FORMULARIO);
            return Constantes.VISTA_PRODUCTOS;
        }
        
        productoServicio.actualizarProducto(id, productoDTO);
        redirectAttributes.addFlashAttribute(Constantes.ATTR_MENSAJE, Constantes.MSG_PRODUCTO_ACTUALIZADO);
        return Constantes.REDIRECT_PRODUCTOS;
    }

    @GetMapping(Constantes.RUTA_PRODUCTOS_ELIMINAR)
    public String eliminarProducto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productoServicio.eliminarProducto(id);
        redirectAttributes.addFlashAttribute(Constantes.ATTR_MENSAJE, Constantes.MSG_PRODUCTO_ELIMINADO);
        return Constantes.REDIRECT_PRODUCTOS;
    }
}
