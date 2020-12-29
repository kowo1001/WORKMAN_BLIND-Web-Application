package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.model.dto.Member;
import workman.model.util.PublicCommon;

public class MemberDAO {

	public static boolean addMember(String userid, String userpw, String username, String useremail)
			throws SQLException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			
			Member member = Member.builder().userid(userid).userpw(userpw).username(username)
					.useremail(useremail).build();
			em.persist(member);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static boolean updateMemberPw(String userid, String userpw) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			
			Member member = em.find(Member.class, userid);
			member.setUserpw(userpw);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;

	}

	public static boolean updateMemberName(String userid, String username) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			
			Member member = em.find(Member.class, username);
			member.setUsername(username);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;

	}

	public static boolean updateMemberEmail(String userid, String useremail) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			
			Member member = em.find(Member.class, useremail);
			member.setUseremail(useremail);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;

	}

	public static boolean deleteMember(String userid) throws SQLException {
	
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			
			Member member = em.find(Member.class, userid);
			em.remove(member);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();

		} finally {

			em.close();

		}
		return result;
	}

	public static Member getMember(String userid) throws SQLException {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Member member = null;
		
		try {
			
			member = em.find(Member.class, userid);
			
		} catch (Exception e) {
			
			// log
			
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
			
			memlist = (ArrayList<Member>) em.createNativeQuery("select * from member", Member.class).getResultList();
		
		} catch (Exception e) {
			
			// log
			
		} finally {
			
			em.close();
			
		}
		return memlist;
	}

}
