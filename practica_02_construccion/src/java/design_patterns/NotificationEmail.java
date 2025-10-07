package design_patterns;

public class NotificationEmail extends BaseNotification
{
     public NotificationEmail(ServicioNotificacion servicioNotificacion) 
     {
          super(servicioNotificacion);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println
          (
               "\nNotificación por email enviada a: " + 
               destinatario + ".\n" + mensaje
          );
     }
          
     @Override
     public String obtenerServicio() 
     {
          return "Email";
     }
}