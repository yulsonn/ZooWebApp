<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <p><br/></p>
  <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="page-header" style="margin-top:5px;">
            <h3>Form: Add cage</h3>
          </div>
          <form:form role="form" CssClass="form-horizontal" method="post" action = "addCage" commandName = "cage">
            <div class="form-group">
              <form:label for="number" path="number" cssClass="col-sm-2 control-label">Cage number</form:label>
              <div class="col-sm-10">
                <div class="input-group col-sm-6">
                  <form:input id="number" path="number" cssClass="form-control" placeholder="Cage number"/>
                </div>
                <div class="has-error">
                  <div class="help-block"><form:errors path="number"/></div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <form:label for="description" path="description" cssClass="col-sm-2 control-label">Description</form:label>
              <div class="col-sm-10">
                <div class="input-group col-sm-6">
                  <form:input id="description" path="description" cssClass="form-control" placeholder="Description"/>
                </div>
                <div class="has-error">
                  <p class="help-block"><form:errors path="description"/></p>
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