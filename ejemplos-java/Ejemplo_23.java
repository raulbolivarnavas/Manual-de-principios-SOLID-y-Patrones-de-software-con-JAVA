import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_23 {
    record ClienteFila(String id, String nombre) {}
    interface ClienteDao { Optional<ClienteFila> seleccionar(String id); }
    static final class MemoriaDao implements ClienteDao {
        private final Map<String, ClienteFila> filas;
        MemoriaDao(Map<String, ClienteFila> filas) { this.filas = Map.copyOf(filas); }
        public Optional<ClienteFila> seleccionar(String id) {
            return Optional.ofNullable(filas.get(id));
        }
    }

    public static void main(String[] args) {
        ClienteDao dao = new MemoriaDao(Map.of("1", new ClienteFila("1", "Ana")));
        System.out.println(dao.seleccionar("1").orElseThrow().nombre());
    }
}
