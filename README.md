## WorkShop
### Sistema de acceso web con Chain of Responsibility

Este proyecto demuestra la implementación del patrón Chain of Responsibility en Java. Se trata de un sistema de autenticación y autorización para una aplicación en línea, donde las solicitudes se procesan de manera secuencial a través de diferentes manejadores (handlers).

### Estructura del Proyecto

<ul>
<li>AbstractHandler: Clase base abstracta para todos los manejadores.</li>
<li>ConcreteHandlerInvalid: Maneja las solicitudes con fallos repetidos y bloquea las IP después de múltiples intentos fallidos.</li>
<li>ConcreteHandlerUsuario: Maneja las solicitudes de usuarios normales.</li>
<li>ConcreteHandlerAdmin: Maneja las solicitudes de administradores.</li>
<li>ConcreteHandlerCache: Maneja el historial de inicio de sesión.</li>
<li>SistemaORdenes: Es el Handler Final, que da acceso al sistema de ordenes.</li>
<li>GeneradorIp: Genera una ip random.</li>
<li>SolicitudLogin: Clase que representa la solicitud de autenticación con usuario, contraseña, tipo de usuario.</li>
<li>Cliente: Clase principal que configura y ejecuta la cadena de responsabilidad.</li>
</ul>

### Diagrama UML

<span>![</span><span>Diagrama UML</span><span>]</span><span>(</span><span>https://raw.githubusercontent.com/SantiagoGZ1/WorkShopAccesoWeb/master/img/Workshop2.drawio.png</span><span>)</span>
