import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_44 {
    record Evento(String id, BigDecimal monto) {}
    static final class Proyeccion {
        private final Set<String> vistos = new HashSet<>();
        private BigDecimal total = BigDecimal.ZERO;
        void aplicar(Evento evento) {
            if (vistos.add(evento.id())) total = total.add(evento.monto());
        }
        BigDecimal total() { return total; }
    }

    public static void main(String[] args) {
        var log = List.of(new Evento("E1", new BigDecimal("10")), new Evento("E2", new BigDecimal("20")));
        var actual = new Proyeccion(); log.forEach(actual::aplicar);
        var reconstruida = new Proyeccion(); log.forEach(reconstruida::aplicar);
        System.out.println(actual.total().equals(reconstruida.total()));
    }
}
