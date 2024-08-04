# Configuraciones Despliegue Back

## Conexiones a BD

### Conexión en Local

spring.datasource.url=jdbc:mysql://localhost:3307/pruebaw

spring.datasource.username=root

spring.datasource.password=prueba1234

### Conexion en remoto

spring.datasource.url=jdbc:mysql://sql10.freemysqlhosting.net/sql10723768

spring.datasource.username=sql10723768

spring.datasource.password=s5u4kRLqmu

## Descargar la Imagen de Docker de la Base de Datos

Puedes descargar la imagen de Docker desde el siguiente enlace:

https://hub.docker.com/r/victor1902/pruebaw

comando: docker pull victor1902/pruebaw

## Comando para Iniciar Base de Datos en Local

docker run --name pruebaw2 -e MYSQL_ROOT_PASSWORD=prueba1234 -p 3307:3306 -d victor1902/pruebaw:tag
