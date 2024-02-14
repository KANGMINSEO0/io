package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {

    public static void main(String[] args) {

        /* 수업목표. 객체단위 입출력 보조스트림을 이해하고 사용할 수 있다. */
        /* ObjectInputStream/ObjectOutputStream */

        MemberDTO[] outputMember = {
                new MemberDTO("user01", "pass01", "홍길동", "hong777@ohgiraffers.com", 25, '남', 1250.7),
                new MemberDTO("user02", "pass02", "유관순", "korea31@ohgiraffers.com", 16, '여', 1221.6),
                new MemberDTO("user03", "pass03", "이순신", "leesoonsin7@ohgiraffers.com", 22, '남', 1234.6)
        };

        ObjectOutputStream objOut = null;

        try {
            objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt")));

            for (int i = 0; i < outputMember.length; i++) {
                objOut.writeObject(outputMember[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objOut != null) {
                try {
                    objOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /* 직렬화란?
        * 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부에서도 사용할 수 있도록
        * 바이트(byte)형태로 데이터를 젼환하는 기술을 말한다.
        * 반대로 바이트로 변환된 데이터를 다시 객체로 변환하는 기술을 역직렬화라고 한다.
        * */
        MemberDTO[] inputMember = new MemberDTO[3];
        ObjectInput objIn = null;

        try {
            objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt")));

            while (true) {
                System.out.println(objIn.readObject());
            }
        } catch (EOFException e) {
            System.out.println("끝!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objIn != null) {
                try {
                    objIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}