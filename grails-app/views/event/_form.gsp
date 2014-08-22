<%@ page import="calendar.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="event.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${eventInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="event.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${eventInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'cost', 'error')} ">
	<label for="cost">
		<g:message code="event.cost.label" default="Cost" />
		
	</label>
	<g:field name="cost" type="number" value="${eventInstance.cost}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="event.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${eventInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'discription', 'error')} ">
	<label for="discription">
		<g:message code="event.discription.label" default="Discription" />
		
	</label>
	<g:textField name="discription" value="${eventInstance?.discription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="event.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${calendar.User.list()}" optionKey="id" required="" value="${eventInstance?.user?.id}" class="many-to-one"/>
</div>

