# LABORATORIO 5
__Camilo Andrés Pichimata Cárdenas__ 

__Zuly Valentina Vargas Ramirez__

## PARTE I. - JUGANDO A SER UN CLIENTE HTTP

_2. Realizando una conexión síncrona TCP/IP a través de Telnet_

Comando :

<img src = "img/comando1Telnet.png " >

_3. Realizando consultas_

    GET /sssss/abc.html HTTP/1.0
    Host: escuelaing.edu.co    

Resultado:

<img src = "img/PrimerTelnet.png " >

Obtuvimos el error **301**, este error indica que el recurso ha sido movido permanentemente. 


_¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?_

Existen los errores 3xx los cuales son errores de redirección, le indican al ciente que los datos han sido transferidos a otra dirección y/o debe intentarlo con una nueva dirección.

Los errores 4xx indican errores que se producen por parte del cliente, como sintaxis incorrecta o datos no encontrados en la dirección indicada. 

Los errores 5xx indican errores que se producen por parte del servidor, tales como tiempo de espera excedido o errores internos entre otros. 

_4. Realizando nueva conexión a telnet_

En este punto empleamos una consola de Ubuntu para poder emplear los comandos de conteo de caracteres. 

Comando : 

    GET /html  HTTP/1.1
    Host: httpbin.org 

<img src = "img/comando2Telnet.png " >



Resultado:

<img src = "img/SegundoTelnet_2.png ">

 Obtuvimos un mensaje de éxito (200) y se nos mostró el contenido en formato html. 

_5. Contando palabras_

Se copia el contenido html obtenido con CTRL + SHIFT + C.

Se crea y pega el contenido en un archivo llamado contenido.txt

Con el comando **wc -c** se puede obtener la cantidad de caracteres del contenido del archivo contenido.txt.


<img src = "img/numeroCaracteres.png ">  

En este caso se obtuvo un total de 3743 caracteres.
  <br/><br/>

 _¿Cuál es la diferencia entre los verbos GET y POST?_

 Tanto el método GET como POST son protocolos HTPP el cual envían al servidor como petición (request) y reciben una respuesta a dicha solicitud (response). 

 El concepto **GET** permite obtener información del servidor. Es decir, traer datos que están almacenadas en el servidor, ya sea una base de datos o archivo al cliente. El concepto **POST** en cambio es enviar información desde el cliente para que sea procesada y actualice o agregue información en el servidor, como sería la carga o actualización. 

_¿Qué otros tipos de peticiones existen?_
 
 Dentro del prótocolo HTTP se encuentran otras peticiones tales como:

 - **HEAD** : La petición HEAD pide una respuesta idéntica a la de una petición GET, pero este solo retorna el encabezado sin el cuerpo de la respuesta.

 - **PUT** : La petición PUT es usado para solicitar que el servidor almacene el cuerpo de la entidad en una ubicación específica dada por el URL.

 - **DELETE** : Esta petición es utilizada para solicitar al servidor que elimine un archivo en una ubicación específica dada por la URL. Este método elimina un recurso determinado.

- **CONNECT** : Esta petición es usada para establecer una conexión de red con un servidor web mediante HTTP.

Información tomada de :

https://yosoy.dev/peticiones-http-get-post-put-delete-etc/

https://developer.mozilla.org/es/docs/Web/HTTP/Methods


_6. Probando otro comando_

Comando curl :

    curl www.httpbin.org 

<img src = "img/curl_1.png "> 
<br/><br/>

Comando curl -v:

    curl -v www.httpbin.org

<img src = "img/curl_v.png "> 
<br/><br/>

Comando curl -i:

    curl -v www.httpbin.org

<img src = "img/curl_i.png "> 
<br/><br/>

EL comando **curl -v** nos permite obtener el encabezado de la solicitud y el número de la respuesta obtenida.El modo detallado -v también hará que curl muestre todos los encabezados que envía y recibe. Permite visualizar la petición GET y el Host realizado para obtener el contenido.

