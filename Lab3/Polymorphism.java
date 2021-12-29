class Parent {
    void Print() {
        System.out.println("this is the parent class");
    }
    void Print(String str) {
        System.out.println(String.join(" ",str));
    }
}

class child1 extends Parent {
    void Print() {
        System.out.println("this is child class number 1");
    }
}

class child2 extends Parent {
    void Print() {
        System.out.println("this is child class number 2");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        Parent a;

        a = new Parent();
        a.Print();
        a.Print("This is to showcase overlaoding");

        a = new child1();
        a.Print();

        a = new child2();
        a.Print();
    }

}