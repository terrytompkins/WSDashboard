package com.tdbank.greenhornet

import com.tdbank.greenhornet.Jvm

class Ear {
	String name
	static hasMany = [jvms: Jvm]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	static belongsTo = Jvm
	
	static constraints = {
		name(unique:true, blank:false)
		jvms()
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
	
	String toString() {
		return name
	}
}
