package fm.servlets.concepts.servlets;

import java.util.HashMap;
import java.util.Map;

public class Page {
  private String pageTitle;
  private Map<String, Object> headerValues;
  private Map<String, Object> footerValues;
  private Map<String,Object> pageValues;

  public Page(final String pageTitle, Map<String, Object> header, Map<String, Object> footer, Map<String,Object> values) {
     this.pageTitle = pageTitle;
     this.headerValues = header;
     this.footerValues = footer;
     this.pageValues = values;
  }
  
  public Page(final String pageTitle) {
    this(pageTitle,new HashMap<>(),new HashMap<>(), new HashMap<>());
  }
  
  public Page() {
    this("", new HashMap<>(), new HashMap<>(), new HashMap<>());
  }
  
  public Page withPageTitle(final String newTitle) {
    this.pageTitle = newTitle;
    return this;
  }
  
  public Page withHeader(final Map<String,Object> newHeader) {
    this.headerValues = newHeader;
    return this;
  }

  public Page withFooter(final Map<String,Object> newFooter) {
    this.footerValues = newFooter;
    return this;
  }
  
  public Page addHeaderValue(final String key, final Object value) {
    this.headerValues.put(key, value);
    return this;
  }

  public Page appendFooterValue(final String key, final Object value) {
    this.footerValues.put(key, value);
    return this;
  }
  
  public Page addPageValue(String key, final Object value) {
    this.pageValues.put(key, value);
    return this;
  }


  public String getPageTitle() {
    return this.pageTitle;
  }

  public Map<String, Object> getHeaderValues() {
    return headerValues;
  }

  public Map<String, Object> getFooterValues() {
    return footerValues;
  }
  
  public Map<String, Object> getPageValues() {
    return this.pageValues;
  }
  
  

}
