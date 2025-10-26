package design_patterns;

public class DesignPattern 
{
     public static void main(String[] args) 
     {
          ServicioNotificacion notificacion = new Notification("Manuel Cruz Sanchez","Notificación Simple");
          
          NotificationEmail emailNotification = new NotificationEmail(notificacion);
          emailNotification.enviarNotificacion("Manuel Cruz Sanchez", "Este es un mensaje de notificación por email.");

          NotificationPush pushNotification = new NotificationPush(notificacion);
          pushNotification.enviarNotificacion("Manuel Cruz Sanchez", "Este es un mensaje de notificación push.");

          NotificationSMS smsNotification = new NotificationSMS(notificacion);
          smsNotification.enviarNotificacion("Manuel Cruz Sanchez", "Este es un mensaje de notificación por SMS.");

          EncriptedNotification encriptedNotification = new EncriptedNotification(notificacion);
          encriptedNotification.enviarNotificacion("Manuel Cruz Sanchez", "Este es un mensaje de notificación encriptada.");

          LogNotification logNotification = new LogNotification(notificacion);
          logNotification.enviarNotificacion("Manuel Cruz Sanchez", "Este es un mensaje de notificación con log.");

          RetryNotification retryNotification = new RetryNotification(notificacion);
          retryNotification.enviarNotificacion("Manuel Cruz Sanchez", "Este es un mensaje de notificación con reintentos.");

          PrioritaryNotification prioritaryNotification = new PrioritaryNotification(notificacion);
          prioritaryNotification.enviarNotificacion("Manuel Cruz Sanchez", "Este es un mensaje de notificación prioritaria.");

           
     }
}