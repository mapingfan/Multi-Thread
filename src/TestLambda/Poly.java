package TestLambda;

public class Poly {
    public static void main(String[] args) {
        A a = new B();
        a.poly();

    }
}

class A {
    int a = 9;

    public void poly() {
        System.out.println(a);
    }
}

class B extends A {
        int a = 10;
        @Override
        public void poly() {
        System.out.println(a);
    }
}