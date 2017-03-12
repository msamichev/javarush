/**
 *
 */
public class ThreadTest extends Thread
{
    public static void main(String[] args)
    {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();

        System.out.println("finish");
    }

    @Override
    public void run()
    {
        while(true){
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("test");
        }
    }
}
