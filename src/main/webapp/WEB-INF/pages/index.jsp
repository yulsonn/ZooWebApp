<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
<c:if test = "${!empty animals}">     <%--test - The test condition that determines whether or not the body content should be processed.--%>
  <p><br/></p>
  <div class="row">
  <div class="col-md-1"></div>
  <div class="col-md-10">
  <div class="panel panel-default">
  <div class="panel-body">
  <div class="page-header" style="margin-top:5px;">
  <h3>Table: Animals</h3>

  <table  data-toggle="table" data-sort-name="id" class="table table-striped">
    <thead>
    <tr>
      <th data-field="id" data-sortable="true">Id</th>
      <th data-field="name" data-sortable="true">Name</th>
      <th data-field="type" data-sortable="true">Type</th>
      <th data-field="age" data-sortable="true">Age</th>
      <th data-field="cage" data-sortable="true">Cage</th>
      <th data-field="caretaker" data-sortable="true">Caretaker</th>
      <th></th>
      <th></th>
    </tr>
    </thead>
    <c:forEach items = "${animals}" var = "animal">         <%--items - Collection of items to iterate over--%>
      <tr>                                                  <%--var - Name of the exported scoped variable for the current item of the iteration.--%>
        <td>${animal.id}</td>
        <td>${animal.name}</td>
        <td>${animal.type}</td>
        <td>${animal.age}</td>
        <td>${animal.cage.description}</td>
        <td>${animal.caretaker.lastname} ${animal.caretaker.firstname}</td>
        <td><a href="<c:url value="/updateAnimal/${animal.id}" />">Edit</a></td>
        <td><a href="<c:url value="/deleteAnimal/${animal.id}" />" onclick="return confirm('Are you sure you want to delete this record?')">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  </div></div></div></div></div>
</c:if>
</t:template>
