<%@include file="/WEB-INF/pages/jspf/include.jspf" %>
<%@ taglib tagdir="/WEB-INF/tags/grid" prefix="grid" %>

<script type="text/javascript">
$(document).ready(function () {
	$.ajax({
	    url:addContextPath('/allarmiEuropeAssistance'),
	    type:"GET",
	    contentType: "application/json; charset=utf-8",
	    success: function (data) {
	    	$("#allarmiEuropeAss").jsGrid({data:JSON.parse(data)});
	    }
	});
});
</script>

<div class="row">
	<div id="gradient" style="color:black;text-align:center;"><spring:message code="label.prove" text="label.prove"/></div>
	<grid:grid
		id="allarmiEuropeAss"
		callbackFunction="">
		<jsp:attribute name="options">
			height:"100%",
			width: "100%",
		    filtering: false,
		    autoload: true,
		    editing: false,
		    sorting: true,
		    selecting:true
		</jsp:attribute>
	    <jsp:attribute name="fields">
	       	{name: "id_allarme",type:"text",width:32},
	       	{name: "ab_codi",type:"text",width:15},
	       	{name: "dataRichiesta",type:"text",width: 15},
	       	{name: "dataArrivo",type:"text",width: 15},
	       	{name: "cognomeCliente",type:"text",width: 15},
	       	{name: "numeroTelefono1",type:"text",width: 15},
	       	{name: "numeroOrdine",type:"text",width: 15},
	       	{name: "tipologiaServizio",type:"text",width: 15},
	       	{name: "tipologiaConsulenza",type:"text",width: 15}
	    </jsp:attribute>
	</grid:grid>
</div>
