interface A {
    void foo1();

    default void foo() {
        System.out.println("Hey!");
    }
}

interface B {
    void foo2();

    default void foo() {
        System.out.println("Hi!");
    }
}

public class MultiInterface implements A, B {
    @Override
    public void foo2() {
        System.out.println("Foo2!");
    }

    @Override
    public void foo1() {
        System.out.println("Foo1!");
    }

    @Override
    public void foo() {
        System.out.println("Foo!");
    }

    public static void main(String[] args) {
        MultiInterface C = new MultiInterface();
        C.foo();
        C.foo1();
        C.foo2();
    }
}
