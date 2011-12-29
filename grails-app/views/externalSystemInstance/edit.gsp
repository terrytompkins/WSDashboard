

<%@ page import="com.tdbank.greenhornet.ExternalSystemInstance" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${externalSystemInstanceInstance}">
            <div class="errors">
                <g:renderErrors bean="${externalSystemInstanceInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${externalSystemInstanceInstance?.id}" />
                <g:hiddenField name="version" value="${externalSystemInstanceInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="externalSystemInstance.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: externalSystemInstanceInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${externalSystemInstanceInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="externalSystem"><g:message code="externalSystemInstance.externalSystem.label" default="External System" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: externalSystemInstanceInstance, field: 'externalSystem', 'errors')}">
                                    <g:select name="externalSystem.id" from="${com.tdbank.greenhornet.ExternalSystem.list()}" optionKey="id" value="${externalSystemInstanceInstance?.externalSystem?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="jvms"><g:message code="externalSystemInstance.jvms.label" default="Jvms" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: externalSystemInstanceInstance, field: 'jvms', 'errors')}">
                                    
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="notes"><g:message code="externalSystemInstance.notes.label" default="Notes" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: externalSystemInstanceInstance, field: 'notes', 'errors')}">
                                    <g:textField name="notes" value="${externalSystemInstanceInstance?.notes}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="displayOrder"><g:message code="externalSystemInstance.displayOrder.label" default="Display Order" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: externalSystemInstanceInstance, field: 'displayOrder', 'errors')}">
                                    <g:textField name="displayOrder" value="${fieldValue(bean: externalSystemInstanceInstance, field: 'displayOrder')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="modifiedBy"><g:message code="externalSystemInstance.modifiedBy.label" default="Modified By" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: externalSystemInstanceInstance, field: 'modifiedBy', 'errors')}">
                                    <g:select name="modifiedBy.id" from="${com.tdbank.greenhornet.User.list()}" optionKey="id" value="${externalSystemInstanceInstance?.modifiedBy?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
