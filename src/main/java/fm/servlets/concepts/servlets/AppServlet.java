package fm.servlets.concepts.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/app" })
public class AppServlet extends BaseServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Inside :: doGet");
    resp.addHeader("contextType", "text/html; charset=UTF-8");
    loadTemplate("productlist.html", createModel(), resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Inside :: doGet");
  }

  private Page createModel() {
    // Create the root hash. We use a Map here, but it could be a JavaBean too.
    Page page = new Page("Product List").addHeaderValue("title", "Welcome ...")
        .addHeaderValue("links", createLinks()).addPageValue("products", createProducts());
    // and put it into the root
    return page;

  }

  private Map<String, String> createLinks() {
    Map<String, String> links = new LinkedHashMap<>();
    links.put("Link 1", "http://domain.com/link1");
    links.put("Link 2", "http://domain.com/link2");
    links.put("Link 3", "http://domain.com/link3");
    return links;

  }

  private List<Product> createProducts() {
    List<Product> products = new ArrayList<>();

    Product p1 = new Product();
    p1.setUrl("products/greenmouse.html");
    p1.setName("Green Mouse");
    p1.setPrice(100);

    Product p2 = new Product();
    p2.setUrl("products/whitemouse.html");
    p2.setName("White Mouse");
    p2.setPrice(200);

    Product p3 = new Product();
    p3.setUrl("products/whitekeyboard.html");
    p3.setName("White Keyboard");

    products.add(p1);
    products.add(p2);
    products.add(p3);

    return products;
  }

}
