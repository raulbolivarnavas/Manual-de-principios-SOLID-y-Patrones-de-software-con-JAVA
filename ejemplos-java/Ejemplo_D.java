import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_D {
    interface PagoPort { String pagar(BigDecimal monto); }
    static final class IniciarPago {
        private final PagoPort pagos;
        IniciarPago(PagoPort pagos) { this.pagos = Objects.requireNonNull(pagos); }
        String ejecutar(BigDecimal monto) {
            if (monto.signum() <= 0) throw new IllegalArgumentException("Monto inválido");
            return pagos.pagar(monto);
        }
    }

    public static void main(String[] args) {
        PagoPort fake = monto -> "PAGO-" + monto.toPlainString();
        System.out.println(new IniciarPago(fake).ejecutar(new BigDecimal("50")));
    }
}
