package com.Mobitel.MobitelBack.Test;


	import java.util.List;

	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Mobitel.MobitelBack.dao.UserDAO;
import com.Mobitel.MobitelBack.model.User;

	

	public class UserTestCase {
			public static void main(String arg[])
			{
				AnnotationConfigApplicationContext
				context=new AnnotationConfigApplicationContext();
				
				context.scan("com.Mobitel.MobitelBack");
				
				context.refresh();
				
				// Inserting a User Object.
				UserDAO userDAO=(UserDAO)context.getBean("userDAO");
				
				//Insertion TestCase
				User user=new User();
				System.out.println("Inserting value ...");
				user.setUname("bittu");
				user.setUpswd("bittu");
				user.setAddr("Rnchi");
				user.setCustName("bittu");
				user.setRole("Role_Admin");
				user.setEmail("bittu0208@gmail.com");
				user.setEnabled(true);
				user.setMobile("8013058309");
				userDAO.insertUpdateUser(user);		
				System.out.println("User Inserted");
				
				//Retrieval TestCase
				
			/*	User user=userDAO.getUser(2);
				System.out.println("User Name:"+user.getCatname());
				System.out.println("User Description:"+user.getCatdesc());
				
			*/	//Deletion TestCase
				/*User user=userDAO.getUser(2);
				userDAO.deleteUser(user);
				System.out.println("The User Deleted");*/
				
				//Retrieving the Data
				
			/*	List<User> list=userDAO.getUserDetails();
				
				for(User user:list)
				{
			
					System.out.println(user.getUid()+":"+user.getUname()+":"+user.getUpswd()+":"+user.getContact()+":"+user.getRole());
				}
				*/
				//Update the User
				/*User user=userDAO.getUser(1);
				user.setUname("Admin");
				userDAO.insertUpdateUser(user);
				System.out.println("The User Updated");
				*/
			}
		}





