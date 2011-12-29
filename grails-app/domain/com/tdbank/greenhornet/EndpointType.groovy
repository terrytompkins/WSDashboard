package com.tdbank.greenhornet

import java.util.Date;

class EndpointType {
	String name
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		name(unique:true, blank:false)
		displayOrder(nullable: true)
		modifiedBy()
		dateCreated()
		lastUpdated()
	}
	
	String toString() {
		return name
	}
}
