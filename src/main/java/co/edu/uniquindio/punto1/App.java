package co.edu.uniquindio.punto1;

import co.edu.uniquindio.estructuras.Pila;

public class App {
    public static void mostrarPila(Pila<Caja> pila) {

        Pila<Caja> auxiliar = new Pila<>();


        while (!pila.estaVacia()) {
            Caja caja = pila.desapilar();

            System.out.println(caja);
            auxiliar.apilar(caja);
        }

        // Restaurar la pila original
        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }
    }

    public static void main(String[] args) {

        Pila<Caja> cajas = new Pila<>();

        // Insertar cajas en el orden indicado
        cajas.apilar(new Caja("C1", 2));
        cajas.apilar(new Caja("C2", 4));
        cajas.apilar(new Caja("C3", 6));
        cajas.apilar(new Caja("C4", 8));
        cajas.apilar(new Caja("C5", 3));
        cajas.apilar(new Caja("C6", 9));
        cajas.apilar(new Caja("C7", 5));

        System.out.println("PILA INICIAL");
        mostrarPila(cajas);

        System.out.println("\nRETIRAR C3");
        System.out.println("Resultado: " +
                RetiroCajas.retirarCaja(cajas, "C3"));
        mostrarPila(cajas);

        System.out.println("\nRETIRAR C4");
        System.out.println("Resultado: " +
                RetiroCajas.retirarCaja(cajas, "C4"));
        mostrarPila(cajas);

        System.out.println("\nRETIRAR C7");
        System.out.println("Resultado: " +
                RetiroCajas.retirarCaja(cajas, "C7"));
        mostrarPila(cajas);

        System.out.println("\nPILA FINAL");
        mostrarPila(cajas);
    }
}

