package com.pc.privacylibrary.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author : liaominggui
 * e-mail : liaominggui@pconline.com.cn
 * date   : 2022/4/2 11:42
 * desc   :
 */
public class CheckEmail {

    public static boolean checkEmail(String email) {// 验证邮箱的正则表达式
        Pattern pattern = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");//\w表示a-z，A-Z，0-9(\\转义符)

        Matcher matcher = pattern.matcher(email);

        boolean b = matcher.matches();

        if (b) {
            return true;// 邮箱名合法，返回true
        } else {
            return false;// 邮箱名不合法，返回false
        }
    }

}
