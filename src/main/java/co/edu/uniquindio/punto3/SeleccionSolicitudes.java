package co.edu.uniquindio.punto3;
import co.edu.uniquindio.estructuras.Cola;

public class SeleccionSolicitudes {
    private GestorPaquetes gestor;

    public SeleccionSolicitudes() {
        gestor = new GestorPaquetes();
    }

    public Cola<Paquete> seleccionarPaquetes(
            Cola<Paquete> pendientes,
            int capacidad) {

        // Crear la cola de paquetes seleccionados
        Cola<Paquete> seleccionados = new Cola<>();

        // Verificar la capacidad disponible
        if (capacidad <= 0) {
            return seleccionados;
        }

        // Procesar primero los paquetes urgentes
        capacidad = gestor.procesarTipo(
                pendientes,
                seleccionados,
                capacidad,
                TipoEntrega.URGENTE
        );

        // Procesar después los paquetes normales
        gestor.procesarTipo(
                pendientes,
                seleccionados,
                capacidad,
                TipoEntrega.NORMAL
        );

        // Retornar los paquetes seleccionados
        return seleccionados;
    }
}

