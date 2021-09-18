package assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_1 {

	@Test
	public void abc() {

		String s = "Aishwarya Soni";
		System.out.println(s);
		Assert.assertEquals(s, "Aishu");
	}

	@Test
	public void xyz() {

		boolean b = true;

		Assert.assertEquals(b, true);
	}

	@Test
	public void pqr() {

		String s[] = { "Aishwarya", "Soni" };
		String ss[] = { "Aishwarya", "Soni" };
		Assert.assertEquals(s, ss);

	}

	@Test(priority = 1)
	public void m1() {

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(10);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(10);

		Assert.assertEquals(list1, list2);
		
	}

	@Test
	public void m2() {

		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(10);
		set1.add(20);
		set1.add(10);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(10);
		set2.add(20);
		set2.add(10);

		Assert.assertEquals(set1, set2);
	}
	

	@Test()
	public void m3() {

		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(10);
		set1.add(20);
		set1.add(null);
		set1.add(10);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(10);
		set2.add(20);
		set2.add(10);
		
		System.out.println(set1);
		System.out.println(set2);

		Assert.assertEquals(set1, set2);
	}
	@Test()
	public void m4() {

		Map<Integer,Integer> set1 = new HashMap<Integer,Integer>();
		set1.put(10,20);
		set1.put(20,30);
		set1.put(30,40);
		System.out.println(set1.get(10));
		set1.put(50,60);
		System.out.println(set1);
		

		Assert.assertTrue(false, "Assert failed");
		
		
		System.err.println("Push code to git repo master branch");
	}

}