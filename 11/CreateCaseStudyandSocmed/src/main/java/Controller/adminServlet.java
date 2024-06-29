package Controller;
/**
 * @author Nurafizah
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.admin;

public class adminServlet extends HttpServlet {
    
    private List<admin> adminDatabase = new ArrayList<>();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "create":
                createAdmin(request, response);
                break;
            case "update":
                updateAdmin(request, response);
                break;
            case "delete":
                deleteAdmin(request, response);
                break;
            default:
                response.sendRedirect("adminHomepage.jsp"); // Redirect to admin homepage
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("read".equals(action)) {
            readAdmin(request, response);
        } else {
            response.sendRedirect("adminHomepage.jsp"); // Redirect to admin homepage
        }
    }
    
    private void createAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        // Perform validation if necessary
        
        admin admin = new admin(adminDatabase.size() + 1, username, password, role);
        adminDatabase.add(admin);
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Admin Created Successfully</h3>");
        out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
        out.println("</body></html>");
    }
    
    private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        // Find the admin to update based on id (in real scenario, you'd fetch from database)
        for (admin admin : adminDatabase) {
            if (admin.getId() == id) {
                admin.setUsername(username);
                admin.setPassword(password);
                admin.setRole(role);
                break;
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Admin Updated Successfully</h3>");
        out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
        out.println("</body></html>");
    }
    
    private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Find the admin to delete based on id (in real scenario, you'd delete from database)
        for (admin admin : adminDatabase) {
            if (admin.getId() == id) {
                adminDatabase.remove(admin);
                break;
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Admin Deleted Successfully</h3>");
        out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
        out.println("</body></html>");
    }
    
    private void readAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Find the admin to read based on id (in real scenario, you'd fetch from database)
        admin adminToRead = null;
        for (admin admin : adminDatabase) {
            if (admin.getId() == id) {
                adminToRead = admin;
                break;
            }
        }
        
        if (adminToRead != null) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Admin Information</h3>");
            out.println("<p>ID: " + adminToRead.getId() + "</p>");
            out.println("<p>Username: " + adminToRead.getUsername() + "</p>");
            out.println("<p>Password: " + adminToRead.getPassword() + "</p>");
            out.println("<p>Role: " + adminToRead.getRole() + "</p>");
            out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
            out.println("</body></html>");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Admin Not Found</h3>");
            out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
            out.println("</body></html>");
        }
    }
}

