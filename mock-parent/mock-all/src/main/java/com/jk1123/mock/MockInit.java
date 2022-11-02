package com.jk1123.mock;

import com.jk1123.mock.address.chinese.MockChineseAddressGenerator;
import com.jk1123.mock.education.chinese.MockChineseEducationGenerator;
import com.jk1123.mock.name.chinese.MockChineseNameGenerator;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/3 1:31
 * @description
 */
public class MockInit {
    public static void init(){
        //初始化中国地区
        MockChineseAddressGenerator.init();
        //初始化中文名
        MockChineseEducationGenerator.init();
        //初始化中文大学
        MockChineseNameGenerator.init();
    }
}
