import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_56 {
    record Artefacto(String digest, boolean verificado) {}
    interface Despliegue { void promover(Artefacto artefacto, String ambiente); }
    static final class Entrega {
        private final Despliegue despliegue;
        Entrega(Despliegue despliegue) { this.despliegue = despliegue; }
        void ejecutar(Artefacto artefacto, String ambiente) {
            if (!artefacto.verificado()) throw new IllegalStateException("Sin evidencia");
            despliegue.promover(artefacto, ambiente);
        }
    }

    public static void main(String[] args) {
        var entrega = new Entrega((a, ambiente) -> System.out.println(a.digest() + " -> " + ambiente));
        entrega.ejecutar(new Artefacto("sha256:demo", true), "UAT");
    }
}
