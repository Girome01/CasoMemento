package diseno.casomemento;

import java.util.ArrayList;
import org.w3c.dom.Text;

public class TextoCaretaker {
    private ArrayList<TextoMemento> memento;
    private Texto texto;
    private int currentIndex;

    public TextoCaretaker(Texto texto) {
        this.texto = texto;
        this.currentIndex = -1;
        this.memento = new ArrayList<>();
    }

    public void addMemento(TextoMemento memento){
        this.currentIndex += 1;
        this.memento.add(memento);
        this.texto = memento.getTexto();
    }

    public TextoMemento getPrevMemento(){
        return ;
    }
    public TextoMemento getNextMemento(){
        return ;
    }
    public TextoMemento getCurrentMemento(){
        return ;
    }




}
