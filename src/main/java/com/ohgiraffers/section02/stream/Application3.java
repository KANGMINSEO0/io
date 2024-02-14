package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {

    public static void main(String[] args) {

        /* 수업목표. FileOutputStream을 이해하고 사용할 수 있다. */
        /* FileOutputStream
        * 프로그램의 데이터를 파일로 내보내기 위한 용도의 스트림이다.
        * 1바이트 단위로 데이터를 처리한다.
        * */

        FileOutputStream fout = null; // null로 Stream을 생성
        try {
            fout = new FileOutputStream(("src/main/java/com/ohgiraffers/section02/stream/testOutputStream.txt"));   // FileOutputStream으로 경로 설정하여 파일 생성

            fout.write(97);

            byte[] bar = new byte[]{98, 99, 100, 101, 10};  // 10은 개행 문자임
//            byte[] bar = new byte[]{98, 99, 100, 101, 102};
            fout.write(bar);

            fout.write(bar, 1, 3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);  // write는 IOException 핸들링 해줘야 함
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);  // close도 IOException 핸들링 해줘야 함
                }
            }
        }

    }
}
