# Spring

## Librerias 
### Librerias Spring
* spring-core
* spring-context
* spring-beans
* spring-aop
* spring-web
* spring-webmvc
* spring-expression

##Conexion a base de datos

### Librerias para conexion

* mysql-connector-java
* spring-jdbc
* commons-dbcp

### Creacion de un bean dentro del archivo de configuracion spring

1. Crear un bean de id Datasource que apunte a la clase *org.apache.commons.dbcp.BasicDataSource*
2. Anadir las propiedades:
	* driverClassName : debe especificar el nombre del driver que voy a usar.
	* url: (jdbc:database://localhost:puerto_db/nombre:base_datos) Url de conexion.
	* username: Usuario de base de datos
	* password: password de la base de datos
	
> Es recomendable reiniciar el IDE si este no detecta la clase org.apache.commons.dbcp.BasicDataSource

> Revisar que no existan espacios en blanco

## Interaccion con la Base de Datos

### Crea la interfaz y clase DAO

Se crea una interfaz en donde se especifique los metodos que debe implementar las clases que lo implemente. La clase que implementa la interfaz, debe tener las propiedades para interactuar con la base de datos. Ademas esta clase debe tener antes de la clase la anotacion `@Component("nombreDao")`

### Proceso de guardado
1. Se declara una variable apuntando al archivo de configuracion spring spring.config.xml

```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.config.xml");
```
2. Se hace una referencia a la clase dao por medio de spring.

```java
AdministratorDao adminDao = (AdministratorDao) applicationContext.getBean("administratorDao");
```
3.  Ejecutar la funcion de la case Dao que se requiera.

## Control de errores
* CannotGetJdbcConnectionException: Controla los problemas que puede sucitarse con la conexion.
* DataAccesException:  Controla los problemas que puede sucitarse con el acceso a datos.

## Patrones de disenio 
### DAO Data Access Object
Objeto o una interfaz que permite cceso a la base de datos o algun metodo de persistencia.

```java
public interface AdminDao{
 public boolean save(Admin admin);
}
```

```java
@Component
public class AdminDao Implements AdminDao{
	//Operaciones sobre la B.D
	@Override
	public void save(Admin admin){
		//Salvar la base de datos
	}
}
```
 
 