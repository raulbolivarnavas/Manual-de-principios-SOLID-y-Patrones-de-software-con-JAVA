import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_42 {
    interface Extractor { List<String> extraer(); }
    interface Transformador { BigDecimal transformar(String fila); }
    interface Cargador { void cargar(List<BigDecimal> valores); }
    static final class Etl {
        private final Extractor e; private final Transformador t; private final Cargador l;
        Etl(Extractor e, Transformador t, Cargador l) { this.e = e; this.t = t; this.l = l; }
        void ejecutar() { l.cargar(e.extraer().stream().map(t::transformar).toList()); }
    }

    public static void main(String[] args) {
        new Etl(() -> List.of("10.50", "20.00"), BigDecimal::new, System.out::println).ejecutar();
    }
}
