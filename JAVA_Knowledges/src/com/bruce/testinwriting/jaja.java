package com.bruce.testinwriting;

import java.util.Date;

/**
 * Created by qizhenghao on 17/3/2.
 */
public class jaja extends Date{

    public static void main(String[] args) {

        new jaja().test();
        jaja jaja = new jaja();
        jaja.test();

        Date date = new Date();
        System.out.println(date.getClass().getName());

        System.out.println(date.getClass().getSuperclass().getName());
        System.out.println(resolve(new int[]{2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7}));

        String authResult = "resultStatus={6001};memo={操作已经取消。};result={success=true&auth_code=d9d1b5acc26e461dbfcb6974c8ff5E64&result_code=200&user_id=2088003646494707}";
        String[] tempArr = authResult.split(";");
        String resultTemp = "";
        if (tempArr.length == 3) {
            resultTemp = tempArr[2].substring(7, tempArr[2].length()-1);
        }
        String[] resultArr = resultTemp.split("&");
        String auth_code = null, result_code = null;
        long user_id = 0;
        if (resultArr.length > 1) {
            String[] resultItemArr = resultArr[0].split("=");
            if (resultItemArr.length==2 && "true".equals(resultItemArr[1])) {
                for (int i = 1; i < resultArr.length; i++) {
                    resultItemArr = resultArr[i].split("=");
                    if (resultItemArr.length == 2) {
                        if ("auth_code".equals(resultItemArr[0])) {
                            auth_code = resultItemArr[1];
                            continue;
                        }
                        if ("result_code".equals(resultItemArr[0])) {
                            result_code = resultItemArr[1];
                            continue;
                        }
                        if ("user_id".equals(resultItemArr[0])) {
                            user_id = Long.parseLong(resultItemArr[1]);
                            continue;
                        }
                    }
                }
            }
            System.out.println(auth_code + ", " + result_code + ", " + user_id);
        }
    }

    public void test() {
        System.out.println(getClass().getName());
        System.out.println(super.getClass().getSuperclass().getName());
    }


    public static boolean resolve(int[] A) {
        if (A == null || A.length < 7)
            return false;
        int sum = 0;
        int sum1 = A[0];
        int sum2 = A[A.length-1];
        int start = 0, end = A.length-1;

        while (start < end) {
            if (sum1 < sum2) {
                sum1 += A[++start];
            } else if (sum1 > sum2){
                sum2 += A[--end];
            } else {
                if (sum1 == sum) {
                    if (end - start==2)
                        return true;
                    return false;
                }
                sum = sum1;
                start += 2;
                end -= 2;
                sum1 = A[start];
                sum2 = A[end];
            }
        }
        return false;
    }
}
