package com.tdbank.greenhornet

import java.util.Date;
import com.tdbank.greenhornet.User

class FidelityRegion {
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
