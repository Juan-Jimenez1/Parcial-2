package co.edu.uniquindio.punto3;
import co.edu.uniquindio.estructuras.Cola;

public class GestorPaquetes {

    public int procesarTipo(
            Cola<Paquete> pendientes,
            Cola<Paquete> seleccionados,
            int capacidad,
            TipoEntrega tipo) {

        Cola<Paquete> auxiliar = new Cola<>();

        return procesarRecursivo(
                pendientes,
                seleccionados,
                auxiliar,
                capacidad,
                tipo,
                pendientes.cantidad()
        );
    }

    private int procesarRecursivo(
            Cola<Paquete> pendientes,
            Cola<Paquete> seleccionados,
            Cola<Paquete> auxiliar,
            int capacidad,
            TipoEntrega tipo,
            int cantidad) {

        if (cantidad == 0) {
            restaurarPendientes(auxiliar, pendientes, auxiliar.cantidad());
            return capacidad;
        }

        Paquete paquete = pendientes.desencolar();

        if (paquete.getTipoEntrega() == tipo) {

            if (paquete.getPeso() <= capacidad) {
                seleccionados.encolar(paquete);
                capacidad -= paquete.getPeso();

                System.out.println(paquete
                        + " -> SELECCIONADO");
            } else {
                auxiliar.encolar(paquete);

                System.out.println(paquete
                        + " -> PENDIENTE (no cabe)");
            }

        } else {
            auxiliar.encolar(paquete);
        }

        return procesarRecursivo(
                pendientes,
                seleccionados,
                auxiliar,
                capacidad,
                tipo,
                cantidad - 1
        );
    }

    private void restaurarPendientes(
            Cola<Paquete> auxiliar,
            Cola<Paquete> pendientes,
            int cantidad) {

        if (cantidad == 0) {
            return;
        }

        Paquete paquete = auxiliar.desencolar();
        pendientes.encolar(paquete);

        restaurarPendientes(auxiliar, pendientes, cantidad - 1);
    }
}


