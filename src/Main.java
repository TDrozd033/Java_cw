public class Main {
    public static void main(String[] args)
    {

        Stack s = new Stack();
        s.push( 'A');
        s.push('B');
        s.push('C');
        try{
            System.out.println( s.pop() + " " + s.pop() );
            System.out.println( s.pop());
            System.out.println( s.pop()); // wygenreuje wyjątek


        }
        catch(StackException e)
        {
            System.out.println("Exception: " + e.getReason());

        }


    }
}