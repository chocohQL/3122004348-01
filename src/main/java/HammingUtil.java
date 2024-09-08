import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chocoh
 */
public class HammingUtil {
    public static double getSimilarity(String original, String target) {
        String simHash1 = getSimHash(original);
        String simHash2 = getSimHash(target);
        int hammingDistance = getHammingDistance(simHash1, simHash2);
        return 1 - (double) hammingDistance / simHash1.length();
    }

    public static String getSimHash(String text) {
        int[] v = new int[128];
        List<String> words = getWords(text);
        for (String word : words) {
            BigInteger hash = new BigInteger(getHash(word), 16);
            for (int i = 0; i < 128; i++) {
                if (hash.testBit(i)) {
                    v[i] += 1;
                } else {
                    v[i] -= 1;
                }
            }
        }
        StringBuilder simHash = new StringBuilder();
        for (int i : v) {
            if (i > 0) {
                simHash.append("1");
            } else {
                simHash.append("0");
            }
        }
        return simHash.toString();
    }

    public static List<String> getWords(String text) {
        List<String> words = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(text);
        while (tokenizer.hasMoreTokens()) {
            words.add(tokenizer.nextToken());
        }
        return words;
    }

    public static String getHash(String word) {
        return Integer.toHexString(word.hashCode());
    }

    public static int getHammingDistance(String simHash1, String simHash2) {
        int distance = 0;
        for (int i = 0; i < simHash1.length(); i++) {
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
