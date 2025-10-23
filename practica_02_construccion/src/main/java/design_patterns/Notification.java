package design_patterns;

public class Notification implements ServicioNotificacion
{
    private String destinatary;
    private String message;

    public Notification(String destinatary, String message)
    {
        this.destinatary = destinatary;
        this.message = message;
    }

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) 
    {
        System.out.println("\n --- Se manda notificacion --- \n");
    }

    @Override
    public String obtenerServicio() 
    {
        return "Notificacion";
    }
}