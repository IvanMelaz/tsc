<%@include file="/WEB-INF/pages/jspf/include.jspf" %> 
    
  <div class="form-group">
    <label for="username" class="control-label">Nome Utente</label>
    <input name="username" type="text" class="form-control" />
  </div>
  
  <div class="form-group">
     <label class="control-label">Ruolo</label>
     <select class="form-control" name="role" required>
         <option value="">Scegli il ruolo</option>
         <option value="ROLE_ADMIN">Amministratore</option>
         <option value="ROLE_ADMIN">Utente</option>
         <option value="ROLE_BACKOFFICE">Backoffice</option>
     </select>
  </div>

  <div class="form-group">
    <label for="inputEmail" class="control-label">Email</label>
    <input name="email" type="email" class="form-control" data-error="Bruh, that email address is invalid" />
    <div class="help-block with-errors"></div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword" class="control-label">Password</label>
    <div class="form-inline row">
      <div class="form-group col-sm-6">
        <input name="password" type="password" data-minlength="6" class="form-control" />
        <div class="help-block">Minimum of 6 characters</div>
      </div>
      <div class="form-group col-sm-6">
        <input name="passwordConfirm" type="password" class="form-control" data-match="#password" data-match-error="Whoops, these don't match" />
        <div class="help-block with-errors"></div>
      </div>
    </div>
  </div>

  <div class="form-group">
    <button type="submit" class="btn btn-primary">Aggiungi</button>
  </div>