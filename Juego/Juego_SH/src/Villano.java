import java.util.Random;
public class Villano extends Personaje { //extends se usa para indicar que villano es un elemento "hijo" de personaje

    public Villano(String nombre, int fuerza, int velocidad, int vida_hp) { //se crea constructor 
        super(nombre, fuerza, velocidad, vida_hp); //Se heredan los atributos de la clase "padre" personaje
        
    }


    @Override //se implementa el metodo atacar para modificarlo
    public void atacar(Personaje oponente) { //en caso de defensa se ejecuta 
        Random random = new Random();
        if (oponente.isDefending) {
    
            int danioReducido = this.fuerza / 2; // Aplica la mitad del daño
            oponente.vida_hp -= danioReducido;
            oponente.isDefending = false; // Resetea el estado de defensa
            System.out.println(this.nombre + " ataca a " + oponente.nombre + " y le hace daño.");
            System.out.println(oponente.nombre + " se ha defendido del ataque, no recibe daño completo. Solo recibe " + danioReducido + " de daño");
        
        } else{ //en caso de defensa se ejecuta 
        int danio = this.fuerza + random.nextInt(5) ;  //al daño generado se le suma un numero random entre 0 y 5 ya que el villano puede hacer trampa
        oponente.vida_hp -= danio;                           // la operacion danio - this.fuerza,  descifra el numero random generado para saber si se hizo o no trampa 
        System.out.println(this.nombre + " ataca a " + oponente.nombre);

            if (danio - this.fuerza >= 1 && danio - this.fuerza <= 5) { //se verifica con un if si el villano hace trampa restando al el daño total generado la fuerza base del personaje  
                System.out.println(this.nombre  + " ¡Hizo trampa! Aumentó su daño en " + (danio - this.fuerza) + " y le hace daño a " + oponente.nombre + " con una fuerza de " + danio);
            }
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

        public void atacar(Personaje oponente, int aumentadorPoder ) { // Sobrecarga del método atacar (con aumento de poder)
            Random random = new Random();
            if (oponente.isDefending) {
        
                int danioReducido = this.fuerza * aumentadorPoder / 2; // Aplica la mitad del daño
                oponente.vida_hp -= danioReducido;
                oponente.isDefending = false; // Resetea el estado de defensa
                System.out.println(this.nombre + " ha aumentado sus poderes en " + aumentadorPoder + " para atacar a " + oponente.nombre + " y le hace daño.");
                System.out.println(oponente.nombre + " se ha defendido del ataque, no recibe daño completo. Solo recibe " + danioReducido + " N de daño");
            
            } else{
            int danio = (this.fuerza * aumentadorPoder) + random.nextInt(5) ;  //al daño generado se le suma un numero random entre 0 y 5 ya que el villano puede hacer trampa
            oponente.vida_hp -= danio;                           // la operacion danio - this.fuerza,  descifra el numero random generado para saber si se hizo o no trampa 
            System.out.println(this.nombre + " ha aumentado sus poderes en " + aumentadorPoder + " para atacar a " + oponente.nombre + " y le hace daño con una fuerza de " + danio + " N");

                if (danio - (this.fuerza * aumentadorPoder) >= 1 && danio - (this.fuerza * aumentadorPoder) <= 5) { //se verifica con un if si el villano hace trampa restando al el daño total generado la fuerza base del personaje  
                    System.out.println(this.nombre  + " ¡Hizo trampa! Aumentó su daño en " + (danio - this.fuerza) + " y le hace daño a " + oponente.nombre + " con una fuerza de " + danio);
                }
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

    @Override //metodo para hacer trampa
    public void ataqueEspecial(Personaje oponente) { // se invoca al método abstracto, para que la subclase (superhero) implementar su propia versión de ataque especial
        int danioTrampa = this.fuerza * 2; //el atacante hace trampa para duplica su ataque
        oponente.vida_hp -= danioTrampa;
            System.out.println("El villano " + this.nombre + " hace trampa, duplicado su ataque a " + oponente.nombre + " con una nueva fuerza de " + danioTrampa  );
        
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
