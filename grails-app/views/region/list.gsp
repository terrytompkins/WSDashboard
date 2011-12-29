
<%@ page import="com.tdbank.greenhornet.Region" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'region.label', default: 'Region')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'region.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'region.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="displayOrder" title="${message(code: 'region.displayOrder.label', default: 'Display Order')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'region.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <th><g:message code="region.modifiedBy.label" default="Modified By" /></th>
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'region.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${regionInstanceList}" status="i" var="regionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${regionInstance.id}">${fieldValue(bean: regionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: regionInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: regionInstance, field: "displayOrder")}</td>
                        
                            <td><g:formatDate date="${regionInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: regionInstance, field: "modifiedBy")}</td>
                        
                            <td><g:formatDate date="${regionInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${regionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
