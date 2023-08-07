<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <hr>
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>due Date</th>
            <th>Done</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.dueDate}</td>
                <td>${todo.completed}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn bg-warning">DELETE</a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn bg-success">UPDATE</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@include file="common/footer.jspf"%>