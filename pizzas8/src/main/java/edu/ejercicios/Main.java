package edu.ejercicios;
import edu.ejercicios.pizza.base.tampizza;
import edu.ejercicios.pizza.base.Pizza;
import edu.ejercicios.pizza.base.Topping;
import edu.ejercicios.pizza.especialidades.PizzaItaliana;
import edu.ejercicios.pizza.interfaces.PizzaBase;

import java.util.Scanner;


public class Main {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        Topping loroco = new Topping("loroco", 3.0);
        Topping piña = new Topping("Piña", 2.0);
        Topping salami = new Topping("Salami", 4.0);

        Topping chile = new Topping("Chile Abanero", 2.0);
        Topping salsa = new Topping("Salsa Italiana", 3.0);
        Topping jamon = new Topping("Jamón", 1.0);
Pizza pizza;
        System.out.println("Elija la especialidad que desee\nBASE O ITALIANA");
        String especialidadinput = scanner.nextLine();

        System.out.println("Seleccione el tamaño de la pizza que desee\nPEQUEÑA, MEDIANA (20% más) O GRANDE(35% más)");
        String tamñoInput = scanner.nextLine();
        tampizza tamaño = tampizza.valueOf(tamñoInput.toUpperCase());


        if (especialidadinput.equalsIgnoreCase("ITALIANA")){
            System.out.println("Seleccione la salsa que desee\n BBQ, Tomate");
            String salsainput = scanner.nextLine();

            pizza = new PizzaItaliana("Pizza", 10.0, salsainput, tamaño, loroco, piña, salami);
        }else {
           pizza = new Pizza("Pizza normal", 9.0,tamaño,loroco, piña, salami);
        }
        double precioTotal = pizza.getPrecioTotal();
        System.out.println("Nombre de la pizza: " + pizza.getName());
        System.out.println("Tamaño de la pizza: " + pizza.getTamaño());

        if (pizza instanceof PizzaItaliana) {
            System.out.println("Salsa de la pizza: " + ((PizzaItaliana)pizza).getSalsa());
        }

        System.out.println("Ingredientes de su pizza: ");
        for (Topping topping : pizza.getToppings()) {
            System.out.println("- " + topping.getNombre() + " Precio: " + topping.getPrice());
        }
        pizza.prepare();
        scanner.close();
        System.out.println("Precio base de la pizza: " + pizza.getPreciobase());
        System.out.println("Precio total de la pizza: " + pizza.getPrecioTotal());

    }

}