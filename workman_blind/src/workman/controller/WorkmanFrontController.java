package workman.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import workman.model.WorkmanService;
import workman.model.dto.ParttimeEval;
import workman.model.dto.ParttimeList;

@Slf4j
@WebServlet("/workman")
public class WorkmanFrontController extends HttpServlet {
	
	static WorkmanService service = WorkmanService.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {   

		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		if (command != null) {
			
			if (command.equals("CompanyAll")) {
				companyAll(request, response);

			} else if (command.equals("Company")) {
				company(request, response);

			} else if (command.equals("CompanyInsert")) {
				companyInsert(request, response);

			} else if (command.equals("CompanyUpdateReq")) {
				companyUpdateReq(request, response);

			} else if (command.equals("CompanyUpdateNum")) {
				companyUpdateNum(request, response);

			} else if (command.equals("CompanyDelete")) {
				companyDelete(request, response);

			} else if (command.equals("MemberAll")) {
				memberAll(request, response);

			} else if (command.equals("Member")) {
				member(request, response);

			} else if (command.equals("MemberInsert")) {
				memberInsert(request, response);

			} else if (command.equals("MemberUpdateReq")) {
				memberUpdateReq(request, response);

			} else if (command.equals("MemberUpdatePw")) {
				memberUpdatePw(request, response);

			} else if (command.equals("MemberDelete")) {
				memberDelete(request, response);

			} else if (command.equals("PtListAll")) {
				ptListAll(request, response);

			} else if (command.equals("PtList")) {
				ptList(request, response);

			} else if (command.equals("PtListInsert")) {
				ptListInsert(request, response);

			} else if (command.equals("PtListUpdateReq")) {
				ptListUpdateReq(request, response);

			} else if (command.equals("PtListUpdateRecruitstat")) {
				ptListUpdateRecruitstat(request, response);

			} else if (command.equals("PtListDelete")) {
				ptListDelete(request, response);

			} else if (command.equals("PtEvalAll")) {
				ptEvalAll(request, response);

			} else if (command.equals("PtEval")) {
				ptEval(request, response);

			} else if (command.equals("PtEvalInsert")) {
				ptEvalInsert(request, response);

			} else if (command.equals("PtEvalUpdateReq")) {
				ptEvalUpdateReq(request, response);

			} else if (command.equals("PtEvalUpdateExperience")) {
				ptEvalUpdateExperience(request, response);

			} else if (command.equals("PtEvalDelete")) {
				ptEvalDelete(request, response);

			}

		} else {
			response.sendRedirect("index.html");
		}
	}

