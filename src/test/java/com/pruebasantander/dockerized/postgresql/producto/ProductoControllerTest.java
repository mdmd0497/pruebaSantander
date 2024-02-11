package com.pruebasantander.dockerized.postgresql.producto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductoControllerTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoController productoController;

    @Test
    public void testGetAllProductos() {
        // Given
        List<Producto> productos = Arrays.asList(
                new Producto( "Producto 1", 10.0),
                new Producto("Producto 2", 20.0)
        );
        when(productoRepository.findAll()).thenReturn(productos);

        // When
        List<Producto> actualProductos = productoController.getAllProductos();

        // Then
        assertEquals(productos, actualProductos);
    }

}
