package edu.ejercicios.pizza.especialidades;
import edu.ejercicios.pizza.base.tampizza;
import edu.ejercicios.pizza.base.Pizza;
import edu.ejercicios.pizza.base.Topping;

public class PizzaItaliana extends Pizza {
    private String salsa;

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    public PizzaItaliana(String name, double price, String Salsa, tampizza tamaño, Topping... toppings){
        super(name,price,tamaño, toppings);
        this.salsa = salsa;
    }
}
