import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_10 {
    interface Reportes { String leer(); }
    static final class ProxyAutorizado implements Reportes {
        private final Reportes destino;
        private final BooleanSupplier permitido;
        ProxyAutorizado(Reportes destino, BooleanSupplier permitido) {
            this.destino = destino; this.permitido = permitido;
        }
        public String leer() {
            if (!permitido.getAsBoolean()) throw new SecurityException("Sin permiso");
            return destino.leer();
        }
    }

    public static void main(String[] args) {
        Reportes proxy = new ProxyAutorizado(() -> "Reporte", () -> true);
        System.out.println(proxy.leer());
    }
}
