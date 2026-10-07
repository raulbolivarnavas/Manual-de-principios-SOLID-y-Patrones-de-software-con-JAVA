import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_47 {
    interface Calidad { boolean aceptar(List<Integer> datos); }
    interface Publicacion { void publicar(List<Integer> datos); }
    static final class Pipeline {
        private final Calidad calidad; private final Publicacion publicacion;
        Pipeline(Calidad c, Publicacion p) { calidad = c; publicacion = p; }
        void ejecutar(List<Integer> datos) {
            if (!calidad.aceptar(datos)) throw new IllegalStateException("Calidad insuficiente");
            publicacion.publicar(List.copyOf(datos));
        }
    }

    public static void main(String[] args) {
        var pipeline = new Pipeline(ds -> ds.stream().allMatch(x -> x >= 0), System.out::println);
        pipeline.ejecutar(List.of(1, 2, 3));
    }
}
