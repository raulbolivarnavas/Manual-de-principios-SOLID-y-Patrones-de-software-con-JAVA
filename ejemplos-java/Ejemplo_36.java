import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_36 {
    interface Destino { String atender(); }
    static final class Gateway {
        private final Map<String, Destino> rutas;
        Gateway(Map<String, Destino> rutas) { this.rutas = Map.copyOf(rutas); }
        String atender(String ruta) {
            var destino = rutas.get(ruta);
            if (destino == null) throw new NoSuchElementException("Ruta desconocida");
            return destino.atender();
        }
    }

    public static void main(String[] args) {
        var gateway = new Gateway(Map.of("/clientes", () -> "Clientes"));
        System.out.println(gateway.atender("/clientes"));
    }
}
