import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_22 {
    record Contexto(int edad, boolean consentimiento) {}
    interface Expresion { boolean evaluar(Contexto c); }
    record MayorDeEdad() implements Expresion {
        public boolean evaluar(Contexto c) { return c.edad() >= 18; }
    }
    record Consiente() implements Expresion {
        public boolean evaluar(Contexto c) { return c.consentimiento(); }
    }
    record Y(Expresion izquierda, Expresion derecha) implements Expresion {
        public boolean evaluar(Contexto c) { return izquierda.evaluar(c) && derecha.evaluar(c); }
    }

    public static void main(String[] args) {
        Expresion regla = new Y(new MayorDeEdad(), new Consiente());
        System.out.println(regla.evaluar(new Contexto(25, true)));
    }
}
