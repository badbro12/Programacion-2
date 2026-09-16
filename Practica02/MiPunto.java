public class Main {
    public static void main(String[] args) {
        MiPunto p1 = new MiPunto();          // (0, 0)
        MiPunto p2 = new MiPunto(10, 30.5);  // (10, 30.5)
 
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("Distancia entre p1 y p2 = " + p1.distancia(p2));
 
       
        System.out.println("Distancia entre p1 y (10, 30.5) = " + p1.distancia(10, 30.5));
    }
}
 
class MiPunto {
 
    // Atributos
    private double x;
    private double y;
 
    // b) Constructor sin argumentos: punto (0,0)
    MiPunto() {
        this.x = 0;
        this.y = 0;
    }
 
    // c) Constructor con las coordenadas especificadas
    MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }
 
    // a) Getters
    double getX() {
        return x;
    }
 
    double getY() {
        return y;
    }
 
    // d) Distancia desde este punto hasta otro punto MiPunto
    double distancia(MiPunto p) {
        double dx = this.x - p.getX();
        double dy = this.y - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
 
    // e) Distancia desde este punto hasta el punto (x2, y2)
    double distancia(double x2, double y2) {
        double dx = this.x - x2;
        double dy = this.y - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
 
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
 
