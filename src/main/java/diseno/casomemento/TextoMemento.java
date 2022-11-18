package diseno.casomemento;

public class TextoMemento {
    private Texto texto;

    public TextoMemento(Texto texto) {
        this.texto = new Texto();
        this.texto.setNombre(texto.getNombre());
        this.texto.setTexto(texto.getTexto());
    }
    
    public TextoMemento getMemento(TextoMemento txtMemento){
        //No tengo idea de que se realiza aqui
        return txtMemento;
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }
}
