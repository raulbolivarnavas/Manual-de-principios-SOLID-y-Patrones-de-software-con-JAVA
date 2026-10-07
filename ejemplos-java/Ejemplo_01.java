import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_01 {
    interface Capacidades { boolean soporta(String banco); }
    enum Catalogo implements Capacidades {
        INSTANCE;
        private final Set<String> bancos = Set.of("CO01", "PE01", "BR01", "CL01");
        public boolean soporta(String banco) { return bancos.contains(banco); }
    }
    static final class ValidarBanco {
        private final Capacidades catalogo;
        ValidarBanco(Capacidades catalogo) { this.catalogo = catalogo; }
        boolean ejecutar(String banco) { return catalogo.soporta(banco); }
    }

    public static void main(String[] args) {
        System.out.println(new ValidarBanco(Catalogo.INSTANCE).ejecutar("CL01"));
    }
}
