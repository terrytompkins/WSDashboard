package com.tdbank.greenhornet

import java.util.Date;

import com.tdbank.greenhornet.SecUser

class User extends SecUser {
	String lastName
	String firstName
	String middleName
	String email
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		lastName(blank:false)
		firstName(blank:false)
		middleName(nullable:true)
		email(nullable:true, email:true)
	}
	
	String toString() {
		return "${lastName}, ${firstName}"
	}
}
