from pathlib import Path
import subprocess, json, sys

root = Path(__file__).resolve().parent
expected = json.loads((root / 'resultados-esperados.json').read_text(encoding='utf-8'))
failures = []
for name, output in expected.items():
    p = subprocess.run(['java', str(root / (name + '.java'))], capture_output=True, text=True, timeout=30,
                       encoding='utf-8')
    if p.returncode != 0 or p.stdout.strip() != output:
        failures.append({'name': name, 'returncode': p.returncode, 'stdout': p.stdout, 'stderr': p.stderr})
print(json.dumps({'total': len(expected), 'correctos': len(expected) - len(failures), 'fallos': failures},
                 ensure_ascii=False, indent=2))
sys.exit(bool(failures))
