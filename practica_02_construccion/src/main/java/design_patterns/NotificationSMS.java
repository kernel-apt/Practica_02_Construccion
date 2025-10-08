package design_patterns;

public class NotificationSMS extends BaseNotification
{
     public NotificationSMS(ServicioNotificacion servicioNotificacion) 
     {
          super(servicioNotificacion);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println
          (
               "\nNotificación por SMS enviada a: " + 
               destinatario + ".\n" + mensaje
          );
     }
          
     @Override
     public String obtenerServicio() 
     {
          return "Servicio SMS";
     }
}   