package ClasesLogica;

public class Zombie {
    
    public int vidaZ = (int) (((Math.random() * 2) + 2) + (MansiónZombie.habitacionActual - 1));
    public int ptsAtaqueZ = (int) (((Math.random() * 2) + 2) + (MansiónZombie.habitacionActual - 1));
    public int ataqueZ;
    
}
