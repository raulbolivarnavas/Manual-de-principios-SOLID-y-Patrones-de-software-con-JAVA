import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_19 {
    record Moneda(String codigo) {}
    static final class Monedas {
        private final ConcurrentHashMap<String, Moneda> cache = new ConcurrentHashMap<>();
        Moneda obtener(String codigo) {
            return cache.computeIfAbsent(codigo, Moneda::new);
        }
    }
    record Operacion(BigDecimal monto, Moneda moneda) {}

    public static void main(String[] args) {
        var fabrica = new Monedas();
        var a = fabrica.obtener("USD");
        var b = fabrica.obtener("USD");
        System.out.println(a == b);
    }
}
