import java.util.Scanner;

public class Estadistica_Modular {

    static double[] datos = new double[10];

    public static double promedio() {
        double suma = 0;
        for (int i = 0; i < datos.length; i++) {
            suma += datos[i];
        }
        return suma / datos.length;
    }
    public static double desviacion() {
        double prom = promedio();
        double sumaCuadrados = 0;
        for (int i = 0; i < datos.length; i++) {
            sumaCuadrados += Math.pow(datos[i] - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (datos.length - 1));
    }

    /** Metodo Principal */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese 10 numeros: ");
        for (int i = 0; i < datos.length; i++) {
            datos[i] = sc.nextDouble();
        }

        System.out.printf("El promedio es %.2f%n", promedio());
        System.out.printf("La desviacion estandar es %.5f%n", desviacion());

        sc.close();
    }
}
