package biz.bna.project.servlet;

import biz.bna.project.repository.AppendixRepository;
import biz.bna.project.utils.DatabaseUtils;
import biz.bna.project.utils.WordUtils;
import biz.bna.project.view.AppendixView;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class BrowserServlet extends HttpServlet {

    private final String sqlForSearchByWord = "" + "SELECT a.*, " + "       r.repeat_count as relevance " + "FROM   appendix a " + "       INNER JOIN repeat r ON r.appendix_id = a.appendix_id " + "       INNER JOIN word w ON w.word_id = r.word_id " + "WHERE  w.word_text = ? " + "ORDER BY r.repeat_count DESC";
    private DatabaseUtils databaseUtils = new DatabaseUtils();
    private AppendixRepository appendixRepository = new AppendixRepository();

    @Override
    public void init(ServletConfig config) {
        try {
            super.init(config);
        }catch (ServletException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setCharacterEncoding("UTF-8");
            String search = WordUtils.stem(request.getParameter("search"));
            List<AppendixView> result = new ArrayList<>();
            if(search != null && !search.isEmpty()){
                ResultSet resultSet = databaseUtils.select(sqlForSearchByWord, search);
                while(resultSet.next()){
                    AppendixView Appendix = new AppendixView();
                    Appendix.setAppendixId(resultSet.getInt("appendix_id"));
                    Appendix.setAppendixName(resultSet.getString("appendix_name"));
                    Appendix.setAppendixPath(resultSet.getString("appendix_path"));
                    Appendix.setRelevance(resultSet.getInt("relevance"));
                    result.add(Appendix);
                }
            }else{
                result = new ArrayList<>();
            }
            request.setAttribute("result", result);
            request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
