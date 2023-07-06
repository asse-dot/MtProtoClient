package telegram.raw.core;

import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.functions.account.AcceptAuthorization;
import telegram.raw.types.MessageEntityMentionName;
import telegram.raw.types.MessageEntitySpoiler;
import telegram.raw.types.MessageEntityUnderline;
import telegram.raw.types.MessageEntityUrl;
import telegram.raw.types.*;
import telegram.raw.types.Message;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class TlObject {

    private static Map<Integer, Class<? extends TlObject>> objects = new HashMap<Integer, Class<? extends TlObject>>();

    static{
        objects.put(ResPQ.ID, ResPQ.class);
        objects.put(VectorPrimitive.ID, VectorPrimitive.class);
        objects.put(ServerDHParamsOk.ID, ServerDHParamsOk.class);
        objects.put(ServerDHInnerData.ID, ServerDHInnerData.class);
        objects.put(BadServerSalt.ID, BadServerSalt.class);
        objects.put(RpcResult.ID, RpcResult.class);
        objects.put(User.ID, User.class);
        objects.put(Updates.ID, Updates.class);
        objects.put(UpdateNewMessage.ID, UpdateNewMessage.class);
        objects.put(Message.ID, Message.class);
        objects.put(PeerUser.ID, PeerUser.class);
        objects.put(MessageEntityBold.ID, MessageEntityBold.class);
        objects.put(MessageEntityBotCommand.ID, MessageEntityBotCommand.class);
        objects.put(MessageEntityBlockquote.ID, MessageEntityBlockquote.class);
        objects.put(MessageEntityCashtag.ID, MessageEntityCashtag.class);
        objects.put(MessageEntityCustomEmoji.ID, MessageEntityCustomEmoji.class);
        objects.put(MessageEntityEmail.ID, MessageEntityEmail.class);
        objects.put(MessageEntityItalic.ID, MessageEntityItalic.class);
        objects.put(MessageEntityHashtag.ID, MessageEntityHashtag.class);
        objects.put(MessageEntityMention.ID, MessageEntityMention.class);
        objects.put(MessageEntityMentionName.ID, MessageEntityMentionName.class);
        objects.put(MessageEntityPhone.ID, MessageEntityPhone.class);
        objects.put(MessageEntityPre.ID, MessageEntityPre.class);
        objects.put(MessageEntitySpoiler.ID, MessageEntitySpoiler.class);
        objects.put(MessageEntityStrike.ID, MessageEntityStrike.class);
        objects.put(MessageEntityUrl.ID, MessageEntityUrl.class);
        objects.put(MessageEntityUnderline.ID, MessageEntityUnderline.class);
        objects.put(MessageEntityUnknown.ID, MessageEntityUnknown.class);
        objects.put(AcceptAuthorization.ID, AcceptAuthorization.class);
        objects.put(GZipPacked.ID, GZipPacked.class);
        objects.put(MessageMediaPhoto.ID, MessageMediaPhoto.class);
        objects.put(telegram.raw.types.photos.Photo.ID, telegram.raw.types.photos.Photo.class);
        objects.put(PhotoSize.ID, PhotoSize.class);
        objects.put(VideoSize.ID, VideoSize.class);
    }


    public abstract byte[] write() throws IOException;

    public static TlObject read(ByteArrayInputStream bytes) throws IOException {
        try {
            int id = IntPrimitive.read(bytes).getValue();
            System.out.println(Integer.toHexString(id));
            return (TlObject) objects.get(id).getMethod("read", ByteArrayInputStream.class).invoke(null, bytes);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {

        }

        return null;
    }

    public int getLength() {
        try {
            return this.write().length;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
