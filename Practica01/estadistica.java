import java.util.Scanner;

// Clase Estadistica
class Estadistica {


    private double[] datos;

   
    public Estadistica(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        double suma = 0;
        for (double x : datos) {
            suma += x;
        }
        return suma / datos.length;
    }

    public double desviacion() {
        double prom = promedio();
        double sumaCuadrados = 0;
        for (double x : datos) {
            sumaCuadrados += Math.pow(x - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (datos.length - 1));
    }
}

// Clase principal 
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numeros = new double[10];

        System.out.print("Ingrese 10 numeros: ");
        for (int i = 0; i < numeros.length; i++) {
            if (sc.hasNextDouble()) {
                numeros[i] = sc.nextDouble();
            }
        }
        // Crea un objeto Estadistica con los datos ingresados
        Estadistica estadistica = new Estadistica(numeros);

        System.out.printf("El promedio es %.2f%n", estadistica.promedio());
        System.out.printf("La desviacion estandar es %.5f%n", estadistica.desviacion());

        sc.close();
    }
}
