package design_patterns;

public class NotificationPush extends BaseNotification
{
     public NotificationPush(ServicioNotificacion servicioNotificacion) 
     {
          super(servicioNotificacion);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println
          (
               "\nNotificación Push enviada a: " + 
               destinatario + ".\n" + mensaje
          );
     }
          
     @Override
     public String obtenerServicio() 
     {
          return "Notificación Push";
     }
}