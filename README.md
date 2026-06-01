# 🧟 Mansión Zombie — Java Swing Desktop Game

Juego de aventura y supervivencia desarrollado en **Java con Swing** en el que el jugador controla a un superviviente que debe atravesar una mansión infestada de zombies habitación por habitación. Incluye sistema de combate por turnos, búsqueda de objetos, curación y selección de dificultad.

---

## 📁 Estructura del proyecto

```
MansionZombievf/
└── src/
    ├── Botones/
    │   ├── BotonAvanzar.java         # Botón para avanzar a la siguiente habitación
    │   ├── BotonBuscar.java          # Botón para buscar objetos en la habitación
    │   ├── BotonCurarse.java         # Botón para usar el botiquín
    │   ├── BotonInicio.java          # Botón de inicio de partida
    │   ├── BotonLuchar.java          # Botón para atacar al zombie
    │   ├── BotonTerminar.java        # Botón para terminar la lucha
    │   └── BotonXCierre.java         # Botón personalizado de cierre
    ├── ClasesLogica/
    │   ├── MansiónZombie.java        # Clase principal con el estado global de la partida
    │   ├── Superviviente.java        # Lógica del jugador: combate, búsqueda, curación, movimiento
    │   └── Zombie.java               # Entidad enemiga con stats escalados por habitación
    ├── Componentes/
    │   ├── Acciones.java/.form       # Diálogo HUD principal — stats y botones de acción
    │   ├── FondoVentanaInicio.java/.form
    │   ├── ImagenDerrota.java/.form  # Pantalla de game over
    │   ├── ImagenVictoria.java/.form # Pantalla de victoria
    │   ├── ImagenZombieLucha.java/.form
    │   ├── Inicio.java/.form         # Ventana de inicio — selector de dificultad
    │   ├── Lucha.java/.form          # Diálogo de combate por turnos
    │   └── SelectorDificultad.java   # Componente selector de dificultad
    ├── fuentes/
    │   └── GhoulFriAOE.ttf           # Tipografía personalizada de terror
    └── Imagenes/
        ├── ImagenBotonAvanzar.png
        ├── ImagenBotonBuscar.png
        ├── ImagenBotonCurarse.png
        ├── ImagenBotonInicio.png
        ├── ImagenBotonLuchar.png
        ├── ImagenBotonTerminar.png
        ├── imagenDerrota.png
        ├── imagenFondo.png
        ├── imagenVictoria.png
        ├── XCierres.png
        └── zombieLucha.png / zombieLucha2.png
```

---

## 🎮 Cómo funciona

### Inicio y selección de dificultad (`Inicio.java`)
La ventana de inicio se abre en pantalla completa sin decoración de sistema. Usa la fuente personalizada **GhoulFriAOE.ttf** para el estilo visual. El jugador selecciona la dificultad a través de `SelectorDificultad`, que determina el número de habitaciones:

- **Fácil** → 5 habitaciones
- **Difícil** → 10 habitaciones

Al confirmar, se crean los objetos `Superviviente` y `Zombie` y se abre el diálogo de **Acciones**.

### HUD de Acciones (`Acciones.java`)
Diálogo modal que muestra en tiempo real el estado del superviviente y de la partida:

| Indicador | Descripción |
|---|---|
| Puntos de vida | Vida actual del superviviente (máx. 20) |
| Cantidad de protecciones | Objetos defensivos encontrados |
| Cantidad de armas | Armas encontradas (aumentan el daño de ataque) |
| ¿Botiquín? | SI/NO — solo se puede tener uno a la vez |
| Intentos de búsqueda | Búsquedas restantes en la habitación actual (máx. 3) |
| Zombies | Zombies activos en la habitación |
| Habitación actual | Progreso (habitación actual / máximo) |

Desde este diálogo se accede a todas las acciones disponibles mediante botones con imagen personalizada.

### Sistema de combate (`Lucha.java` + `Superviviente.combatirZombie()`)
El combate es por **turnos**. En cada turno:

1. El superviviente ataca: daño = número aleatorio entre 0 y `ptsAtaqueS` + `cantidadArmas`.
2. Si el zombie sobrevive, contraataca: daño = número aleatorio entre 0 y `ptsAtaqueZ`.
3. Si el zombie muere, se reduce el contador de zombies de la habitación.
4. Cuando no quedan zombies, aparece el botón **Terminar** y desaparece el de **Luchar**.
5. Si el superviviente llega a 0 de vida, se desactivan todos los botones de acción.

