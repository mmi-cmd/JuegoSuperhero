Análisis:


1. Usar una clase abstracta que funcona como clase base o padre llamada Personaje con: 

    - Las características o atributos compartidos y que pueden heredarse como: nombre, fuerza, velocidad y vida_hp.

    - un método normal (con implementación) para mostrar las estadísticas actuales:

        Dentro de este metodo, se van a imprimir las estadisitcas luego de cada batalla con los atributos (nombre, fuerza, velocidad y vida_hp)

    -Un método con implementación para acciones comparidas como defender y recuperarse

        a. En defender se usa un atributo denominado isDefending = true, que va a defiir si el oponente desea defenderse o no en caso de hacerlo, poder reducir el daño generado a la mitad.

        b. En recuperar, cada personaje va a poder aumentar su vida_hp en 20


    - un método abstracto: para el ataque especial, ya que cada superhéroe o villano lo puede ejecutar de manera diferente (el superhéroe tiene ataques especiales y el villano puede duplicar su ataque).

        a. Para el caso de villano, este método especial consiste en hacer trampa, en donde este puede duplicar su fuerza y por lo tanto aumentar el daño generado al oponente.

        b. Para el cas de superhero, este método especial consiste en aumentar sus poderes en 35 para generar un mayor daño a su oponente

    - un método abstracto: para la funcion atacar, ya que cada superhéroe o villano lo puede ejecutar de manera diferente.

        a. Para el caso del villano este método va a estar controlado por un if que depende del isDefending  mencionado antes, en caso de quel oponenete decida hacer la defensa, solo se generará la mitad del dao y además de esto se se usa la funcion random que permite generar un  numero entre 0 y 5 que se suma a sus poderes, ya que este tiene la capacidad de hacer trampa. Y en caso de no hacer la defensa, el daño generado es completo a su oponente, más la suma de numero random generado.

        b. Para el caso del superhero, este método también esta controlado por el if que depende de isDefending, pero a diferencia de villano, este no puede hacer trampa, por lo tanto el dao generado es igual a su fuerza en caso de no defensa y en caso de defensa, su fuerza se aplica reducida a la mitad.


2. Crear dos subclases de Personaje --> SuperHero y Villano

    -Aplicar la herencia en cada uno y los métodos abstractos para modificarlos según corresponda 

3. Dentro del main crear 4 objetos dentro de una ArrayList, dos que representen a Villao y dos a Superhero

4. Se implementa una sobrecarga de métodos, en este caso se sobrecarga el método atacar, dandole un nuevo paárametro denomidado aumentarPoder, esto con el fin de que su fuerza se amplifique y se genere un mayor daño. Tanto el villano, como el superhero tiene esta misma sobrecarga, basado en su método atacar.

5. Con el fin de veificar la vida_hp de cada personaje, se verifica con un if si esta es menor o igual a cero y en este caso, el juego termina.


Dentro de la simulación del juego se usan algunos conceptos importantes de POO como:

1. La herencia es un principio que permite crear una nueva clase (subclase o clase derivada) a partir de una clase existente (superclase o clase base). La subclase hereda los atributos y métodos de la superclase, lo que promueve la reutilización del código y una jerarquía de clases.

    Ejemplo: La clase principal es Personaje y de ella heredan Superhero y Villano

2. Clase abstracta: Puede contener métodos abstractos (sin implementación) y métodos concretos (con implementación). Se utiliza como plantilla para otras clases, lo que obliga a las subclases a implementar los métodos abstractos. En este caso Peronaje obliga a Superhero y Villano a implementar métodos absctractos como atacar

3. Funciones asbtractas: Las funciones (o métodos) abstractas son aquellos que se declaran en una clase abstracta sin proporcionar una implementación. Las subclases que heredan de la clase abstracta deben implementar estas funciones para ser instanciables.

    Ejemplo: Gracias a la clase abstracta atacar, tanto villano como superhero puede heredarla y modificarla segun deseen.

4. Encapsulamiento: que permite cotrolar el acceso entre clases. Por ejemplo el uso en los atributos de protected, para permitir que los atributos o métodos sean accesibles únicamente dentro de la misma clase


