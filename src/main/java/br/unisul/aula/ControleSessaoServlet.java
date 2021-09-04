package br.unisul.aula;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ControleSessaoServlet", value = "/ControleSessaoServlet")
public class ControleSessaoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("logado") != null) {
            if (session.getAttribute("logado").equals("estalodo")) {
                response.getWriter().println("Usuário está logado");
                return;
            }
        }
        response.getWriter().println("Usuário PRECISA ESTAR LOGADO");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
