
<%@ page import="com.tdbank.greenhornet.EndpointAssignment" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'endpointAssignment.label', default: 'EndpointAssignment')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'endpointAssignment.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="endpointUrl" title="${message(code: 'endpointAssignment.endpointUrl.label', default: 'Endpoint Url')}" />
                        
                            <th><g:message code="endpointAssignment.endpointType.label" default="Endpoint Type" /></th>
                        
                            <th><g:message code="endpointAssignment.webService.label" default="Web Service" /></th>
                        
                            <th><g:message code="endpointAssignment.jvm.label" default="Jvm" /></th>
                        
                            <g:sortableColumn property="displayOrder" title="${message(code: 'endpointAssignment.displayOrder.label', default: 'Display Order')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${endpointAssignmentInstanceList}" status="i" var="endpointAssignmentInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${endpointAssignmentInstance.id}">${fieldValue(bean: endpointAssignmentInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: endpointAssignmentInstance, field: "endpointUrl")}</td>
                        
                            <td>${fieldValue(bean: endpointAssignmentInstance, field: "endpointType")}</td>
                        
                            <td>${fieldValue(bean: endpointAssignmentInstance, field: "webService")}</td>
                        
                            <td>${fieldValue(bean: endpointAssignmentInstance, field: "jvm")}</td>
                        
                            <td>${fieldValue(bean: endpointAssignmentInstance, field: "displayOrder")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${endpointAssignmentInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
