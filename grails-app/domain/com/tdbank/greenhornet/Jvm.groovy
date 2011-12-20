package com.tdbank.greenhornet

import java.util.Date;

class Jvm {
	String name
	Server server
	Region region
	FidelityRegion fidelityRegion
	Date lastEarDeployDate
	CodePhase codePhase
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	static hasMany = [ears: Ear]
	
	static constraints = {
		name(unique:true, blank:false)
		server(nullable:false)
		region(nullable:false)
		fidelityRegion(nullable:false)
		lastEarDeployDate(nullable:false)
		codePhase(nullable:false)
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()	
	}
}
