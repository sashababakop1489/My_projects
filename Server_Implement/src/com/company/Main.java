package com.company;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9090);

        } catch (Exception e) {
            e.getMessage();
        }

        Socket clientSocket = null;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                InputStream in = clientSocket.getInputStream();
                String input = readStream(in);
                InputProcessor processor = new InputProcessor();
                String response = processor.processInput(input);
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println(response);
                in.close();
                writer.close();
            } catch (Exception e) {
                clientSocket.close();
                e.getMessage();
            }
        }

    }

    private static String readStream(InputStream in) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        byte[] endMaskGet = {13, 10, 13, 10};
        byte[] endMaskPost = {34, 13, 10, 125};
        byte[] lastFourBytes = {0, 0, 0, 0};
        int c = 0;
        do {
            c = in.read();
            System.out.println(c);
            byteArray.write(c);
            updateBytes(lastFourBytes, c);
            if (in.available() == 0 ){
                break;
            }

        } while (c != -1 && !Arrays.equals(endMaskPost, lastFourBytes));
            String result = byteArray.toString();
            System.out.println(result);
            return result;

    }

        private static void updateBytes ( byte[] arr, int c){
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[3];
            arr[3] = (byte) c;

        }
    }