El comando **curl -i** incluye el encabezado HTTP en la salida. El encabezado HTTP incluye cosas como nombre del servidor, fecha del documento, versión HTTP etc.

El comando **curl** retorna únicamente el contenido del recurso solicitado.

Información tomada de:

https://everything.curl.dev/usingcurl/verbose

https://coderwall.com/p/f3avyq/include-http-headers-in-curl-response
<br/><br/>

## PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.

___I. Cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp:___

Creamos el proyecto con el siguiente comando:

    mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp

Luego completamos los datos solicitados como se puede ver en la siguiente imagen

<img src = "img/CreacionProyectoServlet.png"> 


### **Estructura del proyecto**

<img src = "img/EstructuraProyecto.png">
<br/><br/>

_1. Revise la clase SampleServlet, e identifique qué hace:_

La clase SampleServlet que extiende a HttpServlet permite mediante el método doGet recibir una petición de usuario y dar una respuesta a este.

_4. Compile y ejecute la aplicación en el servidor embebido Tomcat_

Para compilar y ejecutar empleamos los siguientes comandos respectivamente

    mvn package 
    mvn tomcat7:run

_5. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’_

<img src = "img/5-ResultadoConsulta.png">
<br/><br/>

_6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’_

<img src = "img/6-ResultadoConsulta.png">
<br/><br/>

_15. Probando funcionalidades_

- Prueba Id existente

<img src = "img/15-IdExistente.png">
<br/><br/>

- Prueba Id no existente

<img src = "img/15-IdNoExistente.png">
<br/><br/>

- Prueba sin especificar Id

<img src = "img/15-RequerimientoInvalido.png">
<br/><br/>

- Prueba Id Iválido

<img src = "img/15-IdInvalido.png">
<br/><br/>

## PARTE III.

_18. Prueba del Formulario usando el método post_

<img src = "img/PruebaFormulario.png">
<br/><br/>

_20. Cambie el formulario para que ahora en lugar de POST, use el método GET. ¿Qué diferencia observa?_

Al realizar el cambio y probar nuevamente, el resultado es el mismo, esto se debe a que la implemetación de los 2 métodos es la mima.

_21. ¿Qué se está viendo?_

Cuando se ingresa en el espacio un valor diferente a un número válido se muestra una advertencia indicándonos que el valor ingresado no es un valor de tipo numérico. Si el valor ingresado es válido se muestran los datos solicitados como se ve a continuación:

<img src = "img/21-ConsultaValida-1.png">

<img src = "img/21-ConsultaValida-2.png">
<br/><br/>

## PARTE IV. - FRAMEWORKS WEB MVC – JAVA SERVER FACES / PRIME FACES

_3. Configuraciones agregadas_

- **javax.javaee-api:**
    De Java Enterprise Edition, Java EE en adelante, es un conjunto de estándares de tecnologías dedicadas al desarrollo de Java del lado del servidor. La plataforma Java EE consta de un conjunto de servicios, API y protocolos que proporcionan la funcionalidad necesaria para desarrollar aplicaciones basadas en web de varios niveles.

- **com.sun.faces.jsf-api y com.sun.faces.jsf-impl:**
    JavaServer Faces (JSF) es una tecnología y framework para aplicaciones Java basadas en web que simplifica el desarrollo de interfaces de usuario en aplicaciones Java EE; 

    Como objetivos se tienen proporcionar un conjunto de componentes para la interfaz de usuario, incluyendo los elementos estándares de HTML para representar un formulario; Proporcionar un modelo de JavaBeans para enviar eventos desde los controles de la interfaz de usuario del lado del cliente a la aplicación del servidor entre otros.

- **javax.servlet.jstl:**
    JSTL es un conjunto de librerías de etiquetas simples y estándares que encapsulan la funcionalidad principal que es usada comúnmente para escribir páginas JSP.

