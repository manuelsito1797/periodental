package com.project.periodental.adapter.security.basic;

import com.project.periodental.adapter.security.EncryptionAdapter;
import com.project.periodental.utils.PropertyUtil;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Objects;

/**
 * @author djimenez on 31/3/2022
 * periodental
 */
public class CipherAdapter implements EncryptionAdapter {

    private static final String INSTANCE_STRING = "PBEWithMD5AndDES";
    private static final char[] PASSWORD = Objects.requireNonNull(PropertyUtil.load()).getProperty("secret").toCharArray();
    private static final byte[] SALT = { (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33,
            (byte) 0x10, (byte) 0x12, };

    @Override
    public String encrypt(String text) throws GeneralSecurityException, UnsupportedEncodingException {
        var keyFactory = SecretKeyFactory.getInstance(INSTANCE_STRING);
        var key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        var pbeCipher = Cipher.getInstance(INSTANCE_STRING);
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(text.getBytes("UTF-8")));
    }

    private static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public String decrypt(String text) throws GeneralSecurityException {
        var keyFactory = SecretKeyFactory.getInstance(INSTANCE_STRING);
        var key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        var pbeCipher = Cipher.getInstance(INSTANCE_STRING);
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(base64Decode(text)));
    }

    private static byte[] base64Decode(String property) {
        return Base64.getDecoder().decode(property);
    }
}
