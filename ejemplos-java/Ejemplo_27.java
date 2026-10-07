import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_27 {
    record Evento(String id, int version, String solicitud) {}
    interface Publicador { void publicar(Evento evento); }
    static final class BusLocal implements Publicador {
        private final List<Consumer<Evento>> consumidores = new ArrayList<>();
        void suscribir(Consumer<Evento> consumidor) { consumidores.add(consumidor); }
        public void publicar(Evento evento) {
            for (var consumidor : List.copyOf(consumidores)) consumidor.accept(evento);
        }
    }

    public static void main(String[] args) {
        var bus = new BusLocal();
        bus.suscribir(e -> System.out.println(e.solicitud()));
        bus.publicar(new Evento("E1", 1, "S1"));
    }
}
