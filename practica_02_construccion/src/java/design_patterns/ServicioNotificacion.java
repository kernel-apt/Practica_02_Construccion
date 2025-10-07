package design_patterns;

public interface ServicioNotificacion 
{
     /**
      * Envía una notificación al destinatario 
      * con el mensaje especificado.
      * @param destinatario
      * @param mensaje
      */
     void enviarNotificacion(String destinatario, String mensaje);

     /**
      * Regresa el nombre del servicio de notificación.
      * @return
      */
     String obtenerServicio();
}