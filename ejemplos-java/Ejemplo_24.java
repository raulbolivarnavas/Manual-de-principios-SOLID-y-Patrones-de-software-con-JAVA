import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_24 {
    record Solicitud(String id, String estado) {}
    interface Solicitudes {
        Optional<Solicitud> porId(String id);
        void guardar(Solicitud solicitud);
    }
    static final class Memoria implements Solicitudes {
        private final Map<String, Solicitud> datos = new HashMap<>();
        public Optional<Solicitud> porId(String id) { return Optional.ofNullable(datos.get(id)); }
        public void guardar(Solicitud solicitud) { datos.put(solicitud.id(), solicitud); }
    }

    public static void main(String[] args) {
        Solicitudes repo = new Memoria();
        repo.guardar(new Solicitud("S1", "ABIERTA"));
        System.out.println(repo.porId("S1").orElseThrow().estado());
    }
}
