package ood.coffeemaker;

class SimpleCoffee implements Coffee {

	@Override
	public double getCost() {
		return 2;
	}

	@Override
	public String getIngredients() {
		return "Plain Coffee";
	}

}
