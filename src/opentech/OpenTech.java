/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opentech;


import clases.Persona;
import clases.Vehiculo;
import controladores.Controlador;
import controladores.Fabrica;
import controladores.IControlador;
import enumerados.TipoOrigen;
import enumerados.TipoRol;
import enumerados.TipoVehiculo;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author juan
 */
public class OpenTech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IControlador controlador = Fabrica.getInstance().getIControlador();

        Persona juan = new Persona("1.111.111-1","Juan Perez","B. Artigas 1234","099111222","juan.perez@algo.com", TipoRol.Titular, "01/08/1960");
        Persona maria = new Persona("2.222.222-2","Maria Gomez","18 de Julio 4455","091123456","mariagomez@gmail.com", TipoRol.Funcionario, "24/02/1955");
        Persona luis = new Persona("1.234.567-8","Luis Hernandez","Eduardo Acevedo 8890","096147852","luisher@gmail.com", TipoRol.InspectorTitular, "11/11/1979");

        controlador.altaPersonaSistema(juan);
        System.out.println("Persona Ingresada: " + juan.toString());
        controlador.altaPersonaSistema(maria);
        System.out.println("Persona Ingresada: "+ maria.toString());
        controlador.altaPersonaSistema(luis);
        System.out.println("Persona Ingresada: "+ luis.toString());

        Vehiculo fiat = new Vehiculo("1234", "SDH544", TipoVehiculo.Auto, "Fiat", "1998", 15555, "Uno", TipoOrigen.Nacional, "Av. brasil 1854");
        Vehiculo renault = new Vehiculo("3655", "SEE617", TipoVehiculo.Auto, "Renault", "2001", 3600, "Clio", TipoOrigen.Nacional, "Fernandez Crespo 8756");

        controlador.altaVehiculoSistema(fiat);
        System.out.println("Vehiculo Ingresado: "+ fiat.toString());
        controlador.altaVehiculoSistema(renault);
        System.out.println("Vehiculo Ingresado: "+ renault.toString());

        fiat.setTitular1(juan);
        renault.setTitular1(luis);

        List<Persona> listaTitulares = controlador.listarTitulares(fiat);
        for (Persona titular : listaTitulares){
            System.out.println("El titular "+ titular.getCi() + " ahora pasa a tener el rol de Funcionario Titular");
            controlador.asignarRolPersona(titular, TipoRol.FuncionarioTitular);
        }

        boolean transfOk = controlador.transferirTitular(luis, maria, renault);
        if (transfOk){
            System.out.println("Se realizó la transferencia de titular de la persona "+ luis.getCi() + " a la persona " + maria.getCi() + " del vehiculo " + renault.getNumPadron());
        }else{
            System.out.println("No se pudo realizar la transferencia de titular de la persona "+ luis.getCi() + " a la persona " + maria.getCi() + " del vehiculo " + renault.getNumPadron());
        }

    }
    
}
