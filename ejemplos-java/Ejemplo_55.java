import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_55 {
    interface Comision { BigDecimal calcular(BigDecimal monto); }
    static void verificar(Comision regla) {
        var resultado = regla.calcular(new BigDecimal("100"));
        if (resultado.compareTo(new BigDecimal("2")) != 0)
            throw new AssertionError("Comisión incorrecta");
    }

    public static void main(String[] args) {
        verificar(monto -> monto.multiply(new BigDecimal("0.02")));
        System.out.println("Verificación OK");
    }
}
