<%@include file="/WEB-INF/pages/jspf/include.jspf" %>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="ajaxForm" %>

<spring:message code="label.anagrafica.success" text="label.anagrafica.success"  var="label.anagrafica.success"/>
<spring:message code="label.anagrafica.failure" text="label.anagrafica.failure"  var="label.anagrafica.failure"/>

   <div id="anagrafica" align="center">
	<table style="border-collapse: collapse" >
    <tr>
      <td align="left">
                    <font color="#C0C0C0"
                    face="Arial" size="2"><strong>Codice:</strong></font></td>
      <td align="left">
					<input type="text" size="20" data-bind="value: $data.ab_codi">
	  </td>
      <td align="left"><b><font face="Arial" size="2" color="#C0C0C0">Centrale:</font></b></td>
      <td align="left">
                    <font face="Arial" color="#4682B4" size="1">
                    <b>
                    <input type="text" size="15" data-bind="value: $data.centrale" /></b></font></td>
      <td align="left">
                    <font size="2"
                    face="Arial" color="#C0C0C0"><strong>Tel.:</strong></font></td>
      <td colspan="3" align="left">
                    <font color="#4682B4" face="Arial" size="1"><b>
                    <input type="text" size="28" data-bind="with: $data.telefono"></b></font></td>

    </tr>
    <tr>
      <td align="left"><b><font face="Arial" size="2" color="#C0C0C0">Matricola:</font></b></td>
			<td colspan="3" style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<font color="#4682B4" face="Arial" size="1"><input type="text" size="20" data-bind="value: $data.matricola"></font></td>
      <td align="left"><font size="2" face="Arial" color="#C0C0C0"><strong>Cell.:</strong></font></td>
      <td colspan="3" align="left"><font color="#4682B4" face="Arial" size="1"><b><input type="text" size="28" data-bind="value: $data.cellulare"></b></font></td>

    </tr>
    <tr>
      <td align="left">
                    <font size="2"
                    face="Arial" color="#C0C0C0"><strong>Nominativo:</strong></font></td>
      <td colspan="3" align="left"><font color="#4682B4" face="Arial" size="1"><b>
                    <input type="text" size="50" data-bind="value: $data.nominativo"></b></font></td>
      <td align="left">
                    <font size="2"
                    face="Arial" color="#C0C0C0"><strong>Sesso:</strong></font></td>
      <td align="left"><font face="Arial" color="#4682B4" size="1">
                    <b>
                    <input
                    type="text" size="2" data-bind="value: $data.sesso"></b></font></td>
      <td align="left"><b><font size="2" face="Arial" color="#C0C0C0">Ente:</font></b></td>
      <td colspan="3" style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<font color="#4682B4" face="Arial" size="1"><b><input type="text" size="9" data-bind="value: $data.ente"></b></font></td>
    </tr>
    <tr>
      <td align="left">&nbsp;</td>
      <td colspan="3" align="left">&nbsp;</td>
      <td align="left">&nbsp;</td>
      <td align="left">&nbsp;</td>
      <td align="left">&nbsp;</td>
      <td align="left"></td>
    </tr>
		<tr>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">Indirizzo:</font></b></td>
			<td colspan="3" style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<font color="#4682B4" face="Arial" size="1"><b><input type="text" size="50" data-bind="value: $data.indirizzo"></b></font></td>
			<td align="left"><b><font size="2" color="#C0C0C0" face="Arial">Zona:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="5" data-bind="value: $data.zona"></font></b></td>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">Tavola:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="5" data-bind="value: $data.tavola"></font></b></td>
		</tr>
		<tr>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">
			Comune:</font></b></td>
			<td colspan="3" style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="50" data-bind="value: $data.comune"></font></b></td>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">Prov:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="5" data-bind="value: $data.provincia"></font></b></td>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">Cap:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="5" data-bind="value: $data.cap"></font></b></td>
		</tr>
		<tr>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">
			Cod.Fisc.:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="16" data-bind="value: $data.cf"></font></b></td>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">
			P.IVA:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="11" data-bind="value: $data.piva"></font></b></td>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">Peso:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="5" data-bind="value: $data.peso"></font></b></td>
			<td align="left"><b><font size="2" color="#C0C0C0" face="Arial">Altezza:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="5" data-bind="value: $data.altezza"></font></b></td>
		</tr>
		<tr>
			<td align="left"><b><font face="Arial" size="2" color="#C0C0C0">D.nascita:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial"><input type="text" size="10" data-bind="value: $data.data_nascita"></font></b></td>
			<td align="left"><b><font size="2" color="#C0C0C0" face="Arial">L. nascita:</font></b></td>
			<td style="border-style: ridge; border-width: 0px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px" align="left">
			<b><font face="Arial">
			<input type="text" size="15" data-bind="value: $data.luogo_nascita"></font></b></td>
			<td align="left">
                    <font size="2"
                    face="Arial" color="#C0C0C0"><strong>Stato Nascita:</strong></font></td>
			<td colspan="3" align="left">
                    <font color="#4682B4" face="Arial" size="1"><b>
                    <input type="text" size="28" data-bind="value: $data.stato_nascita"></b></font></td>
		</tr>
	</table>
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