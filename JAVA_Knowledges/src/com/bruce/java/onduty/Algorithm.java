package com.bruce.java.onduty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizhenghao on 15-8-27.
 */
public class Algorithm {

    private static List<User> list1;
    private static List<User> list2;
    private static List<User> list3;

    private static ArrayList<List<User>> resultList = null;

    public static void main(String[] args) {
        init();
//        removeAllSameGender();
        sort();
//        keepApart();
//        sortByKeepApart();
//        calculationTimesTo21();
//        cutOffTo21();


        printResult();
    }

    private static void sort() {
        for (int i=0;i<7;i++) {
            for (int j=0;j<6;j++) {
                User user1 = list1.get(j);
                user1.time++;
                int k = i%2==0?(j + 3)%6:j;
                User user2 = list2.get(k);
                user2.time++;
                int n = (k + 3)%6;
                User user3 = list3.get(n);
                user3.time++;

                List<User> resultItem = new ArrayList<User>();
                resultItem.add(user1);
                resultItem.add(user2);
                resultItem.add(user3);
                resultList.add(resultItem);
            }
        }
    }

    private static void calculationTimesTo21() {
        for (int i=0;i<21;i++) {
            List<User> tempList = resultList.get(i);
            for (User user : tempList) {
                user.time++;
            }
        }
    }

    private static void cutOffTo21() {

    }

//    private static void sort() {
//            List<User> lastOneList = resultList.get(0);
//            int lastPosition = 0;
//
//            for (int i = 1; i < resultList.size(); i++) {
//                List<User> currList = resultList.get(i);
//                if (isExistSameUser(lastOneList, currList)) {
//                    continue;
//                } else {
//                    lastPosition++;
//                    resetPosition(lastPosition, i);
//                    lastOneList = resultList.get(lastPosition);
//                    i = lastPosition;
//                }
//            }
//    }

    private static void keepApart() {
        int temp = 0;
        for (int i = 1; i < 21; i++) {
            int n = i % 5;
            switch (n) {
                case 0:
                    continue;
                case 1:
                    temp = 1 * 21 - 1 + i;
                    break;
                case 2:
                    temp = 2 * 21 - 1 + i - 1;
                    break;
                case 3:
                    temp = 3 * 21 - 1 + i - 2;
                    break;
                case 4:
                    temp = 3 * 21 + 1 * 24 - 1 + i - 3;
                default:
                    break;
            }
            resetPosition(i, temp);
        }
    }

    private static void sortByKeepApart() {

        List<User> lastOneList = resultList.get(0);
        int lastPosition = 0;

//        for (int i = 1; i < resultList.size(); i++) {
        for (int i = 1; i < 21; i++) {
            List<User> currList = resultList.get(i);
            if (isExistSameUser(lastOneList, currList)) {
                continue;
            } else {
                lastPosition++;
                resetPosition(lastPosition, i);
                lastOneList = resultList.get(lastPosition);
                i = lastPosition;
            }
        }
    }

    private static boolean isExistSameUser(List<User> lastOneList, List<User> currList) {
        for (int i = 0; i < 3; i++) {
            if (lastOneList.get(i).id == currList.get(i).id) {
                return true;
            }
        }
        return false;
    }

    private static void resetPosition(int lastPosition, int currPosition) {
        List<User> temp = null;
        temp = resultList.get(lastPosition);
        resultList.remove(lastPosition);
        resultList.add(lastPosition, resultList.get(currPosition));
        resultList.remove(currPosition);
        resultList.add(currPosition, temp);
    }

    private static void printResult() {
        for (int i = 0; i < resultList.size(); i++) {
//        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < resultList.get(i).size(); j++) {
                System.out.print(resultList.get(i).get(j).toString() + " ");
            }
            System.out.println();
        }

        System.out.println(resultList.size() + "天");
    }

    private static void removeAllSameGender() {

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                for (int k = 0; k < 6; k++) {
                    List<User> itemList = new ArrayList<User>();

                    int n = list1.get(i).gender + list2.get(j).gender + list3.get(k).gender;

                    if (n == 1 || n == 2) {
                        itemList.add(list1.get(i));
                        itemList.add(list2.get(j));
                        itemList.add(list3.get(k));
                        list1.get(i).time++;
                        list2.get(j).time++;
                        list3.get(k).time++;

                        resultList.add(itemList);
                    }

                }
            }
        }
    }

    private static void init() {
        resultList = new ArrayList<List<User>>();

        list1 = new ArrayList<User>();
        list2 = new ArrayList<User>();
        list3 = new ArrayList<User>();

        User user11 = new User(11, 1, "一一", 1);
        User user12 = new User(12, 1, "一二", 1);
        User user13 = new User(13, 1, "一三", 1);
        User user14 = new User(14, 1, "一四", 0);
        User user15 = new User(15, 1, "一五", 0);
        User user16 = new User(16, 1, "一六", 0);

        list1.add(user11);
        list1.add(user12);
        list1.add(user13);
        list1.add(user14);
        list1.add(user15);
        list1.add(user16);

        User user21 = new User(21, 2, "二一", 1);
        User user22 = new User(22, 2, "二二", 1);
        User user23 = new User(23, 2, "二三", 1);
        User user24 = new User(24, 2, "二四", 0);
        User user25 = new User(25, 2, "二五", 0);
        User user26 = new User(26, 2, "零零", 0);

        list2.add(user21);
        list2.add(user22);
        list2.add(user23);
        list2.add(user24);
        list2.add(user25);
        list2.add(user26);

        User user31 = new User(31, 3, "三一", 1);
        User user32 = new User(32, 3, "三二", 1);
        User user33 = new User(33, 3, "三三", 1);
        User user34 = new User(34, 3, "三四", 0);
        User user35 = new User(35, 3, "三五", 0);
        User user36 = new User(36, 3, "三六", 0);

        list3.add(user31);
        list3.add(user32);
        list3.add(user33);
        list3.add(user34);
        list3.add(user35);
        list3.add(user36);
    }

}
