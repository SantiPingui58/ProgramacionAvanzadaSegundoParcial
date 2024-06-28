# TP Final Programación Avanzada: Ecommerce Supermercado

Suponga que debe crear distintas clases Java para describir los productos que vende un supermercado. Todo producto tiene un ID autoincremental que se genera al darlo de alta en la tienda, nombre, una descripción, precio y país de importación.

## Clases

#### Clase [Detergente](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/models/Detergente.java)
Define una botella de detergente (debe tener en cuenta que este producto puede tener descuento).

Sus propiedades principales serán:
- Marca (String)
- Incluya otras propiedades según sea necesario a la hora de implementar las interfaces.

#### Clase [Cereales](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/models/Cereales.java)
Define el producto caja de cereales (Este producto no tiene descuentos).

Las propiedades del producto serán:
- Marca
- [Tipo de cereal](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/enums/TipoCereales.java)
- Programe los métodos de las interfaces implementadas (Si es necesario añada más propiedades a la clase).

A tener en cuenta: 
- Las calorías serán las siguientes: 5 si el cereal es espelta, 8 si es maíz, 12 si es trigo, y 15 en los demás casos.

#### Clase [Vino](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/models/Vino.java)
Esta clase describirá el producto botella de vino (Este producto es susceptible de tener descuento).

El producto tendrá como propiedades:
- Marca
- Tipo de vino
- Grados de alcohol
- Programe también los métodos set, get, toString y los métodos de las interfaces. Añada nuevas propiedades si es necesario.

A tener en cuenta: 
- Las calorías se calcularán multiplicando por 10 la graduación alcohólica.

## Interfaces

#### Interfaz [EsLiquido](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/interfaces/EsLiquido.java)
Esta interfaz indica que los objetos creados a partir de la clase serán líquidos, y tendrá los siguientes métodos:
```java
public void setVolumen(double v);
public double getVolumen();
public void setTipoEnvase(String env);
public String getTipoEnvase();
```

#### Interfaz [EsAlimento](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/interfaces/EsAlimento.java)
Esta interfaz indica que los objetos creados a partir de la clase serán alimentos, y tendrá
los siguientes métodos:
```java
public void setCaducidad(LocalDate fc);
public LocalDate getCaducidad();
public int getCalorias();
```

#### Interfaz [ConDescuento](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/interfaces/ConDescuento.java)
Esta interfaz indicará que el producto tiene descuento e incluirá los siguientes
métodos:
```java
public void setDescuento(double des);
public double getDescuento();
public double getPrecioDescuento();
```

# Instrucciones:

Para la resolución de este ejercicio podrá implementar el uso de todos temas que hemos visto, hasta las collections (pueden escoger el usar la colección que quieran). Es decir, se debe implementar el uso de patrones de diseño, palabras `static`, `final` y manejo de excepciones.

El programa debe contar con un menú recursivo con las siguientes operaciones:

1. **Precarga de productos:** El programa debe tener un método llamado [`precargarDatos()`](https://github.com/SantiPingui58/ProgramacionAvanzadaTP/blob/df3c5f3db584557a14b2119760ba6d2c3d4eea7f/src/core/Supermercado.java#L38) con el cual se cargarán de forma automática 15 productos en el arreglo.

2. **Búsqueda:** Nos permitirá buscar un producto para conocer sus datos, siempre que se encuentre en el arreglo. Se deberá ingresar el ID o el nombre del producto.

3. **Eliminación:** Podemos contemplar la eliminación de un producto de la lista siempre que se encuentre disponible.

4. **Mostrar un listado con todos los productos de nuestro supermercado.**

5. **Mostrar la cantidad de productos en el supermercado, ingresando el nombre del mismo.**

6. **Ordenamiento:** Se debe mostrar un submenú donde se pueda ordenar por:
    a. Nombre
    b. Descripción
    c. Precio
    d. Producto con mayor descuento

7. **Modificación de un producto:** Pudiendo modificar cualquiera de sus atributos.

8. **Mostrar datos de los productos que son alimentos.**

9. **Producto cuyo precio con descuento sea el más bajo.**


