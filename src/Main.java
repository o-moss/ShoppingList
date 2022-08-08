import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> shoppingList = new ArrayList<>();
        System.out.println("Список возможных операций: " +
                "\n1. Добавить в список покупок. \n2. Показать список покупок. " +
                "\n3. Удалить из списка покупок.\n4. Поиск покупки ключевому слову.");
        while (true) {
            System.out.println("\nВведите номер операции.");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    shoppingList.add(scanner.nextLine());
                    System.out.println("Итого в списке покупок: " + shoppingList.size() + ".");
                    break;
                case 2:
                    printShoppingList(shoppingList);
                    break;
                case 3:
                    printShoppingList(shoppingList);
                    System.out.println("\nЧто хотите удалить? Введите номер или название.");
                    String s = scanner.nextLine();
                    try {
                        int j = Integer.parseInt(s);
                        String removedObject = shoppingList.get(j - 1);
                        shoppingList.remove(j - 1);
                        System.out.println("Покупка \"" + removedObject + "\" удалена.");
                        printShoppingList(shoppingList);
                    } catch (NumberFormatException e) {
                        shoppingList.remove(s);
                        System.out.println("Покупка \"" + s + "\" удалена.");
                        printShoppingList(shoppingList);
                    }
                    break;
                case 4:
                    System.out.println("Введите ключевое слово.");
                    String keyWord = scanner.nextLine();
                    String queryLower = keyWord.toLowerCase();
                    for (int i = 0; i < shoppingList.size(); i++) {
                        String a = shoppingList.get(i);
                        String itemLower = a.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println(i + ". " + a + ".");
                        }
                    }
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        }
    }

    private static void printShoppingList(ArrayList<String> list) {
        System.out.println("Список покупок:");
        int i = 0;
        for (String s : list) {
            i++;
            System.out.println(i + ". " + s + ".");
        }
    }
}
