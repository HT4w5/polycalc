package io.github.ht4w5.polycalc.models;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Double> terms;

    public Polynomial(String str) {
        var args = str.split(" ");
        var n = Integer.parseInt(args[0]);
        if (args.length != n * 2 + 1) {
            throw new IllegalArgumentException("invalid number of arguments");
        }

        terms = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            var coe = Double.parseDouble(args[2 * i - 1]);
            var exp = Integer.parseInt(args[2 * i]);

            terms.merge(exp, coe, Double::sum);
        }

        // Prune terms with zero coefficients
        terms.entrySet().removeIf((entry) -> entry.getValue() == 0.);
    }

    private Polynomial() {
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append(terms.size());
        builder.append(", ");
        terms.descendingMap().forEach((k, v) -> {
            builder.append(v);
            builder.append(", ");
            builder.append(k);
            builder.append(", ");
        });
        return builder.toString();
    }

    public double eval(double x) {
        double result = 0;
        for (var term : terms.entrySet()) {
            result += Math.pow(x, term.getKey()) * term.getValue();
        }
        return result;
    }

    public Polynomial add(Polynomial other) {
        var p = new Polynomial();
        p.terms = new TreeMap<>(terms);

        other.terms.forEach((k, v) -> p.terms.merge(k, v, Double::sum));

        // Prune terms with zero coefficients
        p.terms.entrySet().removeIf((entry) -> entry.getValue() == 0.);
        return p;
    }

    public Polynomial subtract(Polynomial other) {
        var p = new Polynomial();
        p.terms = new TreeMap<>(terms);

        other.terms.forEach((k, v) -> p.terms.merge(k, -v, Double::sum));

        // Prune terms with zero coefficients
        p.terms.entrySet().removeIf((entry) -> entry.getValue() == 0.);
        return p;
    }
}
