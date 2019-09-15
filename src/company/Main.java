package company;

import company.Class.IsoscelesTriangle;
import company.Class.IsoscelesTriangles;
import company.Class.Triangle;
import company.Class.Triangles;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        int quantityTriangles, quantityIsoscelesTriangles;
        Scanner str = new Scanner(System.in);
        System.out.print("Enter quantity of triangles: ");
        quantityTriangles = isPositive(str);
        if(quantityTriangles != 0) {
            Triangles triangles = new Triangles(quantityTriangles);
            System.out.println("Enter the sides of all the triangles:");
            construct(triangles, str, quantityTriangles);
            System.out.println(triangles.toString());
            System.out.println("Average area of all the triangles: " + String.format("%6.2f", triangles.getAverageArea()) + " cm^2");
        } else {
            System.out.println("Zero triangles");
        }
        System.out.print("Enter quantity of isosceles triangles: ");
        quantityIsoscelesTriangles = isPositive(str);
        if(quantityIsoscelesTriangles != 0) {
            IsoscelesTriangles isoscelesTriangles = new IsoscelesTriangles(quantityIsoscelesTriangles);
            System.out.println("Enter the sides of all the isosceles triangles:");
            construct(isoscelesTriangles, str, quantityIsoscelesTriangles);
            System.out.println(isoscelesTriangles.toString());
            System.out.println("Minimal area of all the isosceles triangles: " + String.format("%6.2f", isoscelesTriangles.getMinArea()) + " cm^2");
        } else {
            System.out.println("Zero isosceles triangles");
        }
    }

    private static void construct(final Triangles triangles, final Scanner str, final int quantityTriangles) {
        double sideA, sideB, sideC;
        Triangle triangle;
        for (int i = 0; i < quantityTriangles; i++) {
            System.out.println((i + 1) + ") Triangle:");
            System.out.print("a = ");
            sideA = isDouble(str);
            System.out.print("b = ");
            sideB = isDouble(str);
            System.out.print("c = ");
            sideC = isDouble(str);
            triangle = new Triangle(sideA, sideB, sideC);
            triangles.setTriangle(triangle, i);
        }
    }

    private static void construct(final IsoscelesTriangles isoscelesTriangles, final Scanner str, final int quantityIsoscelesTriangles) {
        double sideA, sideB, sideC;
        IsoscelesTriangle isoscelesTriangle;
        for (int i = 0; i < quantityIsoscelesTriangles; i++) {
            System.out.println((i + 1) + ") Isosceles triangle:");
            System.out.print("a = ");
            sideA = isDouble(str);
            System.out.print("b = ");
            sideB = isDouble(str);
            System.out.print("c = ");
            sideC = isDouble(str);
            isoscelesTriangle = new IsoscelesTriangle(sideA, sideB, sideC);
            isoscelesTriangles.setIsoscelesTriangle(isoscelesTriangle, i);
        }
    }

    private static double isDouble(final Scanner str) {
        while (!str.hasNextDouble()) {
            System.out.println("That not a number!");
            str.next();
        }
        return str.nextDouble();
    }

    private static int isPositive(final Scanner str) {
        int positive = isInt(str);
        while (positive < 0) {
            System.out.println("That not a positive number!");
            positive = isInt(str);
        }
        return positive;
    }

    private static int isInt(final Scanner str) {
        while (!str.hasNextInt()) {
            System.out.println("That not a number!");
            str.next();
        }
        return str.nextInt();
    }
}