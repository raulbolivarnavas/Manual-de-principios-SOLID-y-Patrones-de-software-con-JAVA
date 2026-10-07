import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_11 {
    static abstract class Importador {
        final int importar(String texto) {
            if (texto.isBlank()) throw new IllegalArgumentException("Archivo vacío");
            return interpretar(texto).size();
        }
        protected abstract List<String> interpretar(String texto);
    }
    static final class Csv extends Importador {
        protected List<String> interpretar(String texto) {
            return List.of(texto.split(","));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Csv().importar("A,B,C"));
    }
}
