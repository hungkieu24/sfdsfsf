/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author hungk
 */

class Record {
    String id;
    String name;
    double score;

    public Record(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return id + " " + name + " " + score;
    }
}
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 or 2:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.println("Enter the number of lines:");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        ArrayList<Record> records = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String id = parts[0];
            String name = parts[1];
            double score = Double.parseDouble(parts[2]);
            records.add(new Record(id, name, score));
        }

        Collections.sort(records, new Comparator<Record>() {
            @Override
            public int compare(Record r1, Record r2) {
                if (r2.score != r1.score) {
                    return Double.compare(r2.score, r1.score);
                } else {
                    return r1.id.compareTo(r2.id);
                }
            }
        });

        for (Record record : records) {
            System.out.println(record);
        }

        scanner.close();
    }
}
