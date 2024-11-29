import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberOrdering {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Упорядочивание чисел");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new GridLayout(4, 2));

        JLabel label1 = new JLabel("A:");
        JTextField input1 = new JTextField();
        JLabel label2 = new JLabel("B:");
        JTextField input2 = new JTextField();
        JLabel label3 = new JLabel("C:");
        JTextField input3 = new JTextField();
        JLabel resultLabel = new JLabel("Результат:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        input1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calculateOrder(input1.getText(), input2.getText(), input3.getText(), resultField);
            }
        });
        input2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calculateOrder(input1.getText(), input2.getText(), input3.getText(), resultField);
            }
        });
        input3.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calculateOrder(input1.getText(), input2.getText(), input3.getText(), resultField);
            }
        });

        frame.add(label1);
        frame.add(input1);
        frame.add(label2);
        frame.add(input2);
        frame.add(label3);
        frame.add(input3);
        frame.add(resultLabel);
        frame.add(resultField);

        frame.setVisible(true);
    }

    private static void calculateOrder(String a, String b, String c, JTextField resultField) {
        try {
            double A = Double.parseDouble(a);
            double B = Double.parseDouble(b);
            double C = Double.parseDouble(c);

            double[] numbers = {A, B, C}; // Сохраняем числа в массив
            sortDescending(numbers); // Сортируем массив по убыванию

            StringBuilder result = new StringBuilder();
            for (double number : numbers) {
                result.append(number).append(" "); // Формирование строки с отсортированными числами
            }

            resultField.setText(result.toString()); // Вывод результата в текстовое поле
        } catch (NumberFormatException e) {
            // Обработка исключения если пользователь ввел некорректное число
            resultField.setText("Ошибка");
        }
    }

    private static void sortDescending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}