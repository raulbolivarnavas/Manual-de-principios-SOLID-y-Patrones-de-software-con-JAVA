import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_31 {
    interface Fondos { void reservar(String id); void liberar(String id); }
    interface Emision { void emitir(String id); }
    static final class Saga {
        private final Fondos fondos;
        private final Emision emision;
        Saga(Fondos fondos, Emision emision) { this.fondos = fondos; this.emision = emision; }
        void ejecutar(String id) {
            fondos.reservar(id);
            try { emision.emitir(id); }
            catch (RuntimeException original) {
                try { fondos.liberar(id); }
                catch (RuntimeException compensacion) { original.addSuppressed(compensacion); }
                throw original;
            }
        }
    }

    public static void main(String[] args) {
        Fondos fondos = new Fondos() {
            public void reservar(String id) { System.out.println("Reservado " + id); }
            public void liberar(String id) { System.out.println("Liberado " + id); }
        };
        try { new Saga(fondos, id -> { throw new IllegalStateException("Fallo conocido"); }).ejecutar("S1"); }
        catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }
}
