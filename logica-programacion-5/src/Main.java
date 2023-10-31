import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Crear diccionario Español-Inglés
        Map<String, String> diccionario = new HashMap<>();
        inicializarDiccionario(diccionario);

        // Utilizar un conjunto para realizar un seguimiento de las palabras ya seleccionadas
        Set<String> palabrasDisponibles = new HashSet<>(diccionario.keySet());

        // Solicitar traducciones al usuario y verificar respuestas
        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            // Seleccionar palabra al azar del conjunto de palabras disponibles
            String palabraEsp = palabrasDisponibles.iterator().next();
            palabrasDisponibles.remove(palabraEsp);

            System.out.print("Traducción de '" + palabraEsp + "': ");
            String respuestaUsuario = scanner.nextLine();

            // Verificar la respuesta
            if (verificarRespuesta(diccionario, palabraEsp, respuestaUsuario)) {
                respuestasCorrectas++;
            } else {
                respuestasIncorrectas++;
            }
        }

        // Mostrar resultados
        System.out.println("\nResultados:");
        System.out.println("Respuestas correctas: " + respuestasCorrectas);
        System.out.println("Respuestas incorrectas: " + respuestasIncorrectas);
    }

    // Inicializar el diccionario
    private static void inicializarDiccionario(Map<String, String> diccionario) {
        diccionario.put("Casa", "House");
        diccionario.put("arbol", "Tree");
        diccionario.put("Libro", "Book");
        diccionario.put("Playa", "Beach");
        diccionario.put("Tiempo", "Time");

    }

    // Seleccionar palabras al azar del diccionario
    private static String[] seleccionarPalabrasAlAzar(Map<String, String> diccionario, int cantidad) {
        Random random = new Random();
        String[] palabras = diccionario.keySet().toArray(new String[0]);
        String[] palabrasElegidas = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            palabrasElegidas[i] = palabras[random.nextInt(palabras.length)];
        }

        return palabrasElegidas;
    }

    // Verificar si la traducción es correcta
    private static boolean verificarRespuesta(Map<String, String> diccionario, String palabraEsp, String respuestaUsuario) {
        return diccionario.get(palabraEsp).equalsIgnoreCase(respuestaUsuario.trim());
    }

}

