package design_patterns;

import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;

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
      
          List<ServicioNotificacion> notificacions = FXCollections.observableArrayList(notificacion);
          
          MultiChannelNotifier multiChannelNotifier =  new MultiChannelNotifier(notificacions);
          
          PackageManager packageManager = new PackageManager(multiChannelNotifier, notificacion);

          packageManager.asignarRepartidor("Pepito picapas", "Sillycon Valley, California, United States");
          packageManager.confirmarPedido("Manuel Cruz Sanchez", "Tu pedido ha sido confirmado y está en camino");
          packageManager.notificarEntrega("Manuel Cruz Sanchez");

          packageManager.getMultiChannelNotifier().enviarNotificacion
          (
               "Manuel Cruz Sanchez", 
               "Este es un mensaje de notificación por múltiples canales."
          );
          
     }
}