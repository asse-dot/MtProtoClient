package telegram.crypto;

import telegram.Utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Prime {

    public static long  gdc(long a, long b) {
        while(b != 0) {
            long temp = b;
            b = Math.floorMod(a, b);
            a = temp;
        }
        return a;
    }

    public static int decompose(long pq) {
        if(pq % 2 == 0) {
            return 2;
        }

        BigInteger pqBig = BigInteger.valueOf(pq);
        //ThreadLocalRandom.current().nextLong(1, pq -1)
        BigInteger y = BigInteger.valueOf(ThreadLocalRandom.current().nextLong(1, pq -1));
        BigInteger c = BigInteger.valueOf(ThreadLocalRandom.current().nextLong(1, pq -1));
        BigInteger m = BigInteger.valueOf(ThreadLocalRandom.current().nextLong(1, pq -1));

        BigInteger g = BigInteger.ONE;
        BigInteger r = BigInteger.ONE;
        BigInteger q = BigInteger.ONE;

        BigInteger x = BigInteger.ZERO;
        BigInteger ys = BigInteger.ZERO;

        while(g.compareTo(BigInteger.ONE) == 0) {
            x = y;
            for(BigInteger i = BigInteger.ZERO; i.compareTo(r) == - 1; i =  i.add(BigInteger.ONE)){
                y = y.modPow(BigInteger.valueOf(2), pqBig).add(c).mod(pqBig);
            }

            BigInteger k = BigInteger.ZERO;

            while(k.compareTo(r) == - 1 && g.compareTo(BigInteger.ONE) == 0) {
                ys = y;
                //i<Math.min(m, r-k)
                for(BigInteger i = BigInteger.ZERO; i.compareTo(m.min(r.subtract(k))) == -1; i = i.add(BigInteger.ONE)) {
                    y = y.modPow(BigInteger.valueOf(2), pqBig).add(c).mod(pqBig);
                    q = q.multiply(x.subtract(y).abs()).mod(pqBig);
                }

                g = q.gcd(pqBig);
                k = k.add(m);
            }
            r = r.multiply(BigInteger.valueOf(2));
        }
        if(g.compareTo(pqBig) == 0) {
            while(true) {
                ys = ys.modPow(BigInteger.valueOf(2), pqBig).add(c).mod(pqBig);
                g = x.subtract(ys).abs().gcd(pqBig);
                //g = gdc(Math.abs(x - ys), pq);

                if(g.compareTo(BigInteger.ONE) == 1) {
                    break;
                }
            }
        }
        //g should be a 4 byte integer
        return g.intValue();

    }
}
