package ClasesLogica;

import java.util.Scanner;

public class MansiónZombie {

    Scanner sc = new Scanner(System.in);

    public static int cantidadHabitaciones; //A través de este atributo también se puede definir la dificultad del juego; Fácil -> 5 habitaciones Difícil -> 10 habitaciones.
    public static int intentosBusqueda = 3;
    public static int habitacionActual = 1; // Se establece como estático para que la clase Zombie pueda acceder al valor de este atributo y asi poder calcular la cantidad de vida y ataque de cada Zombie.
    public static int numeroZombiesXHabitacion = 1;

    /*int elegirDificultad() {
        System.out.println("Elija la cantidad de habitaciones: \n "
                + "5 --> Nivel Facil \n"
                + "10 --> Nivel Dificil");

        cantidadHabitaciones = sc.nextInt();

        while (cantidadHabitaciones != 5 && cantidadHabitaciones != 10) { //Con este bucle While se comprueba qu el usuario a introducido una cantidad correcta de habitaciones no distina a 5 ni 10
            System.out.println("Elija un valor valido: \n "
                    + "5 --> Nivel Facil \n"
                    + "10 --> Nivel Dificil");

            cantidadHabitaciones = sc.nextInt();
        }

        switch (cantidadHabitaciones) {
            case 5:
                System.out.println("Has elegido el nivel facil, que comience la aventura...");
                break;
            case 10:
                System.out.println("Has elegido el nivel dificil, que comience la aventura...");
                break;
        }

        return cantidadHabitaciones;
    }*/

    void verInformacion() { //Se añade este metodo para que el jugador pueda ver en cualquier momento la imformacion general relativa a la partida.
        int habitacionesRestantes = cantidadHabitaciones - habitacionActual; //Se añade esta variable para que el jugador pueda conocer la cantidad. de habitaciones que tiene por delante.
        System.out.println("Se encuentra en la habitacion: " + habitacionActual + "\n"
                + "Cuenta con: " + intentosBusqueda + " intentos de busqueda" + "\n"
                + "El numero de zombies activos es de: " + numeroZombiesXHabitacion + "\n"
                + "Quedan : " + habitacionesRestantes + " habitaciones restantes");
    }

    void mostrarMenuAccionesDisponibles(Superviviente s, Zombie z) {
        boolean fin = false;
        String opciones = "Elija una opcion: \n"
                + "1.Combatir contra un zombie \n"
                + "2.Buscar por la habitacion \n"
                + "3.Curarte \n"
                + "4.Comprobar vida \n"
                + "5.Ver informacion general \n"
                + "6.Avanzar habitacion \n"
                + "7.Salir";

        System.out.println(opciones);
        int opcion = sc.nextInt();

        while (opcion < 1 || opcion > 7) {
            System.out.println(opciones);
            opcion = sc.nextInt();
        }

        while (opcion != 7 && s.vidaS > 0) {
            switch (opcion) {
                case 1:
                    System.out.println("Has decidido luchar");
                    break;
                case 2:
                    System.out.println("Has decidido buscar por la habitacion");
                    s.buscarPorLaHabitacion();
                    break;
                case 3:
                    System.out.println("Has decidido curarte");
                    s.curarse();
                    break;
                case 4:
                    System.out.println("Tienes: " + s.vidaS + "Pts de vida");
                    break;
                case 5:
                    System.out.println("Has decidido ver la informacion general");
                    verInformacion();
                    break;
                case 6:
                    System.out.println("Has decidido avanzar de habitacion");
                    s.avanzarHabitacion();
                    break;
            }
            System.out.println("----------------------------------------------------");
            if (s.vidaS > 0) { // Comprobación de que el superviviente sigue con vida
                System.out.println(opciones);
                opcion = sc.nextInt();
            }
        }
        if (opcion == 7) {
            System.out.println("Has salido del juego");
        }
    }

    public static void main(String[] args) {
        //MansiónZombie a = new MansiónZombie();
        //a.elegirDificultad();
        //a.mostrarMenuAccionesDisponibles(s, z);

    }
}
