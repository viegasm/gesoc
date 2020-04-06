package Operaciones;

import Documentos.Remito;
import Items.Articulo;
import Items.Servicio;

import java.util.ArrayList;
import java.util.List;

public class Egreso implements Operacion {

    private EstadoOperacion estado;
    private Long precioTotal;
    private List<Articulo> articulos;
    private List<Servicio> servicios;

    public Egreso() {
        articulos = new ArrayList<>();
        servicios = new ArrayList<>();
        precioTotal = 0L;
        estado = EstadoOperacion.ABIERTA;
    }

    public Long getPrecioTotal() {
        return precioTotal;
    }

    public void agregarArticulo(Articulo articulo) {
        if (estado == EstadoOperacion.ABIERTA) {
            articulos.add(articulo);
            precioTotal += articulo.getPrecio();
        }
    }

    public void agregarServicio(Servicio servicio) {
        if (estado == EstadoOperacion.ABIERTA) {
            servicios.add(servicio);
            precioTotal += servicio.getPrecio();
        }
    }

    public Remito cerrarOperacion() {
        Remito remito = null;

        if (soloArticulos()) {
            remito = new Remito();
        }

        estado = EstadoOperacion.CERRADA;

        return remito;
    }

    private boolean soloArticulos() {
        return servicios.isEmpty();
    }

}
