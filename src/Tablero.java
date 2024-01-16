import java.util.Scanner;

/**
 * Clase que permite la interacción con una instancia de la clase Radio a través de un menú interactivo.
 */

public class Tablero {
    public static void main(String[] args) {
        // Crear una instancia de la clase Radio
        Radio radio = new Radio();
        Scanner scanner = new Scanner(System.in);

        
        
        while (true) {
            // Enciende la radio si está apagada
            while(!radio.isOn()) {
                System.out.println("La radio está apagada. Enciéndela para realizar funciones.");
                System.out.println("1. Encender radio");
                System.out.println("0. Salir");

                System.out.print("Ingresa la opción: ");
                int option1 = scanner.nextInt();

                switch(option1){
                    case 1:
                        radio.Onradio();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }

            }
            // Menú principal para la radio encendida
            System.out.println("1. Mostrar volumen");
            System.out.println("2. Subir volumen");
            System.out.println("3. Bajar volumen");
            System.out.println("4. Siguiente radio");
            System.out.println("5. Radio previa");
            System.out.println("6. Cambiar frecuencia");
            System.out.println("7. Mostrar emisoras guardadas");
            System.out.println("8. Guardar emisora");
            System.out.println("9. Seleccionar emisora guardada");
            System.out.println("10. Apagar la radio");
            System.out.println("0. Salir");

            System.out.print("Ingresa la opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    radio.showVolume();
                    break;
                case 2:
                    radio.volumeUp();
                    break;
                case 3:
                    radio.volumeDown();
                    break;
                case 4:
                    radio.nextRadio();
                    break;
                case 5:
                    radio.previousRadio();
                    break;
                case 6:
                    radio.changeFrecuency();
                    break;
                case 7:
                    radio.showSavedRadios();
                    break;
                case 8:
                    radio.saveRadio();
                    break;
                case 9:
                    System.out.print("Ingresa el número de emisora guardada: ");
                    int savedIndex = scanner.nextInt();
                    radio.selectSaved(savedIndex - 1);
                    break;
                case 10:
                    radio.OffRadio();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
