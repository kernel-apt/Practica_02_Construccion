package design_patterns;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

@DisplayName("Design Pattern Tests")
public class DesignPatternTest {
    
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("Main method should not throw exceptions")
    void testMain() {
        assertDoesNotThrow(() -> DesignPattern.main(new String[]{}));
    }
    
    @Test
    @DisplayName("Notification basic functionality")
    void testNotification() {
        Notification notification = new Notification("user@test.com", "Test message");
        
        notification.enviarNotificacion("user@test.com", "Test message");
        assertEquals("Notificacion", notification.obtenerServicio());
        
        String output = outputStream.toString();
        assertTrue(output.contains("Enviando Notificacion"));
        assertTrue(output.contains("user@test.com"));
        assertTrue(output.contains("Test message"));
    }
    
    @Test
    @DisplayName("NotificationEmail functionality")
    void testNotificationEmail() {
        Notification baseNotification = new Notification("user@test.com", "Test");
        NotificationEmail emailNotification = new NotificationEmail(baseNotification);
        
        emailNotification.enviarNotificacion("user@test.com", "Email test");
        assertEquals("Email", emailNotification.obtenerServicio());
        
        String output = outputStream.toString();
        assertTrue(output.contains("Notificación por email enviada a: user@test.com"));
        assertTrue(output.contains("Email test"));
    }
    
    @Test
    @DisplayName("NotificationSMS functionality")
    void testNotificationSMS() {
        Notification baseNotification = new Notification("+1234567890", "SMS Test");
        NotificationSMS smsNotification = new NotificationSMS(baseNotification);
        
        smsNotification.enviarNotificacion("+1234567890", "SMS test message");
        assertEquals("Servicio SMS", smsNotification.obtenerServicio());
        
        String output = outputStream.toString();
        assertTrue(output.contains("Notificación por SMS enviada a: +1234567890"));
        assertTrue(output.contains("SMS test message"));
    }
    
    @Test
    @DisplayName("NotificationPush functionality")
    void testNotificationPush() {
        Notification baseNotification = new Notification("device123", "Push Test");
        NotificationPush pushNotification = new NotificationPush(baseNotification);
        
        pushNotification.enviarNotificacion("device123", "Push test message");
        assertEquals("Notificación Push", pushNotification.obtenerServicio());
        
        String output = outputStream.toString();
        assertTrue(output.contains("Notificación Push enviada a: device123"));
        assertTrue(output.contains("Push test message"));
    }
    
    @Test
    @DisplayName("EncriptedNotification functionality")
    void testEncriptedNotification() {
        Notification baseNotification = new Notification("user@test.com", "Hello");
        EncriptedNotification encryptedNotification = new EncriptedNotification(baseNotification);
        
        encryptedNotification.enviarNotificacion("user@test.com", "Hello");
        assertTrue(encryptedNotification.obtenerServicio().contains("con encriptacion"));
        
        String output = outputStream.toString();
        assertTrue(output.contains("Mensaje Encriptado"));
        assertTrue(output.contains("olleH")); // "Hello" reversed
    }
    
    @Test
    @DisplayName("LogNotification functionality")
    void testLogNotification() {
        Notification baseNotification = new Notification("user@test.com", "Log Test");
        LogNotification logNotification = new LogNotification(baseNotification);
        
        logNotification.enviarNotificacion("user@test.com", "Log test message");
        assertTrue(logNotification.obtenerServicio().contains("con Log"));
        
        String output = outputStream.toString();
        assertTrue(output.contains("Se activa notificación con log"));
        assertTrue(output.contains("Log"));
    }
    
    @Test
    @DisplayName("PrioritaryNotification functionality")
    void testPrioritaryNotification() {
        Notification baseNotification = new Notification("user@test.com", "Priority Test");
        PrioritaryNotification priorityNotification = new PrioritaryNotification(baseNotification);
        
        priorityNotification.enviarNotificacion("user@test.com", "Priority message");
        assertTrue(priorityNotification.obtenerServicio().contains("prioritaria"));
        
        String output = outputStream.toString();
        assertTrue(output.contains("Enviando notificación proritaria"));
        assertTrue(output.contains("[URGENTE] Priority message"));
    }
    
    @Test
    @DisplayName("RetryNotification functionality")
    void testRetryNotification() {
        Notification baseNotification = new Notification("user@test.com", "Retry Test");
        RetryNotification retryNotification = new RetryNotification(baseNotification);
        
        retryNotification.enviarNotificacion("user@test.com", "Retry message");
        assertTrue(retryNotification.obtenerServicio().contains("con reintentos"));
        
        String output = outputStream.toString();
        assertTrue(output.contains("Retry message"));
    }
    
