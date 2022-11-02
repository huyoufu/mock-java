package com.jk1123.mock.examples;

import com.jk1123.mock.MockInit;
import com.jk1123.mock.address.chinese.MockChineseAddressGenerator;
import com.jk1123.mock.common.MockAgeGenerator;
import com.jk1123.mock.common.MockEmailGenerator;
import com.jk1123.mock.common.MockPhoneNumberGenerator;
import com.jk1123.mock.education.chinese.MockChineseEducationGenerator;
import com.jk1123.mock.name.chinese.MockChineseNameGenerator;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/3 3:20
 * @description
 */
public class Example {
    public static void main(String[] args) {
        //调用这个方法 提前将数据都初始化好 当然也可以不调用
        MockInit.init();
        //mock人名
        String nickname = MockChineseNameGenerator.generate();
        System.out.println("mock人名: "+nickname);
        //mock年龄
        int age = MockAgeGenerator.generate();
        System.out.println("mock年龄: "+age);
        //mock手机号
        String phone = MockPhoneNumberGenerator.generate();
        System.out.println("mock手机号: "+phone);
        //mock邮箱
        String email = MockEmailGenerator.generate();
        System.out.println("mock邮箱: "+email);
        //mock中国大学名字
        String college = MockChineseEducationGenerator.generate();
        System.out.println("mock大学名: "+college);
        //mock中国省市区
        String region = MockChineseAddressGenerator.generate(5);
        System.out.println("mock省市区县乡镇村: "+region);


    }
}
