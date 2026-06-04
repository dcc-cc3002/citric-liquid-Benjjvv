# 99.7% Citric Liquid

## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---

## For Students
--------------
Tarea 1
--------------
No hice README para la Tarea1.

--------------
Tarea 2
--------------
Bueno, en esta entrega se me complico bastante el tema del combate. Hice una variable para las unidades en general(WU o Player)
que se llama combatMode, el cual es un string que puede ser "EVA" o "DEF" para asi al momento de recibir un ataque se apliquen las reglas
de evasion o defensa. Este por defecto esta en modo defensa pero se puede cambiar (mi idea es que se cambie a futuro con el controlador).

Por otro lado, mis funciones de ataque/defensa/evasion no paran hasta que alguien de los de la pelea este derrotado, es ahi
donde entrego las estrellas usando algo similar a combatMode, hice un metodo que recibe las estrellas que se tienen que dar y un string
que indique si es un Wild Unit o un Plater, ya que un wild unit entrega todas sus estrellas y un jugador solo la mitad.

Sobre los paneles, en el Encounter Panel hice un metodo el cual aleatoriamente hace que spawnee un wild unit en el panel
el cual entra en combate con un jugador que este en el panel, para ello instancie un dado de 3 caras.

Sobre cambios con mi tarea1, separe la norma en distintas clases y cree un trait norma junto con una clase abstracta, lo
mismo para los paneles que no tenia clase abstracta y para las unidades cree traits wildunit y units ya que es mala practica
usar una clase abstracta como tipó y mis funciones en algun momento las usaron como tipo, con los traits me ahorro este problema.



## Diagrama de estados

![Diagrama de estados](enunciados/diagrama-estados.png)


<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---