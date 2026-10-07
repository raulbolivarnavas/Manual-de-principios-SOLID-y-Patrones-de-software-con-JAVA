import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_34 {
    static final class Regulador {
        private final BlockingQueue<Runnable> cola = new ArrayBlockingQueue<>(2);
        boolean aceptar(Runnable tarea) { return cola.offer(tarea); }
        void pulso() {
            var tarea = cola.poll(); if (tarea != null) tarea.run();
        }
    }

    public static void main(String[] args) {
        var regulador = new Regulador();
        regulador.aceptar(() -> System.out.println("A"));
        regulador.aceptar(() -> System.out.println("B"));
        System.out.println(regulador.aceptar(() -> {}));
        regulador.pulso(); regulador.pulso();
    }
}