	public void companyAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Companyall", WorkmanService.getAllCompany());
			url = "Companylist.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("모든 회사 조회 에러 발생");

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Company",
					WorkmanService.getCompany(request.getParameter("Companyname")));
			url = "Companydetail.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("특정 회사 조회 에러 발생");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void companyInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		String name = request.getParameter("Companyname");
		String story = request.getParameter("Companystory");
		String loc = request.getParameter("Companyloc");
		String num = request.getParameter("Companynum");

		try {
			
			if (name != null && name.length() != 0) {

				request.getSession().setAttribute("successMsg", "등록 완료");
				WorkmanService.addCompany(name, story, loc, num);
				request.getSession().setAttribute("Company", WorkmanService.getCompany(name));

				url = "Companydetail.jsp";

			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("회사 등록 성공");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void companyUpdateReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.getSession().setAttribute("Company",
					WorkmanService.getCompany(request.getParameter("Companyname")));
			url = "Companyupdate.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("회사 정보 갱신 요청 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void companyUpdateNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		String name = request.getParameter("Companyname");
		String num = request.getParameter("Companynum");

		try {
			WorkmanService.updateCompanyNum(name, num);
			request.getSession().setAttribute("Company", WorkmanService.getCompany(name));
			url = "Companydetail.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("회사 번호 갱신 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void companyDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		String name = request.getParameter("Companyname");

		try {
			if (name != null && name.length() != 0) {

				WorkmanService.deleteCompany(name);
				request.getSession().setAttribute("Companyall", WorkmanService.getAllCompany());
				url = "Companylist.jsp";

			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("회사 삭제 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void memberAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Memberall", WorkmanService.getAllMember());
			url = "Memberlist.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("모든 회원 조회 에러 발생");

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void member(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Member", WorkmanService.getMember(request.getParameter("MemberId")));
			url = "Memberdetail.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("특정 회원 조회 에러 발생");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void memberInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		String id = request.getParameter("Userid");
		String pw = request.getParameter("Userpw");
		String name = request.getParameter("Username");
		String email = request.getParameter("Useremail");

		try {
			
			if (id != null && id.length() != 0) {

				request.getSession().setAttribute("successMsg", "등록 완료");
				WorkmanService.addMember(id, pw, name, email);
				request.getSession().setAttribute("Member", WorkmanService.getMember(id));

				url = "writeSucess.jsp";

			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("회원 등록 성공");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void memberUpdateReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.getSession().setAttribute("Member", WorkmanService.getCompany(request.getParameter("UserId")));
			url = "Memberupdate.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("회원 정보 갱신 요청 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void memberUpdatePw(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		String id = request.getParameter("Userid");
		String pw = request.getParameter("Userpw");

		try {
			WorkmanService.updateMemberPW(id, pw);
			request.getSession().setAttribute("Member", WorkmanService.getMember(id));
			url = "Memberdetail.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("회원 비밀번호 변경 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void memberDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		String id = request.getParameter("Userid");

		try {
			if (id != null && id.length() != 0) {

				WorkmanService.deleteMember(id);
				request.getSession().setAttribute("Memberall", WorkmanService.getAllMember());
				url = "Memberlist.jsp";

			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("회원 삭제 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptListAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("---------------------");

//		String url = "errorMsg.jsp";
//		String url = "partTimeListView2.jsp";
		String url = "errorMsg.jsp";
		try {
			ArrayList<ParttimeList> data = WorkmanService.getAllPTList();
			System.out.println(data);

			request.getSession().setAttribute("Ptlistall", data);
			log.info("모든  알바글 조회 성공");
			url = "partTimeListView2.jsp";
			

		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
			log.info("모든  알바글 조회 에러 발생");

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Ptlist",
					WorkmanService.getPTList(Long.valueOf(request.getParameter("TextList"))));
			url = "Ptlistdetail.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("특정 알바글 조회 에러 발생");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void ptListInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		int reviewnum = Integer.valueOf(request.getParameter("ReviewNum"));
		int reviewscore = Integer.valueOf(request.getParameter("ReviewScore"));
		String recruitstatus = request.getParameter("RecruitStatus");
		String date = request.getParameter("Date");
		String empperiod = request.getParameter("EmpPeriod");

		try {

			request.getSession().setAttribute("successMsg", "등록 완료");
			WorkmanService.addPTList(reviewnum, reviewscore, recruitstatus, date, empperiod);
			// 개선필요
			url = "Ptlistdetail.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("알바글 등록 성공");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptListUpdateReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.getSession().setAttribute("Ptlist",
					WorkmanService.getPTList(Long.valueOf(request.getParameter("TextList"))));
			url = "Ptlistupdate.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("알바글 정보 갱신 요청 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptListUpdateRecruitstat(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		Long textlist = Long.valueOf(request.getParameter("Textlist"));
		String recruitstatus = request.getParameter("Recruitstatus");

		try {
			WorkmanService.updatePTListRecruitstat(textlist, recruitstatus);
			request.getSession().setAttribute("Ptlist", WorkmanService.getPTList(textlist));
			url = "Ptlistdetail.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("알바글 채용상태 변경 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptListDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		Long textlist = Long.valueOf(request.getParameter("Textlist"));

		try {
			if (textlist > 0) {

				WorkmanService.deletePTList(textlist);
				request.getSession().setAttribute("Ptlistall", WorkmanService.getAllPTList());
				url = "Ptlistall.jsp";

			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("알바글 삭제 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptEvalAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Ptevalall", WorkmanService.getAllPTEval());
			url = "Ptevalall.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("모든  평가글 조회 에러 발생");

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptEval(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Pteval",
					WorkmanService.getPTList(Long.valueOf(request.getParameter("Texteval"))));
			url = "Ptevaldetail.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("특정 평가글 조회 에러 발생");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void ptEvalInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		
		long texteval = Long.valueOf(request.getParameter("Testval"));
		long textlist = Long.valueOf(request.getParameter("Textlist"));
		String userid = request.getParameter("Userid");
		String companyname = request.getParameter("Companyname");
		String proscons = request.getParameter("Proscons");
		long wage = Long.valueOf(request.getParameter("Wage"));
		String environment = request.getParameter("Environment");
		String incline = request.getParameter("Incline");
		String workdif = request.getParameter("Workdif");
		String experience = request.getParameter("Experience");
		
		try {
			ParttimeEval parteval= service.addPTEval(texteval,textlist,userid,companyname,proscons,wage,environment,incline,workdif,experience);
			request.getSession().setAttribute("pteval", parteval);
			request.getSession().setAttribute("successMsg", "등록 완료");
			log.info("평가글 등록 성공");
			url = "textWriteSuccess.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("평가글 등록 성공");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptEvalUpdateReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Texteval",
					WorkmanService.getPTEval(Long.valueOf(request.getParameter("texteval"))));
			url = "Ptevalupdate.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("평가글 정보 갱신 요청 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptEvalUpdateExperience(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		Long texteval = Long.valueOf(request.getParameter("Texteval"));
		String experience = request.getParameter("Experience");

		try {
			WorkmanService.updatePTEvalExp(texteval, experience);
			request.getSession().setAttribute("Pteval", WorkmanService.getPTEval(texteval));
			url = "Ptevaldetail.jsp";

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("평가글 경험담 변경 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptEvalDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		Long texteval = Long.valueOf(request.getParameter("Texteval"));

		try {
			if (texteval > 0) {

				WorkmanService.deletePTEval(texteval);
				request.getSession().setAttribute("Ptevalall", WorkmanService.getAllPTEval());
				url = "Ptevalall.jsp";

			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			log.info("평가글 삭제 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
