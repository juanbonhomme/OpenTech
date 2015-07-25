package controladores;

public class Fabrica {

    static private Fabrica instance = null;
    
    private Fabrica(){
      
    }

    static public Fabrica getInstance(){
        if (instance == null)
            instance = new Fabrica();
        return instance;            
    }
    
    public IControlador getIControlador(){
        return Controlador.getInstance();
    }
}
