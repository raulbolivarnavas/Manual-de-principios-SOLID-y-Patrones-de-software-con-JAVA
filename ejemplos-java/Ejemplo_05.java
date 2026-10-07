import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_05 {
    interface Conversion { BigDecimal convertir(long puntos); }
    record Factor(BigDecimal valor) implements Conversion {
        public BigDecimal convertir(long puntos) {
            if (puntos < 0) throw new IllegalArgumentException("Puntos negativos");
            return valor.multiply(BigDecimal.valueOf(puntos));
        }
    }
    static final class Canjear {
        private final Conversion conversion;
        Canjear(Conversion conversion) { this.conversion = conversion; }
        BigDecimal ejecutar(long puntos) { return conversion.convertir(puntos); }
    }

    public static void main(String[] args) {
        var caso = new Canjear(new Factor(new BigDecimal("0.15")));
        System.out.println(caso.ejecutar(100));
    }
}
