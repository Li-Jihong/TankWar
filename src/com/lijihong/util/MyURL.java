package com.lijihong.util;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: MyURL
 * \* @author: li-jihong
 * \* Date: 2023-04-25 18:43
 */

import java.net.URL;

/**
 * toString 默认显示文件名称的 URL
 */
//public record MyURL(@NotNull URL url) {
//    /**
//     * 只返回文件名
//     */
//    @Override
//    public @NotNull String toString() {
//        String path = url.getPath();
//        return url.getPath()
//                .substring(path.lastIndexOf('/', path.lastIndexOf('/') - 1) + 1) // 倒数两个路径,获得上一层的文件夹
//                .substring(path.lastIndexOf('\\') + 1);
//    }
//}
public record MyURL(@NotNull URL url) {

    /**
     * 只返回文件名
     */
    @Override
    public @NotNull String toString() {
        String path = url.getPath();
        String regex = "[/\\\\]"; //将字符串截取操作替换成了正则表达式
        String[] segments = path.split(regex);
        int lastTwo = segments.length - 2;
        return segments[lastTwo] + "/" + segments[segments.length - 1];
    }
}

