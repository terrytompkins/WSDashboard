package com.tdbank.greenhornet

import com.tdbank.greenhornet.User

class ServerCluster {
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
