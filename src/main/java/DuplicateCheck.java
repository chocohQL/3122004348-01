import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

/**
 * @author chocoh
 */
public class DuplicateCheck {
    public static void check(String[] args) throws RuntimeException {
        if (args.length != 3) {
            throw new RuntimeException(ExceptionResult.PARAMETER_EXCEPTION);
        }
        for (int i = 0; i < 3; i++) {
            if (args[i] == null) {
                throw new RuntimeException(ExceptionResult.PARAMETER_EXCEPTION);
            }
        }
        String sourceFile;
        String targetFile;
        try {
            sourceFile = new String(Files.readAllBytes(Paths.get(args[0])));
            targetFile = new String(Files.readAllBytes(Paths.get(args[1])));
        } catch (IOException e) {
            throw new RuntimeException(ExceptionResult.UNABLE_LOAD_FILE);
        }
        try (FileOutputStream out = new FileOutputStream(args[2])) {
            double result = HammingUtil.getSimilarity(sourceFile, targetFile);
            DecimalFormat df = new DecimalFormat("#0.00");
            out.write(df.format(result).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(ExceptionResult.UNABLE_EXPORT_FILE);
        }
    }
}
