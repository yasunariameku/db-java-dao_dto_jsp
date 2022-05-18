package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
import util.ParamUtil;

/**
 * Servlet implementation class SearchAppServlet
 */
@WebServlet("/login")
public class SearchAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // product_idを取得
        String product_idStr = request.getParameter("id");
        
        Integer product_id = null;
        
        //product_idが空文字だった場合の判定
        if (ParamUtil.isNullOrEmpty(product_idStr)) {
        	
        	//msgに「product_idを入力してください。」を入れる
        	request.setAttribute("msg", "product_idを入力してください。");
        	
        	//top.jspにメッセージを返しながら戻る。
        	request.getRequestDispatcher("top.jsp").forward(request, response);
        	
        }else {
        	 product_id = ParamUtil.checkAndParseInt(product_idStr);
        }
        
        
        //ProductServiceクラスのコンストラクタを呼び出してfindByIdメソッドを呼び出す。
         Product p =  new ProductService().findById(product_id);
         
         System.out.println(p);
         
         if ( p == null) {
        	//msgに「対象のデータはありません。」を入れる
         	request.setAttribute("msg", "対象のデータはありません。");
         	
         	//top.jspにメッセージを返しながら戻る。
         	request.getRequestDispatcher("top.jsp").forward(request, response);
         }else {
        	 
        	//msgに「データを取得しました。」を入れる
          	 request.setAttribute("msg", "データを取得しました。");
        	 
        	 request.setAttribute("result", p);
             
             request.getRequestDispatcher("searchResult.jsp").forward(request, response);
            
        	 
         }
         
        
    
        
	}

}
