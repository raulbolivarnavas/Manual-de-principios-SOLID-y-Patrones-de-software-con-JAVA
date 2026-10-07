import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_08 {
    interface Riesgo { String evaluar(String cliente); }
    interface Cupo { BigDecimal consultar(String cliente); }
    record Resumen(String riesgo, BigDecimal cupo) {}
    static final class Fachada {
        private final Riesgo riesgo;
        private final Cupo cupo;
        Fachada(Riesgo riesgo, Cupo cupo) { this.riesgo = riesgo; this.cupo = cupo; }
        Resumen consultar(String cliente) {
            return new Resumen(riesgo.evaluar(cliente), cupo.consultar(cliente));
        }
    }

    public static void main(String[] args) {
        var fachada = new Fachada(id -> "BAJO", id -> new BigDecimal("1000"));
        System.out.println(fachada.consultar("C1"));
    }
}
