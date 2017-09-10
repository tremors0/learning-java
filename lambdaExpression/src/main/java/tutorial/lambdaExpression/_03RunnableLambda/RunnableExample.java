package tutorial.lambdaExpression._03RunnableLambda;

public class RunnableExample {
    
    public static void main(String[] args) {
        //Thread musi mit jako parametr instanci Runnable
        Thread myThread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });

        Thread secondThread = new Thread(()->System.out.println("Printed using lambda"));

        myThread.run();
        secondThread.run();
    }
}