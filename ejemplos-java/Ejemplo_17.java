import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_17 {
    interface Visitante { String visitar(Cuenta c); String visitar(Tarjeta t); }
    interface Producto { String aceptar(Visitante v); }
    record Cuenta(String id) implements Producto {
        public String aceptar(Visitante v) { return v.visitar(this); }
    }
    record Tarjeta(String id) implements Producto {
        public String aceptar(Visitante v) { return v.visitar(this); }
    }
    static final class Etiquetas implements Visitante {
        public String visitar(Cuenta c) { return "Cuenta " + c.id(); }
        public String visitar(Tarjeta t) { return "Tarjeta " + t.id(); }
    }

    public static void main(String[] args) {
        Producto producto = new Tarjeta("T1");
        System.out.println(producto.aceptar(new Etiquetas()));
    }
}
