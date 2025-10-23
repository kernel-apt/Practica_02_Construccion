package design_patterns;

import java.util.List;

/**
 * Clase que implementa un notificador que utiliza múltiples canales de notificación.
 * Implementa la interfaz ServicioNotificacion y delega la tarea de enviar notificaciones
 */
public class MultiChannelNotifier implements ServicioNotificacion
{
     private List<ServicioNotificacion> serviceNotifications;

     public MultiChannelNotifier(List<ServicioNotificacion> notificationsList) 
     {
          serviceNotifications = notificationsList;
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          System.out.println("\n ***** Enviando notificaciones por todos los canales \n");
          for (ServicioNotificacion channel : serviceNotifications) 
          {
               channel.enviarNotificacion(destinatario, mensaje);
          }
     }

     @Override
     public String obtenerServicio() 
     {
          return "Notificacion Multicanal";
     }

     public List<ServicioNotificacion> getServiceNotifications() 
     {
         return serviceNotifications;
     }
}