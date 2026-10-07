# Ejemplos de SOLID y patrones con Java

60 programas independientes. Recomendado JDK 21. Cada archivo se ejecuta mediante java Nombre.java. No realizan conexiones externas ni despliegues. Los casos distribuidos son simulaciones y los límites están documentados en el manual.

Ejecutar todos en PowerShell desde esta carpeta:

```powershell
Get-ChildItem Ejemplo_*.java | Sort-Object Name | ForEach-Object {
    Write-Host $_.Name
    & java $_.FullName
    if ($LASTEXITCODE -ne 0) { throw "Falló $($_.Name)" }
}
```

En Bash:

```bash
for archivo in Ejemplo_*.java; do
    echo "$archivo"
    java "$archivo" || exit 1
done
```

resultados-esperados.json permite comprobar salidas. El verificador Python compara todos los programas y retorna error si alguno falla. Requiere Python 3 y JDK:

```bash
python verificar.py
```

Los imports amplios y tipos anidados facilitan programas autónomos; en producción separa módulos y paquetes según responsabilidades.
