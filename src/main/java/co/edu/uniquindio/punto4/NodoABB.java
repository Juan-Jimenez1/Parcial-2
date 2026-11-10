package co.edu.uniquindio.punto4;

public class NodoABB {

    int clave;
    NodoABB izquierdo;
    NodoABB derecho;

    public NodoABB(int clave) {
        this.clave = clave;
        this.izquierdo = null;
        this.derecho = null;
    }
}
