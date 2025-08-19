package calculadora;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner youtube = new Scanner(System.in);

        int numero1, numero2, opcion;

        System.out.println("Ingrese numero 1: ");
        numero1 = youtube.nextInt();

        System.out.println("Ingrese numero 2: ");
        numero2 = youtube.nextInt();

        // Menú
        do {
            System.out.println("\n--- Calculadora ---");
            System.out.println("1.- Sumar");
            System.out.println("2.- Restar");
            System.out.println("3.- Multiplicar");
            System.out.println("4.- Dividir");
            System.out.println("5.- Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = youtube.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + (numero1 + numero2));
                    break;
                case 2:
                    System.out.println("Resultado: " + (numero1 - numero2));
                    break;
                case 3:
                    System.out.println("Resultado: " + (numero1 * numero2));
                    break;
                case 4:
                    if (numero2 != 0) {
                        System.out.println("Resultado: " + (numero1 / numero2));
                    } else {
                        System.out.println("Error: División por cero");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (opcion != 5);

        youtube.close();
    }
}