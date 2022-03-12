# Laboratorio 5 - INTRODUCCIÓN A PROYECTOS WEB - 2022-1

## PARTE I - JUGANDO A SER UN CLIENTE HTTP

2. Realizando una conexión síncrona TCP/IP a través de Telnet

Comando :

![image](https://user-images.githubusercontent.com/65261708/157998947-301d7eca-69fd-474c-98d3-792e7adda51d.png)

3. Realizando consultas

GET /sssss/abc.html HTTP/1.0

Host: escuelaing.edu.co    

Resultado: 

![image](https://user-images.githubusercontent.com/65261708/157999012-d887f709-20d4-4889-b759-ee7b0e7bc6b8.png)

Obtuvimos el error 301, este error indica que el recurso ha sido movido permanentemente.

¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?

Existen los errores 3xx los cuales son errores de redirección, le indican al ciente que los datos han sido transferidos a otra dirección y/o debe intentarlo con una nueva dirección.

Los errores 4xx indican errores que se producen por parte del cliente, como sintaxis incorrecta o datos no encontrados en la dirección indicada.

Los errores 5xx indican errores que se producen por parte del servidor, tales como tiempo de espera excedido o errores internos entre otros.

4. Realizando nueva conexión a telnet

En este punto empleamos una consola de Ubuntu para poder emplear los comandos de conteo de caracteres.

Comando :

GET /html  HTTP/1.1
Host: httpbin.org

![image](https://user-images.githubusercontent.com/65261708/157999052-8792d73d-abdc-4429-a26e-5890d0e77d03.png)

Resultado:

![image](https://user-images.githubusercontent.com/65261708/157999066-87f8089b-2675-4377-8053-2a1c1b2923bf.png)

Obtuvimos un mensaje de éxito (200) y se nos mostró el contenido en formato html.

5. Contando palabras

Se copia el contenido html obtenido con CTRL + SHIFT + C.

Se crea y pega el contenido en un archivo llamado contenido.txt

Con el comando wc -c se puede obtener la cantidad de caracteres del contenido del archivo contenido.txt.

![image](https://user-images.githubusercontent.com/65261708/157999170-751dec77-203c-4b0b-bc84-8a0cea95c387.png)

En este caso se obtuvo un total de 3743 caracteres.


¿Cuál es la diferencia entre los verbos GET y POST?

Tanto el método GET como POST son protocolos HTPP el cual envían al servidor como petición (request) y reciben una respuesta a dicha solicitud (response).

El concepto GET permite obtener información del servidor. Es decir, traer datos que están almacenadas en el servidor, ya sea una base de datos o archivo al cliente. El concepto POST en cambio es enviar información desde el cliente para que sea procesada y actualice o agregue información en el servidor, como sería la carga o actualización.

¿Qué otros tipos de peticiones existen?

Dentro del prótocolo HTTP se encuentran otras peticiones tales como:

HEAD : La petición HEAD pide una respuesta idéntica a la de una petición GET, pero este solo retorna el encabezado sin el cuerpo de la respuesta.

PUT : La petición PUT es usado para solicitar que el servidor almacene el cuerpo de la entidad en una ubicación específica dada por el URL.

DELETE : Esta petición es utilizada para solicitar al servidor que elimine un archivo en una ubicación específica dada por la URL. Este método elimina un recurso determinado.

CONNECT : Esta petición es usada para establecer una conexión de red con un servidor web mediante HTTP.

6. Probando otro comando

Comando curl :

curl www.httpbin.org 

![image](https://user-images.githubusercontent.com/65261708/157999238-f9df5baa-1f9d-4311-a11e-70eb1e8be32d.png)

Comando curl -v: 

curl -v www.httpbin.org

![image](https://user-images.githubusercontent.com/65261708/157999323-aeae0405-f959-4e31-9436-8fe98deaeab0.png)


EL comando curl -v nos permite obtener el encabezado de la solicitud y el número de la respuesta obtenida.El modo detallado -v también hará que curl muestre todos los encabezados que envía y recibe. Permite visualizar la petición GET y el Host realizado para obtener el contenido.

El comando curl -i incluye el encabezado HTTP en la salida. El encabezado HTTP incluye cosas como nombre del servidor, fecha del documento, versión HTTP etc.

El comando curl retorna únicamente el contenido del recurso solicitado.


## PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.

Para esto, cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp y realice lo siguiente:

1. Revise la clase SampleServlet incluida a continuacion, e identifique qué hace:

~~~
package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/helloServlet"
)
public class SampleServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       Optional<String> optName = Optional.ofNullable(req.getParameter("name"));
       String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

       resp.setStatus(HttpServletResponse.SC_OK);
       responseWriter.write("Hello" + name + "!");
       responseWriter.flush();
   }
}
~~~

Revise qué valor tiene el parámetro ‘urlPatterns’ de la anotación @WebServlet, pues este indica qué URLs atiende las peticiones el servlet.

2. En el pom.xml, modifique la propiedad "packaging" con el valor "war". Agregue la siguiente dependencia:
~~~
<dependency>
     <groupId>javax</groupId>
     <artifactId>javaee-web-api</artifactId>
     <version>7.0</version>
     <scope>provided</scope>
</dependency>
y agregue la seccion build al final del tag project en el archivo pom.xml:

<build>
   <plugins>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-compiler-plugin</artifactId>
           <version>3.8.0</version>
           <configuration>
               <source>1.8</source>
               <target>1.8</target>
           </configuration>
       </plugin>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-war-plugin</artifactId>
           <version>2.3</version>
           <configuration>
               <failOnMissingWebXml>false</failOnMissingWebXml>
           </configuration>
       </plugin>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-dependency-plugin</artifactId>
           <version>2.6</version>
           <executions>
               <execution>
                   <phase>validate</phase>
                   <goals>
                       <goal>copy</goal>
                   </goals>
                   <configuration>
                       <silent>true</silent>
                       <artifactItems>
                           <artifactItem>
                               <groupId>javax</groupId>
                               <artifactId>javaee-endorsed-api</artifactId>
                               <version>7.0</version>
                               <type>jar</type>
                           </artifactItem>
                       </artifactItems>
                   </configuration>
               </execution>
           </executions>
       </plugin>

       <!-- Tomcat embedded plugin. -->
       <plugin>
           <groupId>org.apache.tomcat.maven</groupId>
           <artifactId>tomcat7-maven-plugin</artifactId>
           <version>2.2</version>
           <configuration>
               <port>8080</port>
               <path>/</path>
           </configuration>
       </plugin>
   </plugins>
</build>
~~~

3. Revise en el pom.xml para qué puerto TCP/IP está configurado el servidor embebido de Tomcat (ver sección de plugins).
4. Compile y ejecute la aplicación en el servidor embebido Tomcat, a través de Maven con:
~~~
mvn package
~~~
![](Img/mvn%20package%20lab05.png)
~~~
mvn tomcat7:run
~~~
![](Img/mvn%20tomcatrun%20lab05.png)

5. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá como host ‘localhost’, como puerto, el configurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.
   
![](Img/nav%20hello%20lab05.png)

6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando un parámetro GET (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).

![](Img/nav%20hello%20world%20lab05.png)
7. Busque el artefacto gson en el repositorio de maven y agregue la dependencia.

~~~
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.9.0</version>
</dependency>
~~~
8. En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del path de la url.

![](Img/Json%20lab05.png)

9. Basado en la respuesta que le da el servicio del punto anterior, cree la clase edu.eci.cvds.servlet.model.Todo con un constructor vacío y los métodos getter y setter para las propiedades de los "To Dos" que se encuentran en la url indicada.

![image](https://user-images.githubusercontent.com/65261708/158000217-6065c886-b4a1-4845-8910-2690768054de.png)

10. Utilice la siguiente clase para consumir el servicio que se encuentra en la dirección url del punto anterior:

![image](https://user-images.githubusercontent.com/65261708/158000308-3eb93db8-ff36-4d43-985f-13698cedd998.png)

11. Cree una clase que herede de la clase HttpServlet (similar a SampleServlet), y para la misma sobrescriba el método heredado doGet. Incluya la anotación @Override para verificar –en tiempo de compilación- que efectivamente se esté sobreescribiendo un método de las superclases.


