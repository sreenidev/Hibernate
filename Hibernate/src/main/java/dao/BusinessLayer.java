package dao;

import java.util.List;
import javax.persistence.*;
import dto.EntityLayer;

public class BusinessLayer {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	// adding student data
	public void addStd(int std_id, String std_name, Long std_phno) {
		et.begin();
		EntityLayer el = new EntityLayer();
		el.setStd_id(std_id);
		el.setStd_name(std_name);
		el.setStd_phno(std_phno);
		em.persist(el);
		et.commit();
		System.out.println("THE VALUES \n"+std_id+" "+std_name+" "+std_phno+"\n HAS BEEN ADDED TO Student_Details table");
	}

	// fetch by Student id
	public void fetchByStdid(int stdid) {
		EntityLayer el = em.find(EntityLayer.class, stdid);
		System.out.println((el != null) ? el : "Data not found");
	}

	// fetch All the Student details
	public void fetchAll() {
		Query q = em.createQuery("select a from Student_Details a");
		List<EntityLayer> li = q.getResultList();
		for (EntityLayer result : li)
			System.out.println(result);
	}

	// update Student Name by Student Id
	public void updateStd_name(int std_id, String std_name) {
		EntityLayer el = em.find(EntityLayer.class, std_id);
		if (el != null) {
			et.begin();
			el.setStd_name(std_name);
			em.merge(el);
			et.commit();
		} else
			System.out.println("DATA NOT FOUND");
	}

	// delete Student detail by Student Id
	public void removeStd_Detail(int std_id) {
		EntityLayer el = em.find(EntityLayer.class, std_id);
		if (el != null) {
			et.begin();
			em.remove(el);
			et.commit();
//			System.out.println(std_id + " has been removed");
		} else
			System.out.println("DATA NOT FOUND");
	}

	// delete all the Student details
	public void deleteAll() {
		Query q = em.createQuery("delete from Student_Details");
		et.begin();
		q.executeUpdate();
		et.commit();
		System.out.println("ALL THE DATA HAS BEEN DELETED FROM Student_Details");
	}

}
