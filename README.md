# Manual de principios SOLID y patrones de software con Java

Manual práctico para desarrollo backend con Java 21

Preparado por: `Raul Bolivar Navas`. Los ejemplos son material didáctico nuevo.

---

<a id="proposito-y-alcance"></a>

## Propósito y alcance

- Este manual permite reconocer el problema que resuelve cada entrada, implementar su mecanismo central en Java y evaluar su compatibilidad con SOLID.
- Comienza por los cinco principios y cubre las 55 entradas del catálogo.
- El catálogo mezcla patrones de diseño de objetos, patrones de aplicación, arquitecturas, modelos de infraestructura y prácticas operativas.
- Una clase Java puede demostrar una fábrica o un estado.
- Para CDN, Data Mesh o GitOps, el código muestra la participación de una aplicación en esa solución; no equivale a desplegar su plataforma completa.
- Ningún patrón garantiza SOLID automáticamente: importa cómo se reparten responsabilidades, contratos y dependencias.
- Los ejemplos usan casos de pagos, tarjetas, solicitudes y datos, con puertos de aplicación para facilitar su adaptación a Clean Architecture y arquitectura hexagonal.
- Los factores, límites, estados y umbrales son ilustrativos; no definen reglas bancarias ni configuraciones corporativas.
- El código es deliberadamente independiente de Spring y de SDKs para que el mecanismo resulte visible.

