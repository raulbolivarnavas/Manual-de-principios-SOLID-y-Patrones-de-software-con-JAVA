import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_28 {
    record Entrada(String cliente) {}
    record Salida(String estado) {}
    interface Evaluacion { String ejecutar(String cliente); }
    static final class Handler {
        private final Evaluacion evaluacion;
        Handler(Evaluacion evaluacion) { this.evaluacion = evaluacion; }
        Salida manejar(Entrada entrada) {
            return new Salida(evaluacion.ejecutar(entrada.cliente()));
        }
    }

    public static void main(String[] args) {
        var handler = new Handler(cliente -> "EVALUABLE");
        System.out.println(handler.manejar(new Entrada("C1")).estado());
    }
}
