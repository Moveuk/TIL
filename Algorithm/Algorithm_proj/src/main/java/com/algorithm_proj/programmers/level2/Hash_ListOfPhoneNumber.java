package com.algorithm_proj.programmers.level2;

public class Hash_ListOfPhoneNumber {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = 1; j < phone_book.length; j++) {
                if (phone_book[i].length() < phone_book[j].length()) {
                    String tmp = phone_book[j].substring(0, phone_book[i].length());
                    if (phone_book[i].equals(tmp)) {
                        answer = false;
                        break;
                    }
                }
                if (phone_book[i].length() > phone_book[j].length()) {
                    String tmp = phone_book[i].substring(0, phone_book[j].length());
                    if (phone_book[j].equals(tmp)) {
                        answer = false;
                        break;
                    }
                }
            }
        }


        return answer;
    }
}
