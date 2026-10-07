import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_16 {
    interface Manejador { String procesar(int monto); }
    static final class Positivo implements Manejador {
        private final Manejador siguiente;
        Positivo(Manejador siguiente) { this.siguiente = siguiente; }
        public String procesar(int monto) {
            return monto <= 0 ? "RECHAZADO" : siguiente.procesar(monto);
        }
    }
    static final class Limite implements Manejador {
        public String procesar(int monto) { return monto > 1000 ? "EXCEDE" : "ACEPTADO"; }
    }

    public static void main(String[] args) {
        Manejador cadena = new Positivo(new Limite());
        System.out.println(cadena.procesar(50));
    }
}
