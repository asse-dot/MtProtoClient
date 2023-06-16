import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Date;

public class ClientTg {

    public static void testing()
    {

    }

    public static void main(String[] args) throws IOException {

        String ip = "149.154.167.51";
        int port = 443;
        Class<ClientTg> c = ClientTg.class;
        byte[] stream = new byte[101];
        Socket clientSocket = new Socket(ip, port);
        System.out.println("connected");
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outStream = clientSocket.getOutputStream();
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        outStream.write(0xef);
        System.out.println("to write");
        //bOut.write(0xbe7e8ef1);
        bOut.write(10);
        //auth key id
        bOut.write(0x00);
        bOut.write(0x00);
        bOut.write(0x00);
        bOut.write(0x10);
        bOut.write(0x00);
        bOut.write(0x00);
        bOut.write(0x00);
        bOut.write(0x00);

        long unixtime  = (long)((System.currentTimeMillis() / 1000) * Math.pow(2, 32));
        System.out.println(unixtime);
        byte[] unixbytes = new byte[] {
                (byte)(unixtime),
                (byte)(unixtime >> 8),
                (byte)(unixtime >> 16),
                (byte)(unixtime >> 24),
                (byte)(unixtime >> 32),
                (byte)(unixtime >> 40),
                (byte)(unixtime >> 48),
                (byte)(unixtime >> 56),
        };
        //message id
        bOut.write(unixbytes);
        int lenght = 20;
        byte[] lenght_byte = new byte[] {
                (byte)(lenght),
                (byte)(lenght >> 8),
                (byte)(lenght >> 16),
                (byte)(lenght >> 24)
        };

        System.out.println(lenght_byte[0]);
        //lenght
        bOut.write(lenght_byte);
        //0xbe7e8ef1
        int func = 0xbe7e8ef1;
        byte[] func_byte = new byte[] {
                (byte)(func),
                (byte)(func >> 8),
                (byte)(func >> 16),
                (byte)(func >> 24)
        };
        //function rpc
        bOut.write(func_byte);

        //nonce
        for(int i = 0; i<16; i++) {
            bOut.write(0xaa);
       }
        System.out.println(bOut.toByteArray().length);
        outStream.write(bOut.toByteArray());
        System.out.println("Reading:");
        inputStream.read(stream);
        System.out.println(Arrays.toString(stream));
        System.out.println("Data: ");
        byte[] wrapper = new byte[] {
                stream[77],
                stream[78],
                stream[79],
                stream[80],
                stream[81],
                stream[82],
                stream[83],
                stream[84],
        };


        long k1 = ((long)wrapper[0]) << 0 | ((long)wrapper[1])  << 8 | ((long)wrapper[2])  << 16 | ((long)wrapper[3]) << 24
                | ((long)wrapper[4])  << 32 | ((long)wrapper[5]) << 40 | ((long)wrapper[6]) << 48| ((long)wrapper[7]) << 54;
        long k = ByteBuffer.wrap(wrapper).order(ByteOrder.LITTLE_ENDIAN).getLong();
        System.out.println(k);

        BigInteger a = new BigInteger("C150023E2F70DB7985DED064759CFECF0AF328E69A41DAF4D6F01B538135A6F91F8F8B2A0EC9BA9720CE352EFCF6C5680FFC424BD634864902DE0B4BD6D49F4E580230E3AE97D95C8B19442B3C0A10D8F5633FECEDD6926A7F6DAB0DDB7D457F9EA81B8465FCD6FFFEED114011DF91C059CAEDAF97625F6C96ECC74725556934EF781D866B34F011FCE4D835A090196E9A5F0E4449AF7EB697DDB9076494CA5F81104A305B6DD27665722C46B60E5DF680FB16B210607EF217652E60236C255F6A28315F4083A96791D7214BF64C1DF4FD0DB1944FB26A2A57031B32EEE64AD15A8BA68885CDE74A5BFC920F6ABF59BA5C75506373E7130F9042DA922179251F", 16);

    }
}
