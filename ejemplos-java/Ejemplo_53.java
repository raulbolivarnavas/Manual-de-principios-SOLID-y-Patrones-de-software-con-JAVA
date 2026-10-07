import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_53 {
    record Configuracion(URI endpoint, Duration timeout) {
        Configuracion {
            Objects.requireNonNull(endpoint); Objects.requireNonNull(timeout);
            if (!"https".equals(endpoint.getScheme()) || timeout.isNegative() || timeout.isZero())
                throw new IllegalArgumentException("Configuración inválida");
        }
    }
    static final class Cliente {
        private final Configuracion configuracion;
        Cliente(Configuracion configuracion) { this.configuracion = configuracion; }
        long timeoutMillis() { return configuracion.timeout().toMillis(); }
    }

    public static void main(String[] args) {
        var cfg = new Configuracion(URI.create("https://api.example.com"), Duration.ofSeconds(2));
        System.out.println(new Cliente(cfg).timeoutMillis());
    }
}
