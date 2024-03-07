package TestPackage;

import org.testng.annotations.Test;

public class TestNGGroupingDemo extends BeforeAndAfterBase {
    @Test(groups = {"Group1"})
    public void testMethod1() {
        System.out.println("This testMethod1");
    }
    @Test(groups = {"Group1"})
    public void testMethod2() {
        System.out.println("This testMethod2");
    }
    @Test(groups = {"Group2"})
    public void testMethod3() {
        System.out.println("This testMethod3");
    }
    @Test(groups = {"Group2"})
    public void testMethod4() {
        System.out.println("This testMethod4");
    }
}