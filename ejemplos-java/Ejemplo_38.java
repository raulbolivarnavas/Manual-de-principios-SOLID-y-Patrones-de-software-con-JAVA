import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_38 {
    interface Selector { URI elegir(); }
    static final class RoundRobin implements Selector {
        private final List<URI> instancias;
        private final AtomicInteger turno = new AtomicInteger();
        RoundRobin(List<URI> instancias) {
            if (instancias.isEmpty()) throw new IllegalArgumentException("Sin instancias");
            this.instancias = List.copyOf(instancias);
        }
        public URI elegir() {
            return instancias.get(Math.floorMod(turno.getAndIncrement(), instancias.size()));
        }
    }

    public static void main(String[] args) {
        Selector selector = new RoundRobin(List.of(URI.create("https://a.internal"), URI.create("https://b.internal")));
        System.out.println(selector.elegir()); System.out.println(selector.elegir());
    }
}
