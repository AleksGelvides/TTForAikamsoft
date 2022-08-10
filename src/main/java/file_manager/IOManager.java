package file_manager;

import org.codehaus.plexus.util.IOUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;

public class IOManager {

    public static String readJson(String path) throws IOException{
        try (BufferedReader br = new BufferedReader
                (new InputStreamReader(new FileInputStream(path), UTF_8))) {
            String json = IOUtil.toString(br);
            return json;
        } catch (IOException e) {
            throw new IOException("Json не найден");
        }
    }
}
