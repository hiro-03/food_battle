package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CountUpServlet
 */
@WebServlet("/CountUpServlet")
public class CountUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CountUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		// レスポンスオブジェクトのコンテンツタイプおよびエンコーディング方式の指定
		response.setContentType("text/html; charset=UTF-8");

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// セッションスコープからの属性値の取得
		Integer cnt = (Integer) session.getAttribute("cnt");

		// 初回アクセスの場合に初期値を設定
		if (cnt == null) {
			cnt = 0;
		}

		// 画面へのレスポンス情報の作成
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><title>クリック回数サーブレット</title></head><body>");
		pw.println("<h1>クリックした回数</h1>");
		pw.println("<h1>" + cnt + "回</h1>");
		pw.println("<form action=\"CountUpServlet\" method=\"POST\">");
		pw.println("<input type=\"submit\" value=\"クリック\">");
		pw.println("</form>");
		pw.println("</body></html>");

		cnt++;

		// セッションスコープへの属性の設定
		session.setAttribute("cnt", cnt);
	}

}
