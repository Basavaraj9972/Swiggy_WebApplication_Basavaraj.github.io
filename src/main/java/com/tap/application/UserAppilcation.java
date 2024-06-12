package com.tap.application;

import java.util.List;
import java.util.Scanner;

import com.tap.dao.UserDao;
import com.tap.daoImp.UserDaoImpl;
import com.tap.model.User;

public class UserAppilcation {
	
	
	public static String encrycreptedPassword(String password) {
		String encryptedPassword = "";
		for(int i=0;i<password.length();i++) {
			encryptedPassword = encryptedPassword + (char)(password.codePointAt(i)+43);
		}
		return encryptedPassword;
	}
	public static String encryptedUserName(String userName) {
		String encryptedUsername = "";
		for(int i =0;i<userName.length();i++) {
			 encryptedUsername = encryptedUsername + (char)(userName.codePointAt(i)+52);
		}
		return encryptedUsername;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String encryptedUserName = encryptedUserName("Basavaraj");
		String encrycreptedPassword = encrycreptedPassword("Bassu@123");
		System.out.println(encryptedUserName);
		System.out.println(encrycreptedPassword);
		User user = new User(4,encryptedUserName,encrycreptedPassword);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.updateUserNamePassword(user);
//		System.out.println("Eneter the UserId :");
//		int UserId = sc.nextInt();
//		System.out.println("Eneter the name :");
//		String name = sc.next();
//		System.out.println("Enter the email Id :");
//		String email = sc.next();
//		System.out.println("Enter the Phone Number :");
//		String phoneNo = sc.next();
//		System.out.println("Enter the Address :");
//		String address = sc.next();
//		System.out.println("Enter the userName :");
//		String userName = sc.next();
//		System.out.println("Enter the Password :");
//		String password = sc.next();
//		System.out.println("Enter the Role");
//		String role =sc.next();
//		User user = new User(name,email,phoneNo,address,userName,password,role);
//		userDao.addUser(user);
//		
//		User user2 = userDao.getUser(5);
//		System.out.println(user2);
//		
//		System.out.println();
//		user2.setAddress("");
//		userDao.updateUser(user2);
//		System.out.println(user2);
		
//		userDao.deleteUser(5);

//		List<User> allUser = userDao.getAllUser();
//		for(User user1:allUser) {
//			System.out.println(user1);
//		}
//		User phoneNumber = userDaoImpl.getPhoneNumber("8431623373");
//		System.out.println(phoneNumber.getPhoneNo());
//		
//		User userNamePassword = userDaoImpl.getUserNamePassword("Shivu","Shivu@123");
//		System.out.println(userNamePassword);
//		System.out.println(userNamePassword.getUserName());
//		System.out.println(userNamePassword.getPassword());
//		
		
		
		
		
		
	}

}
