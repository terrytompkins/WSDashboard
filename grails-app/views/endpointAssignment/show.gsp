
<%@ page import="com.tdbank.greenhornet.EndpointAssignment" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'endpointAssignment.label', default: 'EndpointAssignment')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: endpointAssignmentInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.endpointUrl.label" default="Endpoint Url" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: endpointAssignmentInstance, field: "endpointUrl")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.endpointType.label" default="Endpoint Type" /></td>
                            
                            <td valign="top" class="value"><g:link controller="endpointType" action="show" id="${endpointAssignmentInstance?.endpointType?.id}">${endpointAssignmentInstance?.endpointType?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.webService.label" default="Web Service" /></td>
                            
                            <td valign="top" class="value"><g:link controller="webService" action="show" id="${endpointAssignmentInstance?.webService?.id}">${endpointAssignmentInstance?.webService?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.jvm.label" default="Jvm" /></td>
                            
                            <td valign="top" class="value"><g:link controller="jvm" action="show" id="${endpointAssignmentInstance?.jvm?.id}">${endpointAssignmentInstance?.jvm?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.displayOrder.label" default="Display Order" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: endpointAssignmentInstance, field: "displayOrder")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.lastUpdated.label" default="Last Updated" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${endpointAssignmentInstance?.lastUpdated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.modifiedBy.label" default="Modified By" /></td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${endpointAssignmentInstance?.modifiedBy?.id}">${endpointAssignmentInstance?.modifiedBy?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="endpointAssignment.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${endpointAssignmentInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${endpointAssignmentInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
