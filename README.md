### Escuela Colombiana de Ingeniería
### Arquitectura Empresarial - AREP
#  TALLER DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET

Nombre: Camilo Murcia Espinosa


### Objetivo:
El objetivo de este taller es escribir un servidor web que soporte múltiples solicitudes. El servidor debe leer los archivos del disco local y retornar todos los archivos solicitados, incluyendo páginas html, archivos java script, css e imágenes. A su vez, una aplicación web con javascript, css, e imágenes para probar el servidor. Incluya en la aplicación la comunicación asíncrona con servicios REST en el backend. NO se usarán frameworks web como Spark o Spring, únicamente Java y las librerías para manejo de la red.
## Instalación y Ejecución

Primero, debes instalar Git y Maven en tu equipo. Luego, clona el repositorio desde la terminal utilizando el siguiente comando:
```
git clone https://github.com/CamiloMurcia28/AREP-Taller01.git
``` 
Después, accede a la carpeta generada y ejecuta los siguientes comandos de Maven:
```
mvn clean install
```
Finalmente, ejecuta el servidor con el siguiente comando:
```
java -cp target/classes escuelaing.edu.co.arep.AREP
```
Para interactuar con la aplicación web, abre un navegador e ingresa a la dirección: localhost:8080//appointments.html.

Arquitectura
El sistema sigue la arquitectura Cliente-Servidor, donde un servidor aloja todos los recursos y los clientes acceden a ellos mediante solicitudes. Estas solicitudes son atendidas por los servicios REST del Backend.

Evaluación
Además de realizar pruebas unitarias en las clases que contienen la lógica de negocio, también se realizaron pruebas de usuario para verificar el correcto funcionamiento de la aplicación.