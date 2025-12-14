package io.github.ht4w5.polycalc;

import io.github.ht4w5.polycalc.models.Polynomial;

import java.util.Scanner;
import java.util.TreeMap;

public class Polycalc {
    private final TreeMap<String, Polynomial> polynomials;

    public Polycalc() {
        polynomials = new TreeMap<>();
    }

    public void list() {
        System.out.printf("Count: %d\n", polynomials.size());
        polynomials.forEach((k, v) -> {
            System.out.printf("%s: %s\n", k, v.toString());
        });
    }

    public void fromInput() {
        var scanner = new Scanner(System.in);
        System.out.print("name?>");
        String name = scanner.nextLine();
        System.out.print("terms?>");
        String terms = scanner.nextLine();

        if (polynomials.containsKey(name)) {
            System.out.printf("%s already exists\n", name);
            return;
        }

        try {
            polynomials.put(name, new Polynomial(terms));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void print() {
        var scanner = new Scanner(System.in);
        System.out.print("name?>");
        String name = scanner.nextLine();

        Polynomial p = polynomials.get(name);
        if (p == null) {
            System.out.printf("No polynomial with name %s\n", name);
            return;
        }

        System.out.printf("%s: %s\n", name, p.toString());
    }


    public void eval() {
        var scanner = new Scanner(System.in);
        System.out.print("name?>");
        String name = scanner.nextLine();
        System.out.print("x?>");
        String xString = scanner.nextLine();

        Polynomial p = polynomials.get(name);
        if (p == null) {
            System.out.printf("No polynomial with name %s\n", name);
            return;
        }

        double x;
        try {
            x = Double.parseDouble(xString);
        } catch (NumberFormatException e) {
            System.out.printf("Invalid x: %s\n", xString);
            return;
        }

        System.out.printf("Value of %s at x=%f: %f\n", name, x, p.eval(x));
    }

    public void addition() {
        var scanner = new Scanner(System.in);
        System.out.print("first?>");
        String first = scanner.nextLine();
        System.out.print("second?>");
        String second = scanner.nextLine();
        System.out.print("name?>");
        String name = scanner.nextLine();

        if (polynomials.containsKey(name)) {
            System.out.printf("%s already exists\n", name);
            return;
        }

        Polynomial p1 = polynomials.get(first);
        if (p1 == null) {
            System.out.printf("No polynomial with name %s\n", name);
            return;
        }

        Polynomial p2 = polynomials.get(second);
        if (p2 == null) {
            System.out.printf("No polynomial with name %s\n", name);
            return;
        }

        polynomials.put(name, p1.add(p2));
    }

    public void subtraction() {
        var scanner = new Scanner(System.in);
        System.out.print("first?>");
        String first = scanner.nextLine();
        System.out.print("second?>");
        String second = scanner.nextLine();
        System.out.print("name?>");
        String name = scanner.nextLine();

        if (polynomials.containsKey(name)) {
            System.out.printf("%s already exists\n", name);
            return;
        }

        Polynomial p1 = polynomials.get(first);
        if (p1 == null) {
            System.out.printf("No polynomial with name %s\n", name);
            return;
        }

        Polynomial p2 = polynomials.get(second);
        if (p2 == null) {
            System.out.printf("No polynomial with name %s\n", name);
            return;
        }

        polynomials.put(name, p1.subtract(p2));
    }
}
