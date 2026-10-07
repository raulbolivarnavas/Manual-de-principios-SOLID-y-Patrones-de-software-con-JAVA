import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_09 {
    interface Comando { void ejecutar(); }
    record Bloquear(Runnable receptor) implements Comando {
        public void ejecutar() { receptor.run(); }
    }
    static final class Invocador {
        private final Queue<Comando> pendientes = new ArrayDeque<>();
        void agregar(Comando comando) { pendientes.add(comando); }
        void procesar() {
            while (!pendientes.isEmpty()) pendientes.remove().ejecutar();
        }
    }

    public static void main(String[] args) {
        var invocador = new Invocador();
        invocador.agregar(new Bloquear(() -> System.out.println("Bloqueada")));
        invocador.procesar();
    }
}
