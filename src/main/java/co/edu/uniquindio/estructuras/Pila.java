package co.edu.uniquindio.estructuras;

public class Pila<T> {
    private Nodo<T> cima;
    private int cantidad;

    public Pila() {
        cima = null;
        cantidad = 0;
    }

    public void apilar(T dato) {

        Nodo<T> nuevo = new Nodo<>(dato);

        nuevo.setSiguiente(cima);
        cima = nuevo;

        cantidad++;
    }

    public T desapilar() {

        if (estaVacia()) {
            return null;
        }

        T dato = cima.getDato();

        cima = cima.getSiguiente();

        cantidad--;

        return dato;
    }

    public T verTope() {

        if (estaVacia()) {
            return null;
        }

        return cima.getDato();
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int cantidad() {
        return cantidad;
    }
}

