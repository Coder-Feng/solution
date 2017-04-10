/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: Strings.java
 * Author:   coder_feng
 * Date:     2017年3月16日 上午11:04:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.string;

/**
 * 〈一句话功能简述〉<br> 
 * 〈string 常见功能实现〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Strings {

    public static int kmpIndexOf(String plainText, String idxStr) {

        return 0;
    }

    public static int[] kmpPrefix(String text) {
        // 字符串变成字符数组
        char[] chars = text.toCharArray();
        // kmp 算法中需要计算的一个 移动量
        int[] prefix = new int[text.length()];
        // 默认第一个字符移动量为0
        prefix[0] = 0;
        // 
        int k = 0;
        for (int i = 1; i < text.length(); i++) {
            while (k > 0 && chars[k] != chars[i]) {
                k = prefix[k];
            }
            if (chars[k] == chars[i]) {
                k = k + 1;
            }
            prefix[i] = k;
        }
        return prefix;
    }

    /**
     * 
     * 功能描述: <br>
     * 第一次全匹配的索引
     *
     * @param plainText
     * @param idxStr
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static int indexOf(String plainText, String idxStr) {
        // 查找的字符串是空，肯定是匹配的，返回0
        if (idxStr.isEmpty()) {
            return 0;
        } else {
            // 被查找的字符串是空，肯定匹配不到
            if (plainText.isEmpty()) {
                return -1;
            } else if (plainText.length() < idxStr.length()) {
                // 被查找的长度小于查找字符串的长度，必然不满足
                return -1;
            } else {
                //             i
                //             |    delta
                //             ↓ ----------->
                // plainText xxxxxxxxxxxxxxxxxxxxxxxx
                // idx Str   |------->|xxxxxxxxxxxxxx
                //
                //
                //
                // i的偏移量 如上面箭头的区间，此区间后面的长度不够匹配 idxStr
                for (int i = 0; i <= plainText.length() - idxStr.length(); i++) {
                    // 代表能够匹配的长度
                    int delta = 0;
                    for (; delta < idxStr.length();) {
                        //如果有一个字符不同则不匹配
                        if (plainText.charAt(i + delta) != idxStr.charAt(delta)) {
                            break;
                        } else {
                            delta++;
                        }
                    }
                    // 如果匹配的长度 与 查找的字符串长度一致表明 字符串包含,此时 i的位置 就是 idxStr第一次出现的位置
                    if (delta == idxStr.length()) {
                        return i;
                    }
                }
                return -1;
            }

        }
    }
}