[↑ Volver al índice](#indice)


---

<a id="como-utilizar-el-manual-y-ejecutar-los-ejemplos"></a>

## Cómo utilizar el manual y ejecutar los ejemplos

- Cada capítulo contiene problema, mecanismo, implementación, ejecución, resultado, análisis SOLID, límites y ejercicio.
- Lee primero SOLID; después ejecuta y modifica los ejemplos.
- Para arquitecturas distribuidas, usa el capítulo como diseño de un mecanismo y completa los requisitos operativos antes de producción.
- El paquete adjunto contiene 60 archivos Java autónomos: cinco principios y 55 entradas. Cada archivo incluye imports, una clase pública, colaboradores anidados y main.
- Los bloques del manual muestran los colaboradores dentro de esa clase; el bloque de ejecución pertenece a main.
- No hay clases ausentes ni dependencias de Maven, Gradle, Spring, Lombok o SDKs.

---

#### Requisito de uso recomendado:
- JDK 21 | JDK 25

Se usan características compatibles con Java 17 para permitir verificación adicional en ese entorno. Desde la carpeta ejemplos-java ejecuta:

```powershell
java Ejemplo_S.java
java Ejemplo_05.java
java Ejemplo_31.java
```

En Linux se utilizan los mismos comandos. Para compilación tradicional con un JDK que incluya javac:

```bash
javac --release 21 -d clases Ejemplo_05.java
java -cp clases Ejemplo_05
```

Cada archivo es independiente y sus tipos anidados evitan colisiones con los otros ejemplos. `System.out.println` se usa solamente para observar resultados de demostración, no como estrategia de logging de producción.

[↑ Volver al índice](#indice)


---

<a id="fundamentos-que-preceden-a-los-patrones"></a>

## Fundamentos que preceden a los patrones

- **Abstracción y contrato.** Una interfaz expresa operaciones y obligaciones: entradas válidas, significado del resultado, errores, unidades, identidad y efectos. Escribir una interfaz no elimina el acoplamiento si sus tipos exponen SQL, HTTP o detalles de proveedor que el negocio no necesita.
- **Cohesión y composición.** Agrupa reglas que cambian por la misma causa. Usa composición cuando un colaborador puede variar independientemente. La herencia es apropiada cuando hay sustitución semántica; no se justifica únicamente para reutilizar código.
- **Inmutabilidad.** Los records ayudan a expresar valores, pero no hacen inmutables los objetos referenciados. Copia colecciones y arrays cuando el contrato lo requiere. Una lista inmutable puede seguir contener elementos mutables.
- **Dinero y tiempo.** Usa BigDecimal construido desde texto, moneda explícita y política de redondeo definida por negocio. No uses double para dinero. Inyecta reloj para decisiones temporales reproducibles; usa tiempo monotónico para duración y tiempo civil para fechas de negocio.
- **Concurrencia y fallos.** Un ejemplo secuencial no garantiza seguridad concurrente. Antes de compartir objetos decide si deben ser inmutables, sincronizados o confinados. En una operación remota distingue rechazo de negocio, fallo conocido y resultado incierto por timeout.

[↑ Volver al índice](#indice)


---

<a id="mapa-de-cobertura"></a>

## Mapa de cobertura

| Grupo | Secciones del manual | Alcance |
| --- | --- | --- |
| Principios | S O L I D | Cinco fundamentos de diseño |
| Diseño de objetos | 1 a 21 | Veintiún mecanismos creacionales estructurales y de comportamiento |
| Aplicación y persistencia | 22 a 24 | DAO Repository y Service Layer |
| Sistemas y resiliencia | 25 a 37 | Servicios eventos consistencia protección y tráfico |
| Contenido y datos | 38 a 45 | CDN almacenamiento análisis procesamiento y organización |
| Operación y entrega | 46 a 55 | DataOps MLOps AIOps seguridad automatización y entrega |

[↑ Volver al índice](#indice)


---

<a id="indice"></a>

## Índice de capítulos

La numeración de los patrones es consecutiva del 1 al 55. Los nombres de los archivos `Ejemplo_XX.java` conservan su identificación en el paquete de código entregado; por eso pueden diferir del número del capítulo.

- [Propósito y alcance](#proposito-y-alcance)
- [Cómo utilizar el manual y ejecutar los ejemplos](#como-utilizar-el-manual-y-ejecutar-los-ejemplos)
- [Fundamentos que preceden a los patrones](#fundamentos-que-preceden-a-los-patrones)
- [Mapa de cobertura](#mapa-de-cobertura)

**Principios SOLID**

- [S Responsabilidad única](#capitulo-s)
- [O Abierto cerrado](#capitulo-o)
- [L Sustitución de Liskov](#capitulo-l)
- [I Segregación de interfaces](#capitulo-i)
- [D Inversión de dependencias](#capitulo-d)

**Patrones del 1 al 55**

- [1. Singleton](#patron-1)
- [2. Factory Method](#patron-2)
- [3. Observer](#patron-3)
- [4. Strategy](#patron-4)
- [5. Decorator](#patron-5)
- [6. Adapter](#patron-6)
- [7. Facade](#patron-7)
- [8. Command](#patron-8)
- [9. Proxy](#patron-9)
- [10. Template Method](#patron-10)
- [11. Builder](#patron-11)
- [12. Composite](#patron-12)
- [13. State](#patron-13)
- [14. Mediator](#patron-14)
- [15. Chain of Responsibility](#patron-15)
- [16. Visitor](#patron-16)
- [17. Bridge](#patron-17)
- [18. Flyweight](#patron-18)
- [19. Prototype](#patron-19)
- [20. Memento](#patron-20)
- [21. Interpreter](#patron-21)
- [22. DAO](#patron-22)
- [23. Repository](#patron-23)
- [24. Service Layer](#patron-24)
- [25. Microservices](#patron-25)
- [26. Event Driven Architecture](#patron-26)
- [27. Serverless Architecture](#patron-27)
- [28. CQRS](#patron-28)
- [29. Event Sourcing](#patron-29)
- [30. Saga](#patron-30)
- [31. Circuit Breaker](#patron-31)
- [32. Bulkhead](#patron-32)
- [33. Throttling](#patron-33)
- [34. Rate Limiting](#patron-34)
- [35. API Gateway](#patron-35)
- [36. Service Discovery](#patron-36)
- [37. Load Balancing](#patron-37)
- [38. Content Delivery Network](#patron-38)
- [39. Data Lake](#patron-39)
- [40. Data Warehouse](#patron-40)
- [41. ETL](#patron-41)
- [42. Lambda Architecture](#patron-42)
- [43. Kappa Architecture](#patron-43)
- [44. Data Mesh](#patron-44)
- [45. Data Fabric](#patron-45)
- [46. DataOps](#patron-46)
- [47. MLOps](#patron-47)
- [48. AIOps](#patron-48)
- [49. DevSecOps](#patron-49)
- [50. GitOps](#patron-50)
- [51. Infrastructure as Code](#patron-51)
- [52. Configuration as Code](#patron-52)
- [53. Secrets Management](#patron-53)
- [54. Continuous Integration](#patron-54)
- [55. Continuous Delivery](#patron-55)

**Guías complementarias**

- [Comparaciones para elegir con criterio](#comparaciones-para-elegir-con-criterio)
- [Aplicación conjunta en Clean Architecture y arquitectura hexagonal](#aplicacion-conjunta-en-clean-architecture-y-arquitectura-hexagonal)
- [Verificación por tipo de solución](#verificacion-por-tipo-de-solucion)
- [Caso integrador propuesto](#caso-integrador-propuesto)
- [Ruta de estudio y ejercicios de consolidación](#ruta-de-estudio-y-ejercicios-de-consolidacion)
- [Glosario](#glosario)
- [Referencias y lecturas primarias](#referencias-y-lecturas-primarias)

---

<a id="parte-primera-principios-solid"></a>

## Parte primera Principios SOLID

<a id="capitulo-s"></a>

## S Responsabilidad única

**Categoría:** Principio SOLID.

### Problema y contexto

Un servicio que calcula una comisión, guarda movimientos y envía correo cambia por decisiones de tres actores distintos. Separar únicamente métodos dentro de la misma clase no elimina ese acoplamiento.

### Cómo funciona y cuándo elegirlo

Comisiones contiene la regla financiera; Registro representa persistencia; el caso de uso coordina ambas. SRP trata de cohesión y motivos de cambio, no de imponer un método por clase. La coordinación es una responsabilidad legítima.

### Implementación Java

Archivo ejecutable: `Ejemplo_S.java`.

```java
interface Registro { void guardar(BigDecimal comision); }
static final class Comisiones {
    BigDecimal calcular(BigDecimal monto) {
        if (monto.signum() < 0) throw new IllegalArgumentException("Monto negativo");
        return monto.multiply(new BigDecimal("0.02"));
    }
}
static final class Cobrar {
    private final Comisiones regla;
    private final Registro registro;
    Cobrar(Comisiones regla, Registro registro) {
        this.regla = regla; this.registro = registro;
    }
    void ejecutar(BigDecimal monto) { registro.guardar(regla.calcular(monto)); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
new Cobrar(new Comisiones(), System.out::println).ejecutar(new BigDecimal("100"));
```

Resultado esperado:

```text
2.00
```

### Relación con SOLID

SRP separa política financiera y almacenamiento. DIP aparece en el puerto Registro. No se introduce una interfaz para Comisiones porque el ejemplo no necesita implementaciones alternativas.

### Límites y errores que conviene evitar

Una clase por cada línea produce fragmentación. Identifica quién solicita cada cambio y agrupa comportamiento que cambia por la misma causa.

### Ejercicio y comprobación

Agrega un notificador independiente. Verifica que cambiar el formato del mensaje no modifique el cálculo.

[↑ Volver al índice](#indice)


<a id="capitulo-o"></a>

## O Abierto cerrado

**Categoría:** Principio SOLID.

### Problema y contexto

Un cálculo con condiciones por país obliga a modificar y volver a verificar el mismo servicio cada vez que aparece una nueva política.

### Cómo funciona y cuándo elegirlo

La operación depende de una estrategia de comisión. La extensión prevista es la política; la composición elige una implementación. OCP no significa que nunca se pueda editar código: se protegen puntos de variación concretos.

### Implementación Java

Archivo ejecutable: `Ejemplo_O.java`.

```java
interface Comision { BigDecimal calcular(BigDecimal monto); }
static final class Porcentaje implements Comision {
    private final BigDecimal tasa;
    Porcentaje(String tasa) { this.tasa = new BigDecimal(tasa); }
    public BigDecimal calcular(BigDecimal monto) { return monto.multiply(tasa); }
}
static final class Liquidar {
    private final Comision politica;
    Liquidar(Comision politica) { this.politica = politica; }
    BigDecimal ejecutar(BigDecimal monto) { return politica.calcular(monto); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var caso = new Liquidar(new Porcentaje("0.015"));
System.out.println(caso.ejecutar(new BigDecimal("200")));
```

Resultado esperado:

```text
3.000
```

### Relación con SOLID

OCP permite otra política sin editar Liquidar; DIP evita una dependencia del caso de uso con una regla regional específica. El constructor es el lugar de composición.

### Límites y errores que conviene evitar

No anticipes decenas de extensiones imaginarias. Un switch estable en el borde de configuración puede ser más claro que una jerarquía sin variación real.

### Ejercicio y comprobación

Implementa comisión fija y comprueba que Liquidar sigue funcionando sin cambios.

[↑ Volver al índice](#indice)


<a id="capitulo-l"></a>

## L Sustitución de Liskov

**Categoría:** Principio SOLID.

### Problema y contexto

Una implementación que exige requisitos adicionales o cambia el significado del resultado rompe a clientes que confiaban en la interfaz. Compilar y heredar no bastan para respetar LSP.

### Cómo funciona y cuándo elegirlo

El contrato de consulta exige devolver Optional vacío cuando no existe el cliente y prohíbe devolver null. Los adaptadores deben conservar precondiciones, postcondiciones e invariantes. Los errores de infraestructura se documentan por separado.

### Implementación Java

Archivo ejecutable: `Ejemplo_L.java`.

```java
record Cliente(String id) {}
interface Consulta {
    // id no nulo; ausencia -> Optional.empty(); nunca null.
    Optional<Cliente> buscar(String id);
}
static final class Memoria implements Consulta {
    private final Map<String, Cliente> datos;
    Memoria(Map<String, Cliente> datos) { this.datos = Map.copyOf(datos); }
    public Optional<Cliente> buscar(String id) {
        return Optional.ofNullable(datos.get(Objects.requireNonNull(id)));
    }
}
static void verificarContrato(Consulta consulta) {
    if (consulta.buscar("ausente") == null) throw new AssertionError("Contrato roto");
    if (consulta.buscar("ausente").isPresent()) throw new AssertionError("Ausencia rota");
}
```

### Ejecución y resultado

Dentro de `main`:

```java
verificarContrato(new Memoria(Map.of()));
System.out.println("Contrato respetado");
```

Resultado esperado:

```text
Contrato respetado
```

### Relación con SOLID

LSP se verifica con el mismo conjunto de pruebas sobre cada implementación. ISP ayuda a que una consulta no tenga que simular operaciones de escritura.

### Límites y errores que conviene evitar

Un repositorio remoto no equivale operacionalmente a uno local: latencia y fallos siguen existiendo. El contrato debe describirlos; ocultarlos como ausencia falsea el dominio.

### Ejercicio y comprobación

Crea un adaptador que devuelva null y observa que falla la prueba de contrato.

[↑ Volver al índice](#indice)


<a id="capitulo-i"></a>

## I Segregación de interfaces

**Categoría:** Principio SOLID.

### Problema y contexto

Una interfaz de tarjeta con consultar, activar, bloquear y emitir obliga a un consumidor de lectura a depender de operaciones que no necesita.

### Cómo funciona y cuándo elegirlo

Los puertos se definen desde las necesidades del cliente. Una implementación puede satisfacer varias interfaces pequeñas; el caso de uso recibe únicamente la capacidad requerida.

### Implementación Java

Archivo ejecutable: `Ejemplo_I.java`.

```java
interface LeerTarjeta { String estado(String id); }
interface BloquearTarjeta { void bloquear(String id); }
static final class Tarjetas implements LeerTarjeta, BloquearTarjeta {
    private final Map<String, String> estados = new HashMap<>();
    public String estado(String id) { return estados.getOrDefault(id, "ACTIVA"); }
    public void bloquear(String id) { estados.put(id, "BLOQUEADA"); }
}
static final class Consultar {
    private final LeerTarjeta lectura;
    Consultar(LeerTarjeta lectura) { this.lectura = lectura; }
    String ejecutar(String id) { return lectura.estado(id); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var tarjetas = new Tarjetas();
tarjetas.bloquear("T1");
System.out.println(new Consultar(tarjetas).ejecutar("T1"));
```

Resultado esperado:

```text
BLOQUEADA
```

### Relación con SOLID

ISP limita el contrato del consumidor. SRP separa consulta y cambio de estado en los casos de uso; no obliga a separar artificialmente un agregado coherente.

### Límites y errores que conviene evitar

Dividir una interfaz por cada método sin considerar clientes produce ruido. Separa roles funcionales y privilegios reales.

### Ejercicio y comprobación

Agrega EmitirTarjeta sin ampliar LeerTarjeta ni modificar Consultar.

[↑ Volver al índice](#indice)


<a id="capitulo-d"></a>

## D Inversión de dependencias

**Categoría:** Principio SOLID.

### Problema y contexto

El caso de uso que crea directamente un cliente SQL o HTTP queda atado a la infraestructura y exige esos sistemas para probar reglas de negocio.

### Cómo funciona y cuándo elegirlo

La aplicación declara el puerto que necesita y la infraestructura lo implementa. La inyección por constructor hace explícita la dependencia. DIP decide hacia dónde dependen los módulos; DI es una técnica para suministrar objetos.

### Implementación Java

Archivo ejecutable: `Ejemplo_D.java`.

```java
interface PagoPort { String pagar(BigDecimal monto); }
static final class IniciarPago {
    private final PagoPort pagos;
    IniciarPago(PagoPort pagos) { this.pagos = Objects.requireNonNull(pagos); }
    String ejecutar(BigDecimal monto) {
        if (monto.signum() <= 0) throw new IllegalArgumentException("Monto inválido");
        return pagos.pagar(monto);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
PagoPort fake = monto -> "PAGO-" + monto.toPlainString();
System.out.println(new IniciarPago(fake).ejecutar(new BigDecimal("50")));
```

Resultado esperado:

```text
PAGO-50
```

### Relación con SOLID

DIP pone el contrato en la capa que expresa la necesidad. SRP deja transporte y autenticación fuera de IniciarPago. ISP mantiene el puerto enfocado.

### Límites y errores que conviene evitar

Una interfaz en infraestructura importada por dominio puede seguir invirtiendo mal las dependencias. Verifica imports y módulos, no solo anotaciones.

### Ejercicio y comprobación

Reemplaza el fake por un adaptador HTTP sin modificar IniciarPago.

[↑ Volver al índice](#indice)



---

<a id="parte-segunda-catalogo-completo"></a>

## Parte segunda Catálogo completo

<a id="patron-1"></a>

## 1. Singleton

**Categoría:** Creacional.

### Problema y contexto

Una tabla inmutable de capacidades debe compartirse dentro del proceso, sin reconstruirla por cada operación.

### Cómo funciona y cuándo elegirlo

Un enum proporciona una instancia por constante en su contexto de carga de clases. Los consumidores reciben una interfaz; solamente la composición conoce INSTANCE. El alcance no es toda una arquitectura distribuida.

### Implementación Java

Archivo ejecutable: `Ejemplo_01.java`.

```java
interface Capacidades { boolean soporta(String banco); }
enum Catalogo implements Capacidades {
    INSTANCE;
    private final Set<String> bancos = Set.of("HN01", "GT01", "NI01", "PA01");
    public boolean soporta(String banco) { return bancos.contains(banco); }
}
static final class ValidarBanco {
    private final Capacidades catalogo;
    ValidarBanco(Capacidades catalogo) { this.catalogo = catalogo; }
    boolean ejecutar(String banco) { return catalogo.soporta(banco); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
System.out.println(new ValidarBanco(Catalogo.INSTANCE).ejecutar("GT01"));
```

Resultado esperado:

```text
true
```

### Relación con SOLID

DIP se conserva al inyectar Capacidades. SRP limita el singleton a datos inmutables. El patrón por sí solo no garantiza SOLID.

### Límites y errores que conviene evitar

Estado mutable global, pruebas contaminadas y dependencia oculta son riesgos. Un bean singleton de Spring es por contenedor y no garantiza seguridad de hilos.

### Ejercicio y comprobación

Inyecta un catálogo de prueba vacío sin utilizar Catalogo.INSTANCE.

[↑ Volver al índice](#indice)


<a id="patron-2"></a>

## 2. Factory Method

**Categoría:** Creacional.

### Problema y contexto

Un proceso exporta reportes, pero la elección del formato pertenece a otra parte del sistema.

### Cómo funciona y cuándo elegirlo

La clase creadora define una operación y delega en un método fábrica que las subclases implementan. Esta es Factory Method, acorde con la definición del archivo; Simple Factory y Abstract Factory son variantes diferentes.

### Implementación Java

Archivo ejecutable: `Ejemplo_03.java`.

```java
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
```

### Ejecución y resultado

Dentro de `main`:

```java
System.out.println(new ExportadorCsv().exportar());
```

Resultado esperado:

```text
id,monto
```

### Relación con SOLID

OCP permite otro creador; DIP hace que Exportador trabaje con Reporte; LSP exige que todo creador entregue un Reporte válido.

### Límites y errores que conviene evitar

Si solo se necesitan proveedores intercambiables, Supplier<Reporte> puede evitar herencia. No confundas una fábrica con un localizador global de servicios.

### Ejercicio y comprobación

Agrega ExportadorTexto conservando el contrato de exportar.

[↑ Volver al índice](#indice)


<a id="patron-3"></a>

## 3. Observer

**Categoría:** Comportamiento.

### Problema y contexto

Cuando se aprueba una solicitud, auditoría y notificaciones deben enterarse sin incorporarse como dependencias concretas del emisor.

### Cómo funciona y cuándo elegirlo

El sujeto guarda observadores y les comunica un evento. Este ejemplo es síncrono, local y sin durabilidad. La suscripción forma parte de la composición y puede cancelarse.

### Implementación Java

Archivo ejecutable: `Ejemplo_04.java`.

```java
interface Observador { void recibir(String evento); }
static final class Solicitudes {
    private final List<Observador> observadores = new ArrayList<>();
    void suscribir(Observador o) { observadores.add(o); }
    void retirar(Observador o) { observadores.remove(o); }
    void aprobar() {
        for (var o : List.copyOf(observadores)) o.recibir("APROBADA");
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var sujeto = new Solicitudes();
sujeto.suscribir(System.out::println);
sujeto.aprobar();
```

Resultado esperado:

```text
APROBADA
```

### Relación con SOLID

OCP permite nuevos observadores; SRP separa reacción y emisión; DIP evita depender de auditoría concreta.

### Límites y errores que conviene evitar

Una excepción puede interrumpir la notificación a otros observadores. Decide si aislar fallos o propagar; no confundas Observer con un broker persistente.

### Ejercicio y comprobación

Suscribe dos observadores y define qué ocurre si el primero falla.

[↑ Volver al índice](#indice)


<a id="patron-4"></a>

## 4. Strategy

**Categoría:** Comportamiento.

### Problema y contexto

La conversión de puntos a dinero cambia por banco y debe poder probarse sin condiciones regionales en el caso de uso.

### Cómo funciona y cuándo elegirlo

Una interfaz expresa el algoritmo, las implementaciones encapsulan reglas y un contexto invoca la estrategia inyectada. La selección se realiza en el borde de la aplicación.

### Implementación Java

Archivo ejecutable: `Ejemplo_05.java`.

```java
interface Conversion { BigDecimal convertir(long puntos); }
record Factor(BigDecimal valor) implements Conversion {
    public BigDecimal convertir(long puntos) {
        if (puntos < 0) throw new IllegalArgumentException("Puntos negativos");
        return valor.multiply(BigDecimal.valueOf(puntos));
    }
}
static final class Canjear {
    private final Conversion conversion;
    Canjear(Conversion conversion) { this.conversion = conversion; }
    BigDecimal ejecutar(long puntos) { return conversion.convertir(puntos); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var caso = new Canjear(new Factor(new BigDecimal("0.15")));
System.out.println(caso.ejecutar(100));
```

Resultado esperado:

```text
15.00
```

### Relación con SOLID

OCP admite nuevos algoritmos; DIP mantiene al contexto sobre una abstracción; LSP exige unidades y semántica comunes.

### Límites y errores que conviene evitar

No elijas políticas silenciosamente ante un banco desconocido. Factor 0.15 es un dato ilustrativo, no una regla regional vigente.

### Ejercicio y comprobación

Implementa una conversión por tramos y verifica límites de cada tramo.

[↑ Volver al índice](#indice)


<a id="patron-5"></a>

## 5. Decorator

**Categoría:** Estructural.

### Problema y contexto

Una consulta necesita medición de llamadas sin incorporar instrumentación dentro del adaptador.

### Cómo funciona y cuándo elegirlo

El decorador implementa el mismo puerto y delega en otra instancia. Se pueden componer capas de comportamiento sin ampliar el contrato de negocio.

### Implementación Java

Archivo ejecutable: `Ejemplo_06.java`.

```java
interface Consulta { String buscar(String id); }
static final class Medida implements Consulta {
    private final Consulta siguiente;
    private int llamadas;
    Medida(Consulta siguiente) { this.siguiente = siguiente; }
    public String buscar(String id) {
        llamadas++;
        return siguiente.buscar(id);
    }
    int llamadas() { return llamadas; }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var medida = new Medida(id -> "CLIENTE-" + id);
System.out.println(medida.buscar("1"));
System.out.println(medida.llamadas());
```

Resultado esperado:

```text
CLIENTE-1
1
```

### Relación con SOLID

SRP separa consulta y métrica; OCP añade capas por composición; LSP obliga a preservar resultados y errores documentados.

### Límites y errores que conviene evitar

El contador del ejemplo es para ejecución secuencial. En concurrencia usa AtomicLong o métricas apropiadas; el orden de decoradores puede alterar resultados.

### Ejercicio y comprobación

Agrega un decorador de trazas sin imprimir datos sensibles.

[↑ Volver al índice](#indice)


<a id="patron-6"></a>

## 6. Adapter

**Categoría:** Estructural.

### Problema y contexto

Un proveedor heredado devuelve códigos numéricos, mientras el dominio espera un resultado semántico.

### Cómo funciona y cuándo elegirlo

El puerto pertenece a la aplicación. El adaptador traduce protocolo, DTO y errores del proveedor; no introduce tipos del SDK en el dominio.

### Implementación Java

Archivo ejecutable: `Ejemplo_07.java`.

```java
interface EstadoTarjeta { boolean activa(String id); }
static final class Legacy {
    int consultarCodigo(String id) { return 1; }
}
static final class Adaptador implements EstadoTarjeta {
    private final Legacy cliente;
    Adaptador(Legacy cliente) { this.cliente = cliente; }
    public boolean activa(String id) {
        int codigo = cliente.consultarCodigo(id);
        return switch (codigo) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalStateException("Código desconocido");
        };
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
EstadoTarjeta puerto = new Adaptador(new Legacy());
System.out.println(puerto.activa("T1"));
```

Resultado esperado:

```text
true
```

### Relación con SOLID

DIP invierte la dependencia hacia el puerto; SRP concentra traducción; LSP evita convertir una caída remota en tarjeta inactiva.

### Límites y errores que conviene evitar

Una respuesta inesperada no debe mapearse a éxito. En WebFlux un SDK bloqueante debe aislarse de los hilos del event loop.

### Ejercicio y comprobación

Simula código 9 y comprueba que se propaga un error explícito.

[↑ Volver al índice](#indice)


<a id="patron-7"></a>

## 7. Facade

**Categoría:** Estructural.

### Problema y contexto

Un consumidor debe conocer varios componentes para obtener un resumen de solicitud y eso acopla su código a detalles del subsistema.

### Cómo funciona y cuándo elegirlo

Una fachada expone una operación de mayor nivel y coordina contratos pequeños. Las reglas complejas permanecen en componentes especializados.

### Implementación Java

Archivo ejecutable: `Ejemplo_08.java`.

```java
interface Riesgo { String evaluar(String cliente); }
interface Cupo { BigDecimal consultar(String cliente); }
record Resumen(String riesgo, BigDecimal cupo) {}
static final class Fachada {
    private final Riesgo riesgo;
    private final Cupo cupo;
    Fachada(Riesgo riesgo, Cupo cupo) { this.riesgo = riesgo; this.cupo = cupo; }
    Resumen consultar(String cliente) {
        return new Resumen(riesgo.evaluar(cliente), cupo.consultar(cliente));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var fachada = new Fachada(id -> "BAJO", id -> new BigDecimal("1000"));
System.out.println(fachada.consultar("C1"));
```

Resultado esperado:

```text
Resumen[riesgo=BAJO, cupo=1000]
```

### Relación con SOLID

ISP ofrece una entrada reducida; DIP recibe puertos; SRP limita la fachada a coordinación del subsistema.

### Límites y errores que conviene evitar

Una fachada que acumula todas las reglas se convierte en objeto omnipotente. Define timeout y respuesta parcial cuando integra servicios remotos.

### Ejercicio y comprobación

Agrega otro consumidor sin exponer internamente Riesgo y Cupo.

[↑ Volver al índice](#indice)


<a id="patron-8"></a>

## 8. Command

**Categoría:** Comportamiento.

### Problema y contexto

Una operación debe encolarse o ejecutarse por un invocador que no conoce cómo se realiza.

### Cómo funciona y cuándo elegirlo

El comando encapsula una solicitud y su receptor. Este ejemplo usa un Runnable como receptor; almacenar un comando durable exigiría un DTO serializable y resolver dependencias al consumirlo.

### Implementación Java

Archivo ejecutable: `Ejemplo_09.java`.

```java
interface Comando { void ejecutar(); }
record Bloquear(Runnable receptor) implements Comando {
    public void ejecutar() { receptor.run(); }
}
static final class Invocador {
    private final Queue<Comando> pendientes = new ArrayDeque<>();
    void agregar(Comando comando) { pendientes.add(comando); }
    void procesar() {
        while (!pendientes.isEmpty()) pendientes.remove().ejecutar();
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var invocador = new Invocador();
invocador.agregar(new Bloquear(() -> System.out.println("Bloqueada")));
invocador.procesar();
```

Resultado esperado:

```text
Bloqueada
```

### Relación con SOLID

SRP separa solicitud, invocación y receptor; OCP incorpora comandos; DIP mantiene al invocador sobre Comando.

### Límites y errores que conviene evitar

Command no garantiza idempotencia ni deshacer. Una cola local pierde mensajes al reiniciar y no sirve como garantía transaccional.

### Ejercicio y comprobación

Añade un identificador de operación y diseña deduplicación en el receptor.

[↑ Volver al índice](#indice)


<a id="patron-9"></a>

## 9. Proxy

**Categoría:** Estructural.

### Problema y contexto

El acceso a un servicio requiere autorización antes de delegar, sin contaminar su implementación.

### Cómo funciona y cuándo elegirlo

Un proxy representa al servicio e implementa el mismo contrato. Su intención es controlar el acceso; Decorator suele añadir capacidades. La forma de composición puede ser similar.

### Implementación Java

Archivo ejecutable: `Ejemplo_10.java`.

```java
interface Reportes { String leer(); }
static final class ProxyAutorizado implements Reportes {
    private final Reportes destino;
    private final BooleanSupplier permitido;
    ProxyAutorizado(Reportes destino, BooleanSupplier permitido) {
        this.destino = destino; this.permitido = permitido;
    }
    public String leer() {
        if (!permitido.getAsBoolean()) throw new SecurityException("Sin permiso");
        return destino.leer();
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
Reportes proxy = new ProxyAutorizado(() -> "Reporte", () -> true);
System.out.println(proxy.leer());
```

Resultado esperado:

```text
Reporte
```

### Relación con SOLID

SRP separa autorización; DIP depende de Reportes; LSP requiere que la posibilidad de rechazo esté documentada en el contrato público.

### Límites y errores que conviene evitar

Un booleano de ejemplo no sustituye validación de identidad y políticas. El proxy local no impide acceder por otra ruta al servicio protegido.

### Ejercicio y comprobación

Comprueba que permiso false no invoca el destino.

[↑ Volver al índice](#indice)


<a id="patron-10"></a>

## 10. Template Method

**Categoría:** Comportamiento.

### Problema y contexto

Los archivos de diferentes proveedores comparten validar y procesar, pero difieren en cómo interpretar su contenido.

### Cómo funciona y cuándo elegirlo

Una clase base define el orden fijo mediante un método final; las subclases implementan pasos de variación. Se usa herencia cuando el ciclo común es estable.

### Implementación Java

Archivo ejecutable: `Ejemplo_11.java`.

```java
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
```

### Ejecución y resultado

Dentro de `main`:

```java
System.out.println(new Csv().importar("A,B,C"));
```

Resultado esperado:

```text
3
```

### Relación con SOLID

OCP permite pasos nuevos; LSP impide que una subclase debilite el resultado prometido; SRP mantiene el flujo separado de formato.

### Límites y errores que conviene evitar

Herencia profunda vuelve frágiles los contratos. Usa Strategy si necesitas intercambiar pasos en tiempo de ejecución. Este parser no maneja CSV con comillas.

### Ejercicio y comprobación

Implementa otro formato conservando validación y orden de pasos.

[↑ Volver al índice](#indice)


<a id="patron-11"></a>

## 11. Builder

**Categoría:** Creacional.

### Problema y contexto

Una solicitud con campos opcionales y restricciones cruzadas es difícil de construir con un constructor posicional largo.

### Cómo funciona y cuándo elegirlo

El builder acumula datos y valida al construir. El producto es un record inmutable. Los defaults deben ser explícitos y no ocultar datos obligatorios.

### Implementación Java

Archivo ejecutable: `Ejemplo_12.java`.

```java
record Solicitud(String cliente, BigDecimal monto) {
    Solicitud {
        Objects.requireNonNull(cliente); Objects.requireNonNull(monto);
        if (cliente.isBlank() || monto.signum() <= 0)
            throw new IllegalArgumentException("Solicitud inválida");
    }
}
static final class Builder {
    private String cliente;
    private BigDecimal monto;
    Builder cliente(String valor) { cliente = valor; return this; }
    Builder monto(String valor) { monto = new BigDecimal(valor); return this; }
    Solicitud build() { return new Solicitud(cliente, monto); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
System.out.println(new Builder().cliente("C1").monto("50").build());
```

Resultado esperado:

```text
Solicitud[cliente=C1, monto=50]
```

### Relación con SOLID

SRP separa construcción y producto; LSP mantiene invariantes del producto por cualquier vía de creación. El builder no necesita una interfaz artificial.

### Límites y errores que conviene evitar

No compartas builders mutables entre solicitudes. Validar solo en el builder permitiría saltar restricciones mediante el constructor.

### Ejercicio y comprobación

Agrega moneda y comprueba que ninguna vía permite monto no positivo.

[↑ Volver al índice](#indice)


<a id="patron-12"></a>

## 12. Composite

**Categoría:** Estructural.

### Problema y contexto

Una cartera contiene cuentas y subcarteras, pero el consumidor quiere calcular el saldo de ambos con la misma operación.

### Cómo funciona y cuándo elegirlo

Hoja y compuesto implementan un componente común. El compuesto delega a sus hijos y agrega los resultados; el árbol debe evitar ciclos.

### Implementación Java

Archivo ejecutable: `Ejemplo_13.java`.

```java
interface Componente { BigDecimal saldo(); }
record Cuenta(BigDecimal valor) implements Componente {
    public BigDecimal saldo() { return valor; }
}
record Cartera(List<Componente> hijos) implements Componente {
    Cartera { hijos = List.copyOf(hijos); }
    public BigDecimal saldo() {
        return hijos.stream().map(Componente::saldo)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var cartera = new Cartera(List.of(new Cuenta(new BigDecimal("10")),
    new Cartera(List.of(new Cuenta(new BigDecimal("20"))))));
System.out.println(cartera.saldo());
```

Resultado esperado:

```text
30
```

### Relación con SOLID

LSP permite tratar hojas y conjuntos igual; OCP agrega componentes; ISP evita obligar a una hoja a agregar hijos.

### Límites y errores que conviene evitar

Árboles profundos pueden agotar la pila. No incluyas operaciones de mutación de hijos en el contrato de las hojas.

### Ejercicio y comprobación

Agrega una hoja con saldo calculado sin modificar Cartera.

[↑ Volver al índice](#indice)


<a id="patron-13"></a>

## 13. State

**Categoría:** Comportamiento.

### Problema y contexto

Una tarjeta puede bloquearse únicamente desde un estado permitido; condiciones dispersas hacen inconsistentes las transiciones.

### Cómo funciona y cuándo elegirlo

Cada estado decide el siguiente estado. El contexto conserva el estado actual. Un evento no permitido produce un error explícito que forma parte del contrato.

### Implementación Java

Archivo ejecutable: `Ejemplo_14.java`.

```java
interface Estado { Estado bloquear(); String nombre(); }
record Activa() implements Estado {
    public Estado bloquear() { return new Bloqueada(); }
    public String nombre() { return "ACTIVA"; }
}
record Bloqueada() implements Estado {
    public Estado bloquear() { return this; }
    public String nombre() { return "BLOQUEADA"; }
}
static final class Tarjeta {
    private Estado estado = new Activa();
    void bloquear() { estado = estado.bloquear(); }
    String estado() { return estado.nombre(); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var tarjeta = new Tarjeta();
tarjeta.bloquear(); tarjeta.bloquear();
System.out.println(tarjeta.estado());
```

Resultado esperado:

```text
BLOQUEADA
```

### Relación con SOLID

SRP concentra comportamiento por estado; OCP permite nuevos estados; LSP exige una semántica común de bloquear, aquí idempotente.

### Límites y errores que conviene evitar

En persistencia concurrente se necesita control de versión. State describe comportamiento por estado; Strategy describe algoritmos seleccionados independientemente.

### Ejercicio y comprobación

Agrega Cancelada y define explícitamente si bloquear es rechazado o idempotente.

[↑ Volver al índice](#indice)


<a id="patron-14"></a>

## 14. Mediator

**Categoría:** Comportamiento.

### Problema y contexto

Varios componentes de una solicitud necesitan coordinar validación y notificación sin referencias cruzadas entre ellos.

### Cómo funciona y cuándo elegirlo

El mediador conoce los roles y coordina una interacción acotada. Los colaboradores no se llaman mutuamente. Su responsabilidad es la colaboración, no todas las reglas.

### Implementación Java

Archivo ejecutable: `Ejemplo_15.java`.

```java
interface Validacion { boolean valida(String id); }
interface Notificacion { void enviar(String id); }
static final class Mediador {
    private final Validacion validacion;
    private final Notificacion notificacion;
    Mediador(Validacion v, Notificacion n) { validacion = v; notificacion = n; }
    void presentar(String id) {
        if (validacion.valida(id)) notificacion.enviar(id);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var mediador = new Mediador(id -> !id.isBlank(), System.out::println);
mediador.presentar("S1");
```

Resultado esperado:

```text
S1
```

### Relación con SOLID

DIP utiliza contratos de colaboradores; SRP elimina coordinación duplicada; ISP mantiene roles pequeños.

### Límites y errores que conviene evitar

Un mediador universal se vuelve un cuello de cambio. Una fachada simplifica un subsistema; un mediador administra interacciones de colegas.

### Ejercicio y comprobación

Agrega un colaborador de auditoría sin introducir referencias entre validación y notificación.

[↑ Volver al índice](#indice)


<a id="patron-15"></a>

## 15. Chain of Responsibility

**Categoría:** Comportamiento.

### Problema y contexto

Una solicitud puede ser rechazada por diferentes validaciones y el orden de evaluación debe ser configurable.

### Cómo funciona y cuándo elegirlo

Cada manejador atiende o delega. En esta variante de validación, un rechazo detiene la cadena y el éxito continúa. El último manejador define el caso terminal.

### Implementación Java

Archivo ejecutable: `Ejemplo_16.java`.

```java
interface Manejador { String procesar(int monto); }
static final class Positivo implements Manejador {
    private final Manejador siguiente;
    Positivo(Manejador siguiente) { this.siguiente = siguiente; }
    public String procesar(int monto) {
        return monto <= 0 ? "RECHAZADO" : siguiente.procesar(monto);
    }
}
static final class Limite implements Manejador {
    public String procesar(int monto) { return monto > 1000 ? "EXCEDE" : "ACEPTADO"; }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
Manejador cadena = new Positivo(new Limite());
System.out.println(cadena.procesar(50));
```

Resultado esperado:

```text
ACEPTADO
```

### Relación con SOLID

OCP admite manejadores; DIP conecta por Manejador; SRP asigna una condición a cada eslabón.

### Límites y errores que conviene evitar

Orden y terminal son parte del comportamiento. Una cadena no debe caer silenciosamente en ausencia de respuesta ni formar ciclos.

### Ejercicio y comprobación

Inserta validación de banco y verifica que un rechazo no invoque el siguiente paso.

[↑ Volver al índice](#indice)


<a id="patron-16"></a>

## 16. Visitor

**Categoría:** Comportamiento.

### Problema y contexto

Una estructura estable contiene tipos distintos de productos y recibe frecuentemente operaciones nuevas, como reportes o auditorías.

### Cómo funciona y cuándo elegirlo

El elemento acepta un visitante y este sobrecarga una operación por tipo. El doble despacho selecciona tanto el tipo del elemento como la operación.

### Implementación Java

Archivo ejecutable: `Ejemplo_17.java`.

```java
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
```

### Ejecución y resultado

Dentro de `main`:

```java
Producto producto = new Tarjeta("T1");
System.out.println(producto.aceptar(new Etiquetas()));
```

Resultado esperado:

```text
Tarjeta T1
```

### Relación con SOLID

SRP separa operación y estructura; OCP se cumple para nuevas operaciones, pero añadir tipos exige cambiar Visitante. Este costo debe aceptarse explícitamente.

### Límites y errores que conviene evitar

Visitor es mala elección si cambian más los tipos que las operaciones. No expongas estado privado excesivo para que el visitante trabaje.

### Ejercicio y comprobación

Agrega un visitante de auditoría y luego un tipo Préstamo; compara el impacto.

[↑ Volver al índice](#indice)


<a id="patron-17"></a>

## 17. Bridge

**Categoría:** Estructural.

### Problema y contexto

Notificaciones urgentes y normales pueden viajar por diferentes canales; heredar una clase por cada combinación multiplica tipos.

### Cómo funciona y cuándo elegirlo

La abstracción de notificación contiene un implementador de canal. Cada dimensión puede extenderse independientemente. Adapter integra algo existente; Bridge planifica dos ejes de variación.

### Implementación Java

Archivo ejecutable: `Ejemplo_18.java`.

```java
interface Canal { void enviar(String mensaje); }
static abstract class Aviso {
    protected final Canal canal;
    Aviso(Canal canal) { this.canal = canal; }
    abstract void publicar(String texto);
}
static final class Urgente extends Aviso {
    Urgente(Canal canal) { super(canal); }
    void publicar(String texto) { canal.enviar("URGENTE " + texto); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
new Urgente(System.out::println).publicar("Operación pendiente");
```

Resultado esperado:

```text
URGENTE Operación pendiente
```

### Relación con SOLID

OCP extiende ambos ejes; DIP recibe Canal; SRP separa prioridad y transporte.

### Límites y errores que conviene evitar

Si solo varía un eje, una estrategia simple basta. Define qué garantías ofrecen todos los canales sobre entrega y errores.

### Ejercicio y comprobación

Agrega AvisoNormal y un Canal que almacene mensajes para pruebas.

[↑ Volver al índice](#indice)


<a id="patron-18"></a>

## 18. Flyweight

**Categoría:** Estructural.

### Problema y contexto

Millones de operaciones comparten una misma descripción inmutable de moneda, mientras sus montos son diferentes.

### Cómo funciona y cuándo elegirlo

El estado intrínseco se comparte desde una fábrica; el estado extrínseco permanece en cada operación. La clave de caché debe representar toda la identidad del objeto compartido.

### Implementación Java

Archivo ejecutable: `Ejemplo_19.java`.

```java
record Moneda(String codigo) {}
static final class Monedas {
    private final ConcurrentHashMap<String, Moneda> cache = new ConcurrentHashMap<>();
    Moneda obtener(String codigo) {
        return cache.computeIfAbsent(codigo, Moneda::new);
    }
}
record Operacion(BigDecimal monto, Moneda moneda) {}
```

### Ejecución y resultado

Dentro de `main`:

```java
var fabrica = new Monedas();
var a = fabrica.obtener("USD");
var b = fabrica.obtener("USD");
System.out.println(a == b);
```

Resultado esperado:

```text
true
```

### Relación con SOLID

SRP separa compartición y operación; la inmutabilidad evita que un usuario altere el estado de otros. No necesita herencia ni una interfaz sin finalidad.

### Límites y errores que conviene evitar

Una caché sin límite crece indefinidamente si las claves son abiertas. Medir memoria antes de introducir Flyweight; no compartir datos de cliente mutables.

### Ejercicio y comprobación

Incluye precisión en la clave si dos monedas con el mismo código pueden tener distinta configuración.

[↑ Volver al índice](#indice)


<a id="patron-19"></a>

## 19. Prototype

**Categoría:** Creacional.

### Problema y contexto

Una plantilla configurada sirve como base para varias solicitudes, cada una con opciones independientes.

### Cómo funciona y cuándo elegirlo

El prototipo expone una copia explícita. El ejemplo copia la colección mutable; sus elementos String son inmutables. Evita depender de Cloneable y de copias superficiales inadvertidas.

### Implementación Java

Archivo ejecutable: `Ejemplo_20.java`.

```java
interface Copiable<T> { T copiar(); }
static final class Plantilla implements Copiable<Plantilla> {
    private final List<String> campos;
    Plantilla(List<String> campos) { this.campos = new ArrayList<>(campos); }
    public Plantilla copiar() { return new Plantilla(campos); }
    void agregar(String campo) { campos.add(campo); }
    List<String> campos() { return List.copyOf(campos); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var base = new Plantilla(List.of("cliente"));
var copia = base.copiar(); copia.agregar("monto");
System.out.println(base.campos());
System.out.println(copia.campos());
```

Resultado esperado:

```text
[cliente]
[cliente, monto]
```

### Relación con SOLID

SRP ubica la semántica de copia en el objeto; LSP exige copias independientes según contrato; ISP expresa únicamente copiar.

### Límites y errores que conviene evitar

Copiar conexiones, secretos o identificadores persistentes puede ser incorrecto. Con elementos mutables se requiere decidir copia profunda para cada campo.

### Ejercicio y comprobación

Usa elementos mutables y escribe una prueba que detecte alias compartidos.

[↑ Volver al índice](#indice)


<a id="patron-20"></a>

## 20. Memento

**Categoría:** Comportamiento.

### Problema y contexto

Un editor de solicitud permite restaurar una versión previa sin que el historial manipule directamente los campos del editor.

### Cómo funciona y cuándo elegirlo

El originador produce y restaura snapshots. El cuidador almacena el memento sin alterarlo. El estado capturado es inmutable y de tamaño acotado.

### Implementación Java

Archivo ejecutable: `Ejemplo_21.java`.

```java
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
```

### Ejecución y resultado

Dentro de `main`:

```java
var editor = new Editor(); var historial = new Historial();
editor.escribir("A"); historial.agregar(editor.guardar());
editor.escribir("B"); editor.restaurar(historial.ultimo());
System.out.println(editor.leer());
```

Resultado esperado:

```text
A
```

### Relación con SOLID

SRP separa estado e historial; el cuidador trata el snapshot como un valor. El ejemplo expone texto por simplicidad; un memento opaco puede encapsularlo más.

### Límites y errores que conviene evitar

Un snapshot puede contener datos sensibles y ocupar mucha memoria. Restaurar una pantalla no revierte una transacción externa.

### Ejercicio y comprobación

Limita el historial a diez entradas y documenta qué significa deshacer tras persistir.

[↑ Volver al índice](#indice)


<a id="patron-21"></a>

## 21. Interpreter

**Categoría:** Comportamiento.

### Problema y contexto

Un conjunto pequeño de reglas debe combinar condiciones booleanas de manera expresiva.

### Cómo funciona y cuándo elegirlo

Las expresiones forman un árbol sintáctico y se evalúan sobre un contexto. Aquí el árbol se construye en Java; no se implementa un parser de texto.

### Implementación Java

Archivo ejecutable: `Ejemplo_22.java`.

```java
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
```

### Ejecución y resultado

Dentro de `main`:

```java
Expresion regla = new Y(new MayorDeEdad(), new Consiente());
System.out.println(regla.evaluar(new Contexto(25, true)));
```

Resultado esperado:

```text
true
```

### Relación con SOLID

OCP admite expresiones; SRP separa nodos y evaluación; LSP exige que todas las expresiones respondan el mismo contrato booleano.

### Límites y errores que conviene evitar

No uses eval ni ejecutes código de entrada. Para gramáticas grandes adopta un parser formal, límites de profundidad y validación de recursos.

### Ejercicio y comprobación

Agrega O y No y prueba las tablas de verdad.

[↑ Volver al índice](#indice)


<a id="patron-22"></a>

## 22. DAO

**Categoría:** Persistencia.

### Problema y contexto

El acceso a filas o documentos debe aislarse del cálculo de negocio para evitar SQL disperso.

### Cómo funciona y cuándo elegirlo

El DAO representa operaciones cercanas al almacenamiento y devuelve un DTO de fila. El ejemplo utiliza memoria; el adaptador JDBC real alojaría SQL, conexión y mapeo.

### Implementación Java

Archivo ejecutable: `Ejemplo_23.java`.

```java
record ClienteFila(String id, String nombre) {}
interface ClienteDao { Optional<ClienteFila> seleccionar(String id); }
static final class MemoriaDao implements ClienteDao {
    private final Map<String, ClienteFila> filas;
    MemoriaDao(Map<String, ClienteFila> filas) { this.filas = Map.copyOf(filas); }
    public Optional<ClienteFila> seleccionar(String id) {
        return Optional.ofNullable(filas.get(id));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
ClienteDao dao = new MemoriaDao(Map.of("1", new ClienteFila("1", "Ana")));
System.out.println(dao.seleccionar("1").orElseThrow().nombre());
```

Resultado esperado:

```text
Ana
```

### Relación con SOLID

SRP concentra acceso a datos; DIP permite cambiar el adaptador. Los tipos de persistencia no deben invadir reglas del dominio.

### Límites y errores que conviene evitar

DAO y Repository no son sinónimos exactos. DAO suele exponer datos de almacenamiento; Repository usa lenguaje de agregados. En JDBC parametriza SQL y cierra recursos.

### Ejercicio y comprobación

Agrega un adaptador con error de infraestructura sin convertir ese error en Optional vacío.

[↑ Volver al índice](#indice)


<a id="patron-23"></a>

## 23. Repository

**Categoría:** Persistencia y dominio.

### Problema y contexto

El dominio necesita recuperar agregados sin conocer tablas, filas ni consultas concretas.

### Cómo funciona y cuándo elegirlo

El repositorio actúa como colección de agregados. Su interfaz usa lenguaje del dominio. El ejemplo devuelve valores inmutables y una implementación en memoria.

### Implementación Java

Archivo ejecutable: `Ejemplo_24.java`.

```java
record Solicitud(String id, String estado) {}
interface Solicitudes {
    Optional<Solicitud> porId(String id);
    void guardar(Solicitud solicitud);
}
static final class Memoria implements Solicitudes {
    private final Map<String, Solicitud> datos = new HashMap<>();
    public Optional<Solicitud> porId(String id) { return Optional.ofNullable(datos.get(id)); }
    public void guardar(Solicitud solicitud) { datos.put(solicitud.id(), solicitud); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
Solicitudes repo = new Memoria();
repo.guardar(new Solicitud("S1", "ABIERTA"));
System.out.println(repo.porId("S1").orElseThrow().estado());
```

Resultado esperado:

```text
ABIERTA
```

### Relación con SOLID

DIP protege dominio de persistencia; ISP puede separar lectura y escritura; LSP define ausencia, identidad y errores de forma consistente.

### Límites y errores que conviene evitar

El ejemplo no ofrece aislamiento ni versión optimista. Un repositorio por tabla suele perder la noción de agregado y sus invariantes.

### Ejercicio y comprobación

Añade versión al agregado y rechaza dos actualizaciones concurrentes con la misma versión.

[↑ Volver al índice](#indice)


<a id="patron-24"></a>

## 24. Service Layer

**Categoría:** Aplicación.

### Problema y contexto

Los controladores deben ofrecer operaciones de negocio sin duplicar coordinación entre validación, repositorio y reglas.

### Cómo funciona y cuándo elegirlo

La capa de aplicación delimita casos de uso y transacciones. El servicio orquesta; el dominio mantiene invariantes. Aquí el repositorio es un puerto y el resultado no es un DTO HTTP.

### Implementación Java

Archivo ejecutable: `Ejemplo_25.java`.

```java
record Solicitud(String id, String estado) {}
interface Repositorio { void guardar(Solicitud solicitud); }
static final class AbrirSolicitud {
    private final Repositorio repo;
    AbrirSolicitud(Repositorio repo) { this.repo = repo; }
    Solicitud ejecutar(String id) {
        if (id.isBlank()) throw new IllegalArgumentException("Identidad requerida");
        var solicitud = new Solicitud(id, "ABIERTA");
        repo.guardar(solicitud);
        return solicitud;
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var servicio = new AbrirSolicitud(s -> {});
System.out.println(servicio.ejecutar("S1").estado());
```

Resultado esperado:

```text
ABIERTA
```

### Relación con SOLID

SRP distingue orquestación y transporte; DIP inyecta repositorio; ISP evita un servicio con cientos de operaciones no relacionadas.

### Límites y errores que conviene evitar

No conviertas toda regla en un service genérico y dejes entidades anémicas. Una llamada remota no participa automáticamente en la transacción local.

### Ejercicio y comprobación

Escribe una prueba que compruebe que un id vacío no guarda nada.

[↑ Volver al índice](#indice)


<a id="patron-25"></a>

## 25. Microservices

**Categoría:** Arquitectura distribuida.

### Problema y contexto

Una capacidad de negocio requiere despliegue, propiedad y escalado independientes de otras capacidades.

### Cómo funciona y cuándo elegirlo

Cada servicio posee su modelo y datos, y se comunica por contratos explícitos. El ejemplo representa el puerto entre servicios; una lambda simula el adaptador remoto, no un despliegue real.

### Implementación Java

Archivo ejecutable: `Ejemplo_26.java`.

```java
record Perfil(String id, String segmento) {}
interface ClientesRemotos { Perfil consultar(String id); }
static final class EvaluarCredito {
    private final ClientesRemotos clientes;
    EvaluarCredito(ClientesRemotos clientes) { this.clientes = clientes; }
    String ejecutar(String id) {
        var perfil = clientes.consultar(id);
        return perfil.segmento().equals("ESTANDAR") ? "EVALUABLE" : "REVISAR";
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var servicio = new EvaluarCredito(id -> new Perfil(id, "ESTANDAR"));
System.out.println(servicio.ejecutar("C1"));
```

Resultado esperado:

```text
EVALUABLE
```

### Relación con SOLID

DIP separa política y transporte; SRP orienta límites por capacidad. SOLID mejora clases internas, pero no determina por sí solo bounded contexts.

### Límites y errores que conviene evitar

Dividir por entidades o tablas puede producir un monolito distribuido. Debes resolver contratos, timeouts, observabilidad, datos propios y fallos parciales.

### Ejercicio y comprobación

Diseña dos contratos versionados y especifica qué ocurre si Clientes no responde.

[↑ Volver al índice](#indice)


<a id="patron-26"></a>

## 26. Event Driven Architecture

**Categoría:** Arquitectura distribuida.

### Problema y contexto

Varias capacidades deben reaccionar a hechos sin que el productor conozca todos los consumidores.

### Cómo funciona y cuándo elegirlo

Un evento describe algo ocurrido, con identidad y versión. El publicador es un puerto; el broker simulado opera en el proceso. En producción se agrega almacenamiento durable y entrega con semántica explícita.

### Implementación Java

Archivo ejecutable: `Ejemplo_27.java`.

```java
record Evento(String id, int version, String solicitud) {}
interface Publicador { void publicar(Evento evento); }
static final class BusLocal implements Publicador {
    private final List<Consumer<Evento>> consumidores = new ArrayList<>();
    void suscribir(Consumer<Evento> consumidor) { consumidores.add(consumidor); }
    public void publicar(Evento evento) {
        for (var consumidor : List.copyOf(consumidores)) consumidor.accept(evento);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var bus = new BusLocal();
bus.suscribir(e -> System.out.println(e.solicitud()));
bus.publicar(new Evento("E1", 1, "S1"));
```

Resultado esperado:

```text
S1
```

### Relación con SOLID

DIP usa Publicador; OCP incorpora consumidores; SRP diferencia hecho, publicación y reacción.

### Límites y errores que conviene evitar

No presupongas exactly once. Con entrega al menos una vez exige idempotencia; usa outbox para vincular escritura local y publicación, DLQ y versionado de esquema.

### Ejercicio y comprobación

Publica E1 dos veces y diseña una reacción idempotente que procese una sola vez.

[↑ Volver al índice](#indice)


<a id="patron-27"></a>

## 27. Serverless Architecture

**Categoría:** Modelo de ejecución.

### Problema y contexto

Una operación esporádica puede ejecutarse por invocación sin administrar directamente servidores de aplicación.

### Cómo funciona y cuándo elegirlo

Un handler traduce la entrada y llama a un caso de uso inyectado. El ejemplo es independiente de proveedor; desplegar requiere un runtime, configuración, identidad y un adaptador de entrada del proveedor.

### Implementación Java

Archivo ejecutable: `Ejemplo_28.java`.

```java
record Entrada(String cliente) {}
record Salida(String estado) {}
interface Evaluacion { String ejecutar(String cliente); }
static final class Handler {
    private final Evaluacion evaluacion;
    Handler(Evaluacion evaluacion) { this.evaluacion = evaluacion; }
    Salida manejar(Entrada entrada) {
        return new Salida(evaluacion.ejecutar(entrada.cliente()));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var handler = new Handler(cliente -> "EVALUABLE");
System.out.println(handler.manejar(new Entrada("C1")).estado());
```

Resultado esperado:

```text
EVALUABLE
```

### Relación con SOLID

SRP separa handler y negocio; DIP evita dependencia del dominio con un SDK; ISP limita la entrada al caso de uso.

### Límites y errores que conviene evitar

Persistir estado en campos del handler no garantiza durabilidad. Considera cold start, reintentos, concurrencia, límites y pooling de conexiones; serverless no elimina servidores.

### Ejercicio y comprobación

Invoca el mismo evento dos veces y decide dónde almacenar la clave idempotente.

[↑ Volver al índice](#indice)


<a id="patron-28"></a>

## 28. CQRS

**Categoría:** Arquitectura de aplicación.

### Problema y contexto

La representación requerida para consultar es diferente de las invariantes necesarias para actualizar.

### Cómo funciona y cuándo elegirlo

Separar comandos y consultas permite evolucionar ambos modelos. El ejemplo comparte almacenamiento y evita introducir consistencia eventual artificial; CQRS no exige bases separadas ni Event Sourcing.

### Implementación Java

Archivo ejecutable: `Ejemplo_29.java`.

```java
record Vista(String id, String estado) {}
interface Comandos { void abrir(String id); }
interface Consultas { Optional<Vista> consultar(String id); }
static final class Modelo implements Comandos, Consultas {
    private final Map<String, String> estados = new HashMap<>();
    public void abrir(String id) {
        if (estados.putIfAbsent(id, "ABIERTA") != null)
            throw new IllegalStateException("Ya existe");
    }
    public Optional<Vista> consultar(String id) {
        return Optional.ofNullable(estados.get(id)).map(e -> new Vista(id, e));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var modelo = new Modelo();
Comandos comandos = modelo; Consultas consultas = modelo;
comandos.abrir("S1");
System.out.println(consultas.consultar("S1").orElseThrow().estado());
```

Resultado esperado:

```text
ABIERTA
```

### Relación con SOLID

ISP expresa contratos separados; SRP separa intención de cambio y lectura. DIP puede distribuir puertos a adaptadores diferentes.

### Límites y errores que conviene evitar

CQRS agrega complejidad cuando un CRUD simple basta. Si separas proyecciones, documenta retraso, read your writes y reconstrucción.

### Ejercicio y comprobación

Implementa una proyección asíncrona y define qué verá una consulta justo después del comando.

[↑ Volver al índice](#indice)


<a id="patron-29"></a>

## 29. Event Sourcing

**Categoría:** Persistencia de estado.

### Problema y contexto

Es necesario reconstruir cómo evolucionó un agregado y no solamente conservar su último estado.

### Cómo funciona y cuándo elegirlo

El estado se reconstruye aplicando hechos ordenados. El stream es la fuente de verdad; la transición es determinista y no realiza llamadas externas durante replay. El ejemplo conserva eventos en memoria.

### Implementación Java

Archivo ejecutable: `Ejemplo_30.java`.

```java
interface Evento {}
record Abierta(String id) implements Evento {}
record Aprobada() implements Evento {}
static final class Solicitud {
    private String estado = "INEXISTENTE";
    void aplicar(Evento evento) {
        if (evento instanceof Abierta) estado = "ABIERTA";
        else if (evento instanceof Aprobada) estado = "APROBADA";
        else throw new IllegalArgumentException("Evento desconocido");
    }
    String estado() { return estado; }
}
static Solicitud reconstruir(List<Evento> stream) {
    var solicitud = new Solicitud(); stream.forEach(solicitud::aplicar); return solicitud;
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var stream = List.<Evento>of(new Abierta("S1"), new Aprobada());
System.out.println(reconstruir(stream).estado());
```

Resultado esperado:

```text
APROBADA
```

### Relación con SOLID

SRP diferencia decisión, persistencia y aplicación de eventos. DIP deja el event store fuera del agregado. OCP se gestiona mediante evolución deliberada del esquema.

### Límites y errores que conviene evitar

Un log de auditoría no es Event Sourcing. En producción necesitas append atómico con versión esperada, validación de secuencia, snapshots opcionales y estrategia de datos personales.

### Ejercicio y comprobación

Agrega un comando aprobar que solo emita Aprobada desde ABIERTA y rechace una versión obsoleta.

[↑ Volver al índice](#indice)


<a id="patron-30"></a>

## 30. Saga

**Categoría:** Consistencia distribuida.

### Problema y contexto

Una operación debe reservar fondos y emitir un producto en servicios con transacciones locales independientes.

### Cómo funciona y cuándo elegirlo

La saga orquestada ejecuta pasos y, ante un fallo conocido, compensa los ya completados. Cada paso y compensación recibe un identificador estable. Aquí se simula únicamente el camino de compensación en proceso.

### Implementación Java

Archivo ejecutable: `Ejemplo_31.java`.

```java
interface Fondos { void reservar(String id); void liberar(String id); }
interface Emision { void emitir(String id); }
static final class Saga {
    private final Fondos fondos;
    private final Emision emision;
    Saga(Fondos fondos, Emision emision) { this.fondos = fondos; this.emision = emision; }
    void ejecutar(String id) {
        fondos.reservar(id);
        try { emision.emitir(id); }
        catch (RuntimeException original) {
            try { fondos.liberar(id); }
            catch (RuntimeException compensacion) { original.addSuppressed(compensacion); }
            throw original;
        }
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
Fondos fondos = new Fondos() {
    public void reservar(String id) { System.out.println("Reservado " + id); }
    public void liberar(String id) { System.out.println("Liberado " + id); }
};
try { new Saga(fondos, id -> { throw new IllegalStateException("Fallo conocido"); }).ejecutar("S1"); }
catch (IllegalStateException e) { System.out.println(e.getMessage()); }
```

Resultado esperado:

```text
Reservado S1
Liberado S1
Fallo conocido
```

### Relación con SOLID

SRP concentra coordinación; DIP usa puertos; LSP exige semántica de compensación e idempotencia documentada.

### Límites y errores que conviene evitar

Compensar no es rollback ACID. Un timeout deja resultado incierto: antes de liberar consulta o reconcilia el estado. Persiste pasos y reintentos; si compensar falla exige recuperación.

### Ejercicio y comprobación

Simula caída del proceso tras reservar y diseña reanudación con estado persistente.

[↑ Volver al índice](#indice)


<a id="patron-31"></a>

## 31. Circuit Breaker

**Categoría:** Resiliencia.

### Problema y contexto

Una dependencia fallida recibe llamadas repetidas que consumen tiempo y recursos del servicio llamador.

### Cómo funciona y cuándo elegirlo

El circuito transita CLOSED, OPEN y HALF_OPEN. El ejemplo secuencial usa umbral de fallos consecutivos y reloj monotónico inyectado; una llamada tras el enfriamiento funciona como prueba.

### Implementación Java

Archivo ejecutable: `Ejemplo_32.java`.

```java
static final class Circuito {
    enum Estado { CLOSED, OPEN, HALF_OPEN }
    private Estado estado = Estado.CLOSED;
    private int fallos;
    private long reabrir;
    private final LongSupplier reloj;
    Circuito(LongSupplier reloj) { this.reloj = reloj; }
    String llamar(Supplier<String> destino) {
        long ahora = reloj.getAsLong();
        if (estado == Estado.OPEN) {
            if (ahora < reabrir) throw new IllegalStateException("Circuito abierto");
            estado = Estado.HALF_OPEN;
        }
        try {
            String respuesta = destino.get(); fallos = 0; estado = Estado.CLOSED;
            return respuesta;
        } catch (RuntimeException e) {
            if (estado == Estado.HALF_OPEN || ++fallos >= 2) {
                estado = Estado.OPEN; reabrir = ahora + 1000;
            }
            throw e;
        }
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var ahora = new AtomicLong(0); var circuito = new Circuito(ahora::get);
for (int i = 0; i < 2; i++) {
    try { circuito.llamar(() -> { throw new IllegalStateException("Remoto caído"); }); }
    catch (IllegalStateException e) { }
}
try { circuito.llamar(() -> "OK"); }
catch (IllegalStateException e) { System.out.println(e.getMessage()); }
ahora.set(1000);
System.out.println(circuito.llamar(() -> "Recuperado"));
```

Resultado esperado:

```text
Circuito abierto
Recuperado
```

### Relación con SOLID

SRP separa política de fallos; DIP inyecta reloj y operación. El circuito no debe modificar la semántica de errores de dominio.

### Límites y errores que conviene evitar

No es una implementación concurrente de producción. Usa una biblioteca probada, clasifica errores y limita pruebas HALF_OPEN. Circuit Breaker no reemplaza timeout ni retry.

### Ejercicio y comprobación

Comprueba que un circuito abierto no invoca al proveedor y que una prueba fallida vuelve a OPEN.

[↑ Volver al índice](#indice)


<a id="patron-32"></a>

## 32. Bulkhead

**Categoría:** Resiliencia.

### Problema y contexto

Un proveedor lento consume todos los recursos y deja indisponibles operaciones que usan otro proveedor.

### Cómo funciona y cuándo elegirlo

Se reserva capacidad independiente por dependencia. Un semáforo sin cola rechaza al superar el cupo; finalmente devuelve el permiso. Es un bulkhead de concurrencia, no de tasa.

### Implementación Java

Archivo ejecutable: `Ejemplo_33.java`.

```java
static final class Aislamiento {
    private final Semaphore cupos;
    Aislamiento(int maximo) { cupos = new Semaphore(maximo); }
    String ejecutar(Supplier<String> destino) {
        if (!cupos.tryAcquire()) throw new IllegalStateException("Sin capacidad");
        try { return destino.get(); }
        finally { cupos.release(); }
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var proveedorA = new Aislamiento(1); var proveedorB = new Aislamiento(1);
System.out.println(proveedorA.ejecutar(() -> "A"));
System.out.println(proveedorB.ejecutar(() -> "B"));
```

Resultado esperado:

```text
A
B
```

### Relación con SOLID

SRP separa capacidad y negocio; DIP recibe la operación; cada proveedor debe usar su propio aislamiento.

### Límites y errores que conviene evitar

Un único semáforo global destruye la separación. En código reactivo el permiso se libera al terminar o cancelar el publisher, no al construir un Mono.

### Ejercicio y comprobación

Ejecuta dos llamadas concurrentes a A y verifica que la saturación no rechaza B.

[↑ Volver al índice](#indice)


<a id="patron-33"></a>

## 33. Throttling

**Categoría:** Control de carga.

### Problema y contexto

Las solicitudes entran más rápido de lo que una dependencia puede procesar y se requiere espaciar el consumo.

### Cómo funciona y cuándo elegirlo

El throttling regula el flujo. Esta variante acepta trabajo en una cola acotada y ejecuta como máximo una tarea por pulso externo. No bloquea hilos para esperar; el scheduler no se implementa aquí.

### Implementación Java

Archivo ejecutable: `Ejemplo_34.java`.

```java
static final class Regulador {
    private final BlockingQueue<Runnable> cola = new ArrayBlockingQueue<>(2);
    boolean aceptar(Runnable tarea) { return cola.offer(tarea); }
    void pulso() {
        var tarea = cola.poll(); if (tarea != null) tarea.run();
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var regulador = new Regulador();
regulador.aceptar(() -> System.out.println("A"));
regulador.aceptar(() -> System.out.println("B"));
System.out.println(regulador.aceptar(() -> {}));
regulador.pulso(); regulador.pulso();
```

Resultado esperado:

```text
false
A
B
```

### Relación con SOLID

SRP separa admisión y ritmo de ejecución; DIP acepta operaciones sin conocer sus implementaciones.

### Límites y errores que conviene evitar

Throttling y Rate Limiting se solapan en terminología; aquí se distingue regulación por cola de cuota de admisión. Define caducidad, cancelación y rechazo al llenarse.

### Ejercicio y comprobación

Inyecta un scheduler y mide tiempo máximo de espera sin usar Thread.sleep en el servicio.

[↑ Volver al índice](#indice)


<a id="patron-34"></a>

## 34. Rate Limiting

**Categoría:** Control de admisión.

### Problema y contexto

Un consumidor no debe superar una cuota de solicitudes dentro de una ventana temporal.

### Cómo funciona y cuándo elegirlo

El limitador por ventana fija mantiene un contador y devuelve rechazo cuando se agota el cupo. El reloj y el límite se inyectan; la sincronización hace atómica la decisión en una instancia.

### Implementación Java

Archivo ejecutable: `Ejemplo_35.java`.

```java
static final class Limite {
    private final LongSupplier reloj;
    private final int maximo;
    private long ventana = -1;
    private int usados;
    Limite(LongSupplier reloj, int maximo) { this.reloj = reloj; this.maximo = maximo; }
    synchronized boolean permitir() {
        long actual = reloj.getAsLong() / 1000;
        if (actual != ventana) { ventana = actual; usados = 0; }
        if (usados >= maximo) return false;
        usados++; return true;
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var ahora = new AtomicLong(0); var limite = new Limite(ahora::get, 2);
System.out.println(limite.permitir()); System.out.println(limite.permitir());
System.out.println(limite.permitir());
ahora.set(1000); System.out.println(limite.permitir());
```

Resultado esperado:

```text
true
true
false
true
```

### Relación con SOLID

SRP separa cuotas; DIP permite controlar el tiempo en pruebas. Las cuotas deben definirse por identidad y operación.

### Límites y errores que conviene evitar

El ejemplo es por proceso: varias réplicas multiplican la cuota. En límites de ventana puede haber ráfagas dobles. Evalúa token bucket o ventana deslizante y almacenamiento atómico compartido.

### Ejercicio y comprobación

Agrega identidad del cliente y comprueba que las cuotas son independientes.

[↑ Volver al índice](#indice)


<a id="patron-35"></a>

## 35. API Gateway

**Categoría:** Integración.

### Problema y contexto

Clientes distintos necesitan un acceso coherente a servicios con políticas comunes de autenticación, enrutamiento y cuotas.

### Cómo funciona y cuándo elegirlo

El gateway dirige rutas a destinos mediante un contrato. El ejemplo demuestra despacho local; un gateway real integra transporte HTTP, TLS, políticas y observabilidad. Evita alojar reglas financieras en él.

### Implementación Java

Archivo ejecutable: `Ejemplo_36.java`.

```java
interface Destino { String atender(); }
static final class Gateway {
    private final Map<String, Destino> rutas;
    Gateway(Map<String, Destino> rutas) { this.rutas = Map.copyOf(rutas); }
    String atender(String ruta) {
        var destino = rutas.get(ruta);
        if (destino == null) throw new NoSuchElementException("Ruta desconocida");
        return destino.atender();
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var gateway = new Gateway(Map.of("/clientes", () -> "Clientes"));
System.out.println(gateway.atender("/clientes"));
```

Resultado esperado:

```text
Clientes
```

### Relación con SOLID

SRP distingue entrada y negocio; OCP agrega rutas por configuración; DIP evita acoplar el despacho a implementaciones.

### Límites y errores que conviene evitar

Un gateway único sin redundancia es punto de fallo. Valida encabezados de identidad, límites de cuerpo y timeouts; no confíes en headers suministrados por el cliente.

### Ejercicio y comprobación

Diseña la política para ruta inexistente y proveedor que excede su timeout.

[↑ Volver al índice](#indice)


<a id="patron-36"></a>

## 36. Service Discovery

**Categoría:** Infraestructura distribuida.

### Problema y contexto

Las instancias de servicios cambian y no se pueden fijar sus direcciones en cada consumidor.

### Cómo funciona y cuándo elegirlo

Un puerto resuelve un nombre lógico a instancias. El adaptador puede usar DNS, un registro o la plataforma. El ejemplo usa un mapa para que el consumidor desconozca el mecanismo.

### Implementación Java

Archivo ejecutable: `Ejemplo_37.java`.

```java
interface Descubrimiento { List<URI> resolver(String servicio); }
static final class Registro implements Descubrimiento {
    private final Map<String, List<URI>> instancias;
    Registro(Map<String, List<URI>> instancias) { this.instancias = Map.copyOf(instancias); }
    public List<URI> resolver(String servicio) {
        return List.copyOf(instancias.getOrDefault(servicio, List.of()));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
Descubrimiento discovery = new Registro(Map.of("clientes", List.of(URI.create("https://clientes.internal"))));
System.out.println(discovery.resolver("clientes").size());
```

Resultado esperado:

```text
1
```

### Relación con SOLID

DIP separa consumidor y plataforma; SRP ubica resolución de direcciones fuera de reglas; ISP solo expone resolver.

### Límites y errores que conviene evitar

Resolver no garantiza salud. Considera TTL, endpoints obsoletos, identidad del servicio y comportamiento si el registro falla.

### Ejercicio y comprobación

Simula cero instancias y evita elegir por defecto una dirección ajena.

[↑ Volver al índice](#indice)


<a id="patron-37"></a>

## 37. Load Balancing

**Categoría:** Distribución de tráfico.

### Problema y contexto

Las llamadas deben repartirse entre instancias elegibles para evitar concentrar toda la carga en una sola.

### Cómo funciona y cuándo elegirlo

Un selector round robin recibe una lista ya filtrada por salud. La lista inmutable permite selección concurrente con un contador atómico. El transporte y las comprobaciones de salud son responsabilidades distintas.

### Implementación Java

Archivo ejecutable: `Ejemplo_38.java`.

```java
interface Selector { URI elegir(); }
static final class RoundRobin implements Selector {
    private final List<URI> instancias;
    private final AtomicInteger turno = new AtomicInteger();
    RoundRobin(List<URI> instancias) {
        if (instancias.isEmpty()) throw new IllegalArgumentException("Sin instancias");
        this.instancias = List.copyOf(instancias);
    }
    public URI elegir() {
        return instancias.get(Math.floorMod(turno.getAndIncrement(), instancias.size()));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
Selector selector = new RoundRobin(List.of(URI.create("https://a.internal"), URI.create("https://b.internal")));
System.out.println(selector.elegir()); System.out.println(selector.elegir());
```

Resultado esperado:

```text
https://a.internal
https://b.internal
```

### Relación con SOLID

OCP permite otros selectores; DIP evita acoplar transporte y selección; SRP separa balance y descubrimiento.

### Límites y errores que conviene evitar

Round robin no considera diferencias de capacidad ni conexiones largas. Reintentar escrituras en otra instancia puede duplicarlas.

### Ejercicio y comprobación

Implementa selección ponderada y conserva el contrato para una lista vacía.

[↑ Volver al índice](#indice)


<a id="patron-38"></a>

## 38. Content Delivery Network

**Categoría:** Distribución de contenido.

### Problema y contexto

Los usuarios necesitan descargar recursos públicos con baja latencia sin cargar repetidamente el servidor de origen.

### Cómo funciona y cuándo elegirlo

La aplicación genera URLs de contenido con versión inmutable y delega entrega a nodos de borde. Java participa en nombres y contratos; la red CDN, sus cachés y su distribución no se implementan con una clase.

### Implementación Java

Archivo ejecutable: `Ejemplo_39.java`.

```java
interface UrlPublica { URI generar(String version, String archivo); }
record Cdn(URI base) implements UrlPublica {
    public URI generar(String version, String archivo) {
        if (!version.matches("[a-zA-Z0-9_-]+") || !archivo.matches("[a-zA-Z0-9_.-]+"))
            throw new IllegalArgumentException("Ruta inválida");
        return base.resolve(version + "/" + archivo);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
UrlPublica urls = new Cdn(URI.create("https://cdn.example.com/assets/"));
System.out.println(urls.generar("v1", "manual.pdf"));
```

Resultado esperado:

```text
https://cdn.example.com/assets/v1/manual.pdf
```

### Relación con SOLID

SRP separa generación de URL y negocio; DIP permite cambiar proveedor de entrega. El ejemplo requiere base terminada en barra.

### Límites y errores que conviene evitar

No caches datos privados como públicos. Para producción define Cache-Control, invalidación, claves de caché y URLs firmadas cuando corresponda.

### Ejercicio y comprobación

Publica dos versiones del mismo recurso y evita sobrescribir un objeto con caché inmutable.

[↑ Volver al índice](#indice)


<a id="patron-39"></a>

## 39. Data Lake

**Categoría:** Arquitectura de datos.

### Problema y contexto

Se deben conservar datos de origen con formatos diversos para análisis futuros sin perder trazabilidad.

### Cómo funciona y cuándo elegirlo

La ingesta escribe bytes crudos junto a identidad de fuente, fecha, esquema y clave. El puerto representa almacenamiento de objetos; una simulación imprime la clave y no almacena realmente.

### Implementación Java

Archivo ejecutable: `Ejemplo_40.java`.

```java
record Crudo(String clave, String fuente, String esquema, byte[] contenido) {
    Crudo { contenido = contenido.clone(); }
    public byte[] contenido() { return contenido.clone(); }
}
interface Objetos { void guardar(Crudo objeto); }
static final class Ingesta {
    private final Objetos objetos;
    Ingesta(Objetos objetos) { this.objetos = objetos; }
    void recibir(String fuente, String dia, String id, byte[] datos) {
        objetos.guardar(new Crudo(fuente + "/" + dia + "/" + id, fuente, "v1", datos));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var ingesta = new Ingesta(objeto -> System.out.println(objeto.clave()));
ingesta.recibir("tarjetas", "2026-10-06", "E1", "{}".getBytes(StandardCharsets.UTF_8));
```

Resultado esperado:

```text
tarjetas/2026-10-06/E1
```

### Relación con SOLID

SRP separa ingesta y análisis; DIP abstrae almacenamiento; la copia defensiva evita mutación de datos entregados.

### Límites y errores que conviene evitar

Sin catálogo, calidad, permisos y retención se convierte en data swamp. Define cifrado, particiones, deduplicación y linaje; las claves del ejemplo son entradas confiables.

### Ejercicio y comprobación

Agrega validación de ruta y una manifestación de metadatos con hash del contenido.

[↑ Volver al índice](#indice)


<a id="patron-40"></a>

## 40. Data Warehouse

**Categoría:** Arquitectura de datos.

### Problema y contexto

Los analistas necesitan métricas consistentes provenientes de varias fuentes con modelo y semántica comunes.

### Cómo funciona y cuándo elegirlo

Una carga transforma operaciones en hechos agregados de un esquema analítico. El puerto de destino usa upsert para una clave de fecha. El ejemplo agrega datos en memoria, no implementa un motor analítico.

### Implementación Java

Archivo ejecutable: `Ejemplo_41.java`.

```java
record Operacion(LocalDate fecha, BigDecimal monto) {}
record Hecho(LocalDate fecha, BigDecimal total) {}
interface Warehouse { void upsert(Hecho hecho); }
static final class Carga {
    private final Warehouse destino;
    Carga(Warehouse destino) { this.destino = destino; }
    void ejecutar(List<Operacion> operaciones) {
        var totales = new TreeMap<LocalDate, BigDecimal>();
        operaciones.forEach(o -> totales.merge(o.fecha(), o.monto(), BigDecimal::add));
        totales.forEach((fecha, total) -> destino.upsert(new Hecho(fecha, total)));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
new Carga(h -> System.out.println(h.total())).ejecutar(List.of(
    new Operacion(LocalDate.of(2026, 10, 6), new BigDecimal("10")),
    new Operacion(LocalDate.of(2026, 10, 6), new BigDecimal("20"))));
```

Resultado esperado:

```text
30
```

### Relación con SOLID

SRP separa transformación y almacenamiento; DIP utiliza Warehouse; la clave del hecho define identidad de carga.

### Límites y errores que conviene evitar

No sumes monedas distintas sin conversión. Modela dimensiones, datos tardíos, zonas horarias y correcciones. Upsert debe reemplazar un total completo, no sumarlo nuevamente.

### Ejercicio y comprobación

Agrega moneda a la clave y verifica que una recarga no duplique el total.

[↑ Volver al índice](#indice)


<a id="patron-41"></a>

## 41. ETL

**Categoría:** Procesamiento de datos.

### Problema y contexto

Los registros de una fuente requieren normalización antes de entrar al sistema destino.

### Cómo funciona y cuándo elegirlo

Extract, Transform y Load se modelan como roles separados. El flujo coordina los pasos y permite sustituir cada uno. En el ejemplo el conjunto cabe en memoria.

### Implementación Java

Archivo ejecutable: `Ejemplo_42.java`.

```java
interface Extractor { List<String> extraer(); }
interface Transformador { BigDecimal transformar(String fila); }
interface Cargador { void cargar(List<BigDecimal> valores); }
static final class Etl {
    private final Extractor e; private final Transformador t; private final Cargador l;
    Etl(Extractor e, Transformador t, Cargador l) { this.e = e; this.t = t; this.l = l; }
    void ejecutar() { l.cargar(e.extraer().stream().map(t::transformar).toList()); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
new Etl(() -> List.of("10.50", "20.00"), BigDecimal::new, System.out::println).ejecutar();
```

Resultado esperado:

```text
[10.50, 20.00]
```

### Relación con SOLID

SRP asigna una función a cada paso; DIP permite adaptadores; OCP incorpora transformaciones sin modificar el coordinador.

### Límites y errores que conviene evitar

Leer todo en memoria no sirve para cargas grandes. Usa chunks, checkpoints, cuarentena de errores y commits idempotentes; no descartar filas silenciosamente.

### Ejercicio y comprobación

Introduce una fila inválida y diseña un reporte de calidad con recuento de rechazadas.

[↑ Volver al índice](#indice)


<a id="patron-42"></a>

## 42. Lambda Architecture

**Categoría:** Arquitectura de procesamiento.

### Problema y contexto

El sistema necesita una vista histórica exacta y una respuesta rápida sobre datos recién llegados.

### Cómo funciona y cuándo elegirlo

Una capa batch cubre hasta un offset confirmado y una capa rápida incorpora solo eventos posteriores. La capa serving combina resultados sin doble conteo. El ejemplo usa una sola partición y offsets numéricos.

### Implementación Java

Archivo ejecutable: `Ejemplo_43.java`.

```java
record Movimiento(long offset, BigDecimal monto) {}
record Batch(long hasta, BigDecimal total) {}
static final class Serving {
    BigDecimal total(Batch batch, List<Movimiento> recientes) {
        return recientes.stream().filter(e -> e.offset() > batch.hasta())
            .map(Movimiento::monto).reduce(batch.total(), BigDecimal::add);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var batch = new Batch(2, new BigDecimal("30"));
var recientes = List.of(new Movimiento(2, new BigDecimal("20")),
    new Movimiento(3, new BigDecimal("5")));
System.out.println(new Serving().total(batch, recientes));
```

Resultado esperado:

```text
35
```

### Relación con SOLID

SRP separa cálculo histórico, cálculo rápido y servicio de vistas. Compartir lógica de transformación reduce divergencia sin mezclar responsabilidades.

### Límites y errores que conviene evitar

No es AWS Lambda. Mantener dos rutas aumenta costo y riesgo de semánticas distintas. En varias particiones usa posiciones por partición y cambio atómico de la vista batch.

### Ejercicio y comprobación

Simula el avance del batch hasta offset 3 y verifica que el total no cambia.

[↑ Volver al índice](#indice)


<a id="patron-43"></a>

## 43. Kappa Architecture

**Categoría:** Arquitectura de procesamiento.

### Problema y contexto

La lógica de procesamiento debe ser la misma al consumir eventos nuevos y al reconstruir resultados históricos.

### Cómo funciona y cuándo elegirlo

Una sola ruta de streaming procesa un log reproducible. Para recalcular se crea una nueva proyección y se vuelve a consumir el histórico. El ejemplo demuestra que una misma función produce el mismo total.

### Implementación Java

Archivo ejecutable: `Ejemplo_44.java`.

```java
record Evento(String id, BigDecimal monto) {}
static final class Proyeccion {
    private final Set<String> vistos = new HashSet<>();
    private BigDecimal total = BigDecimal.ZERO;
    void aplicar(Evento evento) {
        if (vistos.add(evento.id())) total = total.add(evento.monto());
    }
    BigDecimal total() { return total; }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var log = List.of(new Evento("E1", new BigDecimal("10")), new Evento("E2", new BigDecimal("20")));
var actual = new Proyeccion(); log.forEach(actual::aplicar);
var reconstruida = new Proyeccion(); log.forEach(reconstruida::aplicar);
System.out.println(actual.total().equals(reconstruida.total()));
```

Resultado esperado:

```text
true
```

### Relación con SOLID

SRP concentra una transformación; DIP separaría el log de su consumidor; mantener una ruta reduce duplicación de políticas.

### Límites y errores que conviene evitar

Kappa necesita retención y capacidad de replay. IDs deduplicados y estado deben persistirse atómicamente con offsets; el conjunto del ejemplo no tiene límite.

### Ejercicio y comprobación

Reconstruye con una regla nueva en una proyección separada y define cómo cambiar la vista activa.

[↑ Volver al índice](#indice)


<a id="patron-44"></a>

## 44. Data Mesh

**Categoría:** Organización y arquitectura de datos.

### Problema y contexto

Un equipo central no puede ser dueño de todas las definiciones, calidad y disponibilidad de datos de múltiples dominios.

### Cómo funciona y cuándo elegirlo

Cada dominio ofrece productos de datos con dueño, contrato, semántica y objetivos de calidad. Una plataforma de autoservicio y gobernanza federada permiten interoperabilidad. Java puede validar contratos; no crea por sí solo el modelo organizativo.

### Implementación Java

Archivo ejecutable: `Ejemplo_45.java`.

```java
record ProductoDatos(String nombre, String propietario, String version, URI ubicacion) {
    ProductoDatos {
        if (nombre.isBlank() || propietario.isBlank() || version.isBlank())
            throw new IllegalArgumentException("Contrato incompleto");
        Objects.requireNonNull(ubicacion);
    }
}
interface Catalogo { void publicar(ProductoDatos producto); }
```

### Ejecución y resultado

Dentro de `main`:

```java
Catalogo catalogo = p -> System.out.println(p.nombre() + " " + p.propietario());
catalogo.publicar(new ProductoDatos("solicitudes", "credito", "v1", URI.create("https://datos.internal/solicitudes")));
```

Resultado esperado:

```text
solicitudes credito
```

### Relación con SOLID

SRP asigna propiedad por dominio; DIP desacopla catálogo y producto. SOLID aplica al código de contratos, no reemplaza gobernanza organizativa.

### Límites y errores que conviene evitar

Descentralización sin estándares produce silos. Define SLO de frescura, políticas de acceso, identificadores compartidos, linaje y acuerdos de cambio de esquema.

### Ejercicio y comprobación

Documenta un contrato de producto con dueño, usuarios, frescura y compatibilidad.

[↑ Volver al índice](#indice)


<a id="patron-45"></a>

## 45. Data Fabric

**Categoría:** Arquitectura e integración de datos.

### Problema y contexto

Los datos están dispersos entre plataformas y se necesita acceso coherente apoyado en metadatos y políticas.

### Cómo funciona y cuándo elegirlo

Una capa de integración resuelve productos o recursos a conectores y aplica políticas. La demostración es un enrutador mínimo de conectores; un Data Fabric completo incluye catálogo, linaje y automatización de integración.

### Implementación Java

Archivo ejecutable: `Ejemplo_46.java`.

```java
interface Conector { String consultar(String clave); }
static final class Fabric {
    private final Map<String, Conector> conectores;
    Fabric(Map<String, Conector> conectores) { this.conectores = Map.copyOf(conectores); }
    String consultar(String origen, String clave) {
        var conector = conectores.get(origen);
        if (conector == null) throw new NoSuchElementException("Origen desconocido");
        return conector.consultar(clave);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var fabric = new Fabric(Map.of("clientes", clave -> "Cliente " + clave));
System.out.println(fabric.consultar("clientes", "C1"));
```

Resultado esperado:

```text
Cliente C1
```

### Relación con SOLID

DIP usa conectores; OCP agrega fuentes; SRP separa integración y semántica de negocio.

### Límites y errores que conviene evitar

Una fachada de consultas no basta para llamarse Data Fabric. No asumas consistencia global ni rendimiento uniforme; aplica políticas cerca de cada fuente.

### Ejercicio y comprobación

Agrega metadatos de linaje y autorización antes de invocar un conector.

[↑ Volver al índice](#indice)


<a id="patron-46"></a>

## 46. DataOps

**Categoría:** Práctica operativa.

### Problema y contexto

Los pipelines de datos deben cambiar con trazabilidad y evitar publicar conjuntos que violan reglas de calidad.

### Cómo funciona y cuándo elegirlo

La automatización combina versiones, validación y publicación. El ejemplo implementa una puerta de calidad inyectada; la orquestación, catálogo y monitoreo operativos viven fuera de la clase.

### Implementación Java

Archivo ejecutable: `Ejemplo_47.java`.

```java
interface Calidad { boolean aceptar(List<Integer> datos); }
interface Publicacion { void publicar(List<Integer> datos); }
static final class Pipeline {
    private final Calidad calidad; private final Publicacion publicacion;
    Pipeline(Calidad c, Publicacion p) { calidad = c; publicacion = p; }
    void ejecutar(List<Integer> datos) {
        if (!calidad.aceptar(datos)) throw new IllegalStateException("Calidad insuficiente");
        publicacion.publicar(List.copyOf(datos));
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var pipeline = new Pipeline(ds -> ds.stream().allMatch(x -> x >= 0), System.out::println);
pipeline.ejecutar(List.of(1, 2, 3));
```

Resultado esperado:

```text
[1, 2, 3]
```

### Relación con SOLID

SRP separa calidad y publicación; DIP permite fuentes y destinos distintos; OCP admite políticas de calidad nuevas.

### Límites y errores que conviene evitar

Una prueba de calidad no cubre linaje, permisos ni frescura. Evita promover automáticamente un dataset si faltan evidencias o reconciliaciones.

### Ejercicio y comprobación

Agrega pruebas de unicidad y completitud y versiona el resultado de la evaluación.

[↑ Volver al índice](#indice)


<a id="patron-47"></a>

## 47. MLOps

**Categoría:** Práctica operativa.

### Problema y contexto

Un modelo necesita evaluación reproducible, promoción controlada, observación y posibilidad de reemplazo.

### Cómo funciona y cuándo elegirlo

El puerto de predicción oculta la implementación. Una política de promoción exige métricas mínimas antes de registrar una versión. El ejemplo no entrena un modelo; representa parte de su ciclo de vida.

### Implementación Java

Archivo ejecutable: `Ejemplo_48.java`.

```java
record Modelo(String version, double precision) {}
interface RegistroModelos { void promover(Modelo modelo); }
static final class Promocion {
    private final RegistroModelos registro;
    Promocion(RegistroModelos registro) { this.registro = registro; }
    void ejecutar(Modelo modelo) {
        if (!Double.isFinite(modelo.precision()) || modelo.precision() < 0.90 || modelo.precision() > 1)
            throw new IllegalArgumentException("Métrica no aceptable");
        registro.promover(modelo);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
new Promocion(m -> System.out.println(m.version())).ejecutar(new Modelo("v2", 0.95));
```

Resultado esperado:

```text
v2
```

### Relación con SOLID

SRP separa decisión de promoción y registro; DIP permite otro almacén. La regla de aceptación es una política independiente del framework de ML.

### Límites y errores que conviene evitar

Precisión sola no demuestra calidad: evalúa datos no vistos, sesgo, recall, costo de errores y drift. Vincula datos, código, features, modelo y métricas por versión.

### Ejercicio y comprobación

Introduce una política por métricas múltiples y prueba un modelo preciso pero con recall insuficiente.

[↑ Volver al índice](#indice)


<a id="patron-48"></a>

## 48. AIOps

**Categoría:** Práctica operativa.

### Problema y contexto

El volumen de señales operativas exige correlacionar incidentes y priorizar revisión, sin ejecutar acciones peligrosas a ciegas.

### Cómo funciona y cuándo elegirlo

Un detector produce una señal y un notificador la presenta para evaluación. La implementación es una heurística de demostración, no un modelo de inteligencia artificial ni un sistema AIOps completo.

### Implementación Java

Archivo ejecutable: `Ejemplo_49.java`.

```java
record Metrica(String servicio, double errores) {}
interface Detector { boolean anomalia(Metrica metrica); }
interface Avisos { void emitir(String servicio); }
static final class Analisis {
    private final Detector detector; private final Avisos avisos;
    Analisis(Detector detector, Avisos avisos) { this.detector = detector; this.avisos = avisos; }
    void evaluar(Metrica metrica) {
        if (detector.anomalia(metrica)) avisos.emitir(metrica.servicio());
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var analisis = new Analisis(m -> m.errores() > 0.20, System.out::println);
analisis.evaluar(new Metrica("tarjetas", 0.35));
```

Resultado esperado:

```text
tarjetas
```

### Relación con SOLID

DIP separa detector y acciones; SRP evita mezclar detección y remediación; ISP limita las capacidades del consumidor.

### Límites y errores que conviene evitar

Correlación no prueba causa. Define confianza, falsos positivos, límites de acción, aprobación para remediaciones y protección de datos de logs.

### Ejercicio y comprobación

Sustituye la heurística por un detector simulado y conserva un flujo de revisión humana.

[↑ Volver al índice](#indice)


<a id="patron-49"></a>

## 49. DevSecOps

**Categoría:** Práctica operativa.

### Problema y contexto

La seguridad debe participar en diseño, construcción y operación, con resultados verificables antes de publicar.

### Cómo funciona y cuándo elegirlo

Una puerta de promoción consume hallazgos y rechaza los que violan la política. El scanner es un adaptador externo; Java representa la decisión. Se necesitan controles de código, dependencias, secretos, infraestructura y runtime.

### Implementación Java

Archivo ejecutable: `Ejemplo_50.java`.

```java
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
```

### Ejecución y resultado

Dentro de `main`:

```java
var puerta = new Puerta(() -> List.of(new Hallazgo("H1", "CRITICA")));
System.out.println(puerta.promover());
```

Resultado esperado:

```text
false
```

### Relación con SOLID

SRP separa detección y política; DIP usa Scanner; OCP admite scanners distintos conservando el formato de evidencia.

### Límites y errores que conviene evitar

Un scanner fallido no es un resultado limpio. Define excepciones con vencimiento, SBOM, procedencia y permisos mínimos. Una comparación de severidad aislada no evalúa explotabilidad.

### Ejercicio y comprobación

Agrega estado del análisis y bloquea promoción si falta evidencia.

[↑ Volver al índice](#indice)


<a id="patron-50"></a>

## 50. GitOps

**Categoría:** Práctica de entrega.

### Problema y contexto

Los despliegues cambian manualmente y la infraestructura real diverge de lo revisado y versionado.

### Cómo funciona y cuándo elegirlo

El estado deseado se declara y versiona; un agente lo obtiene y reconcilia continuamente. El ejemplo compara una versión declarada con una observada mediante un puerto; no realiza despliegues.

### Implementación Java

Archivo ejecutable: `Ejemplo_51.java`.

```java
interface Cluster { String version(); void aplicar(String version); }
static final class Reconciliador {
    private final Cluster cluster;
    Reconciliador(Cluster cluster) { this.cluster = cluster; }
    void reconciliar(String deseada) {
        if (!deseada.equals(cluster.version())) cluster.aplicar(deseada);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
Cluster cluster = new Cluster() {
    private String actual = "v1";
    public String version() { return actual; }
    public void aplicar(String version) { actual = version; System.out.println(actual); }
};
var reconciliador = new Reconciliador(cluster);
reconciliador.reconciliar("v2"); reconciliador.reconciliar("v2");
```

Resultado esperado:

```text
v2
```

### Relación con SOLID

SRP separa reconciliación y acceso al cluster; DIP utiliza Cluster; la aplicación idempotente evita cambios innecesarios.

### Límites y errores que conviene evitar

Guardar YAML en Git no basta: importan declaración, historial inmutable, pull automático y reconciliación continua. Gestiona orden, salud, drift y secretos fuera del texto plano.

### Ejercicio y comprobación

Simula drift de vuelta a v1 y verifica que se corrige sin un nuevo commit.

[↑ Volver al índice](#indice)


<a id="patron-51"></a>

## 51. Infrastructure as Code

**Categoría:** Gestión de infraestructura.

### Problema y contexto

Crear recursos a mano dificulta reproducir ambientes y revisar cambios de permisos y capacidad.

### Cómo funciona y cuándo elegirlo

La infraestructura se expresa como una especificación revisable; el motor calcula y aplica diferencias. Java puede validar o generar modelos, pero el ejemplo no sustituye Terraform, CloudFormation ni su gestión de estado.

### Implementación Java

Archivo ejecutable: `Ejemplo_52.java`.

```java
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
```

### Ejecución y resultado

Dentro de `main`:

```java
Planificador planificador = new PlanTexto();
System.out.println(planificador.plan(new Tabla("solicitudes", "id", true)));
```

Resultado esperado:

```text
Crear solicitudes clave=id cifrada=true
```

### Relación con SOLID

SRP separa especificación y ejecución; DIP abstrae planificación; las invariantes validan requisitos del modelo.

### Límites y errores que conviene evitar

Un plan textual no detecta drift. Gestiona estado remoto, locks, permisos, destrucciones, importación y backups. Revisa el plan antes de cambios irreversibles.

### Ejercicio y comprobación

Diseña un cambio de clave primaria y explica por qué puede requerir recreación y migración.

[↑ Volver al índice](#indice)


<a id="patron-52"></a>

## 52. Configuration as Code

**Categoría:** Gestión de configuración.

### Problema y contexto

Los ambientes contienen parámetros divergentes sin validación ni historial confiable.

### Cómo funciona y cuándo elegirlo

La configuración no sensible se representa como datos versionados, validados y separados del código. La aplicación recibe un valor inmutable; el mecanismo de carga se mantiene en el borde.

### Implementación Java

Archivo ejecutable: `Ejemplo_53.java`.

```java
record Configuracion(URI endpoint, Duration timeout) {
    Configuracion {
        Objects.requireNonNull(endpoint); Objects.requireNonNull(timeout);
        if (!"https".equals(endpoint.getScheme()) || timeout.isNegative() || timeout.isZero())
            throw new IllegalArgumentException("Configuración inválida");
    }
}
static final class Cliente {
    private final Configuracion configuracion;
    Cliente(Configuracion configuracion) { this.configuracion = configuracion; }
    long timeoutMillis() { return configuracion.timeout().toMillis(); }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var cfg = new Configuracion(URI.create("https://api.example.com"), Duration.ofSeconds(2));
System.out.println(new Cliente(cfg).timeoutMillis());
```

Resultado esperado:

```text
2000
```

### Relación con SOLID

SRP separa carga y uso; DIP puede abstraer una fuente dinámica si hace falta; validación protege invariantes antes de servir tráfico.

### Límites y errores que conviene evitar

No guardes secretos junto a parámetros versionados. En recarga dinámica valida el conjunto completo y sustituye atómicamente; define precedencia y rollback.

### Ejercicio y comprobación

Prueba endpoint HTTP y timeout cero; ambos deben rechazarse al crear el valor.

[↑ Volver al índice](#indice)


<a id="patron-53"></a>

## 53. Secrets Management

**Categoría:** Seguridad y operación.

### Problema y contexto

Credenciales deben obtenerse sin incrustarlas en código, repositorios ni logs, y deben poder rotarse.

### Cómo funciona y cuándo elegirlo

Un puerto obtiene el secreto por nombre. El caso de uso lo consume a través de un adaptador. El ejemplo no contiene credenciales reales; el proveedor y la autenticación de workload se configuran externamente.

### Implementación Java

Archivo ejecutable: `Ejemplo_54.java`.

```java
interface Secretos { char[] obtener(String nombre); }
interface Autenticador { boolean autenticar(char[] secreto); }
static final class Acceso {
    private final Secretos secretos; private final Autenticador autenticador;
    Acceso(Secretos secretos, Autenticador autenticador) {
        this.secretos = secretos; this.autenticador = autenticador;
    }
    boolean ejecutar(String referencia) {
        char[] valor = secretos.obtener(referencia);
        try { return autenticador.autenticar(valor); }
        finally { Arrays.fill(valor, '\0'); }
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var acceso = new Acceso(nombre -> "demo-no-real".toCharArray(), valor -> valor.length > 0);
System.out.println(acceso.ejecutar("servicio/credencial"));
```

Resultado esperado:

```text
true
```

### Relación con SOLID

DIP aísla proveedor de secretos; SRP separa resolución y autenticación; ISP reduce operaciones disponibles.

### Límites y errores que conviene evitar

Borrar char[] reduce exposición de esa copia, no garantiza borrado de todas las copias en JVM o SDK. Usa identidad de workload, mínimo privilegio, rotación, caché con TTL y enmascaramiento.

### Ejercicio y comprobación

Simula rotación y define qué ocurre si el proveedor falla y el secreto cacheado ya expiró.

[↑ Volver al índice](#indice)


<a id="patron-54"></a>

## 54. Continuous Integration

**Categoría:** Práctica de desarrollo.

### Problema y contexto

Los cambios integrados tarde generan conflictos y defectos difíciles de ubicar.

### Cómo funciona y cuándo elegirlo

La integración frecuente ejecuta compilación, pruebas y verificaciones reproducibles sobre el mismo commit. Java puede proporcionar pruebas ejecutables; el pipeline vive en la plataforma CI.

### Implementación Java

Archivo ejecutable: `Ejemplo_55.java`.

```java
interface Comision { BigDecimal calcular(BigDecimal monto); }
static void verificar(Comision regla) {
    var resultado = regla.calcular(new BigDecimal("100"));
    if (resultado.compareTo(new BigDecimal("2")) != 0)
        throw new AssertionError("Comisión incorrecta");
}
```

### Ejecución y resultado

Dentro de `main`:

```java
verificar(monto -> monto.multiply(new BigDecimal("0.02")));
System.out.println("Verificación OK");
```

Resultado esperado:

```text
Verificación OK
```

### Relación con SOLID

DIP facilita dobles; SRP mantiene pruebas enfocadas en comportamiento; pruebas de contrato validan LSP entre adaptadores.

### Límites y errores que conviene evitar

Un build verde no demuestra ausencia de defectos. No dependas de servicios compartidos sin control, usa credenciales mínimas y conserva evidencia del commit.

### Ejercicio y comprobación

Provoca una comisión errónea y verifica que el proceso termina con código distinto de cero.

[↑ Volver al índice](#indice)


<a id="patron-55"></a>

## 55. Continuous Delivery

**Categoría:** Práctica de entrega.

### Problema y contexto

Una versión validada debe poder entregarse de manera repetible sin reconstrucciones distintas por ambiente.

### Cómo funciona y cuándo elegirlo

Un artefacto inmutable se promueve con evidencias. Continuous Delivery mantiene disponibilidad para desplegar y puede tener aprobación; Continuous Deployment automatiza además cada promoción a producción.

### Implementación Java

Archivo ejecutable: `Ejemplo_56.java`.

```java
record Artefacto(String digest, boolean verificado) {}
interface Despliegue { void promover(Artefacto artefacto, String ambiente); }
static final class Entrega {
    private final Despliegue despliegue;
    Entrega(Despliegue despliegue) { this.despliegue = despliegue; }
    void ejecutar(Artefacto artefacto, String ambiente) {
        if (!artefacto.verificado()) throw new IllegalStateException("Sin evidencia");
        despliegue.promover(artefacto, ambiente);
    }
}
```

### Ejecución y resultado

Dentro de `main`:

```java
var entrega = new Entrega((a, ambiente) -> System.out.println(a.digest() + " -> " + ambiente));
entrega.ejecutar(new Artefacto("sha256:demo", true), "UAT");
```

Resultado esperado:

```text
sha256:demo -> UAT
```

### Relación con SOLID

SRP separa decisión y despliegue; DIP abstrae plataforma; el mismo artefacto evita diferencias entre validación y promoción.

### Límites y errores que conviene evitar

El digest demo no es un hash válido. En producción exige hash real, procedencia, migraciones compatibles, health checks, estrategia canary y recuperación verificable.

### Ejercicio y comprobación

Define un rollback con una migración de datos incompatible; decide si requiere forward fix.

[↑ Volver al índice](#indice)


<a id="comparaciones-para-elegir-con-criterio"></a>

## Comparaciones para elegir con criterio

| Alternativas | Diferencia que decide la elección |
| --- | --- |
| Strategy y State | Strategy intercambia un algoritmo por composición; State depende de transiciones de estado del contexto |
| Decorator y Proxy | Decorator añade capacidades; Proxy controla acceso o representación aunque ambos puedan delegar mediante el mismo puerto |
| Adapter y Bridge | Adapter traduce una interfaz existente; Bridge separa desde el diseño dos ejes de variación |
| Facade y Mediator | Facade ofrece una entrada simple; Mediator administra colaboración entre componentes |
| Factory Method y Builder | Factory Method delega qué producto crear; Builder controla la construcción progresiva y sus invariantes |
| DAO y Repository | DAO se acerca a almacenamiento y filas; Repository a agregados y operaciones de dominio |
| Observer y arquitectura por eventos | Observer puede ser local y síncrono; una arquitectura por eventos exige decisiones explícitas sobre transporte entrega durabilidad y evolución |
| CQRS y Event Sourcing | CQRS separa modelos de comandos y consultas; Event Sourcing conserva hechos como fuente de verdad. Se pueden usar juntos o por separado |
| Rate Limiting y Bulkhead | La cuota controla admisión por tiempo; el bulkhead limita recursos o concurrencia y aísla dependencias |
| Throttling y Rate Limiting | Los términos se solapan. Este manual usa throttling para regular flujo y rate limiting para imponer cuota. Documenta la semántica de tu plataforma |
| Lambda y Kappa | Lambda mantiene rutas batch y rápida; Kappa reutiliza una ruta de streaming y reconstruye mediante replay |
| Data Lake y Warehouse | El lake conserva formatos diversos y datos crudos; el warehouse ofrece un modelo analítico curado. Pueden coexistir |
| Data Mesh y Data Fabric | Mesh enfatiza propiedad por dominio y productos de datos; Fabric enfatiza integración guiada por metadatos. Pueden complementar sus capacidades |
| IaC y GitOps | IaC expresa y automatiza infraestructura; GitOps añade un modelo de obtención y reconciliación continua del estado deseado |
| Continuous Delivery y Deployment | Delivery mantiene artefactos preparados y puede requerir aprobación; Deployment automatiza también su publicación a producción |

[↑ Volver al índice](#indice)


<a id="aplicacion-conjunta-en-clean-architecture-y-arquitectura-hexagonal"></a>

## Aplicación conjunta en Clean Architecture y arquitectura hexagonal

La dirección de dependencias se define por el problema, no por la ubicación de anotaciones. El dominio contiene valores, agregados, reglas y transiciones. La aplicación contiene casos de uso y los puertos que necesita. Los adaptadores implementan esos puertos para HTTP, persistencia, mensajería y servicios externos. El arranque construye el grafo de objetos.

Una organización posible para tu backend Java es:

```text
domain/model
  Solicitud.java
  EstadoSolicitud.java
  PoliticaComision.java
application/port/in
  IniciarSolicitud.java
application/port/out
  Solicitudes.java
  EvaluacionRiesgo.java
  PublicadorEventos.java
application/usecase
  IniciarSolicitudUseCase.java
infrastructure/driving/http
  SolicitudHandler.java
  SolicitudRequestDto.java
infrastructure/driven/persistence
  SolicitudesR2dbcAdapter.java
infrastructure/driven/provider
  RiesgoWebClientAdapter.java
configuration
  CompositionConfig.java
```

Esta lista representa paquetes y responsabilidades de un proyecto de integración propuesto; no son archivos que el paquete de ejemplos pretenda incluir. En un arquetipo multimódulo, dominio y aplicación no importan los adaptadores. La configuración sí puede conocer ambos para enlazarlos.

El flujo de una solicitud de crédito puede combinar Adapter para traducir el proveedor, Strategy para políticas regionales, Repository para guardar el agregado, State para transiciones válidas, Service Layer para coordinación y eventos para comunicar hechos confirmados. Circuit Breaker y Bulkhead rodean cada dependencia con sus propias políticas. No todos deben incorporarse desde el comienzo: selecciona cada uno por una necesidad comprobada.

### Composición explícita

El patrón de construcción que se observa en los ejemplos es intencional:

```java
// En Ejemplo_D.main el puerto se suministra desde el borde.
PagoPort fake = monto -> "PAGO-" + monto.toPlainString();
IniciarPago casoDeUso = new IniciarPago(fake);
```

En Spring, un método @Bean o la inyección por constructor construye el mismo grafo. Las anotaciones del framework son una elección del módulo de infraestructura; no convierten automáticamente una clase en una implementación SOLID. Para varias implementaciones usa selección explícita por configuración o un registro validado; evita un Service Locator global en los casos de uso.

### Traslado a WebFlux

Los ejemplos son síncronos para destacar el mecanismo. Al trasladarlos a WebFlux, adapta los contratos de I/O a Mono o Flux de forma coherente con tu arquetipo. Si deseas dominio completamente independiente de Reactor, conserva reglas puras y sitúa la coordinación reactiva en aplicación; si tus puertos usan Reactor, declara esa decisión arquitectónica y evita dependencias de transporte.

No ejecutes operaciones bloqueantes en el event loop ni uses block dentro del flujo. Un adaptador a un SDK bloqueante debe gestionar un scheduler apropiado y límites; envolver cualquier llamada en Mono no la vuelve no bloqueante. Para un bulkhead, adquisición y liberación deben acompañar suscripción, señal terminal y cancelación. Para un circuito, contabiliza errores al terminar la operación, no cuando construyes el publisher. Un retry debe considerar idempotencia y presupuesto total de tiempo.

Un main local no valida backpressure, cancelación, contexto de correlación ni concurrencia reactiva. En el proyecto real comprueba esos contratos con pruebas dirigidas y herramientas de Reactor apropiadas a las versiones del repositorio.

### Contratos de frontera y errores

Separa DTO HTTP, comandos de aplicación y valores del dominio cuando tengan responsabilidades distintas. Jakarta Validation puede validar la forma de la entrada en el borde; las invariantes financieras siguen perteneciendo al dominio. El adaptador traduce respuesta remota a significado local sin considerar toda ausencia como error de infraestructura o toda excepción como dato no encontrado.

Define encabezados, propagación de correlationId, identidad, timeout, moneda y formato temporal en el contrato. No guardes credenciales en DTOs de log; utiliza referencias de secretos y enmascaramiento consistente. Para eventos versiona esquema, identidad, timestamp y claves de orden o partición.

[↑ Volver al índice](#indice)


<a id="verificacion-por-tipo-de-solucion"></a>

## Verificación por tipo de solución

| Tipo | Evidencia significativa |
| --- | --- |
| Principios y patrones de objetos | Pruebas de invariantes sustitución composición y ramas de error |
| Persistencia | Ausencia diferenciada de fallo atomicidad versión y aislamiento |
| Integración remota | Timeouts rechazo conocido resultado incierto contratos y propagación de errores |
| Eventos y sagas | Duplicados pérdida de conexión reanudación orden compensación fallida y replay |
| Resiliencia | Fallos clasificados circuito abierto recuperación saturación y cancelación |
| Datos | Reconciliación de totales linaje esquemas calidad frescura y recargas idempotentes |
| Entrega y operación | Identidad del artefacto evidencia reproducibilidad permisos mínimos y recuperación |

La colección proporciona ejecución de los caminos didácticos y su salida esperada. Los ejercicios proponen las verificaciones de extensión necesarias. Las simulaciones locales de arquitecturas no certifican disponibilidad, seguridad ni comportamiento distribuido en producción.

[↑ Volver al índice](#indice)


<a id="caso-integrador-propuesto"></a>

## Caso integrador propuesto

Construye una operación IniciarSolicitud siguiendo estas decisiones, una a una:

1. Modela Solicitud y Monto como valores con moneda, identidad y validaciones. Comienza por invariantes antes de escoger infraestructura.
2. Declara los puertos Solicitudes y EvaluacionRiesgo en aplicación. Prueba el caso de uso con fakes respetando sus contratos.
3. Extrae Strategy si la política cambia por región. Configura el registro de políticas y rechaza códigos desconocidos.
4. Aplica Adapter al proveedor y Repository al agregado. Mantén sus DTOs fuera del dominio.
5. Añade State cuando existan transiciones con reglas; prueba todas las transiciones permitidas y rechazadas.
6. Si necesitas publicar hechos con consistencia local, guarda agregado y outbox en una misma transacción; un publicador separado entrega y registra avance.
7. Añade circuito, timeout y bulkhead por proveedor. Comprueba que un fallo de riesgo no agota capacidad de consultas no relacionadas.
8. Si una operación abarca varios servicios, define saga durable e idempotencia de pasos. Registra estados inciertos y una reconciliación recuperable.
9. Separa proyecciones con CQRS solamente si las necesidades de lectura lo justifican. Adopta Event Sourcing solo con una necesidad clara y capacidad de operación.
10. Empaqueta un artefacto inmutable, valida contratos y promueve con configuración y secretos externos. Documenta rollback y límites de la migración.

Criterio de éxito: agregar un nuevo proveedor no cambia la regla de dominio; agregar una regla regional no modifica el cliente HTTP; reemplazar persistencia no cambia el contrato del caso de uso. Si una modificación atraviesa todas las capas, revisa la responsabilidad y los puntos de variación antes de agregar más patrones.

[↑ Volver al índice](#indice)


<a id="ruta-de-estudio-y-ejercicios-de-consolidacion"></a>

## Ruta de estudio y ejercicios de consolidación

**Bloque inicial.** Ejecuta S, O, L, I y D. Para cada uno explica el cambio que queda aislado. Escribe un ejemplo que viole el principio y una prueba que exponga el problema. No memorices únicamente las letras.

**Objetos y aplicación.** Trabaja Strategy, Adapter, Decorator, Factory Method y Repository antes de Visitor, Flyweight e Interpreter. Justifica por qué la alternativa más simple no cubre la necesidad. Refactoriza conservando resultados y contrato.

**Sistemas distribuidos.** Simula timeouts después de que el receptor confirma una escritura, duplicados de eventos y caída entre pasos. Diseña reanudación con estados persistentes en lugar de resolver todos los errores con retry.

**Datos y operación.** Reconstruye proyecciones sin doble conteo, publica un producto de datos con dueño y política de acceso, y crea una evidencia de promoción que identifique commit, artefacto y configuración. Diferencia una demostración local de una garantía de plataforma.

[↑ Volver al índice](#indice)


<a id="glosario"></a>

## Glosario

| Término | Significado en este manual |
| --- | --- |
| Agregado | Frontera de consistencia que protege invariantes de un conjunto de objetos |
| Puerto | Contrato de una capacidad requerida u ofrecida por aplicación |
| Adaptador | Implementación que traduce entre un puerto y una tecnología |
| Idempotencia | Repetir una operación con la misma identidad no agrega efectos indebidos |
| Compensación | Nueva operación de negocio que contrarresta un efecto previo cuando es posible |
| Replay | Reconstrucción de una proyección o estado al aplicar eventos históricos |
| Outbox | Registro de mensajes guardado atómicamente con una escritura local para publicación posterior |
| SLO | Objetivo medible de calidad de servicio como disponibilidad o frescura |
| Drift | Diferencia entre estado deseado y observado |
| Composition root | Lugar donde se construyen e inyectan implementaciones concretas |

[↑ Volver al índice](#indice)


<a id="referencias-y-lecturas-primarias"></a>

## Referencias y lecturas primarias

El catálogo de cobertura procede del archivo aportado. Las explicaciones y programas son una elaboración didáctica original. Las fuentes siguientes ayudan a contrastar definiciones concretas; ninguna fuente se presenta como catálogo único de las 55 entradas.

- Martin, R. C. (2014). The Single Responsibility Principle. https://blog.cleancoder.com/uncle-bob/2014/05/08/SingleReponsibilityPrinciple.html — apoyo para responsabilidad según motivos y actores de cambio.
- Fowler, M. (2004). Inversion of Control Containers and the Dependency Injection pattern. https://martinfowler.com/articles/injection.html — composición e inyección de dependencias.
- Oracle. (s. f.). Enum Java SE 21 API. https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Enum.html — semántica de enums usada en Singleton.
- Fowler, M. (s. f.). Repository. https://martinfowler.com/eaaCatalog/repository.html — relación entre dominio y mapeo de datos.
- Fowler, M. (2011). CQRS. https://martinfowler.com/bliki/CQRS.html — separación de modelos y costo de complejidad.
- Fowler, M. (2005). Event Sourcing. https://martinfowler.com/eaaDev/EventSourcing.html — reconstrucción mediante secuencia de hechos.
- Microsoft. (s. f.). Design patterns for microservices. https://learn.microsoft.com/en-us/azure/architecture/microservices/design/patterns — referencia general de Saga Circuit Breaker y Bulkhead.
- Dehghani, Z. (2019). How to Move Beyond a Monolithic Data Lake to a Distributed Data Mesh. https://martinfowler.com/articles/data-monolith-to-mesh.html — propiedad por dominio y productos de datos.
- OpenGitOps. (s. f.). OpenGitOps principles. https://opengitops.dev/ — estado declarativo versionado obtenido automáticamente y reconciliado.

[↑ Volver al índice](#indice)
