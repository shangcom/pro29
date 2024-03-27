package com.green.pro29;

import com.green.pro29.ex01.MemberVO;
import com.green.pro29.ex01.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/test/*")
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello REST!";
    }

//    @RequestMapping("/member")
//    public MemberVO member() {
//        MemberVO vo = new MemberVO();
//        vo.setId("hong");
//        vo.setPwd("1111");
//        vo.setName("홍일동");
//        vo.setEmail("hong1@naver.com");
//        return vo
//    }

    @RequestMapping("/listMembers")
    public List<MemberVO> listMembers() {
        List<MemberVO> membersList = Arrays.asList(new MemberVO("hong", "1111", "홍일동", "hong1@naver.com"), new MemberVO("hong2", "1111", "홍이동", "hong2@naver.com"), new MemberVO("hong3", "1111", "홍삼동", "hong3@naver.com"));
        return membersList;
    }

    @RequestMapping("/avg")
    public Double avg() {
        List<Student> studentList = Arrays.asList(new Student("홍길동", 70), new Student("홍이동", 75), new Student("홍삼동", 50));

//                double avg = studentList.stream().mapToDouble(Student::getScore).average().getAsDouble();
        double average = studentList.stream().mapToDouble((obj) -> {
            return obj.getScore();
        }).average().getAsDouble();
        return average;
    }


    @RequestMapping("/mapTest")
    String mapTest() {
        Map<String, String> map = new HashMap();
        map.put("a", "apple");
        map.put("b", "banana");

        return map.get("a");
    }

    @RequestMapping("/mapTest2")
    Student mapTest2() {
        Map<String, Student> map = new HashMap();
        map.put("a", new Student("하하", 100));
        map.put("b", new Student("하하2", 200));

        return map.get("b");
    }

    @RequestMapping("/mapTest3")
    List<Student> mapTest3() {
        List<Student> studentList = Arrays.asList(new Student("홍길동", 70), new Student("홍이동", 75), new Student("홍삼동", 50));

        Map<String, List<Student>> map = new HashMap<>();
        map.put("stu", studentList);

        return map.get("stu");
    }
}


