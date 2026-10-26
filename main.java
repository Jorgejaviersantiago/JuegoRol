
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre;
        int vidaMaxima;
        int vidaActual;
        int pocion;
        int danio;
        int opciones;
        boolean algo = false;

        do {

            System.out.println("Nombre del aventurero.");
            nombre = sc.nextLine();
            System.out.println("Vida Maxima");
            vidaMaxima = sc.nextInt();
            vidaMaxima = leerNaturales();
            System.out.println("VidaActual");
            vidaActual = sc.nextInt();
            vidaActual = leerNaturales();
            System.out.println("daño base");
            danio = sc.nextInt();
            danio = leerNaturales();
            System.out.println("Pociones");
            pocion = sc.nextInt();
            pocion = leerNaturales();

            Aventurero aventurero = new Aventurero(nombre, vidaActual, vidaMaxima, danio, pocion);
            Enemigo enemigo = new Enemigo("Orko", 10, 50);
            if (enemigo.getVidaBase() == 0 || aventurero.getVidaActual() == 0) {
                algo = true;
            }
            {
                System.out.println("1.Atacar con el arma.");
                System.out.println("2.Beber pocion.");
                opciones = sc.nextInt();
                opciones = leerNaturales();

                switch (opciones) {
                    case 1:
                        tirarDado20();
                        if (tirarDado20() == 1) {
                            System.out.println("pifia,el ataque a fallado");
                        } else if (tirarDado20() == 20) {
                            enemigo.recibirDano(aventurero.getDanioBase() * 2);
                        } else {
                            enemigo.recibirDano(aventurero.getDanioBase());
                        }

                        aventurero.recibirDano(enemigo.getDanioBase());
                        break;
                    case 2:
                        aventurero.beberPocion();
                        aventurero.recibirDano(enemigo.getDanioBase());

                        break;

                    default:
                        break;
                }
            }

        } while (algo == false);
        System.out.println("Fin de la partida");
    }

    private static int leerNaturales() {
        int naturales = 0;
        boolean esNAtural = false;

        do {
            try {
                naturales = sc.nextInt();
                if (naturales < 0) {
                    System.out.println("Introduzca un numero mayor que 0.");
                } else {
                    esNAtural = true;
                }

            } catch (InputMismatchException ex) {
                System.out.println("A escrito letras en vez de numeros.");
            }

        } while (esNAtural);

        return naturales;
    }

    private static int tirarDado20() {
        Random dado = new Random();
        return dado.nextInt(20) + 1;
    }

}
