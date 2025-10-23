package design_patterns;

public abstract class BaseNotification implements ServicioNotificacion
{
     protected ServicioNotificacion notificationService;

     public BaseNotification(ServicioNotificacion notificationService)
     {
          this.notificationService = notificationService;
     }
}