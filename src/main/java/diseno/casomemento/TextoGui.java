package diseno.casomemento;

import Interfaz.GuiTexto;
import javax.swing.text.BadLocationException;

public class TextoGui {
    private Texto texto;
    private TextoCaretaker caretaker;

    public TextoGui() {
        this.texto = new Texto(); // Texto solo se accede por medio de esta clase
        this.caretaker = new TextoCaretaker(texto); //Esto dado que el caretaker no se usa fuera de esta clase, se usa para acceder a los memento
    }

    
    public void save(String txt){
        //La idea es actualizar los mementos con lo que este en texto en este momento
        //Esta funcion se deberia de llamar siempre que se registre un cambio en el texto
        texto.addTexto(txt);
        TextoMemento memento = texto.createMemento();
        caretaker.addMemento(memento);
    }
    
    public void previous(){
        TextoMemento memento = caretaker.getPrevMemento();
        this.texto.restoreMemento(memento);
    }
    
    public void next(){
        TextoMemento memento = caretaker.getNextMemento();
        this.texto.restoreMemento(memento);
    }
    
    public void updateTexto(GuiTexto refPantalla) throws BadLocationException{//poner refPantalla
        refPantalla.actualizarTexto(texto.getTexto());
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }
    
}
