import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_39 {
    interface UrlPublica { URI generar(String version, String archivo); }
    record Cdn(URI base) implements UrlPublica {
        public URI generar(String version, String archivo) {
            if (!version.matches("[a-zA-Z0-9_-]+") || !archivo.matches("[a-zA-Z0-9_.-]+"))
                throw new IllegalArgumentException("Ruta inválida");
            return base.resolve(version + "/" + archivo);
        }
    }

    public static void main(String[] args) {
        UrlPublica urls = new Cdn(URI.create("https://cdn.example.com/assets/"));
        System.out.println(urls.generar("v1", "manual.pdf"));
    }
}
