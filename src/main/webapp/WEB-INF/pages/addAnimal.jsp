<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
  <p><br/></p>
  <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="page-header" style="margin-top:5px;">
            <h3>Form: Add animal</h3>
          </div>
          <form:form role="form" CssClass="form-horizontal" method="post" action = "addAnimal" commandName = "animal">
            <div class="form-group">
              <form:label for="name" path="name" cssClass="col-sm-2 control-label">Name</form:label>
              <div class="col-sm-10">
                <div class="input-group col-sm-6">
                  <form:input id="name" path="name" cssClass="form-control" placeholder="Name"/>
                </div>
                <div class="has-error">
                  <div class="help-block"><form:errors path="name"/></div>
                </div>
              </div>
            </div>
            <div class="form-group">
            <form:label for="type" path="type" cssClass="col-sm-2 control-label">Type</form:label>
            <div class="col-sm-10">
              <div class="input-group col-sm-6">
                <form:input id="type" path="type" cssClass="form-control" placeholder="Type"/>
              </div>
              <div class="has-error">
                <p class="help-block"><form:errors path="type"/></p>
              </div>
              </div>
            </div>
            <div class="form-group">
              <form:label for="age" path="age" cssClass="col-sm-2 control-label">Age</form:label>
              <div class="col-sm-10">
                <div class="input-group col-sm-6">
                  <form:input id="age" path="age" cssClass="form-control" placeholder="Age"/>
                </div>
                <div class="has-error">
                  <p class="help-block"><form:errors path="age"/></p>
                </div>
              </div>
            </div>
            <div class="form-group">
              <form:label for="cage" path="cage" cssClass="col-sm-2 control-label">Cage</form:label>
              <div class="col-sm-10">
                <div class="input-group col-sm-6">
                  <form:select path="cage.id">
                    <form:options  id="cage" items="${cages}" itemLabel="description" itemValue="id" cssClass="form-control"/>
                  </form:select>
                </div>
                <div class="has-error">
                  <p class="help-block"><form:errors path="cage"/></p>
                </div>
              </div>
            </div>
            <div class="form-group">
              <form:label for="caretaker" path="cage" cssClass="col-sm-2 control-label">Caretaker</form:label>
              <div class="col-sm-10">
                <div class="input-group col-sm-6">
                  <form:select path="caretaker.id">
                    <form:options  id="caretaker" items="${caretakers}" itemValue="id" cssClass="form-control"/>
                  </form:select>
                </div>
                <div class="has-error">
                  <p class="help-block"><form:errors path="caretaker"/></p>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success btn-md">Save</button>
                <button type="button" class="btn btn-warning btn-md"  Onclick=" if (confirm('Are you sure you want to exit this page without saving?')) window.location.href='<c:url value="/" />'">Back</button>
              </div>
            </div>
          </form:form>
        </div>
      </div>
    </div>
    <div class="col-md-2"></div>
  </div>

</t:template>