--
-- insert tsc_user
--

INSERT INTO telesoccorso.tsc_user (username,password,email,`role`,keyId,base32Secret,mfaEnabled) VALUES
('admin','$2a$10$t8DqJ7s553sC5HpjKmXPmerbFWJmmcIMZTPPqt2nViLMr3i7z0UFm','admin@infamiglia.it','ROLE_ADMIN','testUser@tsc.it','fwefwefwegeg',1)
,('admin','$2a$10$0hfDFZ/MroZz62ttl762guvdeFnc1iXwL6fm1603Et4LzXY6qxYHO','admin@infamiglia.it','ROLE_SADMIN','testUser@tsc.it','fwefwefwegeg',1)
,('testUser','$2a$10$fLct.47bx/fifbKI/OiOkuazU7ZXcl6NbKrWFPzcsVgQXhCf78YGu','testUser@tsc.it','ROLE_ADMIN',NULL,NULL,0)
;