package design_patterns;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/**
 * Clase implementa la decoracion de notificaciones con log
 */
public class LogNotification extends BaseNotification
{
     public LogNotification(Notification notification) 
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
               "\nHora de envio: " + LocalDate.now().format(DateTimeFormatter.ofPattern("HH:mm:ss a"))
          );

          System.out.println("------------------------ Log ------------------------ \n");
     }
          
     @Override
     public String obtenerServicio() 
     {
          return "Notificación con Log";
     }
}