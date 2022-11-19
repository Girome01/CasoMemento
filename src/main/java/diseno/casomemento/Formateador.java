package diseno.casomemento;

import java.util.ArrayList;

public class Formateador {

    public static ArrayList<String> listaFormatText(String texto){
        String currentColor;
        String[] listaTexto = texto.split("<");
        ArrayList<String> listaFinal = new ArrayList<>();
        for (String colorSeparation: listaTexto) {
            if (!colorSeparation.equals("")) {
                if (colorSeparation.charAt(0) == '#') {
                    currentColor = colorSeparation.substring(0, 7);
                    listaFinal.add(currentColor);
                    listaFinal.add(colorSeparation.substring(8));
                } else {
                    int pos = listaFinal.size() - 1;
                    String lineCorrection = listaFinal.get(pos) + "<" + colorSeparation;
                    listaFinal.set(pos, lineCorrection);
                }
            }
        }
        return listaFinal;
    }

    public static String noColorTags(String texto){
        String[] listaTexto = texto.split("<");
        String finalText = "";
        for (String colorSeparation: listaTexto) {
            if (!colorSeparation.equals("")) {
                if (colorSeparation.charAt(0) == '#') {
                    finalText += colorSeparation.substring(8);
                } else {
                    finalText += "<" + colorSeparation;
                }
            }
        }
        return finalText;
    }

    public static String updateTexto(String oldTextTags, String newText){
        String finalText = "";
        String currentColor = oldTextTags.substring(0,8);
        boolean currentColorApplied = false;

        int oldTextIndex = 9;

        for (int i = 0; i < newText.length(); i++) {
            System.out.println("old " + oldTextTags.charAt(oldTextIndex) + " new " + newText.charAt(i));
            switch (oldTextTags.charAt(oldTextIndex)) {
                case '<':
                    if (oldTextTags.charAt(i++) == '#'){
                        currentColor = oldTextTags.substring(oldTextIndex,oldTextIndex+9);
                        currentColorApplied = false;
                        oldTextIndex += 9;
                       break;
                    }
                default:
                    if (newText.charAt(i) == oldTextTags.charAt(oldTextIndex)){
                        if(!currentColorApplied){
                            finalText += currentColor;
                            currentColorApplied = true;
                        }
                        finalText += newText.charAt(i);
                    }
                    else {
                        finalText += newText.charAt(i);
                    }
                    break;

            }
            oldTextIndex++;
        }
        return finalText;

    }

    public static void main(String[] args) {
        System.out.println(updateTexto("<#FFFFFF>Hola mundo <#FF0000> Soy gilbert\n < <#FFFF00> me again <", "Hola Mundo  gilbert"));
    }

}
