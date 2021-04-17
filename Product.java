import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "Product", urlPatterns = "/product")
public class Product extends HttpServlet {
    protected int id;
    protected String[] title;
    protected String[] cost;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<h1>Product</h1>");
        title = new String[] {"Ромашка","Роза","Лилия","Гвоздика","Нарцис",
                "Ромашка","Альстромерия","Пион","Василек","Кактус"};
        cost = new String[] {"0,2","2","1","0,5","1","0,1","1,5","1","0,4","0,2"};
        for (id = 0; id < 10; id++) {
            resp.getWriter().println("<p> id:" + id + "</p>");
            resp.getWriter().println("<p> title:" + title[id] + "</p>");
            resp.getWriter().println("<p> cost:" + cost[id] + "$</p>");
        }
    }
}