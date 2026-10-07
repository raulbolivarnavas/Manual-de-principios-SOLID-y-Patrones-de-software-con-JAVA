import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_S {
    interface Registro { void guardar(BigDecimal comision); }
    static final class Comisiones {
        BigDecimal calcular(BigDecimal monto) {
            if (monto.signum() < 0) throw new IllegalArgumentException("Monto negativo");
            return monto.multiply(new BigDecimal("0.02"));
        }
    }
    static final class Cobrar {
        private final Comisiones regla;
        private final Registro registro;
        Cobrar(Comisiones regla, Registro registro) {
            this.regla = regla; this.registro = registro;
        }
        void ejecutar(BigDecimal monto) { registro.guardar(regla.calcular(monto)); }
    }

    public static void main(String[] args) {
        new Cobrar(new Comisiones(), System.out::println).ejecutar(new BigDecimal("100"));
    }
}
