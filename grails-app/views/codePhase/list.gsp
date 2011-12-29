
<%@ page import="com.tdbank.greenhornet.CodePhase" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'codePhase.label', default: 'CodePhase')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'codePhase.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'codePhase.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="displayOrder" title="${message(code: 'codePhase.displayOrder.label', default: 'Display Order')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'codePhase.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <th><g:message code="codePhase.modifiedBy.label" default="Modified By" /></th>
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'codePhase.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${codePhaseInstanceList}" status="i" var="codePhaseInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${codePhaseInstance.id}">${fieldValue(bean: codePhaseInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: codePhaseInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: codePhaseInstance, field: "displayOrder")}</td>
                        
                            <td><g:formatDate date="${codePhaseInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: codePhaseInstance, field: "modifiedBy")}</td>
                        
                            <td><g:formatDate date="${codePhaseInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${codePhaseInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
