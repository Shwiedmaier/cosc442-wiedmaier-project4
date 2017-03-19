package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	public void testAddInventory1(){
		cm.addInventory(10, 10, 10, 10);
		assertEquals(i.getMilk(), 25);
		assertEquals(i.getChocolate(), 25);
		assertEquals(i.getSugar(), 25);
		assertEquals(i.getCoffee(), 25);
	}
	
	public void testCheckInventory(){
		assertEquals(i,cm.checkInventory());
		
	}
	
	public void testPurchaseBeverage1(){
		cm.addRecipe(r1);

		assertEquals(cm.makeCoffee(r1, 50), 0);
	}
	
	public void testGetRecipeForName(){
		cm.addRecipe(r1);
		assertEquals(cm.getRecipeForName("Coffee"), r1);
	}
	
	public void testInventory(){
		i.setChocolate(-1);
		i.setMilk(-1);
		i.setCoffee(-1);
		i.setSugar(-1);
		assertEquals(i.getMilk(), 0);
		assertEquals(i.getChocolate(), 0);
		assertEquals(i.getSugar(), 0);
		assertEquals(i.getCoffee(), 0);
	}
	public void testInventory2(){
		cm.addRecipe(r1);
		r1.setAmtChocolate(1);
		i.setChocolate(-1);
		i.setMilk(-1);
		i.setCoffee(-1);
		i.setSugar(-1);
		
		assertEquals(cm.makeCoffee(r1, 50), 50);
	}
	public void testInventory3(){
		assertEquals(i.toString(), "Coffee: 15" + System.lineSeparator() +
				"Milk: 15" + System.lineSeparator() +
				"Sugar: 15"+ System.lineSeparator() +
				"Chocolate: 15" + System.lineSeparator());
	}
	
	public void testRecipeTest(){
		cm.addRecipe(r1);
		assertEquals("Coffee", r1.toString());
	}
	
	public void testRecipeTest2(){
		cm.addRecipe(r1);
		r1.setAmtChocolate(-1);
		r1.setAmtMilk(-1);
		r1.setAmtSugar(-1);
		r1.setAmtCoffee(-1);
		assertEquals(r1.getAmtMilk(), 0);
		assertEquals(r1.getAmtChocolate(), 0);
		assertEquals(r1.getAmtSugar(), 0);
		assertEquals(r1.getAmtCoffee(), 0);
	}
}