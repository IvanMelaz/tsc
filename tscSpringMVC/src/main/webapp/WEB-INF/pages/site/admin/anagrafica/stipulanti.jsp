<%@include file="/WEB-INF/pages/jspf/include.jspf" %>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form" %>

<spring:message code="label.anagrafic.success" text="label.anagrafic.success"  var="label.anagrafic.success"/>
<spring:message code="label.anagrafic.failure" text="label.anagrafic.failure"  var="label.anagrafic.failure"/>

<div id="stipulanti">
	<div class="row" >
	        <div class="col-xs-3 form-group">
	            <label><spring:message code="label.anagrafic.ab_codi" text="label.anagrafic.ab_codi" /></label>
	            <input data-bind="value: $data.ab_codi"  class="form-control c" readonly="readonly"/>
	        </div>
	        <div class="col-xs-9 form-group">
	            <label><spring:message code="label.anagrafic.nominativo" text="label.anagrafic.nominativo" /></label>
	            <input data-bind="value: $data.nominativo" class="form-control input-sm" readonly="readonly"/>
	        </div>
	</div>
	<div class="row" >
	        <div class="col-xs-4 form-group">
	            <label><spring:message code="label.anagrafic.centrale" text="label.anagrafic.centrale" /></label>
	            <input data-bind="value: $data.centrale"  class="form-control input-sm" readonly="readonly"/>
	        </div>
	        <div class="col-xs-2 form-group">
	            <label><spring:message code="label.anagrafic.sesso" text="label.anagrafic.sesso" /></label>
	            <input data-bind="value: $data.sesso" class="form-control input-sm" readonly="readonly"/>
	        </div>
	        <div class="col-xs-6 form-group">
	            <label><spring:message code="label.anagrafic.matricola" text="label.anagrafic.matricola" /></label>
	            <input data-bind="value: $data.matricola" class="form-control input-sm" readonly="readonly"/>
	        </div>
	</div>
</div>

<script type="text/javascript">
	var viewModel = {
	    telefono: ko.observable(),
	    matricola: ko.observable()
	};

	function loadAnagrafica(data,url) {
		//Receiving data from the server<h1 data-bind="text: name"></h1>
		$.ajax({
			    url:url,
			    data:JSON.stringify(data),
			    type:"POST",
			    contentType: "application/json; charset=utf-8",
		        beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		            xhr.setRequestHeader(HEADER, TOKEN);
		        },
			    success: function(resposeJsonObject){
			    	console.log('loadAnagrafica resposeJsonObject: ',resposeJsonObject);
			        // Success Message Handler
		        	var parsed;
					try {
							parsed = JSON.parse(resposeJsonObject);
							viewModel=ko.mapping.fromJS(parsed);
				        	//apply bindings
				        	ko.cleanNode(document.getElementById('anagrafica'));
							try {
				        		ko.applyBindings(viewModel,document.getElementById('anagrafica'));
							} catch (e) {
								console.log(e);
							}
			    		} catch(e) {
			    			toastr.error(e,"loadAnagrafica");
			    	}
			    }
			});
	}
</script>