package co.edu.uniquindio.punto4;

public class ArbolABB {
    public static int contarEquiposEnRango(
            NodoABB nodo, int inferior, int superior) {

        // Caso base
        if (nodo == null || inferior > superior) {
            return 0;
        }

        // Si la clave es menor al límite inferior
        if (nodo.clave < inferior) {
            return contarEquiposEnRango(
                    nodo.derecho, inferior, superior);
        }

        // Si la clave es mayor al límite superior
        if (nodo.clave > superior) {
            return contarEquiposEnRango(
                    nodo.izquierdo, inferior, superior);
        }

        // Si está dentro del rango
        return 1
                + contarEquiposEnRango(nodo.izquierdo, inferior, superior)
                + contarEquiposEnRango(nodo.derecho, inferior, superior);
    }
}

