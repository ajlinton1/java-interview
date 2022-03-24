package chapter8;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void testFibonacci() {
        int result = fibonacci(10);
        assert (result == 55);
    }

    @Test
    public void testFibonacci1() {
        int result = fibonacci1(10);
        assert (result == 55);
    }

    @Test
    public void testFibonacci2() {
        int result = fibonacci2(10);
        assert (result == 55);
    }

    int fibonacci(int k) {
        if (k <= 1) {
            return k;
        }
        return fibonacci(k - 2) + fibonacci(k - 1);
    }

    int fibonacci1(int k) {
        return fibonacci1(k, new int[k + 1]);
    }

    int fibonacci1(int k, int[] cache) {
        if (k <= 1) {
            return k;
        } else if (cache[k] > 0) {
            return cache[k];
        }
        cache[k] = fibonacci1(k -2, cache) + fibonacci1(k -1, cache);
        return cache[k];
    }

    int fibonacci2(int k) {
        if (k <= 1) {
            return k;
        }
        int first = 1;
        int second = 0;
        int result = 0;
        for (int i = 1; i < k; i++) {
            result = first + second;
            second = first;
            first = result;
        }
        return result;
    }
}