package D5.Immutable;

import java.util.Collections;

public class ExtendClass extends TestFinalKeyword {
    @Override
    public void a() {
        System.out.println("sub a");
    }

    public static void b() {
        System.out.println("sub b");
    }


    public static void main(String[] args) {
        TestFinalKeyword extendClass = new ExtendClass();
        extendClass.a();
        extendClass.c();
        extendClass.b();
        extendClass.d();

    }

}
