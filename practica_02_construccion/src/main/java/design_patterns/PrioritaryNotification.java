package design_patterns;

/**
 * Clase implementa la decoracion de notificaciones prioritarias
 */
public class PrioritaryNotification extends BaseNotification
{
     public PrioritaryNotification(ServicioNotificacion servicioNotificacion) 
     {
          super(servicioNotificacion);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println("\n---------> Enviando notificación proritaria <----------");
          
          servicioNotificacion.enviarNotificacion(destinatario, "[URGENTE] " + mensaje);

          System.out.println("------------------------ proritaria ------------------------ \n");
     }
          
     @Override
     public String obtenerServicio() 
     {
          return "Notificación prioritaria vía " + servicioNotificacion.obtenerServicio();
     }
}