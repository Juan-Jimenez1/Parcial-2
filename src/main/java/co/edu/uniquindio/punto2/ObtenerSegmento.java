package co.edu.uniquindio.punto2;

import co.edu.uniquindio.estructuras.Pila;

public class ObtenerSegmento {
    public static <T> Pila<T> obtenerSegmento(
            Pila<T> original, int inicio, int fin) {

        Pila<T> resultado = new Pila<>();

        // Validamos el rango otorgado
        if (inicio < 1 || inicio > fin ||
                fin > original.cantidad()) {
            return resultado;
        }

        Pila<T> auxiliar = new Pila<>();
        Pila<T> seleccionados = new Pila<>();

        int posicion = 1;

        // Recorremos la pila original
        while (!original.estaVacia()) {

            T elemento = original.desapilar();

            auxiliar.apilar(elemento);

            if (posicion >= inicio && posicion <= fin) {
                seleccionados.apilar(elemento);
            }

            posicion++;
        }

        // Restauramos la pila original
        while (!auxiliar.estaVacia()) {
            original.apilar(auxiliar.desapilar());
        }

        // Devolvemos el resultado
        while (!seleccionados.estaVacia()) {
            resultado.apilar(seleccionados.desapilar());
        }

        return resultado;
    }
}

