package com.tdbank.greenhornet

import java.util.Date;

class Project {
	String name
	String itNumber
	String primaveraId
	String description
	String owner
	Boolean isPhase1
	Boolean isPhase2
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		name(unique:true, blank:false)
		itNumber(nullable:true)
		primaveraId(nullable:false)
		description(nullable:true, maxSize:2000)
		owner(nullable:true)
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()	
	}
}
