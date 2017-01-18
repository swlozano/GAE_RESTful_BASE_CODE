# Código de Ejemplo para crear Servicios Web RESTful con Google App Engine
Código base para crear servicios Web RESTful con JAVA usando google App Engine.


## Qué necesitas:


1. Cuenta de GMAIL.(Requerida para despliegue)
2. IDE Eclipse. https://eclipse.org/ide/
3. El plugin de Eclipse para Google App Engine. https://developers.google.com/eclipse/docs/download


Descarga el proyecto, si usas github puedes hacer un fork y clonar el proyecto.
Importar el proyecto descargado a Eclipse. 


Notarás que el proyecto marca un error en la carpeta war, debido a que para trabajar servicios web RESTful en google App Engine es necesario borrar la librería `asm-4.jar` y reemplazarla por la librería `asm-3.1`, este cambio es absolutamente necesario para que nuestro proyecto funcione  como un servicio Web RESTful. Este error lo marca el plugin de GAE y no el compilador, así que no tendrás problemas de despliegue.

Del lado de JAVA solo tenemos una carpeta `gae.rest.test` que contiene la clase `TestServices.java` y es nuestra clase servicio.
Para cambiar el nombre de los paquetes solo debes refactorizar, y hacer el cambio en la carpeta war en el archivo `web.xml` y cambiar el valor del parámetro `gae.rest.test` por el nombre del paquete que ingresaste en la refactorización, no es necesario hacerlo para todos los paquetes, solo para aquellos paquetes que contienen los servicios.


Dentro del archivo `web.xml` encontrarás la etiqueta `<servlet-mapping>` y esta contiene el parámetro `<url-pattern>` y como valor tiene: `/api/*` el cual indica que para acceder a tus servicios deberás anteponer el prefijo api, así `localhost:8888/api/tus_servicios` o puedes prescindir del prefijo así: `/*` para que sea más transparente.

Si tienes paquetes con múltiples servicios debes duplicar todo el elemento `<servlet>` y  modificar el valor del `<servlet-name>` por uno nuevo y configurar el nombre del paquete como se explica arriba. También deberás duplicar el  `<servlet-mapping>` y cambiar el `<servlet-name>` por el que agregaste dentro de `<servlet>`, el parámetro de la etiqueta `<url-pattern>` puedes conservarlo tal como está o cambiarlo como expliqué arriba. [Ejemplo de múltiples servicios en diferentes paquetes](/web.xml). 

Ejecuta el proyecto, en muchos casos aparece un error, y se debe porque elimine la librería **asm-4.jar**, ignorar y seguir con el despliegue, ejecutar el proyecto no debería tardar más de 15 segundos en entorno local. Accede al servicio con la url especificada `localhost:8888/api/test`, como respuesta el servicio retorna un html content-type.

**Keep coding and print("Hola mundo!")**

tw: @swlozano
