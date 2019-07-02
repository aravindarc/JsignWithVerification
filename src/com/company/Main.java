package com.company;

import net.jsign.pe.PEFile;
import net.jsign.pe.VerificationException;

import javax.naming.AuthenticationException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, VerificationException {

        File file = new File("EXES/ac.exe");
        PEFile peFile = new PEFile(file);

        peFile.verify();
    }
}