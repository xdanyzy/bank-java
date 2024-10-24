import java.io.FileWriter;
import java.io.IOException;

class Update {

    static String writeFile;

    public static void createFile(String nameFile){
        try {
            FileWriter writeFile = new FileWriter(nameFile + ".java");
            writeFile.write("public class " + nameFile + " { static int amount = 0; }");
            writeFile.close();
        } catch (IOException e) {}
    }

    public static void createFile(String nameFile, int get_update_variable){
        try {
            FileWriter writeFile = new FileWriter(nameFile + ".java");
            writeFile.write("public class " + nameFile + " { static int amount = " + get_update_variable + "; }");
            writeFile.close();
        } catch (IOException e) {}
    }
}