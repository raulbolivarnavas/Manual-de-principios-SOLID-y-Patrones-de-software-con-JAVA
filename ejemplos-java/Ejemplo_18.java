import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_18 {
    interface Canal { void enviar(String mensaje); }
    static abstract class Aviso {
        protected final Canal canal;
        Aviso(Canal canal) { this.canal = canal; }
        abstract void publicar(String texto);
    }
    static final class Urgente extends Aviso {
        Urgente(Canal canal) { super(canal); }
        void publicar(String texto) { canal.enviar("URGENTE " + texto); }
    }

    public static void main(String[] args) {
        new Urgente(System.out::println).publicar("Operación pendiente");
    }
}
