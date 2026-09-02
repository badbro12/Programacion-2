import java.util.Scanner;

class EcuacionCuadratica {

    private double a;
    private double b;
    private double c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return b * b - 4 * a * c;
    }

    public double getRaiz1() {
        double discriminante = getDiscriminante();
        if (discriminante < 0) {
            return 0;
        }
        return (-b + Math.sqrt(discriminante)) / (2 * a);
    }

    public double getRaiz2() {
        double discriminante = getDiscriminante();
        if (discriminante < 0) {
            return 0;
        }
        return (-b - Math.sqrt(discriminante)) / (2 * a);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese a, b, c: ");
        if (sc.hasNextDouble()) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();

            EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
            double discriminante = ecuacion.getDiscriminante();

            if (discriminante > 0) {
                System.out.println("La ecuacion tiene dos raices "
                        + ecuacion.getRaiz1() + " y " + ecuacion.getRaiz2());
            } else if (discriminante == 0) {
                System.out.println("La ecuacion tiene una raiz " + ecuacion.getRaiz1());
            } else {
                System.out.println("La ecuacion no tiene raices reales");
            }
        }

        sc.close();
    }
}
