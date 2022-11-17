package diseno.casomemento;

public class TextoGui {
    private Texto texto;
    private TextoCaretaker caretaker;

    public TextoGui() {
        this.texto = new Texto(); // Texto solo se accede por medio de esta clase
        this.caretaker = new TextoCaretaker(texto); //Esto dado que el caretaker no se usa fuera de esta clase, se usa para acceder a los memento
    }

    
    public void save(){
        //Guardar en disco??
        //Agregar la logica para guardar en disco
    }
    
    public void previous(){
        TextoMemento memento = caretaker.getPrevMemento();
        texto.restoreMemento(memento);
    }
    
    public void next(){
        TextoMemento memento = caretaker.getNextMemento();
        texto.restoreMemento(memento);
    }
    
    public void updateTexto(){
        //La idea es actualizar los mementos con lo que este en texto en este momento
        //Esta funcion se deberia de llamar siempre que se registre un cambio en el texto
        TextoMemento memento = texto.createMemento();
        caretaker.addMemento(memento);
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }
    
}
