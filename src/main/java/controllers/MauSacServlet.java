package controllers;

import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
    "/mau-sac/create",  // GET
    "/mau-sac/store",   // POST
    "/mau-sac/edit",    // GET
    "/mau-sac/update",  // POST
    "/mau-sac/delete",  // GET
    "/mau-sac/index",   // GET
})
public class MauSacServlet extends HttpServlet {
    List<MauSac> ds = new ArrayList<>();

    public MauSacServlet()
    {
        this.ds.add(new MauSac(null, "1", "Vàng", 1));
        this.ds.add(new MauSac(null, "2", "Xanh lá", 1));
        this.ds.add(new MauSac(null, "3", "Đen", 0));
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.setAttribute("data", this.ds);
        request.getRequestDispatcher("/views/mau_sac/index.jsp")
            .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/mau_sac/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        MauSac ms = new MauSac(null, ma, ten, trangThai);
        this.ds.add(ms);
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        //
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        //
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        //
    }
}
