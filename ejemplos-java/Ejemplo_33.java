import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_33 {
    static final class Aislamiento {
        private final Semaphore cupos;
        Aislamiento(int maximo) { cupos = new Semaphore(maximo); }
        String ejecutar(Supplier<String> destino) {
            if (!cupos.tryAcquire()) throw new IllegalStateException("Sin capacidad");
            try { return destino.get(); }
            finally { cupos.release(); }
        }
    }

    public static void main(String[] args) {
        var proveedorA = new Aislamiento(1); var proveedorB = new Aislamiento(1);
        System.out.println(proveedorA.ejecutar(() -> "A"));
        System.out.println(proveedorB.ejecutar(() -> "B"));
    }
}
