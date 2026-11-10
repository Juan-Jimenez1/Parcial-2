package co.edu.uniquindio.punto1;

import co.edu.uniquindio.estructuras.Pila;

public class RetiroCajas {
    public static boolean retirarCaja(Pila<Caja> pila, String codigo) {

        Pila<Caja> auxiliar = new Pila<>();
        Caja retirada = null;

        // 1. Buscar la caja que se desea retirar
        while (!pila.estaVacia()) {

            Caja actual = pila.desapilar();

            if (actual.getCodigo().equals(codigo)) {
                retirada = actual;
            } else {
                auxiliar.apilar(actual);
            }
        }

        // 2. Restaurar las cajas restantes
        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }

        // 3. Verificar si se encontró la caja
        if (retirada == null) {
            return false;
        }

        // 4. Separar las cajas por posiciones
        Pila<Caja> impares = new Pila<>();
        Pila<Caja> pares = new Pila<>();

        int posicion = 1;

        while (!pila.estaVacia()) {

            Caja actual = pila.desapilar();

            if (posicion % 2 != 0) {
                impares.apilar(actual);
            } else {
                pares.apilar(actual);
            }

            posicion++;
        }

        // 5. Reorganizar según el valor de la caja retirada
        if (retirada.getValor() % 2 == 0) {

            // Primero posiciones pares y después impares
            while (!pares.estaVacia()) {
                pila.apilar(pares.desapilar());
            }

            while (!impares.estaVacia()) {
                pila.apilar(impares.desapilar());
            }

        } else {

            // Primero posiciones impares y después pares
            while (!impares.estaVacia()) {
                pila.apilar(impares.desapilar());
            }

            while (!pares.estaVacia()) {
                pila.apilar(pares.desapilar());
            }
        }

        return true;
    }
}

