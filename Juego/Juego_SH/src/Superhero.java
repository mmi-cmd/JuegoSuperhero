public class Superhero extends Personaje { //Se crea la clase Superhero que va a servir de "molde" para crear el objeto Superhero
                                                                //extends se usa para indicar que superhero es un elemento "hijo" de personaje

    public Superhero(String nombre, int fuerza, int velocidad, int vida_hp) { //se crea constructor 
        super(nombre, fuerza, velocidad, vida_hp); //Se heredan los atributos de la clase "padre" personaje
    }


    @Override //se implementa el metodo atacar para modificarlo
    public void atacar(Personaje oponente) { //en caso de defensa se ejecuta 
    /*  Paso por referencia: Se aplica a los objetos, como el parámetro oponente, donde se pasa una copia 
       de la referencia al objeto. Modificaciones al objeto dentro del método se reflejan fuera de él. */
        if (oponente.isDefending) {
    
            int danioReducido = this.fuerza / 2; // Aplica la mitad del daño, debido a que el oponente se defiende
            oponente.vida_hp -= danioReducido;
            oponente.isDefending = false; // Resetea el estado de defensa para que no quede así en todo el juego, sino temporalmente
            System.out.println(this.nombre + " ataca a " + oponente.nombre + " y le hace daño.");
            System.out.println(oponente.nombre + " se ha defendido del ataque, no recibe daño completo. Solo recibe " + danioReducido + " N de daño" );
            
        } else{ //en caso de NO defensa se ejecuta 
        int danio = this.fuerza;  //el daño es completo, en estecaso igual a su fuerza
        oponente.vida_hp -= danio; //Cambios como este modifican directamente el objeto oponente, y esas modificaciones persisten fuera del método.
        System.out.println(this.nombre + " ataca a " + oponente.nombre + " y le hace daño con una fuerza de " + danio + " N");
        }
        
        // Verificar si la vida del oponente es menor o igual a 0
        if (oponente.vida_hp <= 0) {
            System.out.println("la vida de "+ oponente.nombre + " es cero, por lo tanto, ha muerto. Fin del juego.");
            System.exit(0); // Termina el programa 
            } else{
                // Mostrar la vida restante del oponente en caso de que sea mayor a 0
            System.out.println("La vida de " + oponente.nombre + " después del ataque es: " + oponente.vida_hp);
            }
        System.out.println("------------------------------------------------");
    }   

         // Sobrecarga del método atacar (con aumento de poder)
        public void atacar(Personaje oponente, int aumentadorPoder) {
                                            //se agrega al argumento o parámtero del método un mltiplicador que permite hacer la sobrecarga
            if (oponente.isDefending) {
        
                int danioReducido = (this.fuerza * aumentadorPoder) / 2; // se aumentan los poderes multiplcando su fuerza
                oponente.vida_hp -= danioReducido;
                oponente.isDefending = false; // Resetea el estado de defensa
                System.out.println(this.nombre + " ha aumentado sus poderes en " + aumentadorPoder + " para atacar a " + oponente.nombre + " y le hace daño. ");
                System.out.println(oponente.nombre + " se ha defendido del ataque, no recibe daño completo. Solo recibe " + danioReducido + " de daño");
            
            } else{
            int danio = this.fuerza * aumentadorPoder;  // Aumenta el daño con el multiplicador aumentarPoder
            oponente.vida_hp -= danio;
            System.out.println(this.nombre + " ha aumentado sus poderes en " + aumentadorPoder + " para atacar a " + oponente.nombre + " y le hace daño con una fuerza de " + danio + " N");
            /* Ejemplo de paso por valor: Aquí, aumentadorPoder es un tipo primitivo int, por lo tanto, se pasa por valor. 
                El valor de aumentadorPoder se copia y cualquier cambio que se haga dentro del método no afectará 
                la variable original fuera del método. */
        
            }
            
            // Verificar si la vida del oponente es menor o igual a 0
            if (oponente.vida_hp <= 0) {
                System.out.println("la vida de "+ oponente.nombre + " es cero, por lo tanto, ha muerto. Fin del juego.");
                System.exit(0); // Termina el programa 
                } else{
                    // Mostrar la vida restante del oponente
                System.out.println("La vida de " + oponente.nombre + " después del ataque es: " + oponente.vida_hp);
                }
            System.out.println("------------------------------------------------");
        }

    @Override // se invoca al método abstracto, para que la subclase (superhero) implementar su propia versión de ataque especial
    public void ataqueEspecial(Personaje oponente) {
        int danioEspecial = this.fuerza + 35; //como ataque especial, superhero aumenta su fuerza en 35 
        oponente.vida_hp -= danioEspecial;
        System.out.println("El superHeroe "+ this.nombre + " se lanza contra su oponente " + oponente.nombre + " usando su ataque especial y reduce su vida en " + danioEspecial);
        
        // Verificar si la vida del oponente es menor o igual a 0
        if (oponente.vida_hp <= 0) {
            System.out.println("la vida de "+ oponente.nombre + " es cero, por lo tanto, ha muerto. Fin del juego.");
            System.exit(0); // Termina el programa 
            } else{
                // Mostrar la vida restante del oponente
            System.out.println("La vida de " + oponente.nombre + " después del ataque es: " + oponente.vida_hp);
            }
            System.out.println("------------------------------------------------");
    }
}
