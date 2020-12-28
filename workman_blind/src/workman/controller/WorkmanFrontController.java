package workman.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import workman.model.WorkmanService;

@Slf4j
@WebServlet("/workman")
public class WorkmanFrontController extends HttpServlet {

	public WorkmanFrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		if (command != null) {
			
			if (command.equals("CompanyAll")) {
				CompanyAll(request, response);

			} else if (command.equals("Company")) {
				Company(request, response);

			} else if (command.equals("CompanyInsert")) {
				CompanyInsert(request, response);

			} else if (command.equals("CompanyUpdateReq")) {
				CompanyUpdateReq(request, response);

			} else if (command.equals("CompanyUpdateNum")) {
				CompanyUpdateNum(request, response);

			} else if (command.equals("CompanyDelete")) {
				CompanyDelete(request, response);

			} else if (command.equals("MemberAll")) {
				MemberAll(request, response);

			} else if (command.equals("Member")) {
				Member(request, response);

			} else if (command.equals("MemberInsert")) {
				MemberInsert(request, response);

			} else if (command.equals("MemberUpdateReq")) {
				MemberUpdateReq(request, response);

			} else if (command.equals("MemberUpdatePw")) {
				MemberUpdatePw(request, response);

			} else if (command.equals("MemberDelete")) {
				MemberDelete(request, response);

			} else if (command.equals("PtListAll")) {
				PTListAll(request, response);

			} else if (command.equals("PtList")) {
				PTList(request, response);

			} else if (command.equals("PtListInsert")) {
				PTListInsert(request, response);

			} else if (command.equals("PtListUpdateReq")) {
				PTListUpdateReq(request, response);

			} else if (command.equals("PtListUpdateRecruitstat")) {
				PTListUpdateRecruitstat(request, response);

			} else if (command.equals("PtListDelete")) {
				PTListDelete(request, response);

			} else if (command.equals("PtEvalAll")) {
				PTEvalAll(request, response);

			} else if (command.equals("PtEval")) {
				PTEval(request, response);

			} else if (command.equals("PtEvalInsert")) {
				PTEvalInsert(request, response);

			} else if (command.equals("PtEvalUpdateReq")) {
				PTEvalUpdateReq(request, response);

			} else if (command.equals("PtEvalUpdateExperience")) {
				PTEvalUpdateExperience(request, response);

			} else if (command.equals("PtEvalDelete")) {
				PTEvalDelete(request, response);

			}

		} else {
			response.sendRedirect("index.html");
		}
	}

	public void CompanyAll(HttpServletRequest request, HttpServletResponse response)
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

	public void Company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	protected void CompanyInsert(HttpServletRequest request, HttpServletResponse response)
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

	public void CompanyUpdateReq(HttpServletRequest request, HttpServletResponse response)
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

	public void CompanyUpdateNum(HttpServletRequest request, HttpServletResponse response)
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

	public void CompanyDelete(HttpServletRequest request, HttpServletResponse response)
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

	public void MemberAll(HttpServletRequest request, HttpServletResponse response)
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

	public void Member(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	protected void MemberInsert(HttpServletRequest request, HttpServletResponse response)
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

	public void MemberUpdateReq(HttpServletRequest request, HttpServletResponse response)
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

	public void MemberUpdatePw(HttpServletRequest request, HttpServletResponse response)
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

	public void MemberDelete(HttpServletRequest request, HttpServletResponse response)
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

	public void PTListAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {

			request.getSession().setAttribute("Ptlistall", WorkmanService.getAllPTList());
			url = "Ptlistall.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("모든  알바글 조회 에러 발생");

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void PTList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	protected void PTListInsert(HttpServletRequest request, HttpServletResponse response)
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

	public void PTListUpdateReq(HttpServletRequest request, HttpServletResponse response)
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

	public void PTListUpdateRecruitstat(HttpServletRequest request, HttpServletResponse response)
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

	public void PTListDelete(HttpServletRequest request, HttpServletResponse response)
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

	public void PTEvalAll(HttpServletRequest request, HttpServletResponse response)
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

	public void PTEval(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	protected void PTEvalInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		String proscons = request.getParameter("Procons");
		long wage = Long.valueOf(request.getParameter("Wage"));
		String environment = request.getParameter("Environment");
		String incline = request.getParameter("Incline");
		String workdif = request.getParameter("Workdif");
		String experience = request.getParameter("Experience");

		try {

			request.getSession().setAttribute("successMsg", "등록 완료");
			WorkmanService.addPTEval(proscons, wage, environment, incline, workdif, experience);
			// 개선필요
			url = "Ptevaldetail.jsp";

		} catch (Exception s) {

			request.setAttribute("errorMsg", s.getMessage());
			log.info("평가글 등록 성공");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void PTEvalUpdateReq(HttpServletRequest request, HttpServletResponse response)
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

	public void PTEvalUpdateExperience(HttpServletRequest request, HttpServletResponse response)
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

	public void PTEvalDelete(HttpServletRequest request, HttpServletResponse response)
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
