package com.tdbank.greenhornet

class EndpointType {
	String name
	
	static constraints = {
		name(unique:true, blank:false)
	}
}
