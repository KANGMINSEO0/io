package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. FileReader를 이해하고 사용할 수 있다. */
        /* FileReader
        * FileInputStream과 사용하는 방법이 거의 동일하다.
        * 단, byte 단위가 아닌 character 단위로 읽어들이는 부분이 차이점이다.
        * 따라서 2바이트이던 3바이트이던 글자 단위로 읽어오기 때문에 한글을 정상적으로 읽어올 수 있다.
        * */

        FileReader fr = null;
        try {
            fr = new FileReader("src/main/java/com/ohgiraffers/section02/stream/testReader.txt");

            int value;
            while ((value = fr.read()) != -1) {
                System.out.print((char) value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             if (fr != null) {
                 try {
                     fr.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}
