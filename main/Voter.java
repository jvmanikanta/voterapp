package com.voting.main;

import java.util.Scanner;

import com.voting.exceptions.NotEligibleException;
import com.voting.service.ElectionBooth;

public class Voter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectionBooth booth = new ElectionBooth();
		try(Scanner sc = new Scanner(System.in);) {
			System.out.println("entere age");
			int age = sc.nextInt();
			boolean checkAge = booth.checkAge(age);
			if (checkAge) {
				System.out.println("entere locality");
				sc.nextLine();
				String locality = sc.nextLine();
				//System.out.println(locality);
				boolean checkLocality = booth.checkLocality(locality);
				if (checkLocality) {
					System.out.println("entere voter id");
					int vid = sc.nextInt();
					booth.checkEligibility(age, locality, vid);
				}
			}
		} catch (NotEligibleException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
