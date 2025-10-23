package design_patterns;

public class PackageManager
{
     private MultiChannelNotifier multiChannelNotifier;
     private ServicioNotificacion notificationService;

     public PackageManager(MultiChannelNotifier multiChannelNotifier, ServicioNotificacion notificationService) 
     {
          this.multiChannelNotifier = multiChannelNotifier;
         this.notificationService = notificationService;
     }
     
     public PackageManager(ServicioNotificacion notificationService) 
     {
         this.notificationService = notificationService;
     }

     public void confirmarPedido(String cliente, String detalles) 
     {
          notificationService.enviarNotificacion
          (
               "\n Hola " + cliente, "!  Tu pedido ha sido confirmado: " + detalles
          );
     }
     
     public void asignarRepartidor(String repartidor, String direccion) 
     {
          notificationService.enviarNotificacion
          (
               "Hola " + repartidor, " te informo que se te ha asignado un\n "+
               "pedido asignado para entrega en: \n" + direccion
          );
     }

     public void notificarEntrega(String cliente)
     {
          notificationService.enviarNotificacion
          (
               "Hola " + cliente, "Tu pedido ha sido entregado."
          );
     }

     public MultiChannelNotifier getMultiChannelNotifier() 
     {
          return multiChannelNotifier;
     }
}