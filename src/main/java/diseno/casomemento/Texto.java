package diseno.casomemento;

public class Texto {

    private String texto;
    private String nombre;


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public TextoMemento createMemento(){
        return;
    }

    public void restoreMemento(TextoMemento txtMemento){
        ;
    }
}
