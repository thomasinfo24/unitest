package org.example;

public interface EmailCliente {
     default void enviarCorreo(String direccion, String mensaje) {

    }
}
