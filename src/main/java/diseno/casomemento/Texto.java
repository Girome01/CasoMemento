package diseno.casomemento;

public class Texto {

    private String texto;
    private String nombre; //myDocument.txt


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
        TextoMemento memento = new TextoMemento(this);
        return memento;
    }

    public void restoreMemento(TextoMemento txtMemento){
        Texto memTxt = txtMemento.getTexto();
        this.nombre = memTxt.nombre;
        System.out.println(this.texto);
        System.out.println(memTxt.texto);
        this.texto = memTxt.texto;
    }
}
