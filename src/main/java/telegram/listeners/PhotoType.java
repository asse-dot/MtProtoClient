package telegram.listeners;

public class PhotoType {

    private long photo_id;
    private long access_hash;
    private byte[] file_reference;

    public long getPhoto_id() {
        return photo_id;
    }

    public long getAccess_hash() {
        return access_hash;
    }

    public byte[] getFile_reference() {
        return file_reference;
    }

    public PhotoType(long photo_id, long access_hash, byte[] file_reference) {
        this.photo_id = photo_id;
        this.access_hash = access_hash;
        this.file_reference = file_reference;
    }
}
