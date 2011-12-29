package com.tdbank.greenhornet

import java.util.Date;

class ExternalSystemInstance {
	String name
	String notes
	static belongsTo = [ExternalSystem, Jvm]
	ExternalSystem externalSystem
	static hasMany = [jvms: Jvm]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		name(unique:'externalSystem', nullable: false)
		externalSystem(nullable: false)
		jvms(nullable: true)
		notes(nullable: true)
 		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
	
	String toString() {
		return "${externalSystem} - ${name}"
	}
}
