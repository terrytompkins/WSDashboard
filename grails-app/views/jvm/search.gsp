<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title><g:message code="default.search.label" args="[entityName]" /></title>
</head>
<body>
	<div class="body">
	<z:style>
	    .z-label { 
	      display: block; 
	    } 
	    tr.z-row td.z-row-inner { 
	      padding: 2px 5px; 
	    } 
	    .z-row-cnt, .z-column-cnt {
	      text-align: center; 
	    } 
	    .category-center .z-auxheader-cnt { 
	      text-align: center; 
	    }
	    .footer_right .z-footer-cnt {
			  text-align: right;
			  font-weight: bold; 
		}
	</z:style>
	<z:window id="envSearchWindow" apply="com.tdbank.greenhornet.EnvironmentSearchComposer">
		<z:grid id="envSearchGrid">
			<z:auxhead sclass="category-center">
				<z:auxheader label="JVM Environment List" colspan="6" />
			</z:auxhead>
			<z:auxhead sclass="category-center">
				<z:auxheader colspan="1">
					<image src="/images/funnel.png" />
					<z:textbox id="jvmFilter" c:onClick="this.select()" onChanging='getEnvDataByInput(event)' width="100px" />
				</z:auxheader>
				<z:auxheader colspan="1">
					<image src="/images/funnel.png" />
					<z:textbox id="regionFilter" c:onClick="this.select()" onChanging='getEnvDataByInput(event)' width="100px" />
				</z:auxheader>
				<z:auxheader colspan="1">
					<image src="/images/funnel.png" />
					<z:textbox id="channelFilter" c:onClick="this.select()" onChanging='getEnvDataByInput(event)' width="100px" />
				</z:auxheader>
				<z:auxheader colspan="1">
					<image src="/images/funnel.png" />
					<z:textbox id="codePhaseFilter" c:onClick="this.select()" onChanging='getEnvDataByInput(event)' width="100px" />
				</z:auxheader>
				<z:auxheader label="Environment Attributes" colspan="3" />
			</z:auxhead>
			<z:columns>
				<z:column hflex="1">JVM</z:column>
				<z:column hflex="1">Region</z:column>
				<z:column hflex="1">Channel</z:column>
				<z:column hflex="1">Code Phase</z:column>
				<z:column hflex="1">Ext. Sys. Instance</z:column>
				<z:column hflex="1">Server Cluster</z:column>
				<z:column hflex="2">Deployment Ear</z:column>
			</z:columns>
			<z:foot>
				<z:footer />
				<z:footer id="footer_msg" colspan="3" />
				<z:footer />
				<z:footer id="footer_category" colspan="3" class="footer_right" label="A Total of @@@ JVMs, @@@ Endpoints." />
			</z:foot>
		</z:grid>
		</z:window>
	</div>
</body>
</html>