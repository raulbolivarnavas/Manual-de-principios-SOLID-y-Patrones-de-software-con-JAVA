import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_07 {
    interface EstadoTarjeta { boolean activa(String id); }
    static final class Legacy {
        int consultarCodigo(String id) { return 1; }
    }
    static final class Adaptador implements EstadoTarjeta {
        private final Legacy cliente;
        Adaptador(Legacy cliente) { this.cliente = cliente; }
        public boolean activa(String id) {
            int codigo = cliente.consultarCodigo(id);
            return switch (codigo) {
                case 1 -> true;
                case 2 -> false;
                default -> throw new IllegalStateException("Código desconocido");
            };
        }
    }

    public static void main(String[] args) {
        EstadoTarjeta puerto = new Adaptador(new Legacy());
        System.out.println(puerto.activa("T1"));
    }
}
