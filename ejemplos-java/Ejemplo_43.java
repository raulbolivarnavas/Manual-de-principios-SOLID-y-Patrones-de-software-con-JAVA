import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_43 {
    record Movimiento(long offset, BigDecimal monto) {}
    record Batch(long hasta, BigDecimal total) {}
    static final class Serving {
        BigDecimal total(Batch batch, List<Movimiento> recientes) {
            return recientes.stream().filter(e -> e.offset() > batch.hasta())
                .map(Movimiento::monto).reduce(batch.total(), BigDecimal::add);
        }
    }

    public static void main(String[] args) {
        var batch = new Batch(2, new BigDecimal("30"));
        var recientes = List.of(new Movimiento(2, new BigDecimal("20")),
            new Movimiento(3, new BigDecimal("5")));
        System.out.println(new Serving().total(batch, recientes));
    }
}
