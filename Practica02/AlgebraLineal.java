import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
 
        // Caso 1: vectores perpendiculares en 2D -> (1,0) y (0,1)
        AlgebraVectorial v1 = new AlgebraVectorial(1, 0, 0, 1);
        System.out.println("--- Vectores a=(1,0) y b=(0,1) ---");
        System.out.println("a) Perpendicular por suma |a+b|=|a-b|:      " + v1.esPerpendicularPorSuma());
        System.out.println("b) Perpendicular por resta |a-b|=|b-a|:     " + v1.esPerpendicularPorResta());
        System.out.println("c) Perpendicular por producto a.b=0:        " + v1.esPerpendicularPorProducto());
        System.out.println("d) Perpendicular por pitagoras |a+b|^2=...: " + v1.esPerpendicularPorPitagoras());
 
        // Caso 2: vectores paralelos en 3D -> (2,4,6) y (1,2,3)
        AlgebraVectorial v2 = new AlgebraVectorial(2, 4, 6, 1, 2, 3);
        System.out.println("\n--- Vectores a=(2,4,6) y b=(1,2,3) ---");
        System.out.println("e) Paralela por razon a=r*b:               " + v2.esParalelaPorRazon());
        System.out.println("f) Paralela por producto vectorial a x b=0: " + v2.esParalelaPorProductoVectorial());
 
        // Caso 3: proyeccion y componente, a=(3,4), b=(1,0)
        AlgebraVectorial v3 = new AlgebraVectorial(new double[]{3, 4}, new double[]{1, 0});
        System.out.println("\n--- a=(3,4) sobre b=(1,0) ---");
        System.out.println("g) Proyeccion de a sobre b: " + Arrays.toString(v3.proyeccion()));
        System.out.println("h) Componente de a en b:    " + v3.componente());
    }
}

class AlgebraVectorial {
 
    private double[] a;
    private double[] b;
   
 
    // ---------- Constructores sobrecargados ----------
 
    // Vectores en 2D
    AlgebraVectorial(double ax, double ay, double bx, double by) {
        this.a = new double[]{ax, ay};
        this.b = new double[]{bx, by};
    }
 
    // Vectores en 3D
    AlgebraVectorial(double ax, double ay, double az, double bx, double by, double bz) {
        this.a = new double[]{ax, ay, az};
        this.b = new double[]{bx, by, bz};
    }
 
    // Vectores como arreglos (cualquier dimension)
    AlgebraVectorial(double[] a, double[] b) {
        this.a = a;
        this.b = b;
    }
 
    // ---------- Metodos auxiliares privados ----------
 
    private double productoPunto(double[] v1, double[] v2) {
        double resultado = 0;
        for (int i = 0; i < v1.length; i++) {
            resultado += v1[i] * v2[i];
        }
        return resultado;
    }
 
    private double[] sumaVec(double[] v1, double[] v2) {
        double[] r = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            r[i] = v1[i] + v2[i];
        }
        return r;
    }
 
    private double[] restaVec(double[] v1, double[] v2) {
        double[] r = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            r[i] = v1[i] - v2[i];
        }
        return r;
    }
 
    private double magnitud(double[] v) {
        return Math.sqrt(productoPunto(v, v));
    }
 
 
    // a) |a + b| = |a - b|
    boolean esPerpendicularPorSuma() {
        double m1 = magnitud(sumaVec(a, b));
        double m2 = magnitud(restaVec(a, b));
        return Math.abs(m1 - m2) < EPS;
    }
 
    // b) |a - b| = |b - a| (siempre es verdadero, se deja para completar el enunciado)
    boolean esPerpendicularPorResta() {
        double m1 = magnitud(restaVec(a, b));
        double m2 = magnitud(restaVec(b, a));
        return Math.abs(m1 - m2) < EPS;
    }
 
    // c) a . b = 0
    boolean esPerpendicularPorProducto() {
        return Math.abs(productoPunto(a, b)) < EPS;
    }
 
    // d) |a + b|^2 = |a|^2 + |b|^2
    boolean esPerpendicularPorPitagoras() {
        double izq = Math.pow(magnitud(sumaVec(a, b)), 2);
        double der = Math.pow(magnitud(a), 2) + Math.pow(magnitud(b), 2);
        return Math.abs(izq - der) < EPS;
    }
 
    // ---------- e) f) Paralelismo ----------
 
    // e) a = r * b (para algun escalar r)
    boolean esParalelaPorRazon() {
        Double r = null;
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(b[i]) < EPS) {
                if (Math.abs(a[i]) > EPS) {
                    return false; // no existe r valido
                }
                continue;
            }
            double ri = a[i] / b[i];
            if (r == null) {
                r = ri;
            } else if (Math.abs(r - ri) > EPS) {
                return false;
            }
        }
        return true;
    }
 
    // f) a x b = 0 (vector nulo). Para 2D se usa el equivalente escalar
    // a1*b2 - a2*b1 = 0
    boolean esParalelaPorProductoVectorial() {
        if (a.length == 3) {
            double[] cruz = productoCruz(a, b);
            return magnitud(cruz) < EPS;
        } else if (a.length == 2) {
            double cruz2D = a[0] * b[1] - a[1] * b[0];
            return Math.abs(cruz2D) < EPS;
        }
        throw new IllegalArgumentException("Solo definido para vectores de 2 o 3 componentes");
    }
 
    private double[] productoCruz(double[] v1, double[] v2) {
        return new double[]{
                v1[1] * v2[2] - v1[2] * v2[1],
                v1[2] * v2[0] - v1[0] * v2[2],
                v1[0] * v2[1] - v1[1] * v2[0]
        };
    }
 
    // ---------- g) Proyeccion de a sobre b ----------
 
    // Proy_b(a) = (a . b / |b|^2) * b
    double[] proyeccion() {
        double factor = productoPunto(a, b) / productoPunto(b, b);
        double[] resultado = new double[b.length];
        for (int i = 0; i < b.length; i++) {
            resultado[i] = factor * b[i];
        }
        return resultado;
    }
 
    // ---------- h) Componente de a en b ----------
 
    // Comp_b(a) = a . b / |b|
    double componente() {
        return productoPunto(a, b) / magnitud(b);
    }
}
