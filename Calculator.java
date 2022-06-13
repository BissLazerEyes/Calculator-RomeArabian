package com.example.demo;

import java.util.Scanner;
import java.util.Arrays;

class Calculator {
    public static void main(String[] args) {
        System.out.println("Введите уравнение:");
        Scanner sc = new Scanner(System.in);
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] inOp = {"+","-","*","/"};
        int a=0;
        int b=0;
        int r = 0;
        String s1 = "";
        String s2 = "";
        String res = "";
        String op = "";
        boolean isRome = false;
        boolean cont = true; //пока переменная будет true, цикл будет продолжаться
        do {
            String input = sc.next();
            String[] strings = input.split("\\W");
            String[] operator = input.split("\\w");
            cont = true;
            try {
                s1 = strings[0];

//выход по символу q
                if (strings[0].toLowerCase().equals("q")) {
                    cont = false;
                    throw new Exception("До свидания!");
// break;
                };
                s2 = strings[1];

//проверяем легальность оператора
                op = operator[operator.length - 1];
                if (Arrays.asList(inOp).contains(op)==false) {
                    throw new Exception("Не является арифметическим оператором");
                }
//частный случай: первое число отрицательное
                if (operator[0].equals("-") && strings.length == 3) {
                    throw new Exception("Ошибка ввода: неверное значение аргумента");
                }
//проверяем единичность операторов
                if (strings.length>2) {
                    throw new Exception("Число операторов превышено");
                }
//проверяем на римские цифры и конвертируем
                isRome = false;
                if (Arrays.asList(roman).contains(s1)&&Arrays.asList(roman).contains(s2)) {
                    isRome = true;
                    a = Arrays.asList(roman).indexOf(s1) ;
                    b = Arrays.asList(roman).indexOf(s2) ;
                }
                else {
                    a = Integer.parseInt(strings[0]);
                    b = Integer.parseInt(strings[1]);
                }
                if (a > 10) {
                    throw new Exception("Ошибка ввода: неверное значение аргумента");
                } else if (a == 0) {
                    throw new Exception("Ошибка ввода: неверное значение аргумента");
                } else if (a<0) {
                    throw new Exception("Ошибка ввода: неверное значение аргумента");
                }
                if (b > 10) {
                    throw new Exception("Ошибка ввода: неверное значение аргумента");
// break;
                } else if (b == 0) {
                    throw new Exception("Ошибка ввода: неверное значение аргумента");
// break;
                }
                r = operation(a, b, op);
                if (isRome) {
// выводим римскими
                    if (r == 0) {
                        throw new Exception("В римской системе нет 0");
                    } else if (r<0) {
                        throw new Exception("В римской системе нет отрицательных значений");
                    } else {
                        res = roman[r];
                    }

                } else {
                    res = Integer.toString(r);
                }
                System.out.println("Результат = " + res);
            } catch (Exception e) {
                System.out.println(e);

            }
        } while (cont);
    }

    static int operation(int a, int b, String op) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}