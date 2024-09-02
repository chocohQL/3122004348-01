import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author chocoh
 */
public class Main {
    public static void main(String[] args) {
        run(args);
    }

    public static void run(String[] args) {
        if (args.length != 3) {
            System.out.println("请深入参数：java -jar main.jar [原文文件] [抄袭版论文的文件] [答案文件]");
            return;
        }
        String sourceFile;
        String targetFile;
        try {
            sourceFile = new String(Files.readAllBytes(Paths.get(args[0])));
            targetFile = new String(Files.readAllBytes(Paths.get(args[1])));
        } catch (IOException e) {
            System.out.println("无法加载文件");
            return;
        }
        try (FileOutputStream out = new FileOutputStream(args[2])) {
            double result = DuplicateCheck.check(sourceFile, targetFile);
            out.write(Double.toString(result).getBytes());
        } catch (IOException e) {
            System.out.println("无法输出文件");
        }
    }
}

