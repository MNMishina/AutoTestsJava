import java.util.Scanner;

public class Turtle20thCentury {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения черепахи");
        int a = scanner.nextInt();
        System.out.println("Введите дату смерти черепахи");
        int b = scanner.nextInt();
        scanner.close();

        if (a <= 1900 & b <= 2000) {
            System.out.println("Черепаха родилась в 20м веке");
        } else if (a <= 1900 & b >= 2000) {
            System.out.println("Черепаха родилась в 20м веке");
        } else if (a >= 1900 & b <= 2000) {
            System.out.println("Черепаха родилась в 20м веке");
        } else if (a >= 1900 & b >= 2000) {
            System.out.println("Черепаха родилась в 20м веке");
        } else {
            System.out.println("Черепаха НЕ родилась в 20м веке"); // не работает это условие
        }
    }
}
   /*
            else if (a == 2) {
                switch (b) {
                    case 1:
                        System.out.println("Результат:\nМетры:" + number + "\nМили:" + number * 0.00062 + "\nЯрды:" + number * 1.09 + "\nФуты:" + number * 3.2808);
                        break;
                    case 2:
                        System.out.println("Результат:\nМетры:" + number / 0.00062 + "\nМили:" + number + "\nЯрды:" + number * 1760 + "\nФуты:" + number * 5280);
                        break;
                    case 3:
                        System.out.println("Результат:\nМетры:" + number * 0.914 + "\nМили:" + number * 0.00062 + "\nЯрды:" + number + "\nФуты:" + number * 3);
                        break;
                    case 4:
                        System.out.println("Результат:\nМетры:" + number / 3.2808 + "\nМили:" + number * 0.0002 + "\nЯрды:" + number * 0.33 + "\nФуты:" + number);
                        break;
                    default:
                        break;
                }
            }
        }


    if (operation.equals("+")) {
            System.out.println(a + b);
        }

        */