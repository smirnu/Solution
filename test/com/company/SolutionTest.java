package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void testCase1() {
        String data = "1\n" + "2\n" + "0\n" + "1\n" + "0\n" + "1\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
        } finally {
            System.setIn(stdin);
        }

        try {
            process_packages.main(new String[0]);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        assertEquals(stdin, "1\\n\" + \"2\\n\" + \"0\\n");
    }
}