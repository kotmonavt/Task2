public class Task2 {
    public static void main(String[] args) {
        // 1 повтор символа в строке
        System.out.println("1. repeat: " + repeat("mice", 4));
        // 2 разница самого большого и самого маленького числа массива
        System.out.println("2. differenceMaxMin: " + differenceMaxMin(new int[] {44, 32, 86, 19}));
        // 3 среднее значение
        System.out.println("3. isAvgWhole: " + isAvgWhole(new int[] {1,3}));
        // 4 сумма данного и предыдущих
        System.out.print("4. cumulativeSum: ");
        int[] cumulative = cumulativeSum(new int[] {1, 2, 3});
        for (int i = 0; i < cumulative.length; i++) {
            System.out.print(cumulative[i] + " ");
        }
        System.out.println();
        // 5 десятичные знаки
        System.out.println("5. getDemicalPlaces: " + getDemicalPlaces("457.2089"));
        // 6 Фибоначчи
        System.out.println("6. Fibonacci: " + Fibonacci(7));
        // 7 Почтовые индексы
        System.out.println("7. isValid: " + isValid("85957"));
        // 8 Странные строки
        System.out.println("8. isStrangePair: " + isStrangePair("ratio", "orator"));
        // 9.1 префикс
        System.out.println("9.1. isPrefix: " + isPrefix("automation", "auto-"));
        // 9.2 суффикс
        System.out.println("9.2. isSuffix: " + isSuffix("arachnophobia", "-phobia"));
        // 10 Шаги
        System.out.println("10. boxSeq: " + boxSeq(5));
    }
    // Методы выполнения
    // 1. Метод, который повторяет символы в строке
    public static String repeat(String word, int n) {
        String resultWord = "";
        for (int i=0; i < word.length(); i++) {
            for (int k = 0; k < n; k++) {
                resultWord += word.charAt(i);
            }
        }
        return resultWord;
    }
    // 2. Метод, вычисляющий разницу самого большого и самого маленького числа массива
    public static int differenceMaxMin(int[] args) {
        int x;
        // сортировка на выявление большего элемента
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i] > args [i+1]) {
                x = args[i];
                args[i] = args[i+1];
                args[i+1] = x;
            }
        }
        // сортировка на выявление меньшего элмента
        for (int i = args.length - 2; i > 0; i--) {
            if (args[i] < args[i-1]) {
                x = args[i];
                args[i] = args[i-1];
                args[i-1] = x;
            }
        }
        return args[args.length-1] - args[0];
    }
    // 3. Метод, возвращающий true или false в зависимости от того, является ли среднее значение массива целым числом
    public static boolean isAvgWhole(int[] args) {
        int summ = 0;
        for (int i = 0; i < args.length - 1; i++) {
            summ += args[i];
        }
        return (summ / args.length) % 10 == 0;
    }
    // 4. Метод, вызвращающий новый массив из суммы
    public static int[] cumulativeSum(int[] args) {
        int summ = 0;
        for (int i = 0; i < args.length; i++) {
            summ += args[i];
            args[i] = summ;
        }
        return args;
    }
    // 5. Метод, подсчитывающий количество знаков после запятой
    public static int getDemicalPlaces(String number) {
        int dot = number.lastIndexOf(".");
        return number.length() - dot - 1;
    }
    // 6. Метод, возвращающий числу его число Фибоначчи
    public static int Fibonacci(int f) {
        int fibonacciFirst = 0;
        int fibonacciSecond = 1;
        int reserve;
        for (int i = 1; i <= f; i++) {
            reserve = fibonacciSecond;
            fibonacciSecond += fibonacciFirst;
            fibonacciFirst = reserve;
        }
        return fibonacciSecond;
    }
    // 7. Метод, проверяющий, является ли строка почтовым индексом
    public static boolean isValid(String address) {
       if (address.length() == 5)  {
           int count = 0;
           String numbers = "0123456789";
           for (int i = 0; i < address.length(); i++) {
               char num = address.charAt(i);
               String subString = String.valueOf(num);
               if (numbers.contains(subString)) {
                   count += 1;
               }
           }
           return count == 5;
       } else {
           return false;
       }
    }
    // 8. Метод, проверяющий, являются ли строки странными
    public static boolean isStrangePair(String firstWord, String secondWord) {
        return firstWord.charAt(0) == secondWord.charAt(secondWord.length()-1) && secondWord.charAt(0) == firstWord.charAt(firstWord.length()-1);
    }
    // 9.1. Метод, проверяющий, начинается ли строка с другой строки
    public static boolean isPrefix(String newString, String pref) {
        pref = pref.substring(0, pref.length()-1);
        return newString.startsWith(pref);
    }
    // 9.2. Метод, проверяющий, заканчивается строка другой строкой
    public static boolean isSuffix(String newString, String suff) {
        suff = suff.substring(1);
        return newString.endsWith(suff);
    }
    // 10. Метод, делающий шаги
    public static int boxSeq(int step) {
        int count = 0;
        if (step % 2 ==0) {
            return count - 1 * (step / 2) + 3 * (step / 2);
        } else { return count - 1 * (step / 2) + 3 * (step / 2 + 1); }
    }

}