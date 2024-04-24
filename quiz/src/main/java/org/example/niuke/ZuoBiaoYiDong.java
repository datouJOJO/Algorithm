package org.example.niuke;

import java.util.*;

/**
 * @Author: DiDi
 * @Description: 坐标移动
 * @Data: 2024-04-23-11:34
 */
public class ZuoBiaoYiDong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(";");
        // 过滤无效坐标
        String[] validDate = filterUnValidDate(arr);
//        for (String s : validDate) {
//            System.out.print(s + " ");
//        }
        move(validDate);
    }

    public static void move(String[] moveArr) {
        int x = 0, y = 0;
        for (String s : moveArr) {
            String direction = s.substring(0, 1);
            Integer length = Integer.valueOf(s.substring(1));
            if ("A".equals(direction)) {
                x -= length;
            } else if ("S".equals(direction)) {
                y -= length;
            } else if ("D".equals(direction)) {
                x += length;
            } else {
                y += length;
            }
        }
        System.out.println(x + "," + y);
    }

    public static String[] filterUnValidDate(String[] arr) {
        List<String> filterArr = new ArrayList<>();
        for (String s : arr) {
            if (s.length() > 0) {
                if (s.startsWith("A") || s.startsWith("S") || s.startsWith("D") || s.startsWith("W")) {
                    String number = s.substring(1);
                    boolean isDigit = true;
                    for (char c : number.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            isDigit = false;
                        }
                    }
                    if (isDigit) {
                        filterArr.add(s);
                    }
                }
            }
        }
        return filterArr.toArray(new String[0]);
    }
}
