package io.github.ht4w5.polycalc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var pc = new Polycalc();
        while (true) {
            System.out.print("polycalc>");
            var cmd = scanner.nextLine();
            switch (cmd) {
                case "h":
                    System.out.println("Polycalc: polynomial calculator");
                    System.out.println("---");
                    System.out.println("Commands:");
                    System.out.println("h - show help");
                    System.out.println("n - new polynomial");
                    System.out.println("l - list all");
                    System.out.println("p - print polynomial");
                    System.out.println("a - add two polynomials");
                    System.out.println("s - subtract two polynomials");
                    System.out.println("e - evaluate a polynomial");
                    System.out.println("x - exit");
                    break;
                case "n":
                    pc.fromInput();
                    break;
                case "l":
                    pc.list();
                    break;
                case "p":
                    pc.print();
                    break;
                case "a":
                    pc.addition();
                    break;
                case "s":
                    pc.subtraction();
                    break;
                case "e":
                    pc.eval();
                    break;
                case "x":
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.printf("Unknown command: %s\n", cmd);
            }
        }
    }
}
