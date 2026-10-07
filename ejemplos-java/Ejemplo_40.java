import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_40 {
    record Crudo(String clave, String fuente, String esquema, byte[] contenido) {
        Crudo { contenido = contenido.clone(); }
        public byte[] contenido() { return contenido.clone(); }
    }
    interface Objetos { void guardar(Crudo objeto); }
    static final class Ingesta {
        private final Objetos objetos;
        Ingesta(Objetos objetos) { this.objetos = objetos; }
        void recibir(String fuente, String dia, String id, byte[] datos) {
            objetos.guardar(new Crudo(fuente + "/" + dia + "/" + id, fuente, "v1", datos));
        }
    }

    public static void main(String[] args) {
        var ingesta = new Ingesta(objeto -> System.out.println(objeto.clave()));
        ingesta.recibir("tarjetas", "2026-10-06", "E1", "{}".getBytes(StandardCharsets.UTF_8));
    }
}
