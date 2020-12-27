package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.model.dto.Company;
import workman.model.dto.ParttimeEval;
import workman.model.util.PublicCommon;

public class ParttimeEvalDAO {

	public static void addPTEval(String proscons, long hourlywage, String environment, String incline, String workdif,
			String experience) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			ParttimeEval pteval = ParttimeEval.builder().proscons(proscons).hourlywage(hourlywage)
					.environment(environment).incline(incline).workdif(workdif).experience(experience).build();

			em.persist(pteval);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}

	public static void updatePTEvalProCon(Long texteval, String proscons) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setProscons(proscons);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();
		}
	}

	public static void updatePTEvalHourWage(Long texteval, Long hourlywage) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setHourlywage(hourlywage);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updatePTEvalEnv(Long texteval, String environment) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setEnvironment(environment);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updatePTEvalInc(Long texteval, String incline) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setIncline(incline);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updatePTEvalWorkDif(Long texteval, String workdif) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setWorkdif(workdif);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updatePTEvalExp(Long texteval, String experience) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setExperience(experience);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}

	
	public static void deletePTEval(Long texteval) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	try {
			
			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);
			
			em.remove(pteval);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static ParttimeEval getPTEval(Long texteval) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ParttimeEval pteval = null;
		try {
			pteval = em.find(ParttimeEval.class, texteval);
			
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		return pteval;
	}
	
	
	public static ArrayList<ParttimeEval> getAllPTEval() throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ArrayList<ParttimeEval> ptevallist = null;
		try {
			ptevallist = (ArrayList<ParttimeEval>) em.createNativeQuery("select * from parttimeeval", ParttimeEval.class)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		return ptevallist;
	}
}
