/**
 * @author chocoh
 */
public class Main {
    public static void main(String[] args) {
        run(args);
    }

    public static void run(String[] args) {
        try {
            DuplicateCheck.check(args);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

