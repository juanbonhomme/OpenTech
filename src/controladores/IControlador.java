package controladores;

import clases.Persona;
import clases.Vehiculo;
import enumerados.TipoOrigen;
import enumerados.TipoRol;
import enumerados.TipoVehiculo;
import java.util.Date;
import java.util.List;



public interface IControlador {
    void altaPersonaSistema(Persona persona);
    void altaVehiculoSistema(Vehiculo vehiculo);
    Persona buscarPersona(String ci);
    List<Persona> listarTitulares(Vehiculo vehiculo);
    boolean transferirTitular(Persona titular1, Persona titular2, Vehiculo vehiculo);
    void asignarRolPersona(Persona persona, TipoRol nuevo);
    void sacarRolPersona(Persona persona, TipoRol rol);
    void bajaVehiculo(Persona persona, Vehiculo vehiculo);
}
