import java.util.Scanner;

public class EnterData {
    private static final String[] simvol = {"+", "-", "/", "*"};

    public static void main(String[] args) {
        Converter converter = new Converter();

        Scanner scan = new Scanner(System.in); //ввод инфы
        System.out.println("Введите свое выражение");
        String ent = scan.nextLine();
        var symb = getOperation(ent);
        getResult(ent, symb);
    }


    public static String getOperation(String input) {
        String operation = "";
        input = input.replace(" ", "");
        String[] regSimvol = {"\\+", "-", "/", "\\*"};
        String[] operators = {"+", "-", "/", "*"};
        int count = 0;
        for (int i = 0; i < operators.length; i++) {
            if (input.contains(operators[i])) {
                operation = regSimvol[i];
           count++;
            }
        }
        if (count>1){
            throw new RuntimeException("Допустимо только два операнда!!");
        }
        if (operation.isEmpty()) {
            throw new RuntimeException("Строка не являеться математической!");
        }
        return operation;
    }

    public static void getResult(String input, String operation) {
        String[] info = input.split(operation);
        if (info.length>2){
            throw new RuntimeException("Допустимо только два операнда!!");
        }
        String s1 = info[0].trim();
        String s2 = info[1].trim();
        int a;
        int b;

        if (Converter.isRoman(s1) == Converter.isRoman(s2)) {
            if (Converter.isRoman(s1) && Converter.isRoman(s2)) {// определение формата чиселVV
                a = Converter.romanToInt(s1);
                b = Converter.romanToInt(s2);
                if (a > 10 || b > 10) {
                    throw new IllegalArgumentException(" Числа должны быть не более 10!");
                }

            } else {
                a = Integer.parseInt(s1);
                b = Integer.parseInt(s2);
                if (a > 10 || b > 10) {
                    throw new IllegalArgumentException(" Числа должны быть не более 10!");
                }
            }
        } else {
            throw new NumberFormatException("Числа в разном формате, повторите попытку");
        }
        int result = calcResult(a, b, operation);
        if (Converter.isRoman(s1)) {
            System.out.println(Converter.intToRoman(result));
        } else {
            System.out.println(result);
        }
    }


    private static int calcResult(int a, int b, String operation) {
        return switch (operation) {
            case "\\+" -> a + b;
            case "-" -> a - b;
            case "\\*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Отсутсвует символ операции");
        };
    }
}
//        if(Converter.isRoman(a))
//
//        {
//            System.out.println(Converter.intToRoman(result));
//        } else
//
//        {
//            System.out.println(result);
//        }
//    }







