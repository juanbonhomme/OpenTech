package controladores;

import clases.Persona;
import enumerados.TipoRol;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControladorTest {

    @Test
    public void testAltaPersonaSistema() throws Exception {

    }

    @Test
    public void testAltaVehiculoSistema() throws Exception {

    }

    @Test
    public void testBuscarPersona() throws Exception {

    }

    @Test
    public void testListarTitulares() throws Exception {
new Controlador().altaPersonaSistema(new Persona("","","","","", TipoRol.Administrador,""));
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