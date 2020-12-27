package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.model.dto.Company;
import workman.model.util.PublicCommon;

public class CompanyDAO {
	
	public static void addCompany(String companyname, String companystory, String companyloc, String companynum) throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Company company = Company.builder().companyname(companyname).companystory(companystory).companyloc(companyloc).companynum(companynum).build();
			em.persist(company);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void updateCompanyNum(String companyname, String companynum) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			
			Company company = em.find(Company.class, companyname);
			company.setCompanynum(companynum);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	
	public static void updateCompanyLoc(String companyname, String companyloc) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			
			Company company = em.find(Company.class, companyname);
			company.setCompanyloc(companyloc);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	
	public static void deleteCompany(String companyname) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	try {
			
			Company company = em.find(Company.class, companyname);
			em.remove(company);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}

	
	public static Company getCompany(String companyname) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Company company = null;
		try {
			company = em.find(Company.class, companyname);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		return company;
	}
	
	
	public static ArrayList<Company> getAllCompany() throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ArrayList<Company> comlist = null;
		try {
			comlist = (ArrayList<Company>) em.createNativeQuery("select * from company", Company.class)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		return comlist;
	}
	
}
