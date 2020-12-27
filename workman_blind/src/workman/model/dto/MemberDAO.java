package workman.model.dto;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.model.util.PublicCommon;

public class MemberDAO {
	
	public static void addMember(String user_id, String user_pw, String user_name, String user_email) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Member member = Member.builder().user_id(user_id),user_pw(user_pw),user_name(user_name),user_email(user_email).build();
			em.persist(member);
			tx.commit();

		}catch (Exception e) {
			
			tx.rollback();
			e.printStackTrace();

		} finally {
			em.close();
		}
	}
	

	
	public static void updateMemberPw (String user_id, String user_pw) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Member member = em.find(Member.class, user_id);
			member.setUser_pw(user_pw);
			tx.commit();
			
		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}

	}
	
	public static void updateMemberName (String user_id, String user_name) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Member member = em.find(Member.class, user_name);
			member.setUser_name(user_name);
			tx.commit();
			
		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}

	}
	
	public static void updateMemberEmail (String user_id, String user_email) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Member member = em.find(Member.class, user_email);
			member.setUser_email(user_email);
			tx.commit();
			
		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}

	}
	
	public static void deleteMember(String user_id) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	try {
			Member member = em.find(Member.class, user_id);
			em.remove(member);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
	}
	
	public static Member getMember(String user_id) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Member member = null;
		try {
			member = em.find(Member.class, user_id);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		return member;
	}
	
	public static ArrayList<Member> getAllMember() throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ArrayList<Member> memlist = null;
		try {
			memlist = (ArrayList<Member>) em.createNativeQuery("select * from member", Member.class)
					.getResultList();
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		return memlist;
	}
	

}
