package com.company;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import net.jsign.pe.PEFile;

import javax.naming.AuthenticationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, AuthenticationException {

        File file = new File("EXES/python-3.7.0-amd64.exe");
        PEFile peFile = new PEFile(file);

        peFile.verify();
    }
}