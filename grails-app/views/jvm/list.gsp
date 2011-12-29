
<%@ page import="com.tdbank.greenhornet.Jvm" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'jvm.label', default: 'Jvm')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'jvm.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'jvm.name.label', default: 'Name')}" />
                        
                            <th><g:message code="jvm.server.label" default="Server" /></th>
                        
                            <th><g:message code="jvm.region.label" default="Region" /></th>
                        
                            <g:sortableColumn property="lastEarDeployDate" title="${message(code: 'jvm.lastEarDeployDate.label', default: 'Last Ear Deploy Date')}" />
                        
                            <th><g:message code="jvm.codePhase.label" default="Code Phase" /></th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${jvmInstanceList}" status="i" var="jvmInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${jvmInstance.id}">${fieldValue(bean: jvmInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: jvmInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: jvmInstance, field: "server")}</td>
                        
                            <td>${fieldValue(bean: jvmInstance, field: "region")}</td>
                        
                            <td><g:formatDate date="${jvmInstance.lastEarDeployDate}" /></td>
                        
                            <td>${fieldValue(bean: jvmInstance, field: "codePhase")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${jvmInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
