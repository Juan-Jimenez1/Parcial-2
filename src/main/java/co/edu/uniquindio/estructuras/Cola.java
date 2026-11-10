package co.edu.uniquindio.estructuras;

public class Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> ultimo;
    private int cantidad;

    public Cola() {
        frente = null;
        ultimo = null;
        cantidad = 0;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        cantidad++;
    }

    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            ultimo = null;
        }
        cantidad--;
        return dato;
    }

    public T verFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getDato();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int cantidad() {
        return cantidad;
    }
}

