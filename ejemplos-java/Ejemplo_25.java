import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_25 {
    record Solicitud(String id, String estado) {}
    interface Repositorio { void guardar(Solicitud solicitud); }
    static final class AbrirSolicitud {
        private final Repositorio repo;
        AbrirSolicitud(Repositorio repo) { this.repo = repo; }
        Solicitud ejecutar(String id) {
            if (id.isBlank()) throw new IllegalArgumentException("Identidad requerida");
            var solicitud = new Solicitud(id, "ABIERTA");
            repo.guardar(solicitud);
            return solicitud;
        }
    }

    public static void main(String[] args) {
        var servicio = new AbrirSolicitud(s -> {});
        System.out.println(servicio.ejecutar("S1").estado());
    }
}
