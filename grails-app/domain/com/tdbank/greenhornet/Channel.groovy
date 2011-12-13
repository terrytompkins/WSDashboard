package com.tdbank.greenhornet

import java.util.Date;

class Channel {
	String name
	static hasMany = [jvms: Jvm]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated

	static constraints = {
		name(unique:true, blank:false)
		jvms()
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
}
