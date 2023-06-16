package telegram.crypto;

import telegram.Utils;

import java.math.BigInteger;
import java.util.Arrays;

public class RSA {
    //TODO to modify for all keys
    private final static BigInteger exponent = new BigInteger("010001", 16);
    private final static BigInteger modulus = new BigInteger(
            "AEEC36C8FFC109CB099624685B97815415657BD76D8C9C3E398103D7AD16C9BB" +
            "A6F525ED0412D7AE2C2DE2B44E77D72CBF4B7438709A4E646A05C43427C7F184" +
            "DEBF72947519680E651500890C6832796DD11F772C25FF8F576755AFE055B0A3" +
            "752C696EB7D8DA0D8BE1FAF38C9BDD97CE0A77D3916230C4032167100EDD0F9E" +
            "7A3A9B602D04367B689536AF0D64B613CCBA7962939D3B57682BEB6DAE5B6081" +
            "30B2E52ACA78BA023CF6CE806B1DC49C72CF928A7199D22E3D7AC84E47BC9427" +
            "D0236945D10DBD15177BAB413FBF0EDFDA09F014C7A7DA088DDE9759702CA760" +
            "AF2B8E4E97CC055C617BD74C3D97008635B98DC4D621B4891DA9FB0473047927", 16);

    public static byte[] encrypt(byte[] data) {
        BigInteger base = new BigInteger(1, data);
        byte[] encrypted_data = base.modPow(exponent, modulus).toByteArray();
        if(encrypted_data.length > 256) {
            encrypted_data = Utils.subStr(encrypted_data, 1, encrypted_data.length-1);
        }
        return encrypted_data;
    }





}
