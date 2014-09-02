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

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'privateEvent', 'error')} ">
	<label for="privateEvent">
		<g:message code="event.privateEvent.label" default="Private Event" />
		
	</label>
	<g:checkBox name="privateEvent" value="${eventInstance?.privateEvent}" />
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'attendance', 'error')} ">
	<label for="attendance">
		<g:message code="event.attendance.label" default="Attendance" />
		
	</label>
	<g:select id="attendance" name="attendance.id" from="${calendar.Attendance.list()}" optionKey="id" value="${eventInstance?.attendance?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="event.user.label" default="Host" />
		<span class="required-indicator">*</span>
	</label>
	<sec:username />
	<g:hiddenField name="user.id" value="${sec.loggedInUserInfo(field:"id")}"/>
<!--	<g:select id="user" name="user.id" from="${calendar.User.list()}" optionKey="id" required="" value="${eventInstance?.user?.id}" class="many-to-one"/> -->
</div>

