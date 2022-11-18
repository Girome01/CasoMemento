package diseno.casomemento;

import java.util.ArrayList;

public class TextoCaretaker {
    private ArrayList<TextoMemento> mementoList;
    private Texto texto;
    private int currentIndex;

    public TextoCaretaker(Texto texto) {
        this.texto = texto;
        this.currentIndex = -1;
        this.mementoList = new ArrayList<>();
    }

    public void addMemento(TextoMemento memento){
        this.mementoList.add(memento);
        this.texto = memento.getTexto();
        this.currentIndex = this.mementoList.size()-1;
    }

    public TextoMemento getPrevMemento(){
        TextoMemento tmpMemento;
        if(this.currentIndex > 0){
            this.currentIndex -= 1;
            tmpMemento = this.mementoList.get(currentIndex);
            this.texto = tmpMemento.getTexto();
            return tmpMemento;
        }
        tmpMemento = this.mementoList.get(currentIndex);
        this.texto = tmpMemento.getTexto();
        return tmpMemento;
    }
    
    public TextoMemento getNextMemento(){
        TextoMemento tmpMemento;
        int top = this.mementoList.size();
        if(this.currentIndex < (top-1) ){
            this.currentIndex += 1;
            tmpMemento = this.mementoList.get(currentIndex);
            this.texto = tmpMemento.getTexto();
            return tmpMemento;
        }
        tmpMemento = this.mementoList.get(currentIndex);
        this.texto = tmpMemento.getTexto();
        return tmpMemento;
    }
    public TextoMemento getCurrentMemento(){
        TextoMemento tmpMemento = this.mementoList.get(currentIndex);
        this.texto = tmpMemento.getTexto();
        return tmpMemento;
    }




}
