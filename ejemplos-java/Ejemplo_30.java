import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_30 {
    interface Evento {}
    record Abierta(String id) implements Evento {}
    record Aprobada() implements Evento {}
    static final class Solicitud {
        private String estado = "INEXISTENTE";
        void aplicar(Evento evento) {
            if (evento instanceof Abierta) estado = "ABIERTA";
            else if (evento instanceof Aprobada) estado = "APROBADA";
            else throw new IllegalArgumentException("Evento desconocido");
        }
        String estado() { return estado; }
    }
    static Solicitud reconstruir(List<Evento> stream) {
        var solicitud = new Solicitud(); stream.forEach(solicitud::aplicar); return solicitud;
    }

    public static void main(String[] args) {
        var stream = List.<Evento>of(new Abierta("S1"), new Aprobada());
        System.out.println(reconstruir(stream).estado());
    }
}
