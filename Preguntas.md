Cual es el dominio?
- OnlineShop, Producto, Catálogo, Carrito de compra, Pago, Recibo, Envío

¿Donde esta el dominio en el proyecto?
- Clase Product
- Clase ProductRepository

Identificar donde hay cohesion y donde acoplamiento.
- Hay cohesión dentro de la clase Product
- Acoplamiento dentro de la clase ProductsToChooseExplore (renombrada a ProductsChoice)

¿Tengo el dominio aislado de la infraestructura? ¿Porque si y porque no lo tengo aislado?
 No está aislado. 
- Tenemos partes del producto dentro de una clase que podría ser de presentación/infraestructura

¿Que tengo que hacer para aislarlo de la infraestructura?
- Separar las descripciones de la clase ProductsToChooseExplore, mover a ProductWarehouse
- Separar la implementación del repositorio de productos de su implementación.
- Separar mejor las clases de presentación.
