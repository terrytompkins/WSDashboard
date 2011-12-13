package com.tdbank.greenhornet

import java.util.Date;

class Jvm {
	String name
	Server server
	Region region
	// Ear ear // @@@ TMT: 12/13/2011 - I believe this is now a 1toM
	Date lastEarDeployDate
	CodePhase codePhase
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	static hasMany = [fidelityRegions: FidelityRegion, ears: Ear] // @@@ TMT: 12/13/2011 - any other 1toM's?
	
	static constraints = {
		name(unique:true, blank:false)
		server(nullable:false)
		region(nullable:false)
		fidelityRegions(nullable:true)
		codePhase()
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()	
	}
}
