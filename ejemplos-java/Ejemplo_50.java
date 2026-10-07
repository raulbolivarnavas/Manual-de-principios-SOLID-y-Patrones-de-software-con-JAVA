import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_50 {
    record Hallazgo(String id, String severidad) {}
    interface Scanner { List<Hallazgo> analizar(); }
    static final class Puerta {
        private final Scanner scanner;
        Puerta(Scanner scanner) { this.scanner = scanner; }
        boolean promover() {
            return scanner.analizar().stream()
                .noneMatch(h -> Set.of("ALTA", "CRITICA").contains(h.severidad()));
        }
    }

    public static void main(String[] args) {
        var puerta = new Puerta(() -> List.of(new Hallazgo("H1", "CRITICA")));
        System.out.println(puerta.promover());
    }
}
