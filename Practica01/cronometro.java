import java.util.Random;

// Clase Cronometro
class Cronometro {
    private long inicia;
    private long finaliza;

    // Constructor que inicializa 'inicia' con el tiempo actual del sistema
    public Cronometro() {
        this.inicia = System.currentTimeMillis();
    }

    public long getInicia() {
        return inicia;
    }

    public long getFinaliza() {
        return finaliza;
    }

    // Reinicia el tiempo de inicio al tiempo actual
    public void inicia() {
        this.inicia = System.currentTimeMillis();
    }

    // Detiene el cronómetro guardando el tiempo actual
    public void detener() {
        this.finaliza = System.currentTimeMillis();
    }

    // Retorna la diferencia en milisegundos entre el inicio y el fin
    public long lapsoDeTiempo() {
        return finaliza - inicia;
    }
}

// Clase principal 
public class Main {
    public static void main(String[] args) {
        final int N = 100_000;
        int[] datos = new int[N];

        Random rnd = new Random();
        for (int i = 0; i < N; i++) {
            datos[i] = rnd.nextInt(1_000_000);
        }

        Cronometro cronometro = new Cronometro();

        System.out.println("Iniciando prueba con " + N + " numeros aleatorios...");
        
        cronometro.inicia();
        ordenacionPorSeleccion(datos);
        cronometro.detener();

        System.out.println("Cantidad de numeros ordenados: " + N);
        System.out.println("Tiempo de ejecucion: " + cronometro.lapsoDeTiempo() + " ms");
    }

    // Algoritmo de ordenación por selección (Selection Sort)
    public static void ordenacionPorSeleccion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
    }
}
