package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import workman.exception.MessageException;
import workman.exception.NotExistException;
import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.dto.ParttimeEval;
import workman.model.dto.ParttimeList;

public class WorkmanService {

	// company

	public static boolean addCompany(String companyname, String companystory, String companyloc, String companynum)
			throws MessageException, SQLException {

		return CompanyDAO.addCompany(companyname, companystory, companyloc, companynum);
	}

	public static boolean updateCompanyNum(String companyname, String companynum)
			throws MessageException, SQLException {

		return CompanyDAO.updateCompanyNum(companyname, companynum);
	}

	public static boolean updateCompanyLoc(String companyname, String companyloc)
			throws MessageException, SQLException {

		return CompanyDAO.updateCompanyLoc(companyname, companyloc);
	}

	public static boolean deleteCompany(String companyname) throws MessageException, SQLException {

		return CompanyDAO.deleteCompany(companyname);
	}

	public static Company getCompany(String companyname) throws SQLException, NotExistException {

		Company company = CompanyDAO.getCompany(companyname);

		if (company == null) {

			throw new NotExistException("해당 이름의 회사 정보가 존재하지 않습니다.");

		}
		return company;
	}

	public static ArrayList<Company> getAllCompany() throws SQLException, NotExistException {

		ArrayList<Company> companies = CompanyDAO.getAllCompany();

		if (companies == null) {

			throw new NotExistException("전체 회사 정보가 존재하지 않습니다.");

		}
		return companies;

	}

	// member

	public static boolean addMember(String userid, String userpw, String username, String useremail)
			throws MessageException, SQLException {

		return MemberDAO.addMember(userid, userpw, username, useremail);
	}

	public static boolean updateMemberPW(String userid, String userpw) throws MessageException, SQLException {

		return MemberDAO.updateMemberPw(userid, userpw);
	}

	public static boolean updateMemberName(String userid, String username) throws MessageException, SQLException {

		return MemberDAO.updateMemberName(userid, username);
	}

	public static boolean updateMemberEmail(String userid, String useremail) throws MessageException, SQLException {

		return MemberDAO.updateMemberEmail(userid, useremail);
	}

	public static boolean deleteMember(String userid) throws MessageException, SQLException {

		return MemberDAO.deleteMember(userid);
	}

	public static Member getMember(String userid) throws SQLException, NotExistException {

		Member member = MemberDAO.getMember(userid);

		if (member == null) {

			throw new NotExistException("해당 Id의 회원 정보가 존재하지 않습니다.");

		}
		return member;
	}

	public static ArrayList<Member> getAllMember() throws SQLException, NotExistException {

		ArrayList<Member> members = MemberDAO.getAllMember();

		if (members == null) {

			throw new NotExistException("전체 회사 정보가 존재하지 않습니다.");

		}
		return members;

	}

	// parttimelist // todo

	public static boolean addPTList(int reviewnum, int reviewscore, String recruitstatus, String date, String empperiod)
			throws MessageException, SQLException {

		return ParttimelistDAO.addPTList(reviewnum, reviewscore, recruitstatus, date, empperiod);
	}

	public static boolean updatePTListRecruitstat(Long textlist, String recruitstatus)
			throws MessageException, SQLException {

		return ParttimelistDAO.updatePTListRecruitstat(textlist, recruitstatus);
	}

	public static boolean updatePTListEmpPeriod(Long textlist, String empperiod) throws MessageException, SQLException {

		return ParttimelistDAO.updatePTListEmpPeriod(textlist, empperiod);
	}

	public static boolean updatePTListReviewScore(Long textlist, int reviewscore)
			throws MessageException, SQLException {

		return ParttimelistDAO.updatePTListReviewScore(textlist, reviewscore);
	}

	public static boolean updatePTListCompanyName(Long textlist, Company companyname)
			throws MessageException, SQLException {

		return ParttimelistDAO.updatePTListCompanyName(textlist, companyname);
	}

	public static boolean updatePTListDate(Long textlist, String date) throws MessageException, SQLException {

		return ParttimelistDAO.updatePTListDate(textlist, date);
	}

	public static boolean deletePTList(Long textlist) throws MessageException, SQLException {

		return ParttimelistDAO.deletePTList(textlist);
	}

	public static ParttimeList getPTList(Long textlist) throws SQLException, NotExistException {

		ParttimeList ptlist = ParttimelistDAO.getPTList(textlist);

		if (ptlist == null) {

			throw new NotExistException("해당 Id의 회원 정보가 존재하지 않습니다.");

		}
		return ptlist;
	}

	public static ArrayList<ParttimeList> getAllPTList() throws SQLException, NotExistException {

		ArrayList<ParttimeList> ptlists = ParttimelistDAO.getAllPTList();

		if (ptlists == null) {

			throw new NotExistException("전체 회사 정보가 존재하지 않습니다.");

		}
		return ptlists;

	}

	// parttimeeval

	public static boolean addPTEval(String proscons, long wage, String environment, String incline,
			String workdif, String experience) throws MessageException, SQLException {

		return ParttimeEvalDAO.addPTEval(proscons, wage, environment, incline, workdif, experience);
	}

	public static boolean updatePTEvalProCon(Long texteval, String proscons) throws MessageException, SQLException {

		return ParttimeEvalDAO.updatePTEvalProCon(texteval, proscons);
	}

	public static boolean updatePTEvalWage(Long texteval, Long wage) throws MessageException, SQLException {

		return ParttimeEvalDAO.updatePTEvalWage(texteval, wage);
	}

	public static boolean updatePTEvalEnv(Long texteval, String environment) throws MessageException, SQLException {

		return ParttimeEvalDAO.updatePTEvalEnv(texteval, environment);
	}

	public static boolean updatePTEvalInc(Long texteval, String incline) throws MessageException, SQLException {

		return ParttimeEvalDAO.updatePTEvalInc(texteval, incline);
	}

	public static boolean updatePTEvalWorkDif(Long texteval, String workdif) throws MessageException, SQLException {

		return ParttimeEvalDAO.updatePTEvalWorkDif(texteval, workdif);
	}

	public static boolean updatePTEvalExp(Long texteval, String experience) throws MessageException, SQLException {

		return ParttimeEvalDAO.updatePTEvalExp(texteval, experience);
	}

	public static boolean deletePTEval(Long texteval) throws MessageException, SQLException {

		return ParttimeEvalDAO.deletePTEval(texteval);
	}

	public static ParttimeEval getPTEval(Long texteval) throws SQLException, NotExistException {

		ParttimeEval pteval = ParttimeEvalDAO.getPTEval(texteval);

		if (pteval == null) {

			throw new NotExistException("해당 Id의 회원 정보가 존재하지 않습니다.");

		}
		return pteval;
	}

	public static ArrayList<ParttimeEval> getAllPTEval() throws SQLException, NotExistException {

		ArrayList<ParttimeEval> ptevals = ParttimeEvalDAO.getAllPTEval();

		if (ptevals == null) {

			throw new NotExistException("전체 회사 정보가 존재하지 않습니다.");

		}
		return ptevals;

	}
}
