package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.integers.IntBigPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class ServerDHParamsOk extends TlObject {

    private final int ID = 0xd0e8075c;

    public BigInteger nonce;
    public BigInteger server_nonce;
    public byte[] encrypted_answer;

    public ServerDHParamsOk(BigInteger nonce, BigInteger server_nonce, byte[] encrypted_answer) {
        this.nonce = nonce;
        this.server_nonce = server_nonce;
        this.encrypted_answer = encrypted_answer;
    }

    public static ServerDHParamsOk read(ByteArrayInputStream bytes) throws IOException {
        BigInteger nonce = IntBigPrimitive.read(bytes).getValue();
        BigInteger server_nonce = IntBigPrimitive.read(bytes).getValue();
        byte[] encrypted_answer = BytesPrimitive.read(bytes).getValue();

        return new ServerDHParamsOk(nonce, server_nonce, encrypted_answer);
    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
