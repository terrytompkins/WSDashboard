package com.tdbank.greenhornet

import com.tdbank.greenhornet.ExternalSystemInstance

class ExternalSystem {
	String name
	static hasMany = [externalSystemInstances: ExternalSystemInstance]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated

	static constraints = {
		name(unique:true, blank:false)
		externalSystemInstances()
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
	
	String toString() {
		return name
	}
}
