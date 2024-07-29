import org.example.EmailCliente;
import org.example.NotificadorEmail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
//public class NotificadorEmailTest {
@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    private NotificadorEmailTest() {
    }

    public static NotificadorEmailTest createNotificadorEcmailTest() {
        return new NotificadorEmailTest();
    }


    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    // Test para verificar que no se envía correo con dirección vacía
    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "Mensaje");


        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", null);

        // Verificar que se maneja adecuadamente un mensaje nulo
        // Esto puede variar según la implementación deseada
        // TODO: Implementa la lógica de verificación según tu lógica de negocio
    }


}
