package main.java.IOStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by YZ on 11/22/15.
 */
public class ReadingFromStandardInput {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
           System.out.println(s);
        }
    }
}
