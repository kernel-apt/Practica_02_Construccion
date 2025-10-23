package design_patterns;

/**
 * Clase para notificaciones encriptadas
 * @author Manuel Cruz Sanchez
 */
public class EncriptedNotification extends BaseNotification
{
     public EncriptedNotification(ServicioNotificacion servicioNotificacion) 
     {
          super(servicioNotificacion);
     }

     @Override
     public void enviarNotificacion(String destinatario, String mensaje) 
     {
          String mensajeEncriptado = "";
          int i = 0;
          
          for (i = mensaje.length() - 1; i >= 0 ; i--) 
          {
               mensajeEncriptado += mensaje.charAt(i);
          }
          
          System.out.println("\n ************** Mensaje Encriptado ************** ");
          notificationService.enviarNotificacion(destinatario, mensajeEncriptado);
          System.out.println();
     }
          
     @Override
     public String obtenerServicio() 
     {
          return notificationService.obtenerServicio() + "con encriptacion\n";
     }
}