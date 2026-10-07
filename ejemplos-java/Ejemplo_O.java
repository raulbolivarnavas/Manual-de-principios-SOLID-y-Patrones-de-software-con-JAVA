import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_O {
    interface Comision { BigDecimal calcular(BigDecimal monto); }
    static final class Porcentaje implements Comision {
        private final BigDecimal tasa;
        Porcentaje(String tasa) { this.tasa = new BigDecimal(tasa); }
        public BigDecimal calcular(BigDecimal monto) { return monto.multiply(tasa); }
    }
    static final class Liquidar {
        private final Comision politica;
        Liquidar(Comision politica) { this.politica = politica; }
        BigDecimal ejecutar(BigDecimal monto) { return politica.calcular(monto); }
    }

    public static void main(String[] args) {
        var caso = new Liquidar(new Porcentaje("0.015"));
        System.out.println(caso.ejecutar(new BigDecimal("200")));
    }
}
