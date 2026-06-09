# Proton Standalone SH Creator

## Español

Este programa sirve para crear lanzadores `.sh` para juegos de Windows en Linux sin utilizar un lanzador externo, directamente desde el terminal.

Existen otros métodos, como Lutris, pero con este sistema se pueden usar las últimas versiones de Proton y, en algunos casos, ejecutar juegos que no funcionan en Lutris. Aun así, también hay juegos que solo funcionan en Lutris.

### Requisitos de uso

Para utilizarlo necesitas:

1. Crear un contenedor de Wine con PlayOnLinux; la versión de Wine no importa.
2. Dar acceso, como unidades, a los directorios donde están instalados los juegos.
3. Se recomienda crear un contenedor de Wine por cada versión de Proton.
4. También se recomienda cambiar la unidad `Z:` por un directorio vacío o por el punto de montaje del CD-ROM, para evitar que los juegos vean el sistema de archivos completo.

Debes indicar en el programa la ruta del contenedor de PlayOnLinux.

### Proton GE

Debes descargar una versión de Proton GE y modificar el archivo `proton` de Python siguiendo las instrucciones correspondientes. Según la versión de Proton, el proceso puede variar ligeramente, pero si conoces Python es fácil de adaptar.

En esta dirección web están disponibles varias versiones de Proton ya modificadas:

[https://www.magictoolsweb.com/linux-gaming/proton-standalone-sh-creator/](https://www.magictoolsweb.com/linux-gaming/proton-standalone-sh-creator/)

Debes indicar en el programa la ruta del directorio donde está Proton.

### Selección del ejecutable

Debes elegir en el programa el ejecutable `.exe` del juego. Este archivo debe abrirse desde una ruta similar a:

```text
/home/usuario/playonlinux virtual drives/nombre_del_contenedor/dosdevices/unidad_del_juego
```

Al hacer clic en **Create SH**, se genera un archivo `.sh` para lanzar el juego en la misma carpeta donde has descomprimido la versión de Proton GE.

Si ejecutas ese archivo desde el terminal, el juego se iniciará.

### Librerías

Al crear el archivo `.sh`, puedes elegir si quieres usar las librerías del sistema o las de Steam.

Con las librerías de Steam funcionan muchos más juegos, pero se recomienda usar las del sistema siempre que sea posible. En algunos casos, los juegos no arrancan o fallan los vídeos con las librerías del sistema; si ocurre eso, usa las de Steam. Esta opción puede seleccionarse desde un desplegable de la interfaz.

Recientemente se ha modificado el script porque las instalaciones nuevas de Steam ya no detectaban correctamente las librerías y, como consecuencia, no funcionaba nada.

Incluso se han conseguido ejecutar juegos de VR con este sistema usando WiVRn y unas Pico 4, siempre con las librerías del sistema.

### Cómo modificar Proton

Aunque en la web ya hay versiones de Proton modificadas, estas son las instrucciones del creador original del script, 7oxicshadow:

- Creado por 7oxicshadow (23/09/19)
- Repositorio original: [https://github.com/7oxicshadow/proton-standalone-script](https://github.com/7oxicshadow/proton-standalone-script)

#### Importante

Este script se ha probado con Proton GE, pero en teoría debería funcionar con cualquier versión de Proton.

- Proton GE releases: [https://github.com/GloriousEggroll/proton-ge-custom/releases](https://github.com/GloriousEggroll/proton-ge-custom/releases)

Antes de usar este script debes hacer dos cambios pequeños en el archivo Python de Proton.

> Haz siempre una copia de seguridad antes de modificar nada.

> No hagas estos cambios directamente sobre la versión de Proton usada por Steam. Crea una copia de la carpeta de Proton o usa una versión descargada aparte, ya que estos cambios impedirían que los juegos de Steam arrancasen correctamente.

1. Abre el archivo Python de Proton en un editor de texto.
2. Busca la siguiente línea dentro de la sección `def run(self)`:

```python
self.run_proc([g_proton.wine_bin, "steam"] + sys.argv[2:])
```

3. Cámbiala por esta:

```python
self.run_proc([g_proton.wine_bin] + sys.argv[2:])
```

4. Busca la siguiente línea dentro de la sección `class CompatData`:

```python
self.prefix_dir = self.path("pfx/")
```

5. Cámbiala por esta:

```python
self.prefix_dir = self.path("")
```

6. Guarda los cambios.

## English

This program is used to create `.sh` launchers for Windows games on Linux without using an external launcher, directly from the terminal.

There are other methods, such as Lutris, but this approach lets you use the latest Proton versions and, in some cases, run games that do not work in Lutris. That said, there are also games that only work in Lutris.

### Requirements

To use it, you need to:

1. Create a Wine container with PlayOnLinux; the Wine version does not matter.
2. Grant access, as drive mappings, to the directories where the games are installed.
3. It is recommended to create one Wine container for each Proton version.
4. It is also recommended to change the `Z:` drive to an empty directory or to the CD-ROM mount point so games cannot see the full host filesystem.

You must specify the path to the PlayOnLinux container in the program.

### Proton GE

You need to download a Proton GE release and modify the Python `proton` file according to the instructions. The exact process may vary slightly depending on the Proton version, but if you know Python it is easy to adapt.

Several already modified Proton versions are available here:

[https://www.magictoolsweb.com/linux-gaming/proton-standalone-sh-creator/](https://www.magictoolsweb.com/linux-gaming/proton-standalone-sh-creator/)

You must specify the path to the Proton directory in the program.

### Executable selection

In the program, choose the game's `.exe` file. It should be opened from a path similar to:

```text
/home/user/playonlinux virtual drives/container_name/dosdevices/game_drive
```

When you click **Create SH**, the program creates a `.sh` file to launch the game in the same folder where you extracted the Proton GE release.

If you run that file from the terminal, the game will start.

### Libraries

When creating the `.sh` file, you can choose whether to use the system libraries or the Steam libraries.

More games work with the Steam libraries, but it is recommended to use the system libraries whenever possible. In some cases, games may fail to start or videos may break when using the system libraries; if that happens, switch to the Steam libraries. This option can be selected from a drop-down menu in the interface.

The script was recently modified because newer Steam installations no longer detected the libraries correctly, which caused everything to stop working.

This method has even been used successfully to run VR games with WiVRn and a Pico 4 headset, always using the system libraries.

### How to modify Proton

Although modified Proton builds are already published on the website, these are the instructions from the original script author, 7oxicshadow:

- Created by 7oxicshadow (23/09/19)
- Original repository: [https://github.com/7oxicshadow/proton-standalone-script](https://github.com/7oxicshadow/proton-standalone-script)

#### Important

This script has been tested with Proton GE, but in theory it should work with any Proton version.

- Proton GE releases: [https://github.com/GloriousEggroll/proton-ge-custom/releases](https://github.com/GloriousEggroll/proton-ge-custom/releases)

Before using this script, you must make two small changes to Proton's Python file.

> Always make a backup before changing anything.

> Do not apply these changes directly to the Proton version used by Steam. Create a copy of the Proton folder or use a separately downloaded build, because these changes would prevent Steam games from launching correctly.

1. Open Proton's Python file in a text editor.
2. Find the following line inside the `def run(self)` section:

```python
self.run_proc([g_proton.wine_bin, "steam"] + sys.argv[2:])
```

3. Change it to:

```python
self.run_proc([g_proton.wine_bin] + sys.argv[2:])
```

4. Find the following line inside the `class CompatData` section:

```python
self.prefix_dir = self.path("pfx/")
```

5. Change it to:

```python
self.prefix_dir = self.path("")
```

6. Save the changes.
