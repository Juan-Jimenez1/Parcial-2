package co.edu.uniquindio.punto3;

public class Paquete {
    private String codigo;
    private TipoEntrega tipoEntrega;
    private int peso;

    public Paquete(String codigo, TipoEntrega tipoEntrega, int peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero");
        }
        this.codigo = codigo;
        this.tipoEntrega = tipoEntrega;
        this.peso = peso;
    }
    public String getCodigo() {
        return codigo;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return codigo + " - " + tipoEntrega + " - " + peso + " kg";
    }
}
