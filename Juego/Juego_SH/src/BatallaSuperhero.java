import java.util.Scanner;
import java.util.ArrayList;

public class BatallaSuperhero {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String continuar = "si";

    ArrayList<Personaje> personajes = new ArrayList<>();

    // Se agregan los personajes al ArrayList
    personajes.add(new Superhero("Spiderman", 8, 40, 100));
    personajes.add(new Villano("Venom", 10, 50, 100));
    personajes.add(new Superhero("Thor", 12, 50, 100));
    personajes.add(new Villano("Hela", 14, 60, 100));

    do {
      // Menú inicial para elegir la batalla
      System.out.println("\nElige la batalla a realizar:");
      System.out.println("1. " + personajes.get(0).nombre + " vs " + personajes.get(1).nombre);
      System.out.println("2. " + personajes.get(2).nombre + " vs " + personajes.get(3).nombre);
      System.out.println("3. Salir");
      System.out.print("Selecciona una opción: ");
      int opcionBatalla = scanner.nextInt();

      switch (opcionBatalla) {
        case 1:
          // Primera batalla entre Spiderman y Venom
          realizarBatalla(scanner, personajes.get(0), personajes.get(1));
          break;
        case 2:
          // Segunda batalla entre Thor y Hela
          realizarBatalla(scanner, personajes.get(2), personajes.get(3));
          break;
        case 3:
          continuar = "no"; // Opción para salir
          System.out.println("End game...");
          scanner.close();
          return;
        default:
          System.out.println("Opción no válida.");
          continue; //Al usar continue, el programa regresa al inicio del bucle y le permite al usuario volver a elegir una opción correcta
      }

      System.out.println("¿Deseas realizar otra batalla? (si) / (no)"); //se pregunta si el usuario desea realizar otra batalla
      continuar = scanner.next();

    } while (continuar.equalsIgnoreCase("si"));

    System.out.println("End game...");
    scanner.close();
  }

  // Método para realizar una batalla entre dos personajes
  public static void realizarBatalla(Scanner scanner, Personaje superhero, Personaje villano) {
    System.out.println();
    System.out.println("¡Bienvenido a Shadows of Justice! ¡Prepárate para luchar contra la oscuridad y restaurar la justicia en un mundo caótico!");
    System.out.println("\nEstadísticas de inicio de la batalla");
    System.out.println("------------------------------------------------");
    superhero.MostrarEstadísticasActuales();
    villano.MostrarEstadísticasActuales();
    System.out.println("------------------------------------------------");

    System.out.println("\n¡Qué comience la batalla!");
    System.out.println(superhero.nombre + " vs " + villano.nombre);
      
    boolean enBatalla = true; 
    while (enBatalla) {
      // Menú de opciones para el superhéroe
      System.out.println("\nElige la acción para " + superhero.nombre + ":");
      System.out.println("1. Atacar");
      System.out.println("2. Atacar con poder aumentado");
      System.out.println("3. Defender");
      System.out.println("4. Ataque Especial");
      System.out.println("5. Recuperar Vida");
      System.out.println("6. Finalizar batalla");

      int opcionSuperhero = scanner.nextInt();
      switch (opcionSuperhero) {
        case 1:
          superhero.atacar(villano);
          break;
        case 2:
          ((Superhero)superhero).atacar(villano, 3);
          break;
        case 3:
          superhero.defender(villano);
          break;
        case 4:
          superhero.ataqueEspecial(villano);
          break;
        case 5:
          superhero.recuperar();
          break;
        case 6:
          enBatalla = false;
          break;
        default:
          System.out.println("Opción no válida.");
          continue; //Al usar continue, el programa regresa al inicio del bucle y le permite al usuario volver a elegir una opción correcta 
      }
      
      villano.MostrarEstadísticasActuales();

      if (!enBatalla) break; //si se elige la opcion 6, la batalla termina, porque se cambia enBatalla de true a false

      // Menú de opciones para el villano
      System.out.println("\nElige la acción para " + villano.nombre + ":");
      System.out.println("1. Atacar");
      System.out.println("2. Atacar con poder aumentado");
      System.out.println("3. Defender");
      System.out.println("4. Ataque Especial");
      System.out.println("5. Recuperar Vida");
      System.out.println("6. Finalizar batalla");

      int opcionVillano = scanner.nextInt();
      switch (opcionVillano) {
        case 1:
          villano.atacar(superhero);
          break;
        case 2:
          ((Villano)villano).atacar(superhero, 3);
          break;
        case 3:
          villano.defender(superhero);
          break;
        case 4:
          villano.ataqueEspecial(superhero);
          break;
        case 5:
          villano.recuperar();
          break;
        case 6:
          enBatalla = false;
          break;
        default:
          System.out.println("Opción no válida.");
          continue;
      }

      superhero.MostrarEstadísticasActuales();
    }

    System.out.println("\n¡Fin de la batalla!");
    System.out.println("------------------------------------------------");
    System.out.println("Estadísticas del fin de la batalla");
    villano.MostrarEstadísticasActuales();
    superhero.MostrarEstadísticasActuales();
  }
}
