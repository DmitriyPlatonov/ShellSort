package package1;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] mas = new int[50];

        Random r = new Random();

        for (int i = 0; i < mas.length; i++) {
            mas[i] = r.nextInt(100);
        }

        System.out.println("Исходный массив:");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();

        int d = mas.length;

        while (d > 0) {
            d = d / 2;
            if (d > 0) {
                Thread[] thread = new Thread[d];
                for (int i = 0; i < d; i++) {
                    thread[i] = new Thread(new Sort(mas, d, i));
                    thread[i].start();
                }

                for (int i = 0; i < d; i++) {
                    thread[i].join();
                }
            }
        }

        System.out.println("Отсортированный массив:");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }

    }

}
