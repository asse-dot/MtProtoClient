package telegram.raw.core.primitives;

import telegram.raw.core.TlObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringPrimitive extends TlObject {

    private String value;

    public StringPrimitive(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StringPrimitive read(ByteArrayInputStream bytes) throws IOException {

        String data = new String(BytesPrimitive.read(bytes).getValue(), StandardCharsets.UTF_8);

        return new StringPrimitive(data);
    }

    @Override
    public byte[] write() throws IOException {
        return new BytesPrimitive(this.value.getBytes(StandardCharsets.UTF_8)).write();
    }
}
