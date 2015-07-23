
package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import enumerados.TipoRol;

public class Persona {
    private String ci;
    private String nombre;
    private String dir;
    private String tel;
    private String mail;
    private TipoRol rol;
    private String fechaNac;
    private String contrasenia;
    private List <Vehiculo> vehiculos;
        
    public Persona(String ci1,String nom,String dir1,String tel1,String mail1,TipoRol rol1,String fecha){
        ci = ci1;
        nombre = nom;
        dir = dir1;
        tel = tel1;
        mail = mail1;
        rol = rol1;
        fechaNac = fecha;
        vehiculos = new ArrayList<Vehiculo>();
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public TipoRol getRol() {
        return rol;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setRol(TipoRol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ci='" + ci + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dir='" + dir + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", rol=" + rol +
                ", fechaNac='" + fechaNac + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
}
