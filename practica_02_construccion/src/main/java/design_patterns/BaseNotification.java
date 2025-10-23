package design_patterns;

public abstract class BaseNotification implements ServicioNotificacion
{
     protected ServicioNotificacion servicioNotificacion;

     public BaseNotification()
     {
          this.servicioNotificacion = notification;
     }
}