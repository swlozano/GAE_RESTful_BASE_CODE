# Codigo de Ejemplo para crear Servicios Web RESTful con Google App Engine
Codigo base para crear servicios Web RESTful con JAVA usando google App Engine.

## Que necesitas:

1. Cuenta de GMAIL.(Requeriada para despligue)
2. IDE Eclipse. https://eclipse.org/ide/
3. El plugin de Eclipse para Google App Engine. https://developers.google.com/eclipse/docs/download

Descarga el proyecto o si usas github puedes hacer un fork y clonar el proyecto.
Importa el proyecto descargado a Eclipse. 

Notaras que el proyecto marca un error en la carpeta war, se debe a que para trabajar servicios web RESTful en google App Engine es necesario borrar la libreria asm-4.jar y reemplazarla por la libreria asm-3.1, este cambio es absolutamente necesario para que nuestro proyecto funcione  como un servicio Web RESTful. Este error lo marca el plugin de GAE mas no el compilador, asi que no tendras problemas de despliegue.

Del lado de JAVA solo tenemos una carpeta *gae.rest.test* que contiene la clase TestServices.java y es nuestra clase servicio.
Para cambiar el nombre de los paquetes solo debes refactorizar, y hacer el cambio en la carpera war en el archivo web.xml y cambiar el valor del parametro gae.rest.test por el nombre del paquete que ingresante en la refactorizacion, no es necesario hacerlo para todos los paquetes, solo para aquellos paquetes que contienen los servicios.

Dentro del archivo web.xml encontraras la etiqueta <servlet-mapping> y esta contiene el parametro <url-pattern> y como valor tiene /api/*
el cual indica que para accer a tus servicios deberaras anteponer el prefijo api, asi localhost:8888/api/tus_servicios o puedes presindir del prefijo asi /* para que sea mas transparente.

Si tienes paquetes con multiples servicios debes duplicar todo el elemento <servlet> y  modificar el valor del <servlet-name> por uno nuevo y configurar el nombre del paquete como se explica arriba. Tambien deberas duplicar el  <servlet-mapping> y cambiar el <servlet-name> por el que agregaste dentro de <servlet>, el parametro de la etiqueta <url-pattern> puedes conservarlo tal como esta o cambiarlo como te explique.

Ejeuta el proyecto, en muchos casos aparece un error, y se debe porque elimine la libreria asm-4.jar, ignorar y seguir con el despliegue, ejecutar el proyecto no deberia tardar mas de 15 segundos en entorno local. Accede al servicio con la url especificada localhost:8888/api/test.

Keep coding and print("Hola mundo!")
