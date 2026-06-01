package ClasesLogica;

import Componentes.Acciones;
import Componentes.Lucha;

public class Superviviente {

    private final int vidaMaximaS = 20; //Se establece este atributo como constante debido a que su valor no puede variar.
    int vidaS = 20;
    private int ptsAtaqueS = 4;
    private boolean botiquinS = false; //Se tipa este atributo como boolean para evitar la acumulación de botiquines.
    private int cantidadArmasS = 0;
    private int cantidadProteccionesS = 0;
    private int ataqueS;

    //Getters de los atributos privados
    public int getVidaMaximaS() {
        return vidaMaximaS;
    }

    public int getVidaS() {
        return vidaS;
    }

    public int getPtsAtaqueS() {
        return ptsAtaqueS;
    }

    public String getBotiquinS() {
        if (botiquinS == true) {
            return "SI";
        } else {
            return "NO";
        }
    }

    public int getCantidadArmasS() {
        return cantidadArmasS;
    }

    public int getCantidadProteccionesS() {
        return cantidadProteccionesS;
    }

    public int getAtaqueS() {
        return ataqueS;
    }

    public String combatirZombie(Superviviente s, Zombie z) {
        String informacion = "";
        s.ataqueS = (int) (Math.random() * s.ptsAtaqueS) + s.cantidadArmasS;
        z.ataqueZ = (int) (Math.random() * z.ptsAtaqueZ);

        if (s.vidaS > 0) {
            if (MansiónZombie.numeroZombiesXHabitacion <= 0) { // A través de este condicional if se comprueba que halla Zombies en la habitación.
                informacion = "No hay zombies contra los que luchar";
                Lucha.botonLuchar.setVisible(false);//Se desactiva el boton
                Lucha.botonTerminar.setVisible(true);
            } else {

                informacion = "El zombie tiene: " + z.ataqueZ + "Pts de ataque y: " + z.vidaZ + "Pts de vida \nComienza el ataque... \n";

                z.vidaZ = z.vidaZ - s.ataqueS;

                if (z.vidaZ <= 0) {
                    informacion += "Has hecho " + ataqueS + "Pts de danio, el zombie tiene 0 Pts de vida \nFelicidades, has conseguido acabar con el zombie!!!!!!!\n";
                    MansiónZombie.numeroZombiesXHabitacion = MansiónZombie.numeroZombiesXHabitacion - 1;

                    if (MansiónZombie.numeroZombiesXHabitacion <= 0) {
                        informacion += "Has acabado con todos los zombies de la habitacion.";
                        Lucha.botonLuchar.setVisible(false);//Se desactiva el boton
                        Lucha.botonTerminar.setVisible(true);
                    } else {
                        informacion += "Quedan: " + MansiónZombie.numeroZombiesXHabitacion + " zombies en la habitacion";
                    }

                } else {
                    informacion += "Has hecho " + s.ataqueS + "Pts de danio, el zombie tiene " + z.vidaZ + "Pts de vida \nVaya vaya, el zombie a sobrevivido ahora es su turno de atacar :(";

                    s.vidaS = s.vidaS - z.ataqueZ;
                    if (vidaS <= 0) {
                        informacion += "El zombie ha acabado contigo... \n ***GAME OVER***";
                    } else {
                        informacion += "Has sobrevivido al ataque de " + z.ataqueZ + "Pts del zombie \nTe has quedado con " + vidaS + "Pts de vida";
                    }
                }

            }
        } else {
            informacion = "Has muerto, no puedes atacar";
            Lucha.botonLuchar.setEnabled(false);
            Acciones.botonLuchar.setEnabled(false);
            Acciones.botonCurarse.setEnabled(false);
            Acciones.botonBuscar.setEnabled(false);
            Acciones.botonAvanzar.setEnabled(false);

        }
        return informacion;
    }

    public String buscarPorLaHabitacion() {
        String informacion = "";
        if (MansiónZombie.intentosBusqueda <= 0) {
            informacion = "No tienes mas intentos de busqueda";
            Lucha.botonLuchar.setVisible(false);
        } else {
            if (MansiónZombie.numeroZombiesXHabitacion > 0) {
                informacion = "Sigue habiendo Zombies en la habitacion, no puedes buscar.";
                Lucha.botonLuchar.setVisible(false);
            } else {
                MansiónZombie.intentosBusqueda--;
                informacion = "Has tirado un dado...\n";
                int dado = (int) (Math.random() * 100);
                informacion += "El resultado ha sido: " + dado + "\n";

                if (dado >= 1 && dado <= 75) {
                    informacion += "Has hecho ruido... \n Vuelves a tirar un dado...\n";
                    int dado2 = (int) (Math.random() * 100);
                    informacion+= "El resultado ha sido: " + dado2 + "\n";

                    if (dado2 >= 1 && dado <= 40) {
                        informacion += "No se ha generado ningun zombie, puedes estar tranquilo\n";
                    } else if (dado2 >= 11 && dado2 <= 80) {
                        informacion += "Vaya!!! Se ha anadido un zombie a la habitacion\n";
                        MansiónZombie.numeroZombiesXHabitacion++;
                    } else if (dado2 >= 81 && dado2 <= 100) {
                        informacion += "Vaya!!! Se ha anadido dos zombies a la habitacion\n";
                        MansiónZombie.numeroZombiesXHabitacion = MansiónZombie.numeroZombiesXHabitacion + 2;
                    }
                } else if (dado >= 76 && dado <= 90) {
                    informacion += "Felicidades!!! Has recibido un botiquin\n";
                    botiquinS = true;
                } else if (dado >= 91 && dado <= 95) {
                    informacion += "Felicidades!!! Has recibido una proteccion\n";
                    cantidadProteccionesS++;
                } else if (dado >= 96 && dado <= 100) {
                    informacion += "Felicidades!!! Has recibido un arma\n";
                    cantidadArmasS++;
                }
            }
        }
        
        return informacion;
    }

    public void avanzarHabitacion() {
        if (MansiónZombie.numeroZombiesXHabitacion <= 0) {
            if (MansiónZombie.habitacionActual >= MansiónZombie.cantidadHabitaciones) {
                System.out.println("Estas en la ultima habitacion, no puedes avanzar");
            } else {
                MansiónZombie.habitacionActual++;
                MansiónZombie.intentosBusqueda = 3;
                System.out.println("Has pasado de habitacion y se han reestablecido los intentos de busqueda");
                MansiónZombie.numeroZombiesXHabitacion++;
            }
        } else {
            System.out.println("No puedes avanzar de habitacion si sigue habiendo zombies en ella");
        }
    }

    public void curarse() {
        if (botiquinS == true) {
            System.out.println("Te estas curando...");
            vidaS = vidaS + 4;

            if (vidaS > 20) {
                int diferencia = vidaS - 20;
                vidaS = vidaS - diferencia;
                System.out.println("Tienes: " + vidaS + "Pts de vida \n Has adquirido: " + diferencia + "Pts de vida");
            } else {
                System.out.println("Tienes: " + vidaS + "Pts de vida \n Has adquirido: 4Pts de vida");
            }
            botiquinS = false;
        } else {
            System.out.println("No te quedan botiquines, no te has curado...");
        }
    }

}
