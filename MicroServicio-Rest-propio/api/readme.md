# New Spring Starter project

## Microservicio api

1. H2 --> conector pruebas bbdd subsitutir por SQL
2. Spring web
3. Spring boot devTools 


## Microservicio commons " Solo tendra el modelo de datos"
1. JPA



# Creacion de datos modelo en microservicio commons

-Quitar metodo main de *Application.java, porque es un proyecto de libreria.
-Quitar el plugin de maven del pom.xml
-Crear package model para guardar los objetos mapeados a bbdd. " *models.entity"
-Creamos las entidades
-compilamos el proyecto con mvn clean install package de esta forma generara el paquete en c:..m2..
-copiamos los siguientes parametros del pom de commons
	<groupId>com.api.service.common</groupId>
	<artifactId>api-service-commons</artifactId>
	<version>0.0.1-SNAPSHOT</version>
-Los pegamos como una nueva depencencia en el proyecto api



## Creacion de los servicio "ejemplo: productos" en microservicio api

Abrimos el application.properties donde empezaremos a meter todas las propiedades de spring

Añadimos name y puerto;
spring.application.name=servicios-productos
server.port=8001

## DAO
Creamos el package *.dao para crear las interfaces
Creamos la clase interficie " new interface " y le ponemos el nombre de "ProductoDao"
Y añadimos; 
	extends CrudRepository<Producto, Long> de esta forma heredara las consultas basicas "finById, findAll..."

## SERVICE
Creamos el package *.service para crear los servicios
Creamos la clase interficie " new interface " y le ponemos el nombre de "IProductoService"
Añadimos los metodos de la interfaz;
		public List<Product> findAll();
		public Product findById (Long id);
Creamos la clase implementacion del Servicio "new Class"
Añadimos implements IProductService y añadimos los metodos de la interfaz " sugiere como error"
Añadimos en la clase IProductService la anotacion @Service y añadimos a todos los metodos de consulta;
@Transactional (readOnly = true)
El import de transactional usar el de spring

Añadimos el ProductDao
@Autowired
	private ProductDao productoDao;
	
	return (List<Product>) productoDao.findAll();
	return productoDao.findById(id).orElse(null);
	
	
## CONTROLLERS
Creamos el package *.controllers para crear los controladores
Creamos la clase controller "ProductController"
Marcamos la clase con la anotacion @RestController
Añadimos el productService;
@Autowired
	private IProductService productoService;

Añadimos los metodos con su mapping
@GetMapping("/list")
	public List<Product> list() {
		return productoService.findAll();
	}

@GetMapping("/list/{id}")
	public Product detail(@PathVariable Long id) {
		return productoService.findById(id);
	}



