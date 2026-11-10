
package co.edu.uniquindio.punto4;

public class App{

    public static void main(String[] args) {

        NodoABB raiz = new NodoABB(41);

        raiz.izquierdo = new NodoABB(20);
        raiz.derecho = new NodoABB(52);

        raiz.izquierdo.izquierdo = new NodoABB(16);
        raiz.izquierdo.izquierdo.izquierdo = new NodoABB(6);
        raiz.izquierdo.izquierdo.izquierdo.derecho =
                new NodoABB(13);
        raiz.izquierdo.izquierdo.izquierdo.derecho.izquierdo =
                new NodoABB(12);

        raiz.derecho.derecho = new NodoABB(60);

        raiz.izquierdo.derecho = new NodoABB(22);

        raiz.derecho.izquierdo = new NodoABB(47);
        raiz.derecho.izquierdo.derecho = new NodoABB(50);
        raiz.derecho.izquierdo.izquierdo = new NodoABB(43);
        raiz.derecho.izquierdo.izquierdo.derecho =
                new NodoABB(44);

        System.out.println("CONSULTA DE EQUIPOS POR RANGO");

        int resultado = ArbolABB.contarEquiposEnRango(
                raiz, 13, 47);

        System.out.println("Rango: 13 - 47");
        System.out.println("Equipos encontrados: " + resultado);


        // PRUEBA CON ARBOL VACIO

        System.out.println("\nPRUEBA CON ARBOL VACIO:");

        int resultadoVacio =
                ArbolABB.contarEquiposEnRango(null, 13, 47);

        System.out.println("Equipos encontrados: " + resultadoVacio);


        // PRUEBA CON RANGO INVALIDO

        System.out.println("\nPRUEBA CON RANGO INVALIDO:");

        int resultadoInvalido =
                ArbolABB.contarEquiposEnRango(raiz, 47, 13);

        System.out.println("Equipos encontrados: " + resultadoInvalido);
    }
}


