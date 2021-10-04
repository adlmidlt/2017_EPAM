package servlets;

import data.DataCollection;
import dto.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/"})
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataCollection dataCollection = new DataCollection();
        List<Product> products = dataCollection.dataCollection();
        if (request.getSession().getAttribute("login") == null) {
            response.sendRedirect("/authorization");
        }else {
            getServletContext().setAttribute("products", products);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
