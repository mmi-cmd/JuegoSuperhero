public abstract class Personaje { // se crea una clase abstracta que funciona como la clase base o padre con la finalidad de que atributos compartidos pueden heredarse, así como la creación de funciones abstractas
                                
    protected String nombre; //se usa protected para permitir que los atributos o métodos sean accesibles únicamente dentro de la misma clase
    protected int fuerza;
    protected int velocidad;
    protected int vida_hp;
    protected boolean isDefending; //agregue atributo para verificar si el oponente se defiende o no
    private static final int MAX_VIDA = 100;


    public Personaje(String nombre, int fuerza, int velocidad, int vida_hp) { // se crea el constructor que permite inicializar los atributos en el objeto
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
        this.isDefending = false;
    }

    public void MostrarEstadísticasActuales (){ // se crea metodo normal para mostrar las estadisticas actuales
        System.out.println("Soy " + this.nombre + " y estas son mis estadísticas: ");
        System.out.println(" -Fuerza: " + this.fuerza);
        System.out.println(" -Velocidad: " + this.velocidad);
        System.out.println(" -Vida HP: " + this.vida_hp);
        System.out.println("------------------------------------------------");
    }

    public void defender(Personaje oponente){ //funcion que define si un personaje entra en defensa
        this.isDefending = true; // Marca que está en defensa para el próximo ataque
        System.out.println(this.nombre + " se prepara para defenderse del próximo ataque.");
        System.out.println("------------------------------------------------");
    }


      // Método para recuperar puntos de vida (HP)
    public void recuperar() {
        int puntosRecuperados = 10;
        if (this.vida_hp < MAX_VIDA) {
            this.vida_hp = Math.min(this.vida_hp + puntosRecuperados, MAX_VIDA); //Math.min se utiliza para asegurarse de que vida_hp no exceda el límite de 100 puntos.
            System.out.println(this.nombre + " ha recuperado puntos de vida hasta " + this.vida_hp + ".");
        } else {
            System.out.println(this.nombre + " ya tiene la vida completa.");
        }
    }

    public abstract void atacar(Personaje oponente); // Método abstracto para atacar para que cada subclase, lo puede implementar según sus necesidades

    public abstract void ataqueEspecial(Personaje oponente);  // Método abstracto para el ataque especial, esto porque cada tipo de clase (superhero y villano), lo puedan usar segun sus propios requerimientos
    
}
//Un método abstracto no tiene implementación en la clase abstracta donde se define.
//Obliga a las subclases a que lo implementen para proporcionar su propia versión del método.