import org.junit.Test;

/**
 * @author chocoh
 */
public class MainTest {
    @Test
    public void test1() {
        Main.run(new String[]{});
    }

    @Test
    public void test2() {
        Main.run(new String[]{""});
    }

    @Test
    public void test3() {
        Main.run(new String[]{"", "", ""});
    }

    @Test
    public void test4() {
        Main.run(new String[]{null, null, null});
    }

    @Test
    public void test5() {
        Main.run(new String[]{
                "a",
                "b",
                "c"
        });
    }

    @Test
    public void test6() {
        Main.run(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_add.txt",
                "src/main/resources/result/orig_0.8_add.txt",
        });
    }

    @Test
    public void test7() {
        Main.run(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_del.txt",
                "src/main/resources/result/orig_0.8_del.txt",
        });
    }

    @Test
    public void test8() {
        Main.run(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_dis_1.txt",
                "src/main/resources/result/orig_0.8_dis_1.txt",
        });
    }

    @Test
    public void test9() {
        Main.run(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_dis_10.txt",
                "src/main/resources/result/orig_0.8_dis_10.txt",
        });
    }

    @Test
    public void test10() {
        Main.run(new String[]{
                "src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_dis_15.txt",
                "src/main/resources/result/orig_0.8_dis_15.txt",
        });
    }
}
