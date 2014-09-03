
<%@ page import="calendar.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-event" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list event">
			
				<g:if test="${eventInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="event.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${eventInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="event.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${eventInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.cost}">
				<li class="fieldcontain">
					<span id="cost-label" class="property-label"><g:message code="event.cost.label" default="Cost" /></span>
					
						<span class="property-value" aria-labelledby="cost-label"><g:fieldValue bean="${eventInstance}" field="cost"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.location}">
				<li class="fieldcontain">
					<span id="location-label" class="property-label"><g:message code="event.location.label" default="Location" /></span>
					
						<span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${eventInstance}" field="location"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.discription}">
				<li class="fieldcontain">
					<span id="discription-label" class="property-label"><g:message code="event.discription.label" default="Discription" /></span>
					
						<span class="property-value" aria-labelledby="discription-label"><g:fieldValue bean="${eventInstance}" field="discription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.privateEvent}">
				<li class="fieldcontain">
					<span id="privateEvent-label" class="property-label"><g:message code="event.privateEvent.label" default="Private Event" /></span>
					
						<span class="property-value" aria-labelledby="privateEvent-label"><g:formatBoolean boolean="${eventInstance?.privateEvent}" /></span>
					
				</li>
				</g:if>


			
				 <g:if test="${eventInstance?.guestList}">
				<li class="fieldcontain">
					<span id="guestList-label" class="property-label"><g:message code="event.guestList.label" default="Guest List" /></span>
					
						<span class="property-value" aria-labelledby="guestList-label"><g:link controller="guestList" action="show" id="${eventInstance?.guestList?.id}">${eventInstance?.guestList?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="event.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${eventInstance?.user?.id}">${eventInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:eventInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${eventInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
