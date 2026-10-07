import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_15 {
    interface Validacion { boolean valida(String id); }
    interface Notificacion { void enviar(String id); }
    static final class Mediador {
        private final Validacion validacion;
        private final Notificacion notificacion;
        Mediador(Validacion v, Notificacion n) { validacion = v; notificacion = n; }
        void presentar(String id) {
            if (validacion.valida(id)) notificacion.enviar(id);
        }
    }

    public static void main(String[] args) {
        var mediador = new Mediador(id -> !id.isBlank(), System.out::println);
        mediador.presentar("S1");
    }
}
