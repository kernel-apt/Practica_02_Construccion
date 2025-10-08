package design_patterns;

import java.util.List;

/**
 * Clase que implementa un notificador que utiliza múltiples canales de notificación.
 * Implementa la interfaz ServicioNotificacion y delega la tarea de enviar  notificaciones
 */
public class MultiChannelNotifier implements ServicioNotificacion
{
     private List<ServicioNotificacion> notificationChannels;

     public MultiChannelNotifier(List<ServicioNotificacion> servicioNotificacion) 
     {
          this.notificationChannels = servicioNotificacion;
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          for (ServicioNotificacion channel : notificationChannels) 
          {
               channel.enviarNotificacion(destinatario, mensaje);
          }
     }

     @Override
     public String obtenerServicio() 
     {
          return "Notificacion Multicanal";
     }
}