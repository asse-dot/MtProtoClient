package telegram;

public class Utils {

    public static long modExp(long a, long b, long n) {
        if(b == 0) {
            return 1;
        }
        long t = modExp(a, b/2, n);
        long c = (t*t) % n;
        if(b % 2 == 1) {
            c = (c * a) % n;
        }
        return c;
    }

    public static byte[] toByteBigEndian(int data) {
        return new byte[]{
                (byte) (data >> 24),
                (byte) (data >> 16),
                (byte) (data >> 8),
                (byte) (data)
        };
    }

    public static byte[] subStr(byte[] str, int from, int length) {
        byte[] sub_str = new byte[length];
        System.arraycopy(str, from, sub_str, 0, length);
        return sub_str;
    }

    public static byte[] addArray(byte[] a, byte[] b) {
        byte[] sum = new byte[a.length + b.length];
        System.arraycopy(a, 0, sum, 0, a.length);
        System.arraycopy(b, 0, sum, a.length, b.length);
        return sum;
    }


}
