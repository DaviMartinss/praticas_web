package lab7spa.demo.controller;

public class Produto {

    private Integer id;
    private String name;
    private Float price;



    public Produto(Integer i, String name, float f) {
        this.id = i;
        this.name = name;
        this.price = f;
    }

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
