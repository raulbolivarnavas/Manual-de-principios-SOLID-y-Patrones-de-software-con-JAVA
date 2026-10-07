import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_I {
    interface LeerTarjeta { String estado(String id); }
    interface BloquearTarjeta { void bloquear(String id); }
    static final class Tarjetas implements LeerTarjeta, BloquearTarjeta {
        private final Map<String, String> estados = new HashMap<>();
        public String estado(String id) { return estados.getOrDefault(id, "ACTIVA"); }
        public void bloquear(String id) { estados.put(id, "BLOQUEADA"); }
    }
    static final class Consultar {
        private final LeerTarjeta lectura;
        Consultar(LeerTarjeta lectura) { this.lectura = lectura; }
        String ejecutar(String id) { return lectura.estado(id); }
    }

    public static void main(String[] args) {
        var tarjetas = new Tarjetas();
        tarjetas.bloquear("T1");
        System.out.println(new Consultar(tarjetas).ejecutar("T1"));
    }
}
