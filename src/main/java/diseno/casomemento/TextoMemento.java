package diseno.casomemento;

public class TextoMemento {
    private Texto texto;

    public TextoMemento(Texto texto) {
        this.texto = texto;
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
