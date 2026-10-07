import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_37 {
    interface Descubrimiento { List<URI> resolver(String servicio); }
    static final class Registro implements Descubrimiento {
        private final Map<String, List<URI>> instancias;
        Registro(Map<String, List<URI>> instancias) { this.instancias = Map.copyOf(instancias); }
        public List<URI> resolver(String servicio) {
            return List.copyOf(instancias.getOrDefault(servicio, List.of()));
        }
    }

    public static void main(String[] args) {
        Descubrimiento discovery = new Registro(Map.of("clientes", List.of(URI.create("https://clientes.internal"))));
        System.out.println(discovery.resolver("clientes").size());
    }
}
