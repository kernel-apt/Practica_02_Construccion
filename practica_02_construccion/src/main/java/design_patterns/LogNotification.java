package design_patterns;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase implementa la decoracion de notificaciones con log
 */
public class LogNotification extends BaseNotification
{
     public LogNotification(ServicioNotificacion servicioNotificacion) 
     {
          super(servicioNotificacion);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println("\n---------> Enviando notificación con log <----------");
          System.out.println("\n------------------------ Log ------------------------ ");
          
          servicioNotificacion.enviarNotificacion(destinatario, mensaje);
          
          System.out.println
          (
               // "\nFecha: " + fecha +  
               "\nHora: " + LocalDate.now().format(DateTimeFormatter.ofPattern("HH:mm:ss a"))
          );

          System.out.println("------------------------ Log ------------------------ \n");
     }
          
     @Override
     public String obtenerServicio() 
     {
          return "Notificación con Log";
     }
}