package diseno.casomemento;

import static diseno.casomemento.Formateador.updateTexto;

public class Texto {

    private String texto = ""; //tags
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
        this.texto = memTxt.texto;
    }
    
    public void addColor(String color){
        this.texto = this.texto + "<" + color + ">";
    }
    
    public void addTexto(String txt){
        String sinTags = Formateador.noColorTags(this.texto);
        if(this.texto.isEmpty() || Formateador.noColorTags(this.texto).length()-1 <= 0)
            this.texto += txt;
        else if(sinTags.length() < txt.length()){
            this.texto += txt.substring((sinTags.length()-1));
        }else
            this.texto = updateTexto(this.texto, txt);
    }
        
}
