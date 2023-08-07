<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <hr>
    <h1>Todo</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
        <form:label path="description" >Description</form:label>
        <form:input type="text" path="description" value="${todo.description}" required="required"/>
        <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="dueDate" >Due Date</form:label>
            <form:input type="text" path="dueDate" value="${todo.dueDate}" required="required"/>
            <form:errors path="dueDate" cssClass="text-warning"/>
        </fieldset>
        <form:input type="hidden" path="completed" value="${todo.completed ? 'checked' : ''}"/><br/>
        <form:input type="hidden" path="id" value="${todo.id}"/><br/>
        <input type="submit" class="btn btn-success" value="Save"/>
    </form:form>
    <script type="text/javascript">
        $('#dueDate').datepicker({
                format: 'yyyy-mm-dd'
        });
    </script>
</div>
<%@include file="common/footer.jspf"%>