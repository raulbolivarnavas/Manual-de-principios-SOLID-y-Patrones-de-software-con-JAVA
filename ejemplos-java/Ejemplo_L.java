import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_L {
    record Cliente(String id) {}
    interface Consulta {
        // id no nulo; ausencia -> Optional.empty(); nunca null.
        Optional<Cliente> buscar(String id);
    }
    static final class Memoria implements Consulta {
        private final Map<String, Cliente> datos;
        Memoria(Map<String, Cliente> datos) { this.datos = Map.copyOf(datos); }
        public Optional<Cliente> buscar(String id) {
            return Optional.ofNullable(datos.get(Objects.requireNonNull(id)));
        }
    }
    static void verificarContrato(Consulta consulta) {
        if (consulta.buscar("ausente") == null) throw new AssertionError("Contrato roto");
        if (consulta.buscar("ausente").isPresent()) throw new AssertionError("Ausencia rota");
    }

    public static void main(String[] args) {
        verificarContrato(new Memoria(Map.of()));
        System.out.println("Contrato respetado");
    }
}
