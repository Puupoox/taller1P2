package modelo.Interfaces;

public interface Notificable {
    void notificar(String mensaje);
    String obtenerContacto();
    boolean aceptarNotificaciones();

}