- **PrimeFaces:**
    PrimeFaces es una biblioteca de componentes para JavaServer Faces de código abierto que cuenta con un conjunto de componentes enriquecidos que facilitan la creación de las aplicaciones web.


Información tomada de:

https://www.fundesem.es/bt/publicacion-java-ee-y-el-desarrollo-web-un-enfoque-de-aprendizaje

https://es.wikipedia.org/wiki/JavaServer_Faces

http://www.inf-cr.uclm.es/www/mpolo/asig/0708/tutorJavaWebParte2.pdf

https://es.wikipedia.org/wiki/PrimeFaces
<br/><br/>


_10. Pruebas realizadas_

a. Prueba de aceptación

Realizaremos la siguiente prueba de aceptación:
**Cadena ingresada:** La cadena ingresada será la siguente: _12,14,11_

**Promedio:** Al pulsar el botón Obtener Promedio el resultado mostrado debe ser 12.333333333333334

**Deviación Estándar:** La desviación estándar que se debe mostrar despues de pulsar el botón deber ser: 1.247219128924647

**Varianza:** Finalmente al obtener la varianza pulsando en el botón el resultado a obtener es el siguiente: 1.55555555555556

Al ingresar los datos y realizar la prueba desde el navegador web Microsoft Edge obtuvimos lo siguiente:

<img src = "img/IV.10-Pruebas-a-1.png">
<br/><br/>

b. Ejecuciones desde dos navegadores:

***Navegador Microsoft Edge***

- Ejecución 1

<img src = "img/IV.10-Pruebas-b-1.png">
<br/><br/>

- Ejecución 2

<img src = "img/IV.10-Pruebas-b-2.png">
<br/><br/>

- Ejecución 3

<img src = "img/IV.10-Pruebas-b-3.png">
<br/><br/>

- Ejecución 4

<img src = "img/IV.10-Pruebas-b-4.png">
<br/><br/>

- Ejecución 5

<img src = "img/IV.10-Pruebas-b-5.png">
<br/><br/>

***Navegador Google Chrome***

<img src = "img/IV.10-Pruebas-b-6.png">
<br/><br/>

Al ingresar desde el navegador Chrome se visualizaban los datos que quedaron registrados en el navegador Edge, para eliminarlos se puede dar click en el botón Reiniciar para resetear los datos existentes.

<img src = "img/IV.10-Pruebas-b-7.png">
<br/><br/>

c. ¿Cuál es la diferencia entre los backing-beans de sesión y los de aplicación?

<img src = "img/IV.10-Pruebas-c-1.png">
<br/><br/>

Como se puede ver en la imagen al cambiar el tipo de sesión a @SessionScoped es posible realizar cáculos independentes en los dos navegadores, si recargamos uno la aplicación se inicia sin ningún dato guardado

d. Usango herramientas de desarrollador del explorador

- Elemento oculto

<img src = "img/IV.10-Pruebas-d-ElementoOculto.png">
<br/><br/>

En nuestro caso teníamos como elemento oculto el resultado del cálculo de la moda, ubicamos desde la ventana elmentos usando las herramientas de desarrollo del explorador el label y deshabilitamos la propiedad _display: none_ por lo que se puede visualizar el resultado.

- Estilos

<img src = "img/IV.10-Pruebas-d-Estilos.png">
<br/><br/>

Como se puede ver en la captura es posible personalizar los estilos de los diferentes estilos de la página, en el ejemplo se puede ver como se cambió el color de los botones

Al recargar la página los cambios realizados en el diseño desaparecen.

- Utilidades de las herramientas de desarrollador

Además de las herramientas que se vizualizaban en las capturas anteriores existen varias pestañas con diversas opciones que permiten manipular y obtener informción de la página web, incluso información de la red, en la siguiente captura se pueden visualizar las pestañas disponibles desde el navegador Microsoft Edge

<img src = "img/IV.10-Pruebas-d-Herramientas_de_Desarrollador.png">
<br/><br/>