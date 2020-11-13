package hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;

public class GetCourseAndReviewDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Instructor.class)
												.addAnnotatedClass(InstructorDetail.class)
												.addAnnotatedClass(Course.class)
												.addAnnotatedClass(Review.class)
												.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			
			
			//start transaction
			session.beginTransaction();
			//get the course
			int theId=12;
			Course tempCourse = session.get(Course.class, theId);
			//print the course
			System.out.println(tempCourse);
			//print the course reviews
			System.out.println(tempCourse.getReviews());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally{
			session.close();
			factory.close();
			
		}

	}

}