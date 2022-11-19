package diseno.casomemento;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static String readFile(File path) throws FileNotFoundException, IOException {
        String everything;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }

        return everything;
    }

    //Por favor que el nombre lleve la extension seleccionada
    public static void writeFile(String texto, File file) throws UnsupportedEncodingException, IOException {


        FileWriter escribir;

        try {

            escribir = new FileWriter(file, false);
            escribir.write(texto);
            escribir.close();

        } catch (Exception e) {
        }


    }

    // escribe un objeto
    public static void writeObject(Object obj, String filePath) {
        try {
            //use buffering
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                // escribe el objeto
                output.writeObject(obj);
            } finally {
                output.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // lee un objeto
    public static Object readObject(String filePath) {
        try {
            //use buffering
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                //deserialize the List
                return input.readObject();
            } finally {
                input.close();
            }
        } catch (ClassNotFoundException ex) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return null;
    }

    public static void saveJson(String texto, String filePath) {
        JSONObject js = new JSONObject();
        JSONArray ja = new JSONArray();
        ArrayList<String> formato = Formateador.listaFormatText(texto);
        for (int i = 0; i < formato.size()-1; i+=2) {
            JSONObject jo = new JSONObject();
            jo.put("Color", formato.get(i));
            jo.put("Texto", formato.get(i+1));
            ja.put(jo);
        }
        js.put("Document", ja);
        //System.out.println(js);
        writeObject(js, filePath);
    }

    public static void saveTsv(String texto, String filePath) throws IOException {
        String finalText = "";
        int lastIndex = 0;
        for (int i = 0; i < texto.length()-10; i+=10) {
            finalText += texto.substring(i, i+10) + (char)9;
            lastIndex = i+10;
        }
        finalText += texto.substring(lastIndex);
        writeFile(finalText, new File(filePath));
    }

    /*public static void main(String[] args) {
        saveJson("<#FFFFFF>Hola <#FF0111>mundo <#FF0000> Soy gilbert\n < <#FFFF00> me again <", "");
    }*/
}
