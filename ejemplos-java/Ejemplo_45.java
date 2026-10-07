import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_45 {
    record ProductoDatos(String nombre, String propietario, String version, URI ubicacion) {
        ProductoDatos {
            if (nombre.isBlank() || propietario.isBlank() || version.isBlank())
                throw new IllegalArgumentException("Contrato incompleto");
            Objects.requireNonNull(ubicacion);
        }
    }
    interface Catalogo { void publicar(ProductoDatos producto); }

    public static void main(String[] args) {
        Catalogo catalogo = p -> System.out.println(p.nombre() + " " + p.propietario());
        catalogo.publicar(new ProductoDatos("solicitudes", "credito", "v1", URI.create("https://datos.internal/solicitudes")));
    }
}
