package org.example.controller;

import com.google.gson.Gson;
import org.example.items.Item;
import org.example.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/first")
public class Controller extends HttpServlet {
    private Repository repository;
    private Gson gson;
    public Controller(){
        repository = Repository.getInstance();
        gson = new Gson();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Expose-Headers", "*");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        PrintWriter printWriter = response.getWriter();

        List<Item> items = repository.getAll();
        String itemsAsJson = gson.toJson(items);

        printWriter.println(itemsAsJson);
    }
}