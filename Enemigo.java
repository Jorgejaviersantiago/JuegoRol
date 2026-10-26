
public class Enemigo {

    private String nombreEnemigo;
    private int danioBase;
    private int vidaBase;
    private int vidaMaxima;

    public Enemigo(String nombreEnemigo, int danioBase, int vidaMaxima) {
        this.nombreEnemigo = nombreEnemigo;
        this.vidaBase = vidaMaxima;
        this.danioBase = danioBase;
    }

    public void recibirDano(int dano) {
        if ( dano >= this.vidaBase ) {
            this.vidaBase = 0;
        } else {
            this.vidaBase -= dano;
        }
    }

    public void atacarAventurero(Aventurero aventurero){

        aventurero.recibirDano(this.danioBase);
    }

    public boolean estaDerrotado() {
        boolean algo = false;

        if (this.vidaBase > 0) {
            algo = false;
        } else {
            algo = true;

        }

        return algo;
    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public int getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

}
