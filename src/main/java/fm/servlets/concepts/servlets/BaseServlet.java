package fm.servlets.concepts.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import freemarker.cache.WebappTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public abstract class BaseServlet extends HttpServlet {
  protected Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

  @Override
  public void init(ServletConfig servletConfig) {
//    cfg.setClassForTemplateLoading(AppServlet.class, "/WEB-INF/views");
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    cfg.setWrapUncheckedExceptions(true);
    cfg.setFallbackOnNullLoopVariable(false);
    cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
    
    WebappTemplateLoader templateLoader = new WebappTemplateLoader(servletConfig.getServletContext(),"WEB-INF/views");
    templateLoader.setURLConnectionUsesCaches(false);
    templateLoader.setAttemptFileAccess(false);
    cfg.setTemplateLoader(templateLoader);
  } 
  
  protected void loadTemplate(final String templateName, Object model, HttpServletResponse response) {
    Template welcomeTemplate;
    try {
        welcomeTemplate = cfg.getTemplate(templateName + ".ftl");
        welcomeTemplate.process(model,response.getWriter());
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } 
  }
  

}
