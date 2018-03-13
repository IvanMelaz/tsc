<div id="soccorritori">
	<div class="row" >
	        <div class="col-xs-3 form-group">
	            <label><spring:message code="label.soccorritori.id" text="label.soccorritori.id" /></label>
	            <input data-bind="value: $data.id"  class="form-control c" readonly="readonly"/>
	        </div>
	        <div class="col-xs-9 form-group">
	            <label><spring:message code="label.soccorritori.ab_codi" text="label.soccorritori.ab_codi" /></label>
	            <input data-bind="value: $data.nominativo" class="form-control input-sm" readonly="readonly"/>
	        </div>
	</div>
</div>


<script type="text/javascript">
function MyViewModel() {
    this.buyer = { name: 'Franklin', credits: 250 };
    this.seller = { name: 'Mario', credits: 3000 };
}
ko.applyBindings(new MyViewModel(),document.getElementById('rescuers'));
</script>