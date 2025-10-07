package design_patterns;

import java.util.List;

/**
 * Clase que implementa un notificador que utiliza múltiples canales de notificación.
 * Esta clase extiende de BaseNotification y utiliza el patrón Decorator para
 * agregar funcionalidad adicional a un servicio de notificación existente.
 */
public class MultiChannelNotifier extends BaseNotification
{
     private List<ServicioNotificacion> notificationChannels;

     public MultiChannelNotifier(ServicioNotificacion servicioNotificacion) 
     {
          super(servicioNotificacion);
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
          return "MultiChannelNotifier";
     }
}