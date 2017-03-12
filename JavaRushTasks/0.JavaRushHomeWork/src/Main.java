/**
 *
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
//        Integer a = new Integer(1);
//        Integer b = new Integer(1);
//
//        System.out.println(a>=b?true:false);
//        System.out.println(a<=b?true:false);
//        System.out.println(a==b?true:false);
//
//
//        System.out.println(Math.pow(3,2));
//
//        System.out.println(StringHelper.multiply("Amigo"));
//        System.out.println(StringHelper.multiply("Amigo", 6));
//
//        List<Integer> list = new ArrayList<Integer>();
//        Collection col = list;
//
//        list.add(1);
//        list.add(1);
//        list.add(1);
//
//        list.remove(0);
//        col.remove(0);
//
//        System.out.println("Размер list: " + list.size());
//        System.out.println("Размер col: " + col.size());
//
//
//        System.out.println((byte)301);
//        System.out.println(String.format("%-8s", "foo"));\

//        String str = "501234567";
//        str = String.format("%10s", str).replace(" ", "0");
//        System.out.println(str);
//        StringBuilder sb = new StringBuilder();
//        sb.append("(").append(str.substring(0, 3)).append(")").append(str.substring(3, 6)).append("-").append(str.substring(6, 8)).append("-").append(str.substring(8));
//        System.out.println(sb.toString());
//
//
//        String s = "+38(050)123-45-67";
//        String s1 = "Ivanov, Ivan";
//
//        System.out.println(s.replace("(", "").replace(")", "").replace("-", ""));
//        System.out.println(s1.split(",\\s")[1]);

//
//        String s = "\t\t";
//        System.out.println(s.split("\\t").length);
//        String[] spl = s.split("\\t");
//
//        for (String s1 : spl)
//        {
//            System.out.println(s1);
//        }


//        Thread thread = new Thread()
//        {
//            @Override
//            public void run()
//            {
//                while (true)
//                {
//                    System.out.println("Thread run!!!");
//                    try
//                    {
//                        sleep(1000);
//                    }
//                    catch (InterruptedException e)
//                    {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        thread.start();
//
//        Thread.sleep(5000);
//        try
//        {
//            thread.setPriority(0);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        Thread.currentThread().join();
//


//        System.out.println(String.format("http://hh.ru/search/vacancy?text=java+%s&page=%d", "Kiev", 3));

//        int a = 1;
//        int b = -a++;
//        System.out.println(b);
//        System.out.println(a);


        // method2(null);
        //if(1==1) throw null;


//        float f = (-1f / 0) * 0;
//        System.out.println(f);

        byte b = +10;
        byte c = -64;
        int i = 123;
        long l = 123;

        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println((b << 1));
        System.out.println((i << 32));
        System.out.println((l << 64));


    }


    public Integer[] get(){
        return new Integer[1];
    }


    public static void method1()
    {
        System.out.println("method1");
    }

    public static void method2(Main main)
    {
        main.method1();
    }

}
