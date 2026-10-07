import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_52 {
    record Tabla(String nombre, String clave, boolean cifrada) {
        Tabla {
            if (nombre.isBlank() || clave.isBlank() || !cifrada)
                throw new IllegalArgumentException("Infraestructura inválida");
        }
    }
    interface Planificador { String plan(Tabla tabla); }
    static final class PlanTexto implements Planificador {
        public String plan(Tabla tabla) {
            return "Crear " + tabla.nombre() + " clave=" + tabla.clave() + " cifrada=" + tabla.cifrada();
        }
    }

    public static void main(String[] args) {
        Planificador planificador = new PlanTexto();
        System.out.println(planificador.plan(new Tabla("solicitudes", "id", true)));
    }
}
