package day04;

// 异常    灰体字也是笔记
public class ExceptionTest {
    public static void main(String[] args) {
        // ArithmeticException
        // System.out.println(1/0);

        // StringIndexOutOfBoundsException
        // System.out.println("hello".charAt(5));

        // ArrayIndexOutOfBoundsException
        // System.out.println(new int[]{1,2,3}[3]);

        // NumberFormatException
        // System.out.println(Integer.parseInt("l23"));  //   不是123  是L23

        // NullPointerException NPE  空指针异常
        // String s = null;
        // System.out.println(s.length());

        //try 有异常，try里面的后面的不执行。catch 不捕获异常，catch也不执行。finally里面的执行。整体有异常没有处理，所有最后的也没有执行。
/*        String s = "hello";
        try {
            System.out.println(s.charAt(5));
            System.out.println("in try block...");
        } catch (ArithmeticException e) {
            e.printStackTrace();   // 捕获异常的语句
            System.out.println("NPE...");
        } finally {
            System.out.println("always print...");
        }
        System.out.println("done.");
    }
}
*/
//      try 有异常，try里面的后面不执行。 catch捕获，执行。finally里面的执行。最后的执行。
/*      String s = "hello";
          try {
                System.out.println(s.charAt(5));
                System.out.println("in try block...");
                } catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("NPE...");
                } finally {
                System.out.println("always print...");
                }
                System.out.println("done.");
                }
                }
*/
// exit(0);关闭程序
/*     String s = "hello";
        try {
                System.exit(0);     // 关闭程序    后面都不执行
                System.out.println("in try block...");
                } catch (ArithmeticException e) {
                e.printStackTrace();
                System.out.println("NPE...");
                } finally {
                System.out.println("always print...");
                }
                System.out.println("done.");
                }
                }
*/

//Exception是异常的父类，如果没有把catch (Exception e){System.out.println("Exception");}放在最后，
// 那么try中产生的异常不可能被catch语句捕获，catch语句永远不会执行到。Java编辑器不允许这样的情况，
// 会出现编译错误，因此如果要捕获的异常有继承关系，则子类在前，父类在后。
        try {
             String s = null;
             System.out.println(s.length());  // NPE
             System.out.println(1 / 0);
             System.out.println("hello".charAt(5));
             System.out.println(new int[]{1, 2, 3}[3]);
             System.out.println(Integer.parseInt("l23"));
             } catch (ArithmeticException e) {
             System.out.println("ArithmeticException...");
             } catch (StringIndexOutOfBoundsException e) {
             System.out.println("StringIndexOutOfBoundsException");
             } catch (ArrayIndexOutOfBoundsException e) {
             System.out.println("ArrayIndexOutOfBoundsException");
             } catch (NumberFormatException e) {
             System.out.println("NumberFormatException");
             } catch (Exception e) {
             System.out.println("Exception");
             } finally {
             System.out.println("finally...");
             }
             System.out.println("done.");
             }
             }
