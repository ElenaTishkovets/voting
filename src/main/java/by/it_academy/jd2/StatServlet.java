package by.it_academy.jd2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet("/statTishkovets")
public class StatServlet extends HttpServlet {
    private final Data data = new Data();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //synchronized (Data.lock) {
        synchronized (data) {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            // Data data = new Data();
            PrintWriter writer = resp.getWriter();

            writeTo(data.getArtistsContainer(), writer);
            writeBrakeLine(writer);
            writeTo(data.getGenreContainer(), writer);
            writeBrakeLine(writer);
            for (String line : data.getAboutContainer()) {
                writer.write(line + "</br>\n");
            }
        }
    }

    private synchronized void writeBrakeLine(Writer writer) throws IOException {
        writer.write("****************</br>\n");
    }

    private synchronized void writeTo(Map<String, Integer> map, Writer writer) throws IOException {
        synchronized (data) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
