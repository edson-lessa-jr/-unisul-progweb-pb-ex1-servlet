package br.unisul.aula;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PessoaServlet", value = "/cadastro")
public class PessoaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        txtNome=Edson&nrIdade=11
        String nome = request.getParameter("txtNome");
        int idade = Integer.parseInt(request.getParameter("nrIdade"));

        HttpSession session = request.getSession();
        session.setAttribute("logado","estalodo");

        Pessoa pessoa = new Pessoa(nome, idade);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>"+pessoa.toString()+"</h1>\n" +
                "<br>\n" +
                "<a href=\"ControleSessaoServlet\">Enviar para controle de sessão</a>" +
                "\n" +
                "</body>\n" +
                "</html>");

    }
}
