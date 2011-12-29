
<%@ page import="com.tdbank.greenhornet.EndpointType" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'endpointType.label', default: 'EndpointType')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'endpointType.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'endpointType.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'endpointType.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="displayOrder" title="${message(code: 'endpointType.displayOrder.label', default: 'Display Order')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'endpointType.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <th><g:message code="endpointType.modifiedBy.label" default="Modified By" /></th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${endpointTypeInstanceList}" status="i" var="endpointTypeInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${endpointTypeInstance.id}">${fieldValue(bean: endpointTypeInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: endpointTypeInstance, field: "name")}</td>
                        
                            <td><g:formatDate date="${endpointTypeInstance.dateCreated}" /></td>
                        
                            <td>${fieldValue(bean: endpointTypeInstance, field: "displayOrder")}</td>
                        
                            <td><g:formatDate date="${endpointTypeInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: endpointTypeInstance, field: "modifiedBy")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${endpointTypeInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
