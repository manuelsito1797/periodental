package com.project.periodental.adapter.security;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * @author djimenez on 31/3/2022
 * periodental
 */
public interface EncryptionAdapter {

    String encrypt(String text) throws GeneralSecurityException, UnsupportedEncodingException;

    String decrypt(String text) throws GeneralSecurityException;
}
