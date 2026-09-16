public class Main {
    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, 5, 6);
 
        System.out.println("a = " + a);
        System.out.println("b = " + b);
 
        System.out.println("a) a + b = " + a.suma(b));
        System.out.println("b) 2 * a = " + a.por(2));
        System.out.println("c) |a| (longitud) = " + a.longitud());
        System.out.println("d) normal de a = " + a.normal());
        System.out.println("e) a . b (producto escalar) = " + a.por(b));
        System.out.println("f) a x b (producto vectorial) = " + a.cruz(b));
    }
}
 

class Vector3D {
 
    private double a1;
    private double a2;
    private double a3;
 
    Vector3D() {
        this.a1 = 0;
        this.a2 = 0;
        this.a3 = 0;
    }
 
    Vector3D(double a1, double a2, double a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }
 
    double getA1() {
        return a1;
    }
 
    double getA2() {
        return a2;
    }
 
    double getA3() {
        return a3;
    }
 
    // a) Suma de vectores: c = a + b
    Vector3D suma(Vector3D b) {
        return new Vector3D(this.a1 + b.a1, this.a2 + b.a2, this.a3 + b.a3);
    }
 
    // b) Multiplicacion de un escalar r por un vector: b = r*a
    Vector3D por(double r) {
        return new Vector3D(r * this.a1, r * this.a2, r * this.a3);
    }
 
    // e) Producto escalar (punto) de dos vectores: a . b
    double por(Vector3D b) {
        return this.a1 * b.a1 + this.a2 * b.a2 + this.a3 * b.a3;
    }
 
    // c) Longitud (magnitud) de un vector
    double longitud() {
        return Math.sqrt(a1 * a1 + a2 * a2 + a3 * a3);
    }
 
    // d) Normal (vector unitario) de un vector
    Vector3D normal() {
        double len = this.longitud();
        if (len == 0) {
            throw new ArithmeticException("No se puede normalizar el vector nulo");
        }
        return new Vector3D(a1 / len, a2 / len, a3 / len);
    }
 
    // f) Producto vectorial (cruz) de dos vectores: a x b
    Vector3D cruz(Vector3D b) {
        double x = this.a2 * b.a3 - this.a3 * b.a2;
        double y = this.a3 * b.a1 - this.a1 * b.a3;
        double z = this.a1 * b.a2 - this.a2 * b.a1;
        return new Vector3D(x, y, z);
    }
 
    @Override
    public String toString() {
        return "(" + a1 + ", " + a2 + ", " + a3 + ")";
  
