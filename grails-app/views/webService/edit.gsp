

<%@ page import="com.tdbank.greenhornet.WebService" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'webService.label', default: 'WebService')}" />
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
            <g:hasErrors bean="${webServiceInstance}">
            <div class="errors">
                <g:renderErrors bean="${webServiceInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${webServiceInstance?.id}" />
                <g:hiddenField name="version" value="${webServiceInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="webService.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: webServiceInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${webServiceInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="displayOrder"><g:message code="webService.displayOrder.label" default="Display Order" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: webServiceInstance, field: 'displayOrder', 'errors')}">
                                    <g:textField name="displayOrder" value="${fieldValue(bean: webServiceInstance, field: 'displayOrder')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="modifiedBy"><g:message code="webService.modifiedBy.label" default="Modified By" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: webServiceInstance, field: 'modifiedBy', 'errors')}">
                                    <g:select name="modifiedBy.id" from="${com.tdbank.greenhornet.User.list()}" optionKey="id" value="${webServiceInstance?.modifiedBy?.id}"  />
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
