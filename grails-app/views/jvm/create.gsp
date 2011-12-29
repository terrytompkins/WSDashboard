

<%@ page import="com.tdbank.greenhornet.Jvm" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'jvm.label', default: 'Jvm')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${jvmInstance}">
            <div class="errors">
                <g:renderErrors bean="${jvmInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="jvm.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jvmInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${jvmInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="server"><g:message code="jvm.server.label" default="Server" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jvmInstance, field: 'server', 'errors')}">
                                    <g:select name="server.id" from="${com.tdbank.greenhornet.Server.list()}" optionKey="id" value="${jvmInstance?.server?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="region"><g:message code="jvm.region.label" default="Region" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jvmInstance, field: 'region', 'errors')}">
                                    <g:select name="region.id" from="${com.tdbank.greenhornet.Region.list()}" optionKey="id" value="${jvmInstance?.region?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastEarDeployDate"><g:message code="jvm.lastEarDeployDate.label" default="Last Ear Deploy Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jvmInstance, field: 'lastEarDeployDate', 'errors')}">
                                    <g:datePicker name="lastEarDeployDate" precision="day" value="${jvmInstance?.lastEarDeployDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="codePhase"><g:message code="jvm.codePhase.label" default="Code Phase" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jvmInstance, field: 'codePhase', 'errors')}">
                                    <g:select name="codePhase.id" from="${com.tdbank.greenhornet.CodePhase.list()}" optionKey="id" value="${jvmInstance?.codePhase?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="displayOrder"><g:message code="jvm.displayOrder.label" default="Display Order" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jvmInstance, field: 'displayOrder', 'errors')}">
                                    <g:textField name="displayOrder" value="${fieldValue(bean: jvmInstance, field: 'displayOrder')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="modifiedBy"><g:message code="jvm.modifiedBy.label" default="Modified By" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jvmInstance, field: 'modifiedBy', 'errors')}">
                                    <g:select name="modifiedBy.id" from="${com.tdbank.greenhornet.User.list()}" optionKey="id" value="${jvmInstance?.modifiedBy?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
