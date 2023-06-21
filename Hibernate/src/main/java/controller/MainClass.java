package controller;

import java.util.Scanner;

import dao.BusinessLayer;

public class MainClass {

	public static void main(String[] args) {
		BusinessLayer bl = new BusinessLayer();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println(
					"\n\n 1. Add Std_Details\n 2. FetchBy Std_id\n 3. FetchAll\n 4. Update Std_name by Std_id\n 5. Delete Std_Detail by Std_id\n 6. DeleteAll Std_Details\n 7. Exit\n");
			switch (sc.nextInt()) {
			case 1: {
				System.out.print("ADD STUDENT DETAILS\nStudent Id = ");
				int id = sc.nextInt();
				System.out.print("Student Name = ");
				String name = sc.next();
				System.out.print("Student PhoneNumber = ");
				Long phno = sc.nextLong();
				bl.addStd(id, name, phno);
			}
				break;
			case 2: {
				System.out.print("ENTER STUDENT ID TO FETCH STUDENT DETAILS\nStudent id = \n\n");
				int id = sc.nextInt();
				bl.fetchByStdid(id);
			}
				break;
			case 3: {
				bl.fetchAll();
			}
				break;
			case 4: {
				System.out.print("UPDATE STUDENT NAME BY STUDENT ID\nStudent id = ");
				int id = sc.nextInt();
				System.out.print("New Student Name = ");
				String name = sc.next();
				bl.updateStd_name(id, name);
			}
				break;
			case 5: {
				System.out.print("DELETE A STUDENT DETAIL BY STUDENT ID\nStudent id = ");
				int id = sc.nextInt();
				bl.removeStd_Detail(id);
			}
				break;
			case 6: {
				bl.deleteAll();
			}
				break;
			case 7: {
				flag = false;
				System.out.println("Application Stoped. Run the Application to start again");
			}
				break;

			default:
				System.out.println("Enter a number between 1 - 7");
				break;
			}
		}

	}

}
