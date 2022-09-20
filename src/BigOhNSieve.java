import java.util.ArrayList;
import java.util.List;

public class BigOhNSieve {
    //    int count = 0;
    private final int N;
    private final boolean[] isPrime;
    public List<Integer> primes = new ArrayList<>();
    private final List<Integer> smallestPrimeFactor;

    public BigOhNSieve(int n) {
        N = n;
        isPrime = new boolean[N + 1];
        smallestPrimeFactor = new ArrayList<>();

        isPrime[0] = isPrime[1] = false;// 0 and 1 are not prime.
        for (int i = 0; i <= N; i++) {
            smallestPrimeFactor.add(-1);// negative means no prime factors. initially we mark there is no prime factor.
            isPrime[i] = true;
        }
        modifiedSieve();
    }

    // Complexity: O(n)
    private void modifiedSieve() {
        for (int x = 2; x <= N; x++) {
            if (isPrime[x]) {
                primes.add(x);
                smallestPrimeFactor.set(x, x);// prime itself is the smallest prime factor
            }

            // mark all (x * primeNo[iTh]) as not prime once:
            for (int iTh = 0, sz = primes.size(); iTh < sz && x * primes.get(iTh) <= N && primes.get(iTh) <= smallestPrimeFactor.get(x); iTh++) {
//                count++;
                int next = x * primes.get(iTh);
                isPrime[next] = false;
                smallestPrimeFactor.set(next, primes.get(iTh));
            }
        }
//        System.out.println(count);
    }

    public boolean isPrime(int n) {
        return isPrime[n];
    }
}
