
<%@ page import="com.tdbank.greenhornet.ServerCluster" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'serverCluster.label', default: 'ServerCluster')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'serverCluster.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'serverCluster.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="displayOrder" title="${message(code: 'serverCluster.displayOrder.label', default: 'Display Order')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'serverCluster.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <th><g:message code="serverCluster.modifiedBy.label" default="Modified By" /></th>
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'serverCluster.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${serverClusterInstanceList}" status="i" var="serverClusterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${serverClusterInstance.id}">${fieldValue(bean: serverClusterInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: serverClusterInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: serverClusterInstance, field: "displayOrder")}</td>
                        
                            <td><g:formatDate date="${serverClusterInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: serverClusterInstance, field: "modifiedBy")}</td>
                        
                            <td><g:formatDate date="${serverClusterInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${serverClusterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
