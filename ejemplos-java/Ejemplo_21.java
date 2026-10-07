import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Ejemplo_21 {
    static final class Editor {
        private String texto = "";
        record Snapshot(String texto) {}
        void escribir(String nuevo) { texto = nuevo; }
        Snapshot guardar() { return new Snapshot(texto); }
        void restaurar(Snapshot snapshot) { texto = snapshot.texto(); }
        String leer() { return texto; }
    }
    static final class Historial {
        private final Deque<Editor.Snapshot> cambios = new ArrayDeque<>();
        void agregar(Editor.Snapshot s) { cambios.push(s); }
        Editor.Snapshot ultimo() { return cambios.pop(); }
    }

    public static void main(String[] args) {
        var editor = new Editor(); var historial = new Historial();
        editor.escribir("A"); historial.agregar(editor.guardar());
        editor.escribir("B"); editor.restaurar(historial.ultimo());
        System.out.println(editor.leer());
    }
}
