import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_48 {
    record Modelo(String version, double precision) {}
    interface RegistroModelos { void promover(Modelo modelo); }
    static final class Promocion {
        private final RegistroModelos registro;
        Promocion(RegistroModelos registro) { this.registro = registro; }
        void ejecutar(Modelo modelo) {
            if (!Double.isFinite(modelo.precision()) || modelo.precision() < 0.90 || modelo.precision() > 1)
                throw new IllegalArgumentException("Métrica no aceptable");
            registro.promover(modelo);
        }
    }

    public static void main(String[] args) {
        new Promocion(m -> System.out.println(m.version())).ejecutar(new Modelo("v2", 0.95));
    }
}
