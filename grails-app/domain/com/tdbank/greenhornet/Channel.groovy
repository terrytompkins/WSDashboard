package com.tdbank.greenhornet

import java.util.Date;

class Channel {
	String name
	String description
	static hasMany = [jvms: Jvm]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated

	static constraints = {
		name(unique:true, blank:false)
		description(nullable: true)
		jvms()
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
	
	String toString() {
		return name
	}
}
