package patient.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseHelper;
import patient.modal.Patient;

/**
 * Servlet implementation class OpenBookAppointment
 */
@WebServlet("/openBookAppointment")
public class OpenBookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenBookAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		RequestDispatcher rs;
		try{
			int patientId = (int)session.getAttribute("UserID");
			if(patientId>0)
			{
				Patient patient = new DatabaseHelper().getPatient(patientId);
				if(patient!=null)
				{
					rs = request.getRequestDispatcher("bookAppointment.jsp");
					request.setAttribute("patient", patient);
					rs.forward(request, response);
				}else
				{
					//redirect to login
					redirectToLogin(request,response);
				}
			}else
			{
				//redirect to login
				redirectToLogin(request,response);
			}
		}catch(Exception e){
			e.printStackTrace();
			//redirect to login
			redirectToLogin(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		request.setAttribute("error", "Please login again");
		rs.forward(request, response);
	}

}
