# pruebaSantander

**Prueba Java Banco Santander**

**Instrucciones para ejecutar la aplicación:**

1. Asegúrese de tener Docker instalado y funcionando.
2. Clone el repositorio de GitHub.
3. Cambie al directorio del proyecto.
4. ejecutar el siguiente comando para crear una imagen jar y no hayan problemas al ejecutar docker

```
./mvnw clean package -DskipTests
```
5. luego crear la imagen necesaria para el proyecto
```
docker-compose build java_app
```
7. Ejecute el siguiente comando para construir las imágenes de Docker y ejecutar la aplicación:
```
docker-compose up
```
5. La aplicación estará disponible en la URL http://localhost:8080.


**Metodos para probar Endpoints

Probar el método createProducto en Postman
Para probar el método createProducto en Postman, puedes seguir estos pasos:

1. Crear una nueva solicitud en Postman:

Selecciona el método POST en el menú desplegable.
Introduce la URL de la API: http://localhost:8080/productos (o la URL que corresponda a tu entorno).
```
http://localhost:8080/productos
```
2. Configurar la solicitud:

Selecciona la pestaña Body.
Selecciona la opción raw.
Selecciona el tipo de contenido JSON.
Introduce el siguiente JSON en el cuerpo de la solicitud:
JSON
{
  "nombre": "Producto nuevo",
  "precio": 15.0
}

GET 
Obtener todos
```

http://localhost:8080/productos
```
Find byid
```

http://localhost:8080/productos/{id}
```


**Explicación del código fuente y actividad:**

- El modelo `Producto` representa la entidad "Producto" con los campos `id`, `nombre` y `precio`.
- El repositorio `ProductoRepository` proporciona acceso a la base de datos para la entidad `Producto`.
- El controlador `ProductoController` expone un API REST para realizar operaciones CRUD en los productos.
- El archivo `Dockerfile` define la imagen de Docker para la aplicación Spring Boot.
- El archivo `docker-compose.yml` define dos servicios: la aplicación Spring Boot y una base de datos PostgreSQL.
- La clase `DatabaseConfig` configura la conexión a la base de datos.
- La clase `ProductoControllerTest` contiene una prueba unitaria para el método `getAllProductos` del controlador `ProductoController`.
