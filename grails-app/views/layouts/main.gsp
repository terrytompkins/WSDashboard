<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Green Hornet - WS Dashboard" /></title>
<!-- <link rel="stylesheet" media="screen" href="${resource(dir:'css',file:'spring-security-ui.css')}"/> -->
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
	    <z:resources/>
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
	   <div id='s2ui_header_body'>
		<span id="grailsLogo"><a href="http://grails.org"><img src="${resource(dir:'images',file:'GreenHornetLogo-small.jpg')}" alt="Green Hornet" border="0" /></a></span>

		<span id='s2ui_header_title_inline'>Green Hornet - Web Services Dashboard</span>
  				<z:style>
				    .z-menubar-hor, .z-menubar-ver {
			    	    border: 1px solid #D8D8D8;
				    }
			    </z:style>
            	<z:menubar id="menubar">
					<z:menu label="Environment Information">
						<z:menupopup>
							<z:menu label="Data Entry">
								<z:menupopup>
									<z:menuitem label="Channels" href="/GreenHornet/channel/index" />
									<z:menuitem label="Code Phases" href="/GreenHornet/codePhase/index" />
									<z:menuitem label="Ear Files" href="/GreenHornet/ear/index" />
									<z:menuitem label="Endpoint Assignments" href="/GreenHornet/endpointAssignment/index" />
									<z:menuitem label="Endpoint Types" href="/GreenHornet/endpointType/index" />
									<z:menuitem label="External Systems" href="/GreenHornet/externalSystem/index" />
									<z:menuitem label="External System Instances" href="/GreenHornet/externalSystemInstance/index" />
									<z:menuitem label="JVMs" href="/GreenHornet/jvm/index" />
									<z:menuitem label="Regions" href="/GreenHornet/region/index" />
									<z:menuitem label="Servers" href="/GreenHornet/server/index" />
									<z:menuitem label="Server Clusters" href="/GreenHornet/serverCluster/index" />
									<z:menuitem label="Web Services" href="/GreenHornet/webService/index" />
								</z:menupopup>
							</z:menu>
							<z:menuitem label="Environment Matrix" onClick="alert(self.label)" />
						</z:menupopup>
					</z:menu>
					<z:menu label="Administration">
						<z:menupopup>
							<z:menuitem label="Security Settings" target="_GH_Security" href="/GreenHornet/securityInfo/config" />
							<z:menuitem label="User Profiles" href="/GreenHornet/user/index" />
							<z:menuitem label="GreenHornet DB Console" target="_GH_DBConsole" href="/GreenHornet/dbconsole" />
						</z:menupopup>
					</z:menu>
					<z:menu label="Help">
						<z:menupopup>
							<z:menuitem label="US WebServices Development Site" target="_GH_PortalSite" href="http://w3.ustspmo.td.com/SiteDirectory/100331" />
							<z:menuseparator />
							<z:menu label="About">
								<z:menupopup>
									<z:menuitem label="About USTS WS" onClick="alert(self.label)" />
									<z:menuitem label="About TD Bank" onClick="alert(self.label)" />
								</z:menupopup>
							</z:menu>
						</z:menupopup>
					</z:menu>
				</z:menubar>
		<span id='s2ui_login_link_container'>
		  <nobr>
		    <div id='loginLinkContainer'>
			 <sec:ifLoggedIn>
				Logged in as <sec:username/> (<g:link controller='logout'>Logout</g:link>)
			 </sec:ifLoggedIn>
			 <sec:ifNotLoggedIn>
			   <g:link controller='login' id='loginLink'>Login</g:link>
			 </sec:ifNotLoggedIn>

			 <sec:ifSwitched>
			   <a href='${request.contextPath}/j_spring_security_exit_user'>
					Resume as <sec:switchedUserOriginalUsername/>
			   </a>
			 </sec:ifSwitched>
		    </div>
		  </nobr>
		</span>
	   </div>
				<g:javascript src='spring-security-ui.js'/>
		<g:layoutBody />
<g:render template='/includes/ajaxLogin' plugin='spring-security-ui'/>
    </body>
</html>