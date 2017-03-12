import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class Glommer<T>
{
    String glom(Collection<?> objs)
    {
        String result = "";
        for (Object o : objs)
        {
            result += 0;
        }
        return result;
    }


    int glom(List<Integer> ints){
        int result = 0;
        for(int i: ints){
            result +=i;
        }
        return result;
    }


    public static void main(String[] args)
    {
        List<String> strings = Arrays.asList("1", "2", "3");
        System.out.println(new Glommer().glom(strings));
    }

}
