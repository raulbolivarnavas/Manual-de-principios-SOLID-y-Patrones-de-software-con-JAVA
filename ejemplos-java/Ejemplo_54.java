import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_54 {
    interface Secretos { char[] obtener(String nombre); }
    interface Autenticador { boolean autenticar(char[] secreto); }
    static final class Acceso {
        private final Secretos secretos; private final Autenticador autenticador;
        Acceso(Secretos secretos, Autenticador autenticador) {
            this.secretos = secretos; this.autenticador = autenticador;
        }
        boolean ejecutar(String referencia) {
            char[] valor = secretos.obtener(referencia);
            try { return autenticador.autenticar(valor); }
            finally { Arrays.fill(valor, '\0'); }
        }
    }

    public static void main(String[] args) {
        var acceso = new Acceso(nombre -> "demo-no-real".toCharArray(), valor -> valor.length > 0);
        System.out.println(acceso.ejecutar("servicio/credencial"));
    }
}
