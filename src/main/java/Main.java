/**
 * 主函数
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
            // 捕获打印异常信息
            System.out.println(e.getMessage());
        }
    }
}

