package it.dst.formazione.lezione7.staticinterface;

public interface MathUtilsInterface {

    interface MathUtils {
        static int add(int a, int b) {
            return a + b;
        }

        static int multiply(int a, int b) {
            return a * b;
        }
    }

}
