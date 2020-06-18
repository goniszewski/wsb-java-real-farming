package com.farming;

public class Ground {

    private Integer id;
    private Integer hectars;
    private Integer price;

//getters
    public Integer getId() {
        return id;
    }
    public Integer getHectars() {
        return hectars;
    }
    public Integer getPrice() {
        return price;
    }
//setters

    public void setId(Integer id) {
        this.id = id;
    }
    public void setHectars(Integer hectars) {
        this.hectars = hectars;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Ground (Integer id, Integer hectars, Integer price) {
        this.id = id;
        this.hectars = hectars;
        this.price = price;
    }


}
