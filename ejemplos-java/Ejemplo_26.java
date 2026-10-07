import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_26 {
    record Perfil(String id, String segmento) {}
    interface ClientesRemotos { Perfil consultar(String id); }
    static final class EvaluarCredito {
        private final ClientesRemotos clientes;
        EvaluarCredito(ClientesRemotos clientes) { this.clientes = clientes; }
        String ejecutar(String id) {
            var perfil = clientes.consultar(id);
            return perfil.segmento().equals("ESTANDAR") ? "EVALUABLE" : "REVISAR";
        }
    }

    public static void main(String[] args) {
        var servicio = new EvaluarCredito(id -> new Perfil(id, "ESTANDAR"));
        System.out.println(servicio.ejecutar("C1"));
    }
}
