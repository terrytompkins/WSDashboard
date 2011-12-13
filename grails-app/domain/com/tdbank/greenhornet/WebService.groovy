package com.tdbank.greenhornet

class WebService {
	String name
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated

	static constraints = {
		name(unique:true, blank:false)
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
}
