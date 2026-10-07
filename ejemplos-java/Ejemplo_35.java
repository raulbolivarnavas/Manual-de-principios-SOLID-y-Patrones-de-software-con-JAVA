import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_35 {
    static final class Limite {
        private final LongSupplier reloj;
        private final int maximo;
        private long ventana = -1;
        private int usados;
        Limite(LongSupplier reloj, int maximo) { this.reloj = reloj; this.maximo = maximo; }
        synchronized boolean permitir() {
            long actual = reloj.getAsLong() / 1000;
            if (actual != ventana) { ventana = actual; usados = 0; }
            if (usados >= maximo) return false;
            usados++; return true;
        }
    }

    public static void main(String[] args) {
        var ahora = new AtomicLong(0); var limite = new Limite(ahora::get, 2);
        System.out.println(limite.permitir()); System.out.println(limite.permitir());
        System.out.println(limite.permitir());
        ahora.set(1000); System.out.println(limite.permitir());
    }
}
