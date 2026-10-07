import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_04 {
    interface Observador { void recibir(String evento); }
    static final class Solicitudes {
        private final List<Observador> observadores = new ArrayList<>();
        void suscribir(Observador o) { observadores.add(o); }
        void retirar(Observador o) { observadores.remove(o); }
        void aprobar() {
            for (var o : List.copyOf(observadores)) o.recibir("APROBADA");
        }
    }

    public static void main(String[] args) {
        var sujeto = new Solicitudes();
        sujeto.suscribir(System.out::println);
        sujeto.aprobar();
    }
}
