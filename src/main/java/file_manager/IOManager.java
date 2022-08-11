package file_manager;

import org.codehaus.plexus.util.IOUtil;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class IOManager {

    public static String readJson(String path) throws IOException{
        try (BufferedReader br = new BufferedReader
                (new InputStreamReader(new FileInputStream(path), UTF_8))) {
            String json = IOUtil.toString(br);
            return json;
        } catch (IOException e) {
            System.err.println("JSON не найден или некорректно указан путь" + "\n" + "EXIT");
            System.exit(1);
            return null;
        }
    }

    public static void createJson(String path, String json){
        String outputPath = path.replaceAll("input", "output");
        try(BufferedWriter bw = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream(outputPath), UTF_8))){
            bw.write(json);
        }catch (IOException e){
            System.err.println("Неизвестная ошибка записи");
        }
    }
}
