package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import enumerados.TipoVehiculo;
import enumerados.TipoOrigen;

public class Vehiculo {

    private String numPadron;
    private String matricula;
    private TipoVehiculo tipo;
    private String marca;
    private String anio;
    private int numMotor;
    private String modelo;
    private TipoOrigen origen;
    private String direCobro;
    
    private Persona titular1;
    private Persona titular2;
      

    public Vehiculo(String padron,String matr,TipoVehiculo t,String mar,String anio,int motor,String mod,TipoOrigen o, String dirCobro){
        numPadron = padron;
        matricula = matr;
        tipo = t;
        marca = mar;
        anio = anio;
        numMotor = motor;
        modelo = mod;
        origen = o;
        direCobro = dirCobro;
        titular1 = null;
        titular2 = null;
    }
    
    public String getNumPadron(){
        return numPadron;
    }

    public String getMatricula(){
        return matricula;
    }

    public TipoVehiculo getTipo(){
        return tipo;
    }

    public String getMarca(){
        return marca;
    }

    public String getAnio(){
        return anio;
    }
    
    public String getModelo(){
        return modelo;
    }

    public int getNumMotor(){
        return numMotor;
    }

    public TipoOrigen getOrigen(){
        return origen;
    }
    
    public String getDirCobro(){
        return direCobro;
    }
        
    public Persona getTitular1(){
        return titular1;
    }
    
    public Persona getTitular2(){
        return titular2;
    }
    
    public void setTitular1(Persona p){
        titular1 = p;
    }
    
    public void setTitular2(Persona p){
        titular2 = p;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "numPadron='" + numPadron + '\'' +
                ", matricula='" + matricula + '\'' +
                ", tipo=" + tipo +
                ", marca='" + marca + '\'' +
                ", anio='" + anio + '\'' +
                ", numMotor=" + numMotor +
                ", modelo='" + modelo + '\'' +
                ", origen=" + origen +
                ", direCobro='" + direCobro + '\'' +
                ", titular1=" + titular1 +
                ", titular2=" + titular2 +
                '}';
    }
}
