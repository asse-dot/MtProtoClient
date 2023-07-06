package telegram.raw.core;

import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;
import telegram.raw.core.primitives.BytesPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipPacked extends TlObject{

    public static int ID = 0x3072cfa1;

    public static TlObject read(ByteArrayInputStream bytes) throws IOException {
        byte[] data = BytesPrimitive.read(bytes).getValue();
        byte[] decompress_data = new byte[data.length];
        GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(data));
        gzipInputStream.read(decompress_data);
        return TlObject.read(new ByteArrayInputStream(decompress_data));


    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
