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
import Model.client;

public class ClientServlet extends HttpServlet {
    
    private List<client> clientDatabase = new ArrayList<>();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "create":
                createClient(request, response);
                break;
            case "update":
                updateClient(request, response);
                break;
            case "delete":
                deleteClient(request, response);
                break;
            default:
                response.sendRedirect("ClientHomepage.jsp"); // Redirect to admin homepage
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("read".equals(action)) {
            readClient(request, response);
        } else {
            response.sendRedirect("adminHomepage.jsp"); // Redirect to admin homepage
        }
    }
    
    private void createClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        // Perform validation if necessary
        
        client client = new client(clientDatabase.size() + 1, username, password, role);
        clientDatabase.add(client);
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Admin Created Successfully</h3>");
        out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
        out.println("</body></html>");
    }
    
    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        // Find the admin to update based on id (in real scenario, you'd fetch from database)
        for (client client : clientDatabase) {
            if (client.getId() == id) {
                client.setUsername(username);
                client.setPassword(password);
                client.setRole(role);
                break;
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Admin Updated Successfully</h3>");
        out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
        out.println("</body></html>");
    }
    
    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
    
        for (client client : clientDatabase) {
            if (client.getId() == id) {
                clientDatabase.remove(client);
                break;
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Admin Deleted Successfully</h3>");
        out.println("<a href='adminHomepage.jsp'>Back to Admin Homepage</a>");
        out.println("</body></html>");
    }
    
    private void readClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Find the admin to read based on id (in real scenario, you'd fetch from database)
        client clientToRead = null;
        for (client admin : clientDatabase) {
            if (admin.getId() == id) {
                clientToRead = admin;
                break;
            }
        }
        
        if (clientToRead != null) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Client Information</h3>");
            out.println("<p>ID: " + clientToRead.getId() + "</p>");
            out.println("<p>Username: " + clientToRead.getUsername() + "</p>");
            out.println("<p>Password: " + clientToRead.getPassword() + "</p>");
            out.println("<p>Role: " + clientToRead.getRole() + "</p>");
            out.println("<a href='clientHomepage.jsp'>Back to Admin Homepage</a>");
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


