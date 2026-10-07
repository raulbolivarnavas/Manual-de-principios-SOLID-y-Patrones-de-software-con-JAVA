import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_51 {
    interface Cluster { String version(); void aplicar(String version); }
    static final class Reconciliador {
        private final Cluster cluster;
        Reconciliador(Cluster cluster) { this.cluster = cluster; }
        void reconciliar(String deseada) {
            if (!deseada.equals(cluster.version())) cluster.aplicar(deseada);
        }
    }

    public static void main(String[] args) {
        Cluster cluster = new Cluster() {
            private String actual = "v1";
            public String version() { return actual; }
            public void aplicar(String version) { actual = version; System.out.println(actual); }
        };
        var reconciliador = new Reconciliador(cluster);
        reconciliador.reconciliar("v2"); reconciliador.reconciliar("v2");
    }
}
