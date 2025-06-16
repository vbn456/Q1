package depends_on_method_2;

import org.testng.annotations.Test;

public class DependsOnMethods_VS_Priority {
	@Test(priority = 3, dependsOnMethods = "methodC")
	public void methodA() {
	    System.out.println("method A after B (dependsOn)");
	}

	@Test(priority = 2)
	public void methodB() {
	    System.out.println("method B");
	}

	@Test(priority = 1)
	public void methodC() {
	    System.out.println("method C");
	}
}

// So, dependsOnMethods has higher precedence