package com.ecommerce.carritocompras.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import com.ecommerce.carritocompras.util.Constantes;

import java.time.LocalDateTime;

public class ProductoDTO {

    private Long id;

    @NotBlank(message = Constantes.MSG_VALIDACION_NOMBRE_OBLIGATORIO)
    @Size(max = Constantes.MAX_LONGITUD_NOMBRE, message = Constantes.MSG_VALIDACION_NOMBRE_MAX)
    private String nombre;

    @Size(max = Constantes.MAX_LONGITUD_DESCRIPCION, message = Constantes.MSG_VALIDACION_DESCRIPCION_MAX)
    private String descripcion;

    @NotNull(message = Constantes.MSG_VALIDACION_PRECIO_NULO)
    @Min(value = 0, message = Constantes.MSG_VALIDACION_PRECIO_NEGATIVO)
    private Double precio;

    private Boolean activo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductoDTO() {
    }

    public ProductoDTO(Long id, String nombre, String descripcion, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

