/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: StringsTest.java
 * Author:   coder_feng
 * Date:     2017年3月16日 下午2:18:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.alg.string.Strings;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringsTest {

    @Test
    public void testKmpPrefix() {
        Assert.assertEquals(Strings.kmpIndexOf("abcdefgabcdfabcaegd", "gabcdf"),
                "abcdefgabcdfabcaegd".indexOf("gabcdf"));
    }

    @Test
    public void testIndexOf() {
//        Assert.assertEquals(Strings.indexOf("", ""), "".indexOf(""));
//        Assert.assertEquals(Strings.indexOf("", "a"), "".indexOf("a"));
//        Assert.assertEquals(Strings.indexOf("", "ab"), "".indexOf("ab"));
//        Assert.assertEquals(Strings.indexOf("a", ""), "a".indexOf(""));
        Assert.assertEquals(Strings.indexOf("ab", ""), "ab".indexOf(""));
//        Assert.assertEquals(Strings.indexOf("ab", "1"), "ab".indexOf("1"));
//        Assert.assertEquals(Strings.indexOf("ab", "a"), "ab".indexOf("a"));
//        Assert.assertEquals(Strings.indexOf("ab", "ab"), "ab".indexOf("ab"));
//        Assert.assertEquals(Strings.indexOf("abc", "bc"), "abc".indexOf("bc"));
//        Assert.assertEquals(Strings.indexOf("abc", "b"), "abc".indexOf("b"));
//        Assert.assertEquals(Strings.indexOf("abc", "a"), "abc".indexOf("a"));

    }

    private static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
