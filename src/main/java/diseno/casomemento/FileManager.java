package diseno.casomemento;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    public static String readFile (String path) throws FileNotFoundException, IOException
    {
        String everything;

        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
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
    public static void writeFile(String texto, String path, String name) throws UnsupportedEncodingException, IOException{
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(name), "utf-8"))) {
               writer.write(texto);
               //Esta parte es para mover el archivo creado al path donde se quiera guardar
               /*Files.move(
                    Paths.get("./"+name), 
                    Paths.get(path)
                );*/
        }
        catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
    }

    // escribe un objeto
    public static void writeObject(Object obj, String filePath)
    {
        try{
            //use buffering
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try{
                // escribe el objeto
                output.writeObject(obj);
            }
            finally{
                output.close();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    // lee un objeto
    public static Object readObject(String filePath)
    {
        try{
            //use buffering
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
            try{
                //deserialize the List
                return input.readObject();
            }
            finally{
                input.close();
            }
        }
        catch(ClassNotFoundException ex){

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());

        }
        return null;
    }

}
