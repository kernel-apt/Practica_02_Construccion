package design_patterns;

/**
 * Clase implementa la decoracion de notificaciones prioritarias
 */
public class PrioritaryNotification extends BaseNotification
{
     public PrioritaryNotification(Notification notification) 
     {
          super(notification);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println("\n---------> Enviando notificación proritaria <----------");
          
          notificationService.enviarNotificacion(destinatario, "[URGENTE] " + mensaje);

          System.out.println("------------------------ proritaria ------------------------ \n");
     }
          
     @Override
     public String obtenerServicio() 
     {
          return notificationService.obtenerServicio() + " prioritaria\n ";
     }
}