package yudimf.id.prelo.models;

/**
 * Created by yudimf on 21/10/17.
 */

public class Item {

    public Item(String name, String url, String price) {
        this.name = name;
        this.url = url;
        this.price = price;
    }

    private String name;

    private String url;

    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
