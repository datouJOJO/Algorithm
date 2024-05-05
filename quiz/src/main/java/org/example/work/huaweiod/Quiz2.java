package org.example.work.huaweiod;

import java.util.*;


/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-26-14:05
 */
public class Quiz2 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[][] arr = new String[25][61];
//        // app名称映射对象
//        Map<String, AppInfo> map = new HashMap<>();
//        for(int k = 0 ; k < n; k++) {
//            String appName = sc.next();
//            Integer level = sc.nextInt();
//            String startTime = sc.next();
//            String endTime = sc.next();
//            int iStart = getHours(startTime);
//            int iEnd = getHours(endTime) - iStart;
//            boolean isChongTu = false;
//            String chongTuAppName = "";
//            for (int i = iStart; i < iEnd; i++) {
//                for (int j = 0; j <= 60; j++) {
//                    if (arr[i][j] != null && arr[i][j].length() != 0) {
//                        isChongTu = true;
//                        chongTuAppName = arr[i][j];
//                    }
//                }
//            }
//            if (!isChongTu) {
//                iStart = getHours(endTime);
//
//                for (int j = iEnd; j <= jEnd; j++) {
//                    if (arr[i][j] != null && arr[i][j].length() != 0) {
//                        isChongTu = true;
//                        chongTuAppName = arr[i][j];
//                    }
//                }
//
//            }
//            // 先判断是否和存在的app时间冲突
//            if (isChongTu) {
//                // 比较优先级
//                AppInfo chongTuAppInfo = map.get(chongTuAppName);
//                if (chongTuAppInfo.level < level) {
//                    // 撤销原来的app
//                    deleteApp(chongTuAppInfo, arr, map);
//                    // 安装当前app
//                    AppInfo appInfo = new AppInfo(level, startTime, endTime, appName);
//                    installApp(appInfo, arr, map);
//                }
//            } else {
//                AppInfo appInfo = new AppInfo(level, startTime, endTime, appName);
//                installApp(appInfo, arr, map);
//            }
//
//        }
//        String userTime = sc.next();
//        int i = getHours(userTime);
//        int j = getMinutes(userTime);
//        if (arr[i][j] != null || arr[i][j].length() > 0) {
//            System.out.println(arr[i][j]);
//        } else {
//            System.out.println("NA");
//        }
    }

    public static void installApp(AppInfo appInfo, String[][] arr, Map<String, AppInfo> map) {
        map.put(appInfo.appName, appInfo);
        Integer iStart = getHours(appInfo.startTimeStr);
        int iEnd = getMinutes(appInfo.startTimeStr);
        Integer jStart = getHours(appInfo.endTimeStr);
        int jEnd = getMinutes(appInfo.endTimeStr);
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                arr[i][j] = appInfo.appName;
            }
        }
    }

    public static void deleteApp(AppInfo appInfo, String[][] arr, Map<String, AppInfo> map) {
        map.remove(appInfo.appName);
        Integer iStart = getHours(appInfo.startTimeStr);
        int iEnd = getMinutes(appInfo.startTimeStr);
        Integer jStart = getHours(appInfo.endTimeStr);
        int jEnd = getMinutes(appInfo.endTimeStr);
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                arr[i][j] = "";
            }
        }
    }

    public static Integer getHours(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }

    public static Integer getMinutes(String time) {
        return Integer.parseInt(time.split(":")[1]);
    }
}

class AppInfo {
    // 优先级
    public Integer level;

    // 开始时间
    public Integer startTime;

    public String startTimeStr;

    // 结束时间
    public Integer endTime;

    public String endTimeStr;

    // app名称
    public String appName;

    public AppInfo(Integer level, String startTime, String endTime, String appName) {
        this.level = level;
        this.startTime = transTime(startTime);
        this.startTimeStr = startTime;
        this.endTime = transTime(endTime);
        this.endTimeStr = endTime;
        this.appName = appName;
    }

    public Integer transTime(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
    }

    public boolean judgeTime(String time) {
        Integer timeNumber = transTime(time);
        return timeNumber >= this.startTime && timeNumber <= this.endTime;
    }
}
