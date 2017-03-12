import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\temp\\vah2.txt");
        file.deleteOnExit();
        Files.createFile(file.toPath());
        Path path = Files.createTempFile(null, null);
        System.out.println(Files.exists(path));
        //Files.createFile(path);

        System.out.println(path.toAbsolutePath().toString());

        String[] s = new  String[10];



        for (String s1 : s) {

        }


        List l = new ArrayList();

     }

}

