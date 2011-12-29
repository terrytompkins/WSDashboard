
<%@ page import="com.tdbank.greenhornet.ExternalSystemInstance" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'externalSystemInstance.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'externalSystemInstance.name.label', default: 'Name')}" />
                        
                            <th><g:message code="externalSystemInstance.externalSystem.label" default="External System" /></th>
                        
                            <g:sortableColumn property="notes" title="${message(code: 'externalSystemInstance.notes.label', default: 'Notes')}" />
                        
                            <g:sortableColumn property="displayOrder" title="${message(code: 'externalSystemInstance.displayOrder.label', default: 'Display Order')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'externalSystemInstance.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${externalSystemInstanceInstanceList}" status="i" var="externalSystemInstanceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${externalSystemInstanceInstance.id}">${fieldValue(bean: externalSystemInstanceInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: externalSystemInstanceInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: externalSystemInstanceInstance, field: "externalSystem")}</td>
                        
                            <td>${fieldValue(bean: externalSystemInstanceInstance, field: "notes")}</td>
                        
                            <td>${fieldValue(bean: externalSystemInstanceInstance, field: "displayOrder")}</td>
                        
                            <td><g:formatDate date="${externalSystemInstanceInstance.lastUpdated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${externalSystemInstanceInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
