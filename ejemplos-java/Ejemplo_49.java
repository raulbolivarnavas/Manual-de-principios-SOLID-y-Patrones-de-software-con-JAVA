import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_49 {
    record Metrica(String servicio, double errores) {}
    interface Detector { boolean anomalia(Metrica metrica); }
    interface Avisos { void emitir(String servicio); }
    static final class Analisis {
        private final Detector detector; private final Avisos avisos;
        Analisis(Detector detector, Avisos avisos) { this.detector = detector; this.avisos = avisos; }
        void evaluar(Metrica metrica) {
            if (detector.anomalia(metrica)) avisos.emitir(metrica.servicio());
        }
    }

    public static void main(String[] args) {
        var analisis = new Analisis(m -> m.errores() > 0.20, System.out::println);
        analisis.evaluar(new Metrica("tarjetas", 0.35));
    }
}
