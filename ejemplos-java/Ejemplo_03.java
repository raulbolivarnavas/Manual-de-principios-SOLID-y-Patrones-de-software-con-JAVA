import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_03 {
    interface Reporte { String contenido(); }
    static abstract class Exportador {
        protected abstract Reporte crear();
        final String exportar() { return crear().contenido(); }
    }
    static final class ExportadorCsv extends Exportador {
        protected Reporte crear() { return () -> "id,monto"; }
    }
    static final class ExportadorJson extends Exportador {
        protected Reporte crear() { return () -> "{\"id\":\"P1\"}"; }
    }

    public static void main(String[] args) {
        System.out.println(new ExportadorCsv().exportar());
    }
}
