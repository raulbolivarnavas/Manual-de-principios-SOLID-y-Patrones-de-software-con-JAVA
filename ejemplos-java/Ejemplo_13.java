import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_13 {
    interface Componente { BigDecimal saldo(); }
    record Cuenta(BigDecimal valor) implements Componente {
        public BigDecimal saldo() { return valor; }
    }
    record Cartera(List<Componente> hijos) implements Componente {
        Cartera { hijos = List.copyOf(hijos); }
        public BigDecimal saldo() {
            return hijos.stream().map(Componente::saldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    public static void main(String[] args) {
        var cartera = new Cartera(List.of(new Cuenta(new BigDecimal("10")),
            new Cartera(List.of(new Cuenta(new BigDecimal("20"))))));
        System.out.println(cartera.saldo());
    }
}
