import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> primes = new BigOhNSieve(100).primes;
        System.out.println(primes.size());
    }
}
