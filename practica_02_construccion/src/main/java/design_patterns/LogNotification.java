package design_patterns;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Clase implementa la decoracion de notificaciones con log
 */
public class LogNotification extends BaseNotification
{
     public LogNotification(ServicioNotificacion notification) 
     {
          super(notification);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println("\n---------> Se activa notificación con log <----------");
          System.out.println("\n------------------------ Log ------------------------ ");
          
          notificationService.enviarNotificacion(destinatario, mensaje);
          
          System.out.println
          (
               "\nHora de envio: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss a"))
          );

          System.out.println("------------------------ Log ------------------------ \n");
     }
          
     @Override
     public String obtenerServicio() 
     {
          return notificationService.obtenerServicio() + " con Log";
     }
}