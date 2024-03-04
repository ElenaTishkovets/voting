package by.it_academy.jd2.controller.http;

import by.it_academy.jd2.controller.http.utils.ServletUtils;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.api.dto.AllStatDto;
import by.it_academy.jd2.service.factory.ServiceFactorySingleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/statTishVar5")
public class StatServlet extends HttpServlet {

    private IStatService statService = ServiceFactorySingleton.getStatService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        try {

            AllStatDto allStatDto = this.statService.get();

            ServletUtils.writeTo(allStatDto.getArtistStat().getScore(), writer);
            ServletUtils.writeBrakeLine(writer);
            ServletUtils.writeTo(allStatDto.getGenreStat().getScore(), writer);
            ServletUtils.writeBrakeLine(writer);
            for (String line : allStatDto.getAbouts()) {
                writer.write(line + "</br>\n");
            }
        } catch (IllegalArgumentException e) {
            writer.write("<p>" + e.getMessage() + "</p>");

        }
    }
}

