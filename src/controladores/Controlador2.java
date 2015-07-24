package controladores;

import clases.Persona;
import clases.Vehiculo;
import enumerados.TipoRol;

import java.util.ArrayList;
import java.util.List;


public class Controlador2 implements IControlador{
    static private Controlador2 instance = null;

    private List<Persona> listaPersonas = new ArrayList<Persona>();
    private List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

    static public Controlador2 getInstance(){
        if (instance == null)
            instance = new Controlador2();
        return instance;            
    }

    public void altaPersonaSistema(Persona persona){
        listaPersonas.add(persona);
    }

    public void altaVehiculoSistema(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }

    public Persona buscarPersona(String ci){
        if (listaPersonas != null){
            for (Persona persona : listaPersonas){
                if (ci.equals(persona.getCi())){
                    return persona;
                }
            }
        }
        return null;
    }

    public List<Persona> listarTitulares(Vehiculo vehiculo){
        try {
            List<Persona> lista = new ArrayList<Persona>();
            lista.add(vehiculo.getTitular1());
            if (vehiculo.getTitular2() != null) {
                lista.add(vehiculo.getTitular2());
            }
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean transferirTitular(Persona titular1, Persona titular2, Vehiculo vehiculo){
        try {
            boolean error = true;
            Persona titularAnt1 = null;
            Persona titularAnt2 = null;
            if ((titular2 != null) && (!(vehiculo.getTitular1().getCi().equals(titular1.getCi())) && !(vehiculo.getTitular1().getCi().equals(titular2.getCi())))) {
                //se transfiere el vehiculo a 2 titulares
                if ((vehiculo.getTitular2() != null) && (!(vehiculo.getTitular2().getCi().equals(titular1.getCi())) && !(vehiculo.getTitular2().getCi().equals(titular2.getCi())))) {
                    //el vehiculo tenia 2 propietarios
                    titularAnt1 = vehiculo.getTitular1();
                    titularAnt2 = vehiculo.getTitular2();
                    vehiculo.setTitular1(titular1);
                    vehiculo.setTitular2(titular2);
                    bajaVehiculo(titularAnt1, vehiculo);
                    bajaVehiculo(titularAnt2, vehiculo);
                    error = false;

                } else if ((vehiculo.getTitular2() == null) && (!(vehiculo.getTitular1().getCi().equals(titular1.getCi()))) && (!(vehiculo.getTitular1().getCi().equals(titular2.getCi())))) {
                    titularAnt1 = vehiculo.getTitular1();
                    bajaVehiculo(titularAnt1, vehiculo);
                    vehiculo.setTitular1(titular1);
                    vehiculo.setTitular2(titular2);
                    error = false;

                }
            } else if (titular2 == null) { //se transfiere a un titular.
                //el vehiculo tenia 2 propietarios
                if ((vehiculo.getTitular2() != null) && (!(vehiculo.getTitular1().getCi().equals(titular1.getCi())) && !(vehiculo.getTitular2().getCi().equals(titular2.getCi())))) {
                    titularAnt1 = vehiculo.getTitular1();
                    titularAnt2 = vehiculo.getTitular2();
                    bajaVehiculo(titularAnt1, vehiculo);
                    bajaVehiculo(titularAnt2, vehiculo);
                    vehiculo.setTitular1(titular1);
                    vehiculo.setTitular2(null);
                    error = false;

                } else if ((vehiculo.getTitular2() == null) && (!(vehiculo.getTitular1().getCi().equals(titular1.getCi())) && !(vehiculo.getTitular1().getCi().equals(titular1.getCi())))) {
                    titularAnt1 = vehiculo.getTitular1();
                    bajaVehiculo(titularAnt1, vehiculo);
                    vehiculo.setTitular1(titular1);
                    vehiculo.setTitular2(null);
                    error = false;

                }
            }
            titular1.agregarVehiculo(vehiculo);
            if (titular2 != null)
                titular2.agregarVehiculo(vehiculo);
            titular1.setRol(TipoRol.Titular);
            if (titular2 != null)
                titular2.setRol(TipoRol.Titular);
            titular1 = null;
            titular2 = null;
            return (!error);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void asignarRolPersona(Persona persona, TipoRol nuevo){
        if (persona.getRol() == TipoRol.Ciudadano)
            persona.setRol(nuevo);
        else
        if (persona.getRol() == TipoRol.Titular){
            if (nuevo == TipoRol.Funcionario)
                persona.setRol(TipoRol.FuncionarioTitular);
            else
            if (nuevo == TipoRol.Administrador)
                persona.setRol(TipoRol.AdministradorTitular);
            else
            if (nuevo == TipoRol.Inspector)
                persona.setRol(TipoRol.InspectorTitular);
        }
        else
        if (persona.getRol() == TipoRol.Funcionario){
            if (nuevo == TipoRol.Inspector)
                persona.setRol(TipoRol.Inspector);
            else
            if (nuevo == TipoRol.Administrador)
                persona.setRol(TipoRol.Administrador);
            else
            if (nuevo == TipoRol.Titular)
                persona.setRol(TipoRol.FuncionarioTitular);
        }
        else
        if (persona.getRol() == TipoRol.Administrador){
            if (nuevo == TipoRol.Titular)
                persona.setRol(TipoRol.AdministradorTitular);
        }
        else
        if (persona.getRol() == TipoRol.Inspector){
            if (nuevo == TipoRol.Titular)
                persona.setRol(TipoRol.InspectorTitular);
            else
            if (nuevo == TipoRol.Administrador)
                persona.setRol(TipoRol.Administrador);
        }
        else
        if (persona.getRol() == TipoRol.FuncionarioTitular){
            if (nuevo == TipoRol.Inspector)
                persona.setRol(TipoRol.InspectorTitular);
            else
            if (nuevo == TipoRol.Administrador)
                persona.setRol(TipoRol.AdministradorTitular);
        }
        else
        if (persona.getRol() == TipoRol.InspectorTitular){
            if (nuevo == TipoRol.Administrador)
                persona.setRol(TipoRol.AdministradorTitular);
        }
    }

    public void sacarRolPersona(Persona persona, TipoRol rol){
        if (persona.getRol() == TipoRol.Titular){
            if (rol == TipoRol.Titular)
                persona.setRol(TipoRol.Ciudadano);
        }
        else
        if (persona.getRol() == TipoRol.Funcionario){
            if (rol == TipoRol.Funcionario)
                persona.setRol(TipoRol.Ciudadano);
        }
        else
        if (persona.getRol() == TipoRol.Administrador){
            if (rol == TipoRol.Administrador)
                persona.setRol(TipoRol.Ciudadano);
        }
        else
        if (persona.getRol() == TipoRol.Inspector){
            if (rol == TipoRol.Inspector)
                persona.setRol(TipoRol.Ciudadano);
        }
        else
        if (persona.getRol() == TipoRol.AdministradorTitular){
            if (rol == TipoRol.Administrador)
                persona.setRol(TipoRol.Titular);
            else
            if (rol == TipoRol.Titular)
                persona.setRol(TipoRol.Administrador);
        }
        else
        if (persona.getRol() == TipoRol.FuncionarioTitular){
            if (rol == TipoRol.Funcionario)
                persona.setRol(TipoRol.Titular);
            else
            if (rol == TipoRol.Titular)
                persona.setRol(TipoRol.Funcionario);
        }
        else
        if (persona.getRol() == TipoRol.InspectorTitular){
            if (rol == TipoRol.Inspector)
                persona.setRol(TipoRol.Titular);
            else
            if (rol == TipoRol.Titular)
                persona.setRol(TipoRol.Inspector);
        }
    }

    public void bajaVehiculo(Persona persona, Vehiculo vehiculo){
        persona.getVehiculos().remove(vehiculo);
        if (persona.getVehiculos().isEmpty())
            sacarRolPersona(persona, TipoRol.Titular);
    }

} 
