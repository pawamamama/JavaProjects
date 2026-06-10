package com.pawamamama.wrapper.arrays_.Exercise_;

/**
 * Book
 * <pre></pre>
 *
 * @author pawamamama
 * @since 2026/6/10
 */
public class Book  {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}