### Sistema de búsqueda (`Superviviente.buscarPorLaHabitacion()`)
Solo disponible cuando no hay zombies en la habitación. Se usan hasta **3 intentos** por habitación. El resultado se determina con dados aleatorios (0–100):

| Resultado | Efecto |
|---|---|
| 1–75 | Se hace ruido — segundo dado que puede generar 0, 1 o 2 zombies nuevos |
| 76–90 | Se obtiene un **botiquín** |
| 91–95 | Se obtiene una **protección** |
| 96–100 | Se obtiene un **arma** |

### Curación (`Superviviente.curarse()`)
Usa el botiquín disponible para recuperar **4 puntos de vida**, sin superar el máximo de 20. El botiquín se consume al usarlo y solo se puede tener uno en inventario.

### Avanzar de habitación (`Superviviente.avanzarHabitacion()`)
Solo se puede avanzar si no quedan zombies en la habitación actual. Al avanzar:
- `habitacionActual` se incrementa.
- `intentosBusqueda` se restablece a 3.
- Se añade automáticamente 1 zombie en la nueva habitación.

Al llegar a la última habitación y eliminar todos sus zombies → **Victoria**.

---

## 🧱 Clases principales

| Clase | Descripción |
|---|---|
| `MansiónZombie` | Estado global estático de la partida (habitaciones, zombies, intentos) |
| `Superviviente` | Lógica del jugador — combate, búsqueda, curación, movimiento |
| `Zombie` | Entidad enemiga con vida y ataque escalados según la habitación actual |
| `Inicio` | Ventana de inicio y selector de dificultad, punto de entrada (`main`) |
| `Acciones` | HUD modal con stats del jugador y botones de acción |
| `Lucha` | Diálogo de combate por turnos con log de texto |

---

## ⚔️ Sistema de stats

### Superviviente
- **Vida máxima:** 20 pts
- **Ataque base:** 0–4 pts + bonus por armas encontradas
- **Botiquín:** 1 máximo, recupera 4 pts de vida
- **Armas y protecciones:** acumulables, obtenidas mediante búsqueda

### Zombie
Los stats del zombie escalan con la habitación actual:

```
vidaZ    = aleatorio(0–2) + 2 + (habitacionActual - 1)
ptsAtaqueZ = aleatorio(0–2) + 2 + (habitacionActual - 1)
```

Esto hace que los zombies sean progresivamente más peligrosos conforme el jugador avanza.

---

## ▶️ Requisitos y ejecución

- **Java JDK 8** o superior
- IDE recomendado: **NetBeans** (los archivos `.form` son formularios de NetBeans GUI Builder)
- La fuente `GhoulFriAOE.ttf` debe estar en la ruta `src/fuentes/` relativa al directorio de ejecución

### Compilar y ejecutar desde terminal

```bash
# Desde la raíz del proyecto (donde está src/)
javac -d out -sourcepath src -encoding UTF-8 src/Componentes/Inicio.java
java -cp out Componentes.Inicio
```

> ⚠️ Es necesario usar `-encoding UTF-8` al compilar porque los nombres de clase y atributos contienen caracteres con tilde (`MansiónZombie`, `enumDificultades`).

### Ejecutar desde NetBeans
1. Abrir el proyecto en NetBeans.
2. Establecer `Componentes.Inicio` como clase principal.
3. Ejecutar con `F6`.

---

## 📝 Notas técnicas

- Todos los botones usan imágenes PNG personalizadas cargadas desde `src/Imagenes/`.
- La tipografía **GhoulFriAOE.ttf** se carga en tiempo de ejecución con `Font.createFont()`. Si el archivo no se encuentra en la ruta esperada, el juego usa la fuente por defecto de Swing sin lanzar excepción (el error se captura y se imprime en consola).
- El estado global de la partida se gestiona mediante **atributos estáticos** en `MansiónZombie`, lo que permite que `Superviviente`, `Zombie` y los componentes de la UI compartan el mismo estado sin pasar referencias.
- Los botones de acción en `Acciones.java` y `Lucha.java` son **estáticos** para poder deshabilitarse desde `Superviviente` cuando el jugador muere.
- La ventana principal es **no decorada** (`setUndecorated(true)`); el cierre se gestiona con `BotonXCierre`.
