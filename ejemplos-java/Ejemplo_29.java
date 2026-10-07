import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_29 {
    record Vista(String id, String estado) {}
    interface Comandos { void abrir(String id); }
    interface Consultas { Optional<Vista> consultar(String id); }
    static final class Modelo implements Comandos, Consultas {
        private final Map<String, String> estados = new HashMap<>();
        public void abrir(String id) {
            if (estados.putIfAbsent(id, "ABIERTA") != null)
                throw new IllegalStateException("Ya existe");
        }
        public Optional<Vista> consultar(String id) {
            return Optional.ofNullable(estados.get(id)).map(e -> new Vista(id, e));
        }
    }

    public static void main(String[] args) {
        var modelo = new Modelo();
        Comandos comandos = modelo; Consultas consultas = modelo;
        comandos.abrir("S1");
        System.out.println(consultas.consultar("S1").orElseThrow().estado());
    }
}
