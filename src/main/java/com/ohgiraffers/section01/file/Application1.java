package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. File 클래스의 사용 용법을 이해할 수 있다. */

        /* JDK 1.0부터 지원하는 API로 파일 처리를 수행하는 대표적인 클래스이다.
        * 대상 파일에 대한 정보로 인스턴스를 생성하고
        * 파일의 생성, 삭제 등등의 처리를 수행하는 기능을 제공하고 있다.
        * */

        File file = new File("src/main/java/com/ohgiraffers/section01/file/test.txt");

        try {
            boolean createSuccess = file.createNewFile();

            System.out.println("createSuccess = " + createSuccess); // 초기 생성 시에는 true 반환, 이미 만들어진 다음은 false 반환
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.length() + "byte");
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath()); // 절대경로 가지고오는 메소드

        boolean deleteSuccess = file.delete();
        System.out.println("deleteSuccess = " + deleteSuccess); // 파일을 삭제 시켜서 true 라 출력
    }
}
