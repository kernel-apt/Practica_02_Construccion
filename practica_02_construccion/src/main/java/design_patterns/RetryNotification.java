package design_patterns;

import javax.management.Notification;

/**
 * Añade funcionalidad de reintento a las notificaciones.
 */
public class RetryNotification extends BaseNotification
{
     public RetryNotification(Notification notification) 
     {
          super(notification);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          boolean exito = false;
          int intentoActual = 0;
          int maxIntentos = 3;

          while (intentoActual < maxIntentos && !exito) 
          {
               try 
               {
                    servicioNotificacion.enviarNotificacion(destinatario, mensaje);
                    exito = true;
               } 
               catch (Exception e) 
               {
                    intentoActual++;
                    System.out.println("Intento " + intentoActual + " fallido. Reintentando...");
                    if (intentoActual == maxIntentos) 
                    {
                         System.out.println("Todos los intentos fallaron. No se pudo enviar la notificación.");
                    }
               }
          }
     }
          
     @Override
     public String obtenerServicio() 
     {
          return servicioNotificacion.obtenerServicio() + " con reintentos";
     }
}