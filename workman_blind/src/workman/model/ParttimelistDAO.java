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
	
	public static void addPTList(Long textlist, Member member, Company company, int reviewnum, int reviewscore,
			String recruitstatus, String date, String emp_period) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			ParttimeList ptlist = ParttimeList.builder().textlist(textlist).userid(member).companyname(company).reviewnum(reviewnum).reviewscore(reviewscore).
					recruitstatus(recruitstatus).date(date).empperiod(emp_period).build();

			em.persist(ptlist);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}

	public static void updatePTListCompanyName(Long textlist, String recruitstatus) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setRecruitstatus(recruitstatus);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();
		}
	}

	public static void updatePTListReviewScore(Long textlist, int reviewscore) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setReviewscore(reviewscore);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updatePTListCompanyName(Long textlist, Company companyname) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setCompanyname(companyname);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updatePTListDate(Long textlist, String date) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setDate(date);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updatePTListEmpPeriod(Long textlist, String empperiod) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, textlist);

			ptlist.setEmpperiod(empperiod);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}

	public static void deletePTList(Long textlist) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	try {
			
		ParttimeList ptlist = em.find(ParttimeList.class, textlist);
			
			em.remove(ptlist);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static ParttimeList getPTList(Long textlist) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ParttimeList ptlist = null;
		try {
			ptlist = em.find(ParttimeList.class, textlist);
			
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

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
			ptlist = (ArrayList<ParttimeList>) em.createNativeQuery("select * from parttimelist", ParttimeList.class)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		return ptlist;
	}
	
}
