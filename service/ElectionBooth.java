package com.voting.service;

import com.voting.exceptions.*;

public class ElectionBooth {

	String localities[] = { "ABC Nagar", "XYZ Nagar", "RK Nagar" };

//if age is less than 18 throw exception
	public boolean checkAge(int age) throws UnderAgeException {
		if (age < 18) {
			throw new UnderAgeException("Under voting age");
		}
		return true;
	}

	// check if the locality matches with the array
	public boolean checkLocality(String locality) throws LocalityNotFoundException {
		boolean isLocalityFound = false;
		for (String lname : localities) {
			if (locality.equals(lname)) {
				isLocalityFound = true;
				break;
			}
		}
		if (!isLocalityFound) {
			throw new LocalityNotFoundException("Locality Not Found");
		}
		return true;
	}

	// check if id is within 1000 - 9000
	public boolean checkVoterId(int vid) throws NoVoterIdException {
		if (!(vid >= 1000 && vid <= 9000)) {
			throw new NoVoterIdException("voter id not found");
		}
		return true;
	}

	public boolean checkEligibility(int age, String locality, int vid) throws NotEligibleException {
		// call all three methods // handle the exception //throw it to the voter
		try {
			checkAge(age);
			checkLocality(locality);
			checkVoterId(vid);
		} catch (NotEligibleException e) {
			throw (e);
		}
		System.out.println("vote registered");

		return true;
	}

}
