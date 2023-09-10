package edu.ejercicios.pizza.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import edu.ejercicios.pizza.base.tampizza;
public class Pizza {
    private String name;
    private double preciobase;
    private tampizza tamaño;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name, double preciobase, tampizza tamaño, Topping... toppings) {
        this.name = name;
        this.preciobase = preciobase;
        this.tamaño = tamaño;
        for (Topping topping : toppings) {
            this.toppings.add(topping);
        }
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    public List<Topping> getToppings() {

        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public String getName() {
        return name;
    }
    public tampizza getTamaño(){
        return tamaño;
    }
    public double getPreciobase() {
        return preciobase;
    }
    public double getPrecioTotal(){
        double precio = 1.0;
        switch (tamaño){
            case PEQUEÑA:
                precio =  1.0;
                break;

            case MEDIANA:
                precio = 1.2;
                break;

            case GRANDE:
                precio = 1.35;
                break;
        }

        double prectopp = 0.0; //Esto es para el precio de los toppings
        for (Topping topping : toppings){
            prectopp += topping.getPrice();
        }
        double preciofinal = (preciobase + prectopp) * precio;
        return preciofinal;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPreciobase(double preciobase) {
        this.preciobase = preciobase;
    }

    public void setTamaño(tampizza tamaño) {
        this.tamaño = tamaño;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", price=" + preciobase + ", toppings=" + toppings + '}';
    }

    public void prepare() {
        System.out.println("Preparing..... " + name);
        System.out.println("Adding toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The Pizza is ready!");
    }
}