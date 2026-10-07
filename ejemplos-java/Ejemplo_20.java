import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_20 {
    interface Copiable<T> { T copiar(); }
    static final class Plantilla implements Copiable<Plantilla> {
        private final List<String> campos;
        Plantilla(List<String> campos) { this.campos = new ArrayList<>(campos); }
        public Plantilla copiar() { return new Plantilla(campos); }
        void agregar(String campo) { campos.add(campo); }
        List<String> campos() { return List.copyOf(campos); }
    }

    public static void main(String[] args) {
        var base = new Plantilla(List.of("cliente"));
        var copia = base.copiar(); copia.agregar("monto");
        System.out.println(base.campos());
        System.out.println(copia.campos());
    }
}
