package com.tdbank.greenhornet

import java.util.Date;

class Jvm {
	String name
	Server server
	Region region
	Date lastEarDeployDate
	CodePhase codePhase
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	static hasMany = [ears: Ear, externalSystemInstances: ExternalSystemInstance, projects: Project]
	
	static constraints = {
		name(unique:true, blank:false)
		server(nullable:false)
		region(nullable:false)
		externalSystemInstances()
		projects()
		lastEarDeployDate(nullable:false)
		codePhase(nullable:false)
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()	
	}
	
	String toString() {
		return "${name} - ${region} - ${codePhase}"
	}
}
