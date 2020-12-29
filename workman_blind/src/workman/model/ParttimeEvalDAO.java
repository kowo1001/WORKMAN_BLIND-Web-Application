package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.exception.NotExistException;
import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.dto.ParttimeEval;
import workman.model.dto.ParttimeList;
import workman.model.util.PublicCommon;

public class ParttimeEvalDAO {

	public static ParttimeEval addPTEval(Long texteval, ParttimeList pl, Member m, Company cn, String proscons, Long wage, String environment, String incline, String workdif,
			String experience) throws SQLException, NotExistException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			ParttimeEval pteval = ParttimeEval.builder().texteval(texteval).textlist(pl).userid(m).companyname(cn).proscons(proscons).wage(wage)
					.environment(environment).incline(incline).workdif(workdif).experience(experience).build();
			
			if (pteval != null) {
				em.persist(pteval);
				tx.commit();
				
				return pteval;
			}
		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();
			
		} finally {

			em.close();

		}
		throw new NotExistException("해당 평가게시글이 존재하지 않습니다");
	}

	public static boolean updatePTEvalProCon(Long texteval, String proscons) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setProscons(proscons);
			tx.commit();
			
			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();
		}
		return result;
	}

	public static boolean updatePTEvalWage(Long texteval, Long wage) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setWage(wage);
			tx.commit();
			
			result = true;

		} catch (Exception e) {

			tx.rollback();
			

		} finally {

			em.close();

		}
		return result;
	}
	
	
	public static boolean updatePTEvalEnv(Long texteval, String environment) throws SQLException {
	
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setEnvironment(environment);
			tx.commit();
			
			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}
	
	
	public static boolean updatePTEvalInc(Long texteval, String incline) throws SQLException {
	
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setIncline(incline);
			tx.commit();
			
			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}
	
	
	public static boolean updatePTEvalWorkDif(Long texteval, String workdif) throws SQLException {
	
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setWorkdif(workdif);
			tx.commit();
			
			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}
	
	
	public static boolean updatePTEvalExp(Long texteval, String experience) throws SQLException {
	
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);

			pteval.setExperience(experience);
			tx.commit();
			
			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	
	public static boolean deletePTEval(Long texteval) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;
		
	try {
			
			ParttimeEval pteval = em.find(ParttimeEval.class, texteval);
			
			em.remove(pteval);
			tx.commit();
			
			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}
	
	
	public static ParttimeEval getPTEval(Long texteval) throws SQLException {
	
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ParttimeEval pteval = null;
		
		try {
			
			pteval = em.find(ParttimeEval.class, texteval);

		} catch (Exception e) {

			// log
			
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

		} catch (Exception e) {

			// log
			
		} finally {

			em.close();

		}
		return ptevallist;
	}
}
