class MyException extends Exception
{
    public MyException(String s)
    {
        super(s);
    }
}
  
public class MyExceptionTest
{
    static void foo(int x) throws MyException {
        if (x < 18) {
            throw new MyException("You are underage! Age: " + x);
        }
        else {
            System.out.println("Thank you for voting!");
        }
    }
    public static void main(String args[])
    {
        try {
            foo(21);
            foo(18);
            foo(15);
        }
        catch (MyException ex)
        {
            System.out.println("Caught an Exception: ");
            System.out.println(ex.getMessage());
        }
    }
}