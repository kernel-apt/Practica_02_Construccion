package design_patterns;

public class GestorPedidos
{
     private ServicioNotificacion servicio;

     public GestorPedidos(ServicioNotificacion servicio) 
     {
         this.servicio = servicio;
     }

     public void confirmarPedido(String cliente, String detalles) 
     {
          servicio.enviarNotificacion(cliente, "Tu pedido ha sido confirmado: " + detalles);
     }
     
     public void asignarRepartidor(String repartidor, String direccion) 
     {
          servicio.enviarNotificacion(repartidor, "pedido asignado para entrega en: \n" + direccion);
     }

     public void notificarEntrega(String cliente) 
     {
          servicio.enviarNotificacion(cliente, "Tu pedido ha sido entregado.");
     }
}