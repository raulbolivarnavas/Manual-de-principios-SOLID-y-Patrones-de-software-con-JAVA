import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_06 {
    interface Consulta { String buscar(String id); }
    static final class Medida implements Consulta {
        private final Consulta siguiente;
        private int llamadas;
        Medida(Consulta siguiente) { this.siguiente = siguiente; }
        public String buscar(String id) {
            llamadas++;
            return siguiente.buscar(id);
        }
        int llamadas() { return llamadas; }
    }

    public static void main(String[] args) {
        var medida = new Medida(id -> "CLIENTE-" + id);
        System.out.println(medida.buscar("1"));
        System.out.println(medida.llamadas());
    }
}
