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
        System.out.println("\n --- Enviando Notificacion --- ");
        System.out.println("\n --- Para: " + destinatario);
        System.out.println("\n --- Mensaje: " + mensaje);
    }

    @Override
    public String obtenerServicio() 
    {
        return "Notificacion";
    }
}