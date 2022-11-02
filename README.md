# mock-all

一个简单的模拟数据的工具包

## examples

```java
package com.jk1123.mock.examples;

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

```

结果:

```yacas
例子一:
mock人名: 夏侯窑裤
mock年龄: 62
mock手机号: 14510508731
mock邮箱: 82054@qq.com
mock大学名: 大连交通大学
mock省市区县乡镇村: 黑龙江省-大兴安岭地区-加格达奇区-红旗街道-阳光居委会
例子二:
mock人名: 凤寄灵
mock年龄: 24
mock手机号: 16664154500
mock邮箱: _595d70z80ry@163.com
mock大学名: 新乡医学院
mock省市区县乡镇村: 上海市-市辖区-黄浦区-五里桥街道-斜土居委会
例子三:
mock人名: 惠私
mock年龄: 47
mock手机号: 13844043580
mock邮箱: x1@sogou.com
mock大学名: 上饶师范学院
mock省市区县乡镇村: 山东省-枣庄市-市中区-矿区街道-东井居委会
```



## enjoy~~~