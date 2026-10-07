import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_32 {
    static final class Circuito {
        enum Estado { CLOSED, OPEN, HALF_OPEN }
        private Estado estado = Estado.CLOSED;
        private int fallos;
        private long reabrir;
        private final LongSupplier reloj;
        Circuito(LongSupplier reloj) { this.reloj = reloj; }
        String llamar(Supplier<String> destino) {
            long ahora = reloj.getAsLong();
            if (estado == Estado.OPEN) {
                if (ahora < reabrir) throw new IllegalStateException("Circuito abierto");
                estado = Estado.HALF_OPEN;
            }
            try {
                String respuesta = destino.get(); fallos = 0; estado = Estado.CLOSED;
                return respuesta;
            } catch (RuntimeException e) {
                if (estado == Estado.HALF_OPEN || ++fallos >= 2) {
                    estado = Estado.OPEN; reabrir = ahora + 1000;
                }
                throw e;
            }
        }
    }

    public static void main(String[] args) {
        var ahora = new AtomicLong(0); var circuito = new Circuito(ahora::get);
        for (int i = 0; i < 2; i++) {
            try { circuito.llamar(() -> { throw new IllegalStateException("Remoto caído"); }); }
            catch (IllegalStateException e) { }
        }
        try { circuito.llamar(() -> "OK"); }
        catch (IllegalStateException e) { System.out.println(e.getMessage()); }
        ahora.set(1000);
        System.out.println(circuito.llamar(() -> "Recuperado"));
    }
}
