import Documentos.Remito;
import Items.Articulo;
import Items.Servicio;
import Operaciones.Egreso;
import org.junit.Assert;
import org.junit.Test;

public class EgresoTest {

    Articulo articulo1 = new Articulo(10L);
    Articulo articulo2 = new Articulo(5L);

    @Test
    public void valorOperacionEgreso() {
        Egreso egreso = new Egreso();
        egreso.agregarArticulo(articulo1);
        egreso.agregarArticulo(articulo2);

        Assert.assertEquals(15L, egreso.getPrecioTotal().longValue());
    }

    @Test
    public void cambioPrecioAOperacionCerrada() {
        Egreso egreso = new Egreso();
        egreso.agregarArticulo(articulo1);
        egreso.cerrarOperacion();
        egreso.agregarArticulo(articulo2);

        Assert.assertEquals(10L, egreso.getPrecioTotal().longValue());
    }

    @Test
    public void cambioPrecioArticuloYaAgregado() {
        Egreso egreso = new Egreso();
        egreso.agregarArticulo(articulo1);
        egreso.agregarArticulo(articulo2);

        articulo1.setPrecio(1L);
        articulo2.setPrecio(1L);

        Long precioTotal = egreso.getPrecioTotal();
        Assert.assertEquals(15L, precioTotal.longValue());
    }

    @Test
    public void generacionRemitoDeOperacionConServicios() {
        Egreso egreso = new Egreso();
        Servicio servicio = new Servicio(100L);
        egreso.agregarServicio(servicio);
        egreso.agregarArticulo(articulo1);

        Remito remito = egreso.cerrarOperacion();

        Assert.assertNull(remito);
    }

    @Test
    public void generacionRemitoDeOperacionSinServicios() {
        Egreso egreso = new Egreso();
        egreso.agregarArticulo(articulo1);
        Remito remito = egreso.cerrarOperacion();

        Assert.assertEquals(remito.getClass(), Remito.class);
    }

}
