import java.util.Scanner;

public class Shop {
    public static Scanner scanner = new Scanner(System.in);
    public static String[] products = {"Хлеб", "Яблоки", "Молоко", "Йогурт"};
    public static int[] prices = {50, 80, 60, 10};
    public static int[] basket = new int[products.length];
    public static int[] summary = new int[products.length];
    public static int sum = 0;

    public static String textBasket;

    public static void shopping() {
        while (true) {
            System.out.println("Список возможных товаров для покупки:");
            System.out.println("ВНИМАНИЕ! В магазине действует акция 3 по цене 2. Введите промо-код 'Халява' для доступа к акционным товарам!");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб./шт.");
            }
            System.out.println("Выберите товар и количество или введите 'end' для возврата в главное меню.");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] custChoice = input.split(" ");
            if (custChoice.length != 2) {
                throw new RuntimeException("Пожалуйста, введите только 2 числа: номер продукта по списку и количество!");
            }
            try {
                int productNumber = Integer.parseInt(custChoice[0]) - 1;
                if ((productNumber + 1) > products.length || (productNumber + 1) < 0) {
                    throw new RuntimeException("Введен некорректный номер товара! Пожалуйста, введите номер из списка.");
                }
                int productCount = Integer.parseInt(custChoice[1]);
                if (productCount < 0) {
                    throw new RuntimeException("Введено некорректное количество товара! Пожалуйста, укажите количество еще раз.");
                }
                basket[productNumber] += productCount;
            } catch (NumberFormatException error) {
                System.out.println("Вы ввели название товара! Пожалуйста, введите его номер по списку.");
                continue;
            }
        }

    }

    public static String printBasket(int[] basket, String[] products, int[] prices) {
        StringBuilder s = new StringBuilder();
        //System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (basket[i] > 0) {
                s.append(products[i]);
                s.append(" ");
                s.append(basket[i]);
                s.append(" шт.");
                s.append(" ");
                s.append(prices[i]);
                s.append(" руб./шт.");
                s.append(" ");
                s.append((basket[i] * prices[i]));
                s.append(" руб. в сумме");
                s.append("\n");
            }
        }
        return textBasket = s.toString();
    }

    public static void summarizer(int[] basket, String[] products, int[] prices, int[] summary) {
        for (int i = 0; i < products.length; i++) {
            if (basket[i] > 0) {
                summary[i] = (basket[i] * prices[i]);
            }
        }
    }

    public static int totalCount(int[] summary) {
        for (int sum1 : summary) {
            sum += sum1;
        }
        return sum;
    }
}