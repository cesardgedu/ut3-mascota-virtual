package mascota;

public class RatoncitoFiuFiu {
    //
    // La clase mascota.RatoncitoFiuFiu aun no tiene ningun atributo
    //

    private final int INFANCIA = 10;
    private final  int ADULTO = 25;
    private String nombre; //nombre de la mascota
    private int edad; //tiempo en segundos de la mascota
    private float peso; //peso en gramos de la mascota
    private float hambre; //hambre que tiene la mascota entre 0 (sin hambre) y 10 (mucha hambre)
    private float suciedad; //nivel de suciedad de la mascota entre 0(limpio) y 100(sucio)
    private float salud; //salud de la mascota entre 0(muero) y 100(sano)
    private float energia; //energia de la mascota entre 0(apatico) y 100 (activo)
    private boolean duerme;

    public RatoncitoFiuFiu(String nombre, int peso, byte hambre, byte suciedad, byte salud, byte energia) {
        this.nombre = nombre;
        this.peso = peso;
        this.hambre = hambre;
        this.suciedad = suciedad;
        this.salud = salud;
        this.energia = energia;
        this.duerme = false;
    }

    public void alimentar(float cantidadAlimento) {
        this.aumentarHambre(-(cantidadAlimento / 5));
        this.ganarPeso(cantidadAlimento/8);
    }

    public void curar(float cantidadMedicina) {
        this.aumentarSalud(cantidadMedicina / 5);
    }
    public void limpiar(float esfuerzoHigienico) {
        this.aumentarSuciedad(-(esfuerzoHigienico / 5));
    }

    public String estadisticas() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Peso: ").append(this.peso);
        sb.append("\nHambre: ").append(this.hambre);
        sb.append("\nSuciedad: ").append(this.suciedad);
        sb.append("\nSalud: ").append(this.salud);
        sb.append("\nEnergia").append(this.energia);
        return sb.toString();
    }

    public void envejecer(int tiempo) {
        this.aumentarTiempo(tiempo);
        this.aumentarHambre(tiempo / 15);
        this.aumentarSuciedad(-(tiempo / 20));
        this.aumentarEnergia(-(tiempo / 25));
        this.aumentarSalud(-(tiempo / 60));
    }

    public boolean estasSucio() {
        if (this.suciedad > 45){
            return true;
        }
        return false;
    }

    public boolean estasEnfermo() {
        if (this.salud < 75){
            return true;
        }
        return false;
    }

    public boolean estasMuerto() {
        if (this.salud <= 0){
            return true;
        }
        return false;
    }

    public boolean tienesHambre(){
        if (this.hambre > 6){
            return true;
        }
        return false;
    }

    public boolean estasFeliz(){
        if (!tienesHambre() && !estasSucio() && !estasEnfermo()){
            return true;
        }
        return false;
    }

    private void ganarPeso(float cantidad){
        this.peso += cantidad;
    }

    public void aumentarEnergia(float cantidad){
        this.energia += cantidad;
    }

    private void aumentarSalud(float cantidad){
        this.salud += cantidad;
    }

    private void aumentarSuciedad(float cantidad){
        this.suciedad += cantidad;
    }

    private void aumentarHambre(float cantidad){
        this.hambre += cantidad;
    }

    private void aumentarTiempo(int segundos){
        this.edad += segundos;
    }
    public boolean estasDormido() {
        if (this.energia < 50){
            this.duerme = true;
            return true;
        }

        if (this.energia > 75){
            this.duerme = false;
            return false;
        }

        if (this.energia > 50){
            return this.duerme;
        }

        return this.duerme;
    }

    public int queTramoEdad() {
        if (this.edad < INFANCIA){
            return 1;
        }

        if (this.edad < ADULTO){
            return 2;
        }

        return 3;
    }

    public boolean tienesQuejas() {
        if (!estasFeliz()){
            return true;
        }

        return false;
    }
}