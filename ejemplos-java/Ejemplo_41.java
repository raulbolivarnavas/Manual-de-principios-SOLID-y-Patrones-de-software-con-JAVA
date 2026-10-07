import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_41 {
    record Operacion(LocalDate fecha, BigDecimal monto) {}
    record Hecho(LocalDate fecha, BigDecimal total) {}
    interface Warehouse { void upsert(Hecho hecho); }
    static final class Carga {
        private final Warehouse destino;
        Carga(Warehouse destino) { this.destino = destino; }
        void ejecutar(List<Operacion> operaciones) {
            var totales = new TreeMap<LocalDate, BigDecimal>();
            operaciones.forEach(o -> totales.merge(o.fecha(), o.monto(), BigDecimal::add));
            totales.forEach((fecha, total) -> destino.upsert(new Hecho(fecha, total)));
        }
    }

    public static void main(String[] args) {
        new Carga(h -> System.out.println(h.total())).ejecutar(List.of(
            new Operacion(LocalDate.of(2026, 10, 6), new BigDecimal("10")),
            new Operacion(LocalDate.of(2026, 10, 6), new BigDecimal("20"))));
    }
}
