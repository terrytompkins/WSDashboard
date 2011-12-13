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
		<div id="grailsLogo"><a href="http://grails.org"><img src="${resource(dir:'images',file:'GreenHornetLogo-small.jpg')}" alt="Green Hornet" border="0" /></a></div>

		<div id='s2ui_header_title_inline'>Green Hornet - Web Services Dashboard</div>
  				<z:style>
				    .z-menubar-hor, .z-menubar-ver {
			    	    border: 1px solid #D8D8D8;
				    }
			    </z:style>
            	<z:menubar id="menubar">
					<z:menu label="File">
						<z:menupopup onOpen="alert(self.id)">
							<z:menuitem label="New" onClick="alert(self.label)" />
							<z:menuitem label="Open" onClick="alert(self.label)" />
							<z:menuitem label="Save" onClick="alert(self.label)" />
							<z:menuseparator />
							<z:menuitem label="Exit" onClick="alert(self.label)" />
						</z:menupopup>
					</z:menu>
					<z:menu label="Help">
						<z:menupopup>
							<z:menuitem label="Index" onClick="alert(self.label)" />
							<z:menu label="About">
								<z:menupopup>
									<z:menuitem label="About ZK" onClick="alert(self.label)" />
									<z:menuitem label="About Potix" onClick="alert(self.label)" />
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