package com.tdbank.greenhornet

import com.tdbank.greenhornet.User
import com.tdbank.greenhornet.Server

class ServerCluster {
	String name
	static hasMany = [servers: Server]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		name(unique:true, blank:false)
		servers()
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
	
	String toString() {
		return name
	}
}
