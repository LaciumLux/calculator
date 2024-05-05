import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        String input = sc.nextLine();
        System.out.println("Output:");
        System.out.println(calc(input));
    }

    static int convertToArab(String number) {
       try {
           switch (number){
               case "I" -> {
                   return 1;
               }
               case "II" -> {
                   return 2;
               }
               case "III" -> {
                   return 3;
               }
               case "IV" -> {
                   return 4;
               }
               case "V" -> {
                   return 5;
               }
               case "VI" -> {
                   return 6;
               }
               case "VII" -> {
                   return 7;
               }
               case "VIII" -> {
                   return 8;
               }
               case "IX" -> {
                   return 9;
               }
               case "X" -> {
                   return 10;
               }

           }
       } catch (IllegalArgumentException e) {
           throw new IllegalArgumentException("Введите верное римское число [I..X].");}
        return 0;
    }
    private static String convertToRome(int i) {
        String[] roman = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C"};

        return roman[i];
    }
    public static int operation(int a, String operator, int b) {
        int result;
        switch (operator) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
            default ->  throw new IllegalArgumentException("Неизвестный оператор: " + operator);
            }

        return result;
    }

    public static String calc(String input) {
        int a, b, result;
        String[] value = input.split(" ");
        if (value.length == 1 || value.length == 2)
            throw new ArrayIndexOutOfBoundsException("Строка не является математической операцией.");
        else if (value.length > 3)
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию.");
        String num1 = value[0];
        String operator = value[1];
        String num2 = value[2];
        a = convertToArab(num1);
        b = convertToArab(num2);
        if (a > 0 && b > 0) {
            result = operation(a, operator, b);
            if (result > 0){
                return convertToRome(result);
            }
            else 
                throw new IllegalArgumentException("В римской системе счисления результат не может быть нулевым или отрицательным.");

        } else if(a == 0 && b > 0 || a > 0 && b == 0){
            throw new IllegalArgumentException("Невозможны действия с разными системами счисления.");
        }
        else {
            a = Integer.parseInt(num1);
            b = Integer.parseInt(num2);
            if (a > 0 && a < 11 && b > 0 && b < 11){
                result = operation(a, operator, b);
                return String.valueOf(result);}
            else throw new IllegalArgumentException("Введите верное арабское число [1..10].");
        }

    }
}