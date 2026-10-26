
public class Aventurero {

    private static final int CURACION = 20;

    private String nombreAventurero;
    private int vidaActual;
    private int vidaMaxima;
    private int danioBase;
    private int cantidadDePociones;

    public Aventurero(String nombreAventurero, int vidaActual, int vidaMaxima, int danioBase, int cantidadDePociones) {
        this.nombreAventurero = nombreAventurero;
        this.vidaActual = vidaActual;
        this.vidaMaxima = vidaMaxima;
        this.danioBase = danioBase;
        this.cantidadDePociones = cantidadDePociones;

    }

    public void atacar(Enemigo enemigo) {

        enemigo.recibirDano(this.danioBase);
    }

    public void beberPocion() {
        if (this.cantidadDePociones < 0) {
            System.out.println("No te queda pociones");
        } else {
            if ((this.vidaActual + CURACION) >= this.vidaMaxima) {
                this.vidaActual = this.vidaMaxima;
                cantidadDePociones--;
            } else {
                this.vidaActual += CURACION;
                cantidadDePociones--;
            }

        }

    }

    public void recibirDano(int dano) {
        if (dano >= this.vidaActual) {
            this.vidaActual = 0;
        } else {
            this.vidaActual -= dano;
        }
    }


    public boolean estaCaido(){
        boolean algo = false;
        
        if (this.vidaActual > 0) {
            algo = false;
        } else {
            algo = true;
        }
        return algo;
    }

    public static int getCuracion() {
        return CURACION;
    }

    public String getNombreAventurero() {
        return nombreAventurero;
    }

    public void setNombreAventurero(String nombreAventurero) {
        this.nombreAventurero = nombreAventurero;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }

    public int getCantidadDePociones() {
        return cantidadDePociones;
    }

    public void setCantidadDePociones(int cantidadDePociones) {
        this.cantidadDePociones = cantidadDePociones;
    }


    
}
