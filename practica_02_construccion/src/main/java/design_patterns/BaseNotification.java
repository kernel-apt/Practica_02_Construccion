package design_patterns;

public abstract class BaseNotification implements ServicioNotificacion
{
     protected ServicioNotificacion servicioNotificacion;

     public BaseNotification(ServicioNotificacion servicioNotificacion)
     {
          this.servicioNotificacion = servicioNotificacion;
     }
}