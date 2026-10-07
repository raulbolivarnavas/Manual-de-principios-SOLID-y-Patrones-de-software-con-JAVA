import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_14 {
    interface Estado { Estado bloquear(); String nombre(); }
    record Activa() implements Estado {
        public Estado bloquear() { return new Bloqueada(); }
        public String nombre() { return "ACTIVA"; }
    }
    record Bloqueada() implements Estado {
        public Estado bloquear() { return this; }
        public String nombre() { return "BLOQUEADA"; }
    }
    static final class Tarjeta {
        private Estado estado = new Activa();
        void bloquear() { estado = estado.bloquear(); }
        String estado() { return estado.nombre(); }
    }

    public static void main(String[] args) {
        var tarjeta = new Tarjeta();
        tarjeta.bloquear(); tarjeta.bloquear();
        System.out.println(tarjeta.estado());
    }
}
