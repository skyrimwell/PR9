package Part1;

import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) throws INNException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Здравствуйте! Для оформления вашего заказа, пожалуйста введите ваше ФИО: ");
        String name = sc.nextLine();

        System.out.println("А также ваш ИНН: ");
        String inn = sc.nextLine();

        Client cl = new Client(name, inn);

        System.out.println("Проверка, ваше ФИО: " + cl.getName());
        System.out.println("Ваш ИНН: " + cl.getInn());
    }
}
