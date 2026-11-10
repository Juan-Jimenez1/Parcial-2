
package co.edu.uniquindio.punto3;

import co.edu.uniquindio.estructuras.Cola;

public class App {

    public static void main(String[] args) {

        Cola<Paquete> pendientes = new Cola<>();

        registrarPaquete(pendientes, new Paquete("P1", TipoEntrega.NORMAL, 4));
        registrarPaquete(pendientes, new Paquete("P2", TipoEntrega.URGENTE, 7));
        registrarPaquete(pendientes, new Paquete("P3", TipoEntrega.NORMAL, 3));
        registrarPaquete(pendientes, new Paquete("P4", TipoEntrega.URGENTE, 5));
        registrarPaquete(pendientes, new Paquete("P5", TipoEntrega.NORMAL, 6));
        registrarPaquete(pendientes, new Paquete("P6", TipoEntrega.URGENTE, 4));
        registrarPaquete(pendientes, new Paquete("P7", TipoEntrega.NORMAL, 2));

        int capacidad = 14;

        System.out.println("-- SELECCION DE PAQUETES --");

        System.out.println("\nCOLA INICIAL:");
        mostrarCola(pendientes, pendientes.cantidad());

        SeleccionSolicitudes seleccion = new SeleccionSolicitudes();

        System.out.println("\nEVALUACION DE PAQUETES:");

        Cola<Paquete> resultado =
                seleccion.seleccionarPaquetes(pendientes, capacidad);

        System.out.println("\nCOLA RETORNADA (SELECCIONADOS):");
        mostrarCola(resultado, resultado.cantidad());

        System.out.println("\nCOLA DE PAQUETES PENDIENTES:");
        mostrarCola(pendientes, pendientes.cantidad());

        int pesoSeleccionado =
                calcularPeso(resultado, resultado.cantidad());

        System.out.println("\nCAPACIDAD INICIAL: " + capacidad + " kg");
        System.out.println("PESO SELECCIONADO: "
                + pesoSeleccionado + " kg");
        System.out.println("CAPACIDAD RESTANTE: "
                + (capacidad - pesoSeleccionado) + " kg");
    }

    private static void mostrarCola(Cola<Paquete> cola, int cantidad) {

        if (cantidad == 0) {
            return;
        }

        Paquete paquete = cola.desencolar();
        System.out.println(paquete);
        cola.encolar(paquete);

        mostrarCola(cola, cantidad - 1);
    }

    private static int calcularPeso(Cola<Paquete> cola, int cantidad) {

        if (cantidad == 0) {
            return 0;
        }

        Paquete paquete = cola.desencolar();
        cola.encolar(paquete);

        return paquete.getPeso()
                + calcularPeso(cola, cantidad - 1);
    }

    private static void registrarPaquete(
            Cola<Paquete> cola, Paquete paquete) {

        if (codigoExiste(
                cola, paquete.getCodigo(), cola.cantidad(), false)) {

            System.out.println("El codigo ya se encuentra registrado");

        } else {
            cola.encolar(paquete);
        }
    }

    private static boolean codigoExiste(
            Cola<Paquete> cola,
            String codigo,
            int cantidad,
            boolean encontrado) {

        if (cantidad == 0) {
            return encontrado;
        }

        Paquete paquete = cola.desencolar();

        if (paquete.getCodigo().equals(codigo)) {
            encontrado = true;
        }

        cola.encolar(paquete);

        return codigoExiste(
                cola, codigo, cantidad - 1, encontrado);
    }
}


