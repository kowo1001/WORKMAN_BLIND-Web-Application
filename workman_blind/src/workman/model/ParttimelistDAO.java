package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.dto.ParttimeList;
import workman.model.util.PublicCommon;

public class ParttimelistDAO {

	public static boolean addPTList(int reviewnum, int reviewscore, String recruitstatus, String date,
			String emp_period) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = ParttimeList.builder().reviewnum(reviewnum).reviewscore(reviewscore)
					.recruitstatus(recruitstatus).date(date).empperiod(emp_period).build();

			em.persist(ptlist);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static boolean updatePTListRecruitstat(Long textlist, String recruitstatus) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setRecruitstatus(recruitstatus);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static boolean updatePTListReviewScore(Long textlist, int reviewscore) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setReviewscore(reviewscore);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static boolean updatePTListCompanyName(Long textlist, Company companyname) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setCompanyname(companyname);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static boolean updatePTListDate(Long textlist, String date) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setDate(date);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static boolean updatePTListEmpPeriod(Long textlist, String empperiod) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setEmpperiod(empperiod);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static boolean deletePTList(Long textlist) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			em.remove(ptlist);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static ParttimeList getPTList(Long textlist) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		ParttimeList ptlist = null;

		try {

			ptlist = em.find(ParttimeList.class, textlist);

		} catch (Exception e) {

			// log

		} finally {

			em.close();

		}
		return ptlist;
	}

	public static ArrayList<ParttimeList> getAllPTList() throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		ArrayList<ParttimeList> ptlist = null;

		try {
			ptlist = (ArrayList<ParttimeList>) em.createNativeQuery("select * from parttimelist", ParttimeList.class).getResultList();
			System.out.println("===== " + ptlist);
//		} catch (Exception e) {
//
//			// log

		} finally {

			em.close();

		}
		return ptlist;
	}

}

