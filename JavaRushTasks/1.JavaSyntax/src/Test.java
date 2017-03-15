import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class Test {
    public static void main(String[] args) throws IOException {
        A a= new B();
        a.m();
        ((B)a).m();
     }


     public static class A{
         private void m(){
             System.out.println("A");
         }

     }

     public static class B extends A{
         public void m(){
             System.out.println("B");
         }
     }

}

