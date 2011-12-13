package com.tdbank.greenhornet

import java.util.Date
import com.tdbank.greenhornet.EndpointType
import com.tdbank.greenhornet.WebService
import com.tdbank.greenhornet.Jvm

class EndpointAssignment {
	String endpointUrl
	EndpointType endpointType
	WebService webService
	static belongsTo = [jvm: Jvm]
	Integer displayOrder
	User modifiedBy
	Date dateCreated
	Date lastUpdated

	static constraints = {
		endpointUrl(unique:true, blank:false)
		endpointType(nullable:false)
		webService(nullable:false)
		jvm(nullable:true)
		displayOrder(nullable:true)
		lastUpdated()
		modifiedBy()
	}
}
