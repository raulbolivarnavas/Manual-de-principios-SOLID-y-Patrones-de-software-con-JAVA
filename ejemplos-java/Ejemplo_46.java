import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_46 {
    interface Conector { String consultar(String clave); }
    static final class Fabric {
        private final Map<String, Conector> conectores;
        Fabric(Map<String, Conector> conectores) { this.conectores = Map.copyOf(conectores); }
        String consultar(String origen, String clave) {
            var conector = conectores.get(origen);
            if (conector == null) throw new NoSuchElementException("Origen desconocido");
            return conector.consultar(clave);
        }
    }

    public static void main(String[] args) {
        var fabric = new Fabric(Map.of("clientes", clave -> "Cliente " + clave));
        System.out.println(fabric.consultar("clientes", "C1"));
    }
}
