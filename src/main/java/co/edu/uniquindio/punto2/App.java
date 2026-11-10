package co.edu.uniquindio.punto2;

import co.edu.uniquindio.estructuras.Pila;

public class App {
    public static void main(String[] args) {

        Pila<String> original = new Pila<>();

        original.apilar("A1");
        original.apilar("A2");
        original.apilar("A3");
        original.apilar("A4");
        original.apilar("A5");
        original.apilar("A6");

        Pila<String> resultado =
                ObtenerSegmento.obtenerSegmento(original, 2, 4);

        System.out.println("PILA ORIGINAL:");
        mostrarPila(original);

        System.out.println("\nPILA RESULTADO:");
        mostrarPila(resultado);
    }

    public static <T> void mostrarPila(Pila<T> pila) {

        Pila<T> auxiliar = new Pila<>();

        while (!pila.estaVacia()) {
            T elemento = pila.desapilar();

            System.out.println(elemento);

            auxiliar.apilar(elemento);
        }

        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }
    }
}

