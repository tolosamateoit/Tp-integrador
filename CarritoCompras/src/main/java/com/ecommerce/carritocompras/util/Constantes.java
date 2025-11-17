package com.ecommerce.carritocompras.util;

public final class Constantes {

    private Constantes() {}

    public static final String VISTA_PRODUCTOS = "productos";
    public static final String REDIRECT_PRODUCTOS = "redirect:/productos";
    public static final String RUTA_PRODUCTOS = "/productos";
    public static final String RUTA_PRODUCTOS_CREAR = "/productos/crear";
    public static final String RUTA_PRODUCTOS_EDITAR = "/productos/editar/{id}";
    public static final String RUTA_PRODUCTOS_ACTUALIZAR = "/productos/actualizar/{id}";
    public static final String RUTA_PRODUCTOS_ELIMINAR = "/productos/eliminar/{id}";

    public static final String ATTR_PRODUCTOS = "productos";
    public static final String ATTR_PRODUCTO = "producto";
    public static final String ATTR_NUEVO_PRODUCTO = "nuevoProducto";
    public static final String ATTR_BUSCAR = "buscar";
    public static final String ATTR_BUSCANDO = "buscando";
    public static final String ATTR_ORDENAR = "ordenar";
    public static final String ATTR_EDITANDO = "editando";
    public static final String ATTR_ERROR = "error";
    public static final String ATTR_MENSAJE = "mensaje";

    public static final String ORDENAR_ID = "id";
    public static final String ORDENAR_NOMBRE = "nombre";
    public static final String ORDENAR_PRECIO = "precio";
    public static final String ORDENAR_PRECIO_DESC = "precio-desc";

    public static final String MSG_ERROR_FORMULARIO = "❌ Por favor, corrige los errores en el formulario";
    public static final String MSG_PRODUCTO_CREADO = "✅ Producto creado exitosamente";
    public static final String MSG_PRODUCTO_ACTUALIZADO = "✅ Producto actualizado exitosamente";
    public static final String MSG_PRODUCTO_ELIMINADO = "✅ Producto eliminado exitosamente";
    public static final String MSG_PRODUCTO_NO_ENCONTRADO = "❌ Producto no encontrado";
    public static final String MSG_ERROR_CREAR = "❌ Error al crear el producto: ";
    public static final String MSG_ERROR_ACTUALIZAR = "❌ Error al actualizar: ";
    public static final String MSG_ERROR_ELIMINAR = "❌ Error al eliminar: ";
    public static final String MSG_PRECIO_INVALIDO = "El precio no puede ser negativo o nulo";

    public static final String MSG_VALIDACION_NOMBRE_OBLIGATORIO = "El nombre del producto es obligatorio";
    public static final String MSG_VALIDACION_NOMBRE_MAX = "El nombre no puede exceder 255 caracteres";
    public static final String MSG_VALIDACION_DESCRIPCION_MAX = "La descripción no puede exceder 500 caracteres";
    public static final String MSG_VALIDACION_PRECIO_NULO = "El precio no puede ser nulo";
    public static final String MSG_VALIDACION_PRECIO_NEGATIVO = "El precio no puede ser negativo";

    public static final int MAX_LONGITUD_NOMBRE = 255;
    public static final int MAX_LONGITUD_DESCRIPCION = 500;
}

