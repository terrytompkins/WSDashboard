package com.tdbank.greenhornet

import com.tdbank.greenhornet.ServerCluster
import com.tdbank.greenhornet.User

class Server {
	String name
	String ipAddress
	static belongsTo = [serverCluster: ServerCluster]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated

	static constraints = {
		name(unique:true, blank:false)
		ipAddress(blank:false)
		serverCluster(nullable: false)
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
}
