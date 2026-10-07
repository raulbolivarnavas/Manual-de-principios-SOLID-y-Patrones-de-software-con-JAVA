import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_12 {
    record Solicitud(String cliente, BigDecimal monto) {
        Solicitud {
            Objects.requireNonNull(cliente); Objects.requireNonNull(monto);
            if (cliente.isBlank() || monto.signum() <= 0)
                throw new IllegalArgumentException("Solicitud inválida");
        }
    }
    static final class Builder {
        private String cliente;
        private BigDecimal monto;
        Builder cliente(String valor) { cliente = valor; return this; }
        Builder monto(String valor) { monto = new BigDecimal(valor); return this; }
        Solicitud build() { return new Solicitud(cliente, monto); }
    }

    public static void main(String[] args) {
        System.out.println(new Builder().cliente("C1").monto("50").build());
    }
}