    @Test
    @DisplayName("MultiChannelNotifier functionality")
    void testMultiChannelNotifier() {
        Notification notification1 = new Notification("user1@test.com", "Test1");
        Notification notification2 = new Notification("user2@test.com", "Test2");
        List<ServicioNotificacion> services = Arrays.asList(notification1, notification2);
        
        MultiChannelNotifier multiChannel = new MultiChannelNotifier(services);
        
        multiChannel.enviarNotificacion("user@test.com", "Multi-channel test");
        assertEquals("Notificacion Multicanal", multiChannel.obtenerServicio());
        assertEquals(services, multiChannel.getServiceNotifications());
        
        String output = outputStream.toString();
        assertTrue(output.contains("Enviando notificaciones por todos los canales"));
    }
    
    @Test
    @DisplayName("PackageManager with single service")
    void testPackageManagerSingleService() {
        Notification notification = new Notification("client@test.com", "Package info");
        PackageManager packageManager = new PackageManager(notification);
        
        packageManager.confirmarPedido("John", "Pizza order");
        packageManager.asignarRepartidor("Driver1", "123 Main St");
        packageManager.notificarEntrega("John");
        
        String output = outputStream.toString();
        assertTrue(output.contains("John"));
        assertTrue(output.contains("Pizza order"));
        assertTrue(output.contains("Driver1"));
        assertTrue(output.contains("123 Main St"));
        assertTrue(output.contains("entregado"));
    }
    
    @Test
    @DisplayName("PackageManager with MultiChannelNotifier")
    void testPackageManagerMultiChannel() {
        Notification notification1 = new Notification("email@test.com", "Email");
        Notification notification2 = new Notification("+1234567890", "SMS");
        List<ServicioNotificacion> services = Arrays.asList(notification1, notification2);
        MultiChannelNotifier multiChannel = new MultiChannelNotifier(services);
        
        PackageManager packageManager = new PackageManager(multiChannel, multiChannel);
        
        packageManager.confirmarPedido("Alice", "Book order");
        assertNotNull(packageManager.getMultiChannelNotifier());
        
        String output = outputStream.toString();
        String output = outputStream.toString();
        assertTrue(output.contains("Alice"));
        assertTrue(output.contains("Book order"));
    }
    
    @Test
    @DisplayName("Decorator pattern chaining")
    void testDecoratorChaining() {
        Notification baseNotification = new Notification("user@test.com", "Base message");
        LogNotification logNotification = new LogNotification(baseNotification);
        EncriptedNotification encryptedNotification = new EncriptedNotification(logNotification);
        
        encryptedNotification.enviarNotificacion("user@test.com", "Chained message");
        
        String output = outputStream.toString();
        assertTrue(output.contains("Mensaje Encriptado"));
        assertTrue(output.contains("Se activa notificación con log"));
        assertTrue(output.contains("egassem deniahC")); // "Chained message" reversed
    }
    
    @Test
    @DisplayName("ServicioNotificacion interface contract")
    void testServicioNotificacionInterface() {
        ServicioNotificacion notification = new Notification("test@test.com", "Interface test");
        
        assertDoesNotThrow(() -> notification.enviarNotificacion("test@test.com", "Test message"));
        assertNotNull(notification.obtenerServicio());
        assertFalse(notification.obtenerServicio().isEmpty());
    }
    
    @Test
    @DisplayName("BaseNotification abstract class")
    void testBaseNotificationSubclasses() {
        Notification baseService = new Notification("test@test.com", "Base test");
        
        NotificationEmail email = new NotificationEmail(baseService);
        NotificationSMS sms = new NotificationSMS(baseService);
        NotificationPush push = new NotificationPush(baseService);
        EncriptedNotification encrypted = new EncriptedNotification(baseService);
        LogNotification log = new LogNotification(baseService);
        PrioritaryNotification priority = new PrioritaryNotification(baseService);
        RetryNotification retry = new RetryNotification(baseService);
        
        assertTrue(email instanceof ServicioNotificacion);
        assertTrue(sms instanceof ServicioNotificacion);
        assertTrue(push instanceof ServicioNotificacion);
        assertTrue(encrypted instanceof ServicioNotificacion);
        assertTrue(log instanceof ServicioNotificacion);
        assertTrue(priority instanceof ServicioNotificacion);
        assertTrue(retry instanceof ServicioNotificacion);
    }
    
    @Test
    @DisplayName("Null parameter handling")
    void testNullParameterHandling() {
        Notification notification = new Notification("test@test.com", "Test message");
        
        assertDoesNotThrow(() -> notification.enviarNotificacion(null, "message"));
        assertDoesNotThrow(() -> notification.enviarNotificacion("recipient", null));
        assertDoesNotThrow(() -> notification.enviarNotificacion(null, null));
    }
    
    @Test
    @DisplayName("Empty string parameter handling")
    void testEmptyStringParameters() {
        Notification notification = new Notification("", "");
        
        assertDoesNotThrow(() -> notification.enviarNotificacion("", ""));
        assertNotNull(notification.obtenerServicio());
    }
}