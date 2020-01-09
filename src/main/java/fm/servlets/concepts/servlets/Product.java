package fm.servlets.concepts.servlets;

public class Product {

    private String url;
    private String name;
    private int price;
   
    // This will be used by template engine
    Product() { }
   
    // This can be used by developer
    Product(String url, String name, int price) {
      this.url = url;
      this.name = name;
      this.price = price;
    }
    
    public String getUrl() {
      return this.url;
    }
    
    void setUrl(String newUrl) {
      this.url = newUrl;
    }
    
    void setName(String newName) {
      this.name = newName;
    }
    
    public String getName() {
      return this.name;
    }

    public int getPrice() {
      return price;
    }

    public void setPrice(int price) {
      this.price = price;
    }
    
  }
