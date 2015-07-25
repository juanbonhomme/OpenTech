package controladores;

import clases.Persona;
import enumerados.TipoRol;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jenkins on 25/07/15.
 */
public class ControladorTest {

    @Test
    public void testGetInstance() throws Exception {
        new Controlador();
    }

    @Test
    public void testAltaPersonaSistema() throws Exception {
        new Controlador().altaPersonaSistema(new Persona("","","","","", TipoRol.Administrador,""));
    }

    @Test
    public void testAltaVehiculoSistema() throws Exception {
        new Controlador();
    }

    @Test
    public void testBuscarPersona() throws Exception {
        new Controlador();
    }

    @Test
    public void testListarTitulares() throws Exception {

    }

    @Test
    public void testTransferirTitular() throws Exception {

    }

    @Test
    public void testAsignarRolPersona() throws Exception {

    }

    @Test
    public void testSacarRolPersona() throws Exception {

    }

    @Test
    public void testBajaVehiculo() throws Exception {

    }
}