package com.ecommerce.carritocompras.controlador;

import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public String listarProductos(Model model, @RequestParam(value = "buscar", required = false) String buscar) {
        if (buscar != null && !buscar.isEmpty()) {
            model.addAttribute("productos", productoServicio.buscarProductos(buscar));
            model.addAttribute("buscar", buscar);
            model.addAttribute("buscando", true);
        } else {
            model.addAttribute("productos", productoServicio.obtenerTodosLosProductos());
            model.addAttribute("buscando", false);
        }
        model.addAttribute("nuevoProducto", new Producto());
        return "productos";
    }

    @PostMapping("/productos/crear")
    public String crearProducto(Producto producto, RedirectAttributes redirectAttributes) {
        try {
            productoServicio.crearProducto(producto);
            redirectAttributes.addFlashAttribute("mensaje", "✅ Producto creado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "❌ Error al crear el producto: " + e.getMessage());
        }
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editarFormulario(@PathVariable Long id, Model model) {
        var producto = productoServicio.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            model.addAttribute("productos", productoServicio.obtenerTodosLosProductos());
            model.addAttribute("nuevoProducto", new Producto());
            model.addAttribute("editando", true);
            return "productos";
        }
        return "redirect:/productos";
    }

    @PostMapping("/productos/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, Producto productoActualizado, RedirectAttributes redirectAttributes) {
        try {
            Producto actualizado = productoServicio.actualizarProducto(id, productoActualizado);
            if (actualizado != null) {
                redirectAttributes.addFlashAttribute("mensaje", "✅ Producto actualizado exitosamente");
            } else {
                redirectAttributes.addFlashAttribute("error", "❌ Producto no encontrado");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "❌ Error al actualizar: " + e.getMessage());
        }
        return "redirect:/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            if (productoServicio.eliminarProducto(id)) {
                redirectAttributes.addFlashAttribute("mensaje", "✅ Producto eliminado exitosamente");
            } else {
                redirectAttributes.addFlashAttribute("error", "❌ Producto no encontrado");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "❌ Error al eliminar: " + e.getMessage());
        }
        return "redirect:/productos";
    }
}